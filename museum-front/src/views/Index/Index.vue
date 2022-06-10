<template>
  <div class="box1">

    <div class="lbt">
      <el-carousel :interval="2000" type="card" height="350px" >
        <el-carousel-item >
          <img title="" src="../../assets/img/01.jpg" style="width: 80%;height: 100%">
        </el-carousel-item>
        <el-carousel-item >
          <img title="" src="../../assets/img/02.jpg" style="width: 80%;height: 100%">
        </el-carousel-item>
        <el-carousel-item >
        <img title="" src="../../assets/img/03.jpg" style="width: 80%;height: 100%">
      </el-carousel-item>
        <el-carousel-item >
          <img title="" src="../../assets/img/04.jpg" style="width: 80%;height: 100%">
        </el-carousel-item>
        <el-carousel-item >
          <img title="" src="../../assets/img/05.jpg" style="width: 80%;height: 100%">
        </el-carousel-item>
        <el-carousel-item >
          <img title="" src="../../assets/img/06.jpg" style="width: 80%;height: 100%">
        </el-carousel-item>
        <el-carousel-item >
          <img title="" src="../../assets/img/07.jpg" style="width: 80%;height: 100%">
        </el-carousel-item>
        <el-carousel-item >
          <img title="" src="../../assets/img/08.jpg" style="width: 80%;height: 100%">
        </el-carousel-item>
        <el-carousel-item >
          <img title="" src="../../assets/img/09.jpg" style="width: 80%;height: 100%">
        </el-carousel-item>
        <el-carousel-item >
          <img title="" src="../../assets/img/10.jpg" style="width: 80%;height: 100%">
        </el-carousel-item>
        <el-carousel-item >
          <img title="" src="../../assets/img/11.jpg" style="width: 80%;height: 100%">
        </el-carousel-item>
        <el-carousel-item >
          <img title="" src="../../assets/img/12.jpg" style="width: 80%;height: 100%">
        </el-carousel-item>
        <el-carousel-item >
          <img title="" src="../../assets/img/13.jpg" style="width: 80%;height: 100%">
        </el-carousel-item>
        <el-carousel-item >
          <img title="" src="../../assets/img/14.jpg" style="width: 80%;height: 100%">
        </el-carousel-item>
        <el-carousel-item >
          <img title="" src="../../assets/img/15.jpg" style="width: 80%;height: 100%">
        </el-carousel-item>
        <el-carousel-item >
          <img title="" src="../../assets/img/16.jpg" style="width: 80%;height: 100%">
        </el-carousel-item>
      </el-carousel>
    </div>


    <div class="car1">

      <div class="c_item">
        <div class="itemHeader1">
          <div class="h1" id="date11">{{date}}</div>
        </div>
        <div class="itemContent1">
          <div class="h2">今日开馆</div>
          <div class="p">
            除法定节假日，牛首博物馆全年实行周一闭馆<strong> 入馆参观需验证健康码，测体温，刷身份证</strong>
          </div>
        </div>
      </div>

      <div class="c_item">
        <div class="visi">
          <div class="itemHeader">
            <span>第一资讯</span>
          </div>
          <div class="itemContent">
            <ul>
              <li @click="show1(item)" v-for="item in notice">{{item.title}}</li>
            </ul>
          </div>
        </div>
      </div>

      <div class="c_item">
        <div class="visi">
          <div class="itemHeader">
            <span>馆内上新</span>
          </div>
          <div class="itemContent">
            <ul >
              <li @click="show2(item)" v-for="item in newCu">{{item.culturalRelicName}}</li>
            </ul>
          </div>
        </div>
      </div>

    </div>

  </div>
</template>

<script>

import indexPage from "../../api/indexPage";


export default {
  name: "Index",
  data(){
    return{
      date:'',
      notice:[],
      newCu:[],
      Obj:{},
      dialogTableVisible: true,
      pageItems:[]
    }
  },

  mounted() {
    this.getIndexPages();
    this.getData()
  },

  methods:{


    getIndexPages() {
      indexPage.getNewNotice().then(response=>{
        this.notice = response.data.items
      })
      indexPage.getNewCu().then(response=>{
        this.newCu = response.data.items
        console.log(this.newCu)
      })
    },

    getData(){
      var datetime = new Date();
      var year = datetime.getFullYear();
      var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
      var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
      this.date = year+"/"+month+"/"+date
    },

    show1(obj){
      this.$alert(
              '<p>资讯ID：'+obj.id+'</p>' +
              '<p>发布人：'+obj.publisher+'</p>' +
              '<p>资讯内容：'+obj.content+'</p>' +
              '<p>发布时间：'+obj.release_time+'</p>'
              , obj.title, {
        dangerouslyUseHTMLString: true
      });
    },

    show2(obj){
      this.$router.push({path:'/BiShe/details',query: {id:obj.culturalRelicId}})
    }
  },







}
</script>

<style scoped>

  .box1 {
    background-image: url('../../assets/bg1.jpg')
  }

  .lbt {
    margin: 10px 100px 10px 100px;
    padding-top: 30px;
  }

  .car1 {
    overflow: hidden;
    margin-left: 20px;
  }

  .c_item {
    float: left;
    width: 30%;
    height: 310px;
    background-color: #8080C0;
    border-radius: 20px;
    margin: 20px 20px 80px 20px;
  }

  .h1 {
    text-align: center;
    margin-top: 20px;
    font-size: 40px;
    color: white;
  }

  .h2 {
    margin: 20px;
    font-size: 36px;
    color: #409EFF;
    text-align: center;
  }


  .p {
    margin: 40px;
    text-align: center;
    font-size: 24px;
    color: yellow;
  }

  .itemHeader {
    background-color: white;
    text-align: center;
    font-size: 22px;
    height: 60px;
    line-height: 60px;
    color: #409EFF;
  }

  .itemContent li {
    margin: 26px;
    font-size: 18px;
    color: white;
    cursor: pointer;
  }

  p {
    margin: 20px;
  }

</style>
