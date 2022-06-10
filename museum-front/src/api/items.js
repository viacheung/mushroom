import request from "../utils/request";

export default {

    addItems(items){
        return request({
            url: '/admin/item/addItems',
            method:'post',
            data:items
        })
    },

    getItemsByPage(page,limit){
        return request({
            url:`/admin/item/getItems/${page}/${limit}`,
            method:'get',
        })
    },

    getCount(){
        return request({
            url:'/admin/item/getCount/',
            method:'get',
        })
    },

    delItems(id){
        return request({
            url:`/admin/item/delItems/${id}`,
            method:'delete',
        })
    },

    getItemsById(id){
        return request({
            url:`/admin/item/getItemsById/${id}`,
            method:'get',
        })
    },

    editItems(items){
        return request({
            url:'/admin/item/editItems',
            method:'post',
            data: items
        })
    },

    getByCondition(ItemsQueryVo){
        return request({
            url:'/api/getByCondition',
            method:'get',
            params: ItemsQueryVo
        })
    },





}
