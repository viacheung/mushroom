<template>
  <div class="b-page">
  <div class="myContainer">
    <div class="h2">文物详情</div>
    <div class="d_img">
      <img :src="img" alt="">
    </div>

    <div class="d_desc">
      <h2>{{items.culturalRelicName}}</h2>
      <p>文物编号： {{items.culturalRelicId}}</p>
      <p>文物类别： {{items.culturalRelicType}}</p>
      <p>文物描述： {{items.culturalRelicDescription}}</p>
      <p>发布时间： {{items.culturalRelicTime}}</p>

      <div class="d_btn">
        <el-button type="primary"  @click="collection" >收藏/取消收藏</el-button>
      </div>

    </div>

  </div>

  <!--<div class="liuyan">
    <div class="h3">发表评论</div>
    <div>
      <el-input
              type="textarea"
              :autosize="{ minRows:6, maxRows:6}"
              :rows="2"
              placeholder="请输入内容"
              v-model="textarea">
      </el-input>
    </div>
    <div class="tijiao">
    <el-button type="primary" @click="submit">发表</el-button>
    </div>
  </div>-->



  </div>
</template>

<script>
import indexPage from "../../api/indexPage";
import cookie from "js-cookie";


export default {
  data(){
    return {
      activeName:'first',
      img:'',
      userName:'',
      isCollection: '',
      items:{},
      enshrine:{},
      textarea: '',
    }
  },
  created() {
    this.getItemsById(this.$route.query.id)
    this.queryEnshrine()
    if(cookie.get('userName')){
      this.userName = cookie.get('userName');
    }
  },

  methods:{


    getItemsById(id){
      indexPage.getCulturalRelic(id).then(response=>{
        this.items = response.data.item;
        this.img  = require("../../assets/newCu/"+this.items.img);
        console.log(this.items)
      })
    },


    collection(){
      if(this.userName === ''){
        this.$message.success("您未登录，请登录后查看！");
      }else{
        if(!this.isCollection){//收藏
          this.enshrine.name = this.userName
          this.enshrine.imgId = this.$route.query.id
          indexPage.userEnshrine(this.enshrine).then(response=>{
            this.$message.success("收藏成功！");
            this.isCollection = true
          })
        }else {//取消收藏
          this.enshrine.name = this.userName
          this.enshrine.imgId = this.$route.query.id
          indexPage.deleteUserEnshrine(this.enshrine).then(response=>{
            this.$message.success("取消收藏成功！");
            this.isCollection = false
          })
        }
      }
    },


    queryEnshrine(){
      this.enshrine.name = cookie.get('userName')
      this.enshrine.imgId = this.$route.query.id
      indexPage.queryEnshrine(this.enshrine).then(response=>{
          this.isCollection = response.data.flag
      })
    },

    submit(){

    }



  }



}
</script>

<style>
.b-page{
    background-color: #444444;
}

.h2 {
    margin: 20px;
    font-size: 36px;
    color: #409EFF;
    text-align: center;
}

.h3 {
  margin: 20px;
  font-size: 25px;
  color: #409EFF;
}

.myContainer{
  margin-top: 20px;
  margin-left: 142px;
  margin-right: 142px;
  overflow: hidden;
  min-height: 600px;
}

.liuyan{
  margin-top: 0 px;
  margin-left: 142px;
  margin-right: 142px;
  overflow: hidden;
  min-height: 800px;
}


.d_img {
  float: left;
  width: 60%;
  height: 500px;
}

.d_img img {
  width: 100%;
  height: 100%;
}

.d_desc {
  float: right;
  padding-bottom: 20px;

  width: 39%;
  border: 1px dashed  #409EFF;
}
.d_desc h2 {
  text-align: center;
  font-size: 30px;
  color: #409EFF;
}
.d_desc p {
  color: white;
  margin: 20px;
  font-size: 20px;
}

.d_btn {
  text-align: center;
}

.tijiao {
  float: right;
}

</style>
