import axios from 'axios'
import { ElMessage } from 'element-plus'

// 创建axios实例
const service = axios.create({
    baseURL: 'http://127.0.0.1:9001/', // api 的 base_url
    timeout: 12000 // 请求超时时间
})

// request拦截器
service.interceptors.request.use(
    config => {
      /*  if (store.getters.token) {
            config.headers['X-Token'] = getToken() // 让每个请求携带自定义token 请根据实际情况自行修改
        }*/
        //todo 添加携带token
        //console.log('requestInterceptors:->')
        //console.log(config)
        return config
    },
    error => {
        // Do something with request error
        ElMessage({
            showClose: true,
            message: 'requestInterceptorsError:'+error,
            type: 'error',
            center: true,
            duration: 5 * 1000
        });
        console.log(error) // for debug
        return Promise.reject(error)
    }
)

// response 拦截器
service.interceptors.response.use(
    response => {
        /**
         * code为非20000是抛错 可结合自己业务进行修改
         */
        const res = response.data
        //console.log(res.code)

        if (res.code !== 20000) {
            ElMessage({
                showClose: true,
                message: 'responseInterceptorsMsg:'+res.message,
                type: 'error',
                center: true,
                duration: 5 * 1000
            });

            // 50008:非法的token; 50012:其他客户端登录了;  50014:Token 过期了;
        /*    if (res.code === 50008 || res.code === 50012 || res.code === 50014) {
                MessageBox.confirm(
                    '你已被登出，可以取消继续留在该页面，或者重新登录',
                    '确定登出',
                    {
                        confirmButtonText: '重新登录',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }
                ).then(() => {
                    store.dispatch('FedLogOut').then(() => {
                        location.reload() // 为了重新实例化vue-router对象 避免bug
                    })
                })
            }*/
            return Promise.reject('error')
        } else {
            return response.data
        }
    },
    error => {
        console.log('err' + error) // for debug
        ElMessage({
            showClose: true,
            message: error,
            type: 'error',
            center: true,
            duration: 5 * 1000
        });
        return Promise.reject(error)
    }
)

export default service
