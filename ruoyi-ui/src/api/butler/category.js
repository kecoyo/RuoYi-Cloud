import request from '@/utils/request';

// 查询分类列表
export function listCategory(query) {
  return request({
    url: '/butler/category/list',
    method: 'get',
    params: query,
  });
}

// 查询分类列表，统计账号数量
export function listCategoryCount(query) {
  return request({
    url: '/butler/category/listCount',
    method: 'get',
    params: query,
  });
}

// 获取分类详情
export function getCategory(id) {
  return request({
    url: '/butler/category/' + id,
    method: 'get',
  });
}

// 新增分类
export function addCategory(data) {
  return request({
    url: '/butler/category',
    method: 'post',
    data: data,
  });
}

// 修改分类
export function updateCategory(data) {
  return request({
    url: '/butler/category',
    method: 'put',
    data: data,
  });
}

// 删除分类
export function delCategory(id) {
  return request({
    url: '/butler/category/' + id,
    method: 'delete',
  });
}

// 修改分类状态
export function changeCategoryStatus(id, status) {
  const data = {
    id,
    status,
  };
  return request({
    url: '/butler/category/changeStatus',
    method: 'put',
    data: data,
  });
}
