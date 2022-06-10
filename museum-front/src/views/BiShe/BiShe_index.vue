<template>
  <div class="myContainer">
    <div class="title">牛首博物馆藏品</div>
    <div class="temp"></div>
    <div class="c_d">
      <div class="c_img">
        <img src="../../assets/web.jpg" alt="">
      </div>
      <div class="c_desc">
        <p>牛首博物馆拥有藏品数余件，涵盖了从远古时期到当代各个历史阶段社会发展变化不同方面的内容，具有高度的历史价值、科学价值和艺术价值，全面系统完整地展现中华优秀传统文化、革命文化、社会主义先进文化，是中华文明发展史的典藏宝库。
        </p>
        <p>作为国家级的博物馆，牛首博物馆建立了一整套严格的藏品保管的规章制度，形成了国家博物馆科学严密的藏品保管体系。同时,加大对馆藏藏品整理工作力度，注重发掘藏品自身的内在价值,发挥其在展览陈列中的印证、具象历史的独特作用,国家博物馆顺应时代和社会发展的要求，把各类藏品信息适时公布于众,实现社会共享博物馆的藏品资源，提升馆藏文物的认知度和社会价值。</p>
      </div>
    </div>

    <div class="categroy">
      <a class="c_item" @click="fenlei('')">全部：</a>
      <a class="c_item" @click="fenlei('银质')">银质</a>
      <a class="c_item" @click="fenlei('翡翠')">翡翠</a>
      <a class="c_item" @click="fenlei('铁质')">铁质</a>
      <a class="c_item" @click="fenlei('铜质')">铜质</a>
      <a class="c_item" @click="fenlei('陶瓷')">陶瓷</a>
      <a class="c_item" @click="fenlei('铜像')">铜像</a>
      <a class="c_item" @click="fenlei('仕女图')">仕女图</a>
    </div>



    <div class="card" v-for="(item,index) in culturalRelic" :key="item" @click="show1(item)">
      <div class="c_img1">
        <img class="c_imgs" :src="pres[index]" alt="">
      </div>
      <div class="c_desc1">
        {{item.culturalRelicName}}
      </div>
    </div>
  </div>
</template>

<script>


import indexPage from "../../api/indexPage";

export default {
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
      indexPage.queryCulturalRelic().then(response=>{
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
        indexPage.getCulturalRelicByType(msg).then(response=>{
          this.culturalRelic = response.data.item;
          for (let i = 0 ;i< this.culturalRelic.length;i ++){
            let arr = require("../../assets/newCu/"+this.culturalRelic[i].img);
            this.pres.push(arr);
          }
        })
      }
    },


    show1(item){
      this.$router.push({path:'/BiShe/details',query: {id:item.culturalRelicId}})
    },

  },


}
</script>

<style>
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
  overflow: hidden;
  cursor:pointer;
  float: left;
  margin: 10px;
  width: 255px;
  height: 260px;
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
  text-align: center;
}

.categroy {
  margin: 20px;
  overflow: hidden;
}

.c_item {
  float: left;
  margin-left: 20px;

}
  .c_item a:hover {
    cursor: pointer;
  }

</style>
