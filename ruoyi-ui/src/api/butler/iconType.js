import request from '@/utils/request';

// 查询分类列表
export function listIconType(query) {
  return request({
    url: '/butler/iconType/list',
    method: 'get',
    params: query,
  });
}

// 查询分类列表，统计账号数量
export function listIconTypeCount(query) {
  return request({
    url: '/butler/iconType/listCount',
    method: 'get',
    params: query,
  });
}

// 获取分类详情
export function getIconType(id) {
  return request({
    url: '/butler/iconType/' + id,
    method: 'get',
  });
}

// 新增分类
export function addIconType(data) {
  return request({
    url: '/butler/iconType',
    method: 'post',
    data: data,
  });
}

// 修改分类
export function updateIconType(data) {
  return request({
    url: '/butler/iconType',
    method: 'put',
    data: data,
  });
}

// 删除分类
export function delIconType(id) {
  return request({
    url: '/butler/iconType/' + id,
    method: 'delete',
  });
}

// 修改分类状态
export function changeIconTypeStatus(id, status) {
  const data = {
    id,
    status,
  };
  return request({
    url: '/butler/iconType/changeStatus',
    method: 'put',
    data: data,
  });
}
