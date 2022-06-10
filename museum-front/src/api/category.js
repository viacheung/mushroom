import request from "../utils/request";


export default {

    addCategory(category){
        return request({
            url: '/admin/addCategory',
            method: 'post',
            data: category
        })
    },

    /**
     * 分页查询
     * @param page
     * @param limit
     * @returns {AxiosPromise}
     */
    getCategoryList(page,limit){
        return request({
            url:`/admin/categoryList/${page}/${limit}`,
            method: 'get',
        })
    },

    delCategory(id){
        return request({
            url: `/admin/delCategory/${id}`,
            method: 'delete'
        })
    },

    editCategory(category){
        return request({
            url: '/admin/editCategory',
            method: 'post',
            data: category
        })
    },

    /**
     * 获取全部分类
     */
    getCategory() {
        return request({
            url: '/admin/getCategory',
            method: 'get'
        })
    }


}
