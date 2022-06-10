import request from "../utils/request";

export default {

    getNewCu(){
        return request({
                url: '/api/newCu',
                method: 'post',
        })
    },

    getNewNotice(){
        return request({
            url: '/api/newNotice',
            method: 'post',
        })
    },

    queryCulturalRelic(){
        return request({
            url: '/api/queryCulturalRelic',
            method: 'post',
        })
    },

    adminLogin(admin){
        return request({
            url: '/admin/adminLogin',
            method: 'post',
            data: admin
        })
    },

    addNotice(notice){
        return request({
            url: '/admin/notice',
            method: 'post',
            data: notice
        })
    },

    allNotice(page,limit){
        return request({
            url: '/admin/allNotice',
            method: 'get',
            params: {
                page,limit
            }
        })
    },

    delNotice(id){
        return request({
            url: '/admin/deleteNotice',
            method: 'post',
            params: {
                id
            }
        })
    },

    allCulturalRelic(page,limit,culturalRelicName){
        return request({
            url: '/admin/allCulturalRelic',
            method: 'post',
            params: {
                page,limit,culturalRelicName
            }
        })
    },

    addCulturalRelic(cultural){
        return request({
            url: '/admin/culturalRelic',
            method: 'post',
            data: cultural
        })
    },

    delCulturalRelic(id){
        return request({
            url: '/admin/deleteCulturalRelic',
            method: 'post',
            params: {
                id
            }
        })
    },

    updateCulturalRelic(culturalRelic){
        return request({
            url: '/admin/updateCulturalRelic',
            method: 'post',
            data: culturalRelic
        })
    },

    getCulturalRelic(id){
        return request({
            url: '/admin/getCulturalRelicById',
            method: 'post',
            params: {
                id
            }
        })
    },

    getCulturalRelicByType(type){
        return request({
            url: '/admin/getCulturalRelicByType',
            method: 'post',
            params: {
                type
            }
        })
    },

    allUser(page,limit){
        return request({
            url: '/admin/allUser',
            method: 'post',
            params: {
                page,limit
            }
        })
    },

    delUser(userName){
        return request({
            url: '/admin/deleteUser',
            method: 'post',
            params: {
                userName
            }
        })
    },

    getUserByName(userName){
        return request({
            url: '/admin/getUserByName',
            method: 'post',
            params: {
                userName
            }
        })
    },

    getCulturalRelicByName(name){
        return request({
            url: '/user/getCulturalRelicByName',
            method: 'post',
            params: {
                name
            }
        })
    },

    userLogin(user){
        return request({
            url: '/user/login',
            method: 'post',
            data: user
        })
    },

    register(user){
        return request({
            url: '/user/register',
            method: 'post',
            data: user
        })
    },

    updateUser(user){
        return request({
            url: '/user/updateUser',
            method: 'post',
            data: user
        })
    },

    userEnshrine(enshrine){
        return request({
            url: '/user/userEnshrine',
            method: 'post',
            data: enshrine
        })
    },

    queryEnshrine(enshrine){
        return request({
            url: '/user/queryEnshrine1',
            method: 'post',
            data: enshrine
        })
    },

    deleteUserEnshrine(enshrine){
        return request({
            url: '/user/deleteUserEnshrine',
            method: 'post',
            data: enshrine
        })
    },

    allEnshrine(enshrine){
        return request({
            url: '/user/queryEnshrine',
            method: 'post',
            data: enshrine
        })
    },


    addZhoubian(item){
        return request({
            url: '/zhoubian/add',
            method: 'post',
            data: item
        })
    },

    allZhouBian(){
        return request({
            url: '/zhoubian/list',
            method: 'get',
        })
    },

    delZhoubian(id){
        return request({
            url: '/zhoubian/del',
            method: 'post',
            params: {
                id
            }
        })
    },

    getZhoubianByType(type){
        return request({
            url: '/zhoubian/listByType',
            method: 'post',
            params: {
                type
            }
        })
    },

    getZhoubianById(id){
        return request({
            url: '/zhoubian/getById',
            method: 'post',
            params: {
                id
            }
        })
    },

    payZhouBian(item){
        return request({
            url: '/order/add',
            method: 'post',
            data: item
        })
    },

    allOrder(){
        return request({
            url: '/order/all',
            method: 'get',
        })
    },

    fahuo(id){
        return request({
            url: '/order/update',
            method: 'post',
            params: {
                id
            }
        })
    },

    getOrderByName(uid){
        return request({
            url: '/order/getByName',
            method: 'post',
            params: {
                uid
            }
        })
    },
}
