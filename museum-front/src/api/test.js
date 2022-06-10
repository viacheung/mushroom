import request from "../utils/request";


export default {

    testPostApi(){
        return request({
            url: '/test/testPostApi',
            method: 'post'
        })
    }



}
