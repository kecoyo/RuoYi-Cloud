<template>
  <div class="app-container">
    <el-tabs v-model="categoryId" type="border-card" @tab-change="handleTabChange">
      <el-tab-pane v-for="(item) in categoryList" :label="item.name" :name="item.id" :key="item.id">
        <div v-if="item.id === categoryId">
          <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch">
            <el-form-item label="名称" prop="name">
              <el-input v-model="queryParams.name" placeholder="请输入名称" clearable style="width: 200px"
                @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="备注" prop="remark">
              <el-input v-model="queryParams.remark" placeholder="请输入备注" clearable style="width: 200px"
                @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="状态" prop="status">
              <el-select v-model="queryParams.status" placeholder="请选择" clearable style="width: 200px">
                <el-option v-for="dict in sys_normal_disable" :key="dict.value" :label="dict.label"
                  :value="dict.value" />
              </el-select>
            </el-form-item>
            <el-form-item label="创建时间" style="width: 308px">
              <el-date-picker v-model="dateRange" value-format="YYYY-MM-DD" type="daterange" range-separator="-"
                start-placeholder="开始日期" end-placeholder="结束日期"></el-date-picker>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
              <el-button icon="Refresh" @click="resetQuery">重置</el-button>
            </el-form-item>
          </el-form>
          <el-row :gutter="10" class="mb8">
            <el-col :span="1.5">
              <el-button type="primary" plain icon="Plus" @click="handleAdd"
                v-hasPermi="['system:user:add']">新增</el-button>
            </el-col>
            <el-col :span="1.5">
              <el-button type="success" plain icon="Edit" :disabled="single" @click="handleEdit"
                v-hasPermi="['butler:account:edit']">修改</el-button>
            </el-col>
            <el-col :span="1.5">
              <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete"
                v-hasPermi="['butler:account:remove']">删除</el-button>
            </el-col>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </el-row>
          <el-table v-loading="loading" :data="tableList" @selection-change="handleSelectionChange">
            <el-table-column type="selection" align="center" width="55"></el-table-column>
            <el-table-column label="序号" type="index" width="50" align="center">
              <template #default="scope">
                <span>{{
                  (queryParams.pageNum - 1) * queryParams.pageSize + scope.$index + 1
                }}</span>
              </template>
            </el-table-column>
            <el-table-column label="名称" align="center" prop="name" :show-overflow-tooltip="true" />
            <el-table-column label="描述" align="center" prop="remark" :show-overflow-tooltip="true" />
            <el-table-column label="属性" align="center" prop="properties" :show-overflow-tooltip="true" />
            <el-table-column label="图片" align="center" prop="pictures" :show-overflow-tooltip="true" />
            <el-table-column label="创建时间" align="center" prop="createTime" width="160" />
            <el-table-column label="更新时间" align="center" prop="updateTime" width="160" />
            <el-table-column label="操作" align="center" width="330" class-name="small-padding fixed-width">
              <template #default="scope">
                <el-tooltip content="编辑" placement="top">
                  <el-button link type="primary" icon="Edit" @click="handleEdit(scope.row)"
                    v-hasPermi="['butler:account:edit']"></el-button>
                </el-tooltip>
                <el-tooltip content="删除" placement="top">
                  <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)"
                    v-hasPermi="['butler:account:remove']"></el-button>
                </el-tooltip>
              </template>
            </el-table-column>
          </el-table>
          <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum"
            v-model:limit="queryParams.pageSize" @pagination="getList" />
        </div>
      </el-tab-pane>
    </el-tabs>


    <!-- 预览界面 -->
    <el-dialog :title="preview.title" v-model="preview.open" width="80%" top="5vh" append-to-body
      custom-class="scrollbar">
      <el-tabs v-model="preview.activeName">
        <el-tab-pane v-for="(value, key) in preview.data"
          :label="key.substring(key.lastIndexOf('/') + 1, key.indexOf('.vm'))"
          :name="key.substring(key.lastIndexOf('/') + 1, key.indexOf('.vm'))" :key="value">
          <el-link :underline="false" icon="DocumentCopy" v-copyText="value" v-copyText:callback="copyTextSuccess"
            style="float: right">&nbsp;复制</el-link>
          <pre>{{ value }}</pre>
        </el-tab-pane>
      </el-tabs>
    </el-dialog>
    <import-table ref="importRef" @ok="handleQuery" />
  </div>
</template>

<script setup name="Gen">
import { listCategoryCount } from "@/api/butler/category";
import {
  listAccount,
  previewAccount,
  delAccount,
  genCode,
  synchDb,
} from "@/api/butler/account";
import router from "@/router";
import importTable from "./importTable";

const route = useRoute();
const { proxy } = getCurrentInstance();

const categoryList = ref([]);
const categoryId = ref(0);
const tableList = ref([]);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const tableNames = ref([]);
const dateRange = ref([]);
const uniqueId = ref("");

const data = reactive({
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    tableName: undefined,
    tableComment: undefined,
  },
  preview: {
    open: false,
    title: "代码预览",
    data: {},
    activeName: "domain.java",
  },
});

const { queryParams, preview } = toRefs(data);

onActivated(() => {
  const time = route.query.t;
  if (time != null && time != uniqueId.value) {
    uniqueId.value = time;
    queryParams.value.pageNum = Number(route.query.pageNum);
    dateRange.value = [];
    proxy.resetForm("queryForm");
    getList();
  }
});

function getCategoryList() {
  listCategoryCount().then((response) => {
    categoryList.value = response.data
    categoryId.value = response.data[0].id;

    // 初始化查询
    handleTabChange(categoryId.value);
  });
}

/** 查询表集合 */
function getList() {
  loading.value = true;
  listAccount(proxy.addDateRange(queryParams.value, dateRange.value)).then(
    (response) => {
      tableList.value = response.rows;
      total.value = response.total;
      loading.value = false;
    }
  );
}

const handleTabChange = (tabName) => {
  queryParams.value.categoryId = tabName;
  queryParams.value.pageNum = 1;
  getList();
}
/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
function resetQuery() {
  dateRange.value = [];
  proxy.resetForm("queryRef");
  handleQuery();
}
/** 预览按钮 */
function handlePreview(row) {
  previewTable(row.tableId).then((response) => {
    preview.value.data = response.data;
    preview.value.open = true;
    preview.value.activeName = "domain.java";
  });
}
/** 复制代码成功 */
function copyTextSuccess() {
  proxy.$modal.msgSuccess("复制成功");
}
// 多选框选中数据
function handleSelectionChange(selection) {
  ids.value = selection.map((item) => item.tableId);
  tableNames.value = selection.map((item) => item.tableName);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}
/** 修改按钮操作 */
function handleEdit(row) {
  const tableId = row.tableId || ids.value[0];
  router.push({
    path: "/tool/gen-edit/index/" + tableId,
    query: { pageNum: queryParams.value.pageNum },
  });
}
/** 删除按钮操作 */
function handleDelete(row) {
  const tableIds = row.tableId || ids.value;
  proxy.$modal
    .confirm('是否确认删除表编号为"' + tableIds + '"的数据项？')
    .then(function () {
      return delTable(tableIds);
    })
    .then(() => {
      getList();
      proxy.$modal.msgSuccess("删除成功");
    })
    .catch(() => { });
}

getCategoryList();
</script>
