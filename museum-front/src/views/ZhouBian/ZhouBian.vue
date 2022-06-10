<template>
<div>


    <iframe src="/test/dly.html" scrolling="auto" frameborder="0" style="width: 100%;height: 900px;"></iframe>

    <div class="h2">今日上新</div>
    <div class="categroy">
        <a class="c_item" @click="fenlei('')">全部：</a>
        <a class="c_item" @click="fenlei('手办')">手办</a>
        <a class="c_item" @click="fenlei('文具')">文具</a>
        <a class="c_item" @click="fenlei('服饰')">服饰</a>
        <a class="c_item" @click="fenlei('钥扣')">钥扣</a>
        <a class="c_item" @click="fenlei('书籍')">书籍</a>
    </div>

    <div class="card" v-for="(item,index) in culturalRelic" :key="item" @click="show1(item)">
        <div class="c_img1">
            <img class="c_imgs" :src="pres[index]" alt="">
        </div>
        <div class="c_desc1">
            {{item.name}}
        </div>
        <div class="c_peice">
           ￥:{{item.price}}
        </div>
    </div>


</div>



</template>

<script>
import indexPage from "../../api/indexPage";

export default {
  name: "zhoubian",


    data(){
        return{
            pres:[],
            culturalRelic:[],
        }
    },

    mounted() {
        if(this.$route.query.id){
            this.getByName();
        }else{
            this.getIndexPages();
        }
    },

    methods:{

        getIndexPages() {
            indexPage.allZhouBian().then(response=>{
                console.log(response.data.items)
                this.culturalRelic = response.data.items;
                for (let i = 0 ;i< this.culturalRelic.length;i ++){
                    let arr = require("../../assets/newCu/"+this.culturalRelic[i].img);
                    this.pres.push(arr);
                }
            })
        },

        getByName() {
            indexPage.getCulturalRelicByName(this.$route.query.id).then(response=>{
                this.culturalRelic = response.data.items;
                for (let i = 0 ;i< this.culturalRelic.length;i ++){
                    let arr = require("../../assets/newCu/"+this.culturalRelic[i].img);
                    this.pres.push(arr);
                }
            })
        },

        fenlei(msg){
            this.culturalRelic.length =0;
            this.pres.length=0;
            if(msg === ''){
                this.getIndexPages();
            }else{
                indexPage.getZhoubianByType(msg).then(response=>{
                    this.culturalRelic = response.data.items;
                    for (let i = 0 ;i< this.culturalRelic.length;i ++){
                        let arr = require("../../assets/newCu/"+this.culturalRelic[i].img);
                        this.pres.push(arr);
                    }
                })
            }
        },


        show1(item){
            this.$router.push({path:'ZhouBianDetail',query: {id:item.id}})
        },

    },
}
</script>

<style scoped>

    .h2 {
        margin: 20px;
        font-size: 36px;
        color: #409EFF;
        text-align: center;
    }

    .myContainer{
        margin-left: 142px;
        margin-right: 142px;
        overflow: hidden;
    }
    .title {
        background-color: black;
        font-size: 24px;
        height: 60px;
        line-height: 60px;
        color: white;
        text-align: center;
        border-bottom: 1px solid white;
    }
    .c_d {
        overflow: hidden;
    }

    .c_img {
        float: left;
        height: 350px;
        width: 40%;
    }
    .c_img img {
        width: 100%;
        height: 100%;
    }
    .c_desc {
        background-color: black;
        height: 350px;
        float: left;
        width: 60%;
    }
    .c_desc p {
        margin: 40px;
        text-align: center;
        color: white;
    }

    .temp {
        background-color: black;
        height: 40px;
    }
    .card {
        padding-top: 30px;
        overflow: hidden;
        cursor:pointer;
        float: left;
        margin: 10px;
        width: 255px;
        height: 260px;
        margin-left: 60px;
    }

    .c_img1{
        height: 80%;
    }
    .c_imgs {
        width: 100%;
        height: 100%;
    }

    .c_desc1 {
        height: 20%;
        padding: 10px;
        float: left;
    }
    .c_peice {
        height: 20%;
        padding: 10px;
        color: red;
        float: right;
    }

    .categroy {
        margin: 20px;
        overflow: hidden;
        margin-left: 100px;
    }

    .c_item {
        float: left;
        margin-left: 20px;

    }
    .c_item a:hover {
        cursor: pointer;
    }
</style>
