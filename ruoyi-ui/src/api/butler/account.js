import request from '@/utils/request';

// 查询生成表数据
export function listAccount(query) {
  return request({
    url: '/butler/account/list',
    method: 'get',
    params: query,
  });
}
// 查询db数据库列表
export function listDbAccount(query) {
  return request({
    url: '/butler/account/db/list',
    method: 'get',
    params: query,
  });
}

// 查询表详细信息
export function getGenAccount(accountId) {
  return request({
    url: '/butler/account/' + accountId,
    method: 'get',
  });
}

// 修改代码生成信息
export function updateGenAccount(data) {
  return request({
    url: '/butler/gen',
    method: 'put',
    data: data,
  });
}

// 导入表
export function importAccount(data) {
  return request({
    url: '/butler/account/importAccount',
    method: 'post',
    params: data,
  });
}

// 预览生成代码
export function previewAccount(accountId) {
  return request({
    url: '/butler/account/preview/' + accountId,
    method: 'get',
  });
}

// 删除表数据
export function delAccount(accountId) {
  return request({
    url: '/butler/account/' + accountId,
    method: 'delete',
  });
}

// 生成代码（自定义路径）
export function genCode(accountName) {
  return request({
    url: '/butler/account/genbutler/' + accountName,
    method: 'get',
  });
}

// 同步数据库
export function synchDb(accountName) {
  return request({
    url: '/butler/account/synchDb/' + accountName,
    method: 'get',
  });
}
