<template>
{{date}}---{{time}}
</template>

<script>
    import request from '../../../utils/request';

export default {
    name: "Header",
    data() {
        return {
            date: '123',
            time: ''
        }
    },

    mounted() {

        this.getDate();
        this.timer = setInterval(() => {
            this.getTime();
        }, 1000)
    },

    methods:{

        getDate(){
            let weeks = ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'];
            let time = new Date();
            let year = time.getFullYear();
            let month = time.getMonth() + 1;
            let day = time.getDate();
            let week = weeks[time.getDay()];
            this.getTime();
            this.date = year + '-' + month + '-' + day + " " + week;
        },

        getTime(){
            let time = new Date();
            let hour = time.getHours();
            let minutes = time.getMinutes();
            let second = time.getSeconds();
            if(minutes<10){
                minutes='0'+minutes
            }
            if(second<10){
                second='0'+second
            }
            this.time = hour + "：" + minutes+": "+second
        },

        getWeather(){

            request({
                url: '/test/testPostApi',
                method: 'post'
            }).then()

        }

    }




}
</script>

<style scoped>

</style>
