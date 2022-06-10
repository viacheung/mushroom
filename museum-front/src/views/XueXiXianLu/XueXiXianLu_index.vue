
<template>
  <div class="myContainer">
    <el-divider><el-tag type="warning">我收藏的文物</el-tag></el-divider>

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
import cookie from "js-cookie";

export default {
  data() {
    return {
      activities: [
        {
          timestamp: 'Java基础',
          size: 'large',
          type: 'primary',
          icon: 'el-icon-guide',
        },
        {
          timestamp: 'Java中级',
          size: 'large',
          type: 'primary',
          icon: 'el-icon-guide',
        },
      ],
      pres: [],
      culturalRelic: [],
      enshrine:{},
    }
  },
    mounted() {
      this.getIndexPages();
    },

    methods:{
      getIndexPages() {
        this.enshrine.name = cookie.get('userName')
        indexPage.allEnshrine(this.enshrine).then(response=>{
          this.culturalRelic = response.data.items;
          console.log(this.culturalRelic)
          for (let i = 0 ;i< this.culturalRelic.length;i ++){
            let arr = require("../../assets/newCu/"+this.culturalRelic[i].img);
            this.pres.push(arr);
          }
        })
      },

      show1(item){
        this.$router.push({path:'/BiShe/details',query: {id:item.culturalRelicId}})
      },


    }
}
</script>

<style scoped>
.myContainer{
  margin-top: 20px;
  margin-left: 142px;
  margin-right: 142px;
  min-height: 800px;
}

.card {
  overflow: hidden;
  cursor:pointer;
  float: left;
  margin: 10px;
  width: 260px;
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
</style>
