<template>
  <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect" router>
    <el-menu-item >
      牛首博物馆
      <img title="慕课网" src="../assets/logo.png" style="margin-left: 10px;margin-right: 90px;width: 50px;height: 50px" >
    </el-menu-item>
    <el-menu-item @click="Index">首页</el-menu-item>
    <el-menu-item @click="BiShe">所有藏品</el-menu-item>
    <el-menu-item @click="ZhouBian">文物周边</el-menu-item>
    <el-menu-item @click="collection" >我的收藏</el-menu-item>
    <el-menu-item @click="order" >我的订单</el-menu-item>
    <el-menu-item @click="login" v-if="userName === ''">登录/注册</el-menu-item>
    <el-menu-item @click="toUser" v-else>个人中心</el-menu-item>
    <el-menu-item >
      <el-input v-model="input" placeholder="请输入关键词"></el-input>&nbsp;
      <el-button type="primary" icon="el-icon-search" @click="search" size="small">搜索</el-button>
    </el-menu-item>
    <el-menu-item  @click="centerDialogVisible = true"  style="float: right;margin-left: 45px">管理后台</el-menu-item>
  </el-menu>

  <el-dialog  :show-close="false" v-model="centerDialogVisible" width="40%" center >

    <el-tabs  v-model="activeName"  type="card" >
      <el-tab-pane label="管理员登录" name="first">
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="用户名">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input type="password" v-model="form.pwd" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="验证码">
            <el-input style="width:45%;" v-model="form.code" autocomplete="off"></el-input>
            <img style="height:40px;float:right;width:45%"  @click="showimg" :src="img" />
          </el-form-item>
        </el-form>
      </el-tab-pane>
    </el-tabs>

    <template #footer>
      <span class="dialog-footer">
        <el-button @click="cancel">取 消</el-button>
        <el-button type="primary" @click="submit1">提 交</el-button>
      </span>
    </template>

  </el-dialog>

  <el-dialog  :show-close="false" v-model="centerDialogVisible1" width="40%" center >

    <el-tabs  v-model="activeName"  type="card" >
      <el-tab-pane label="登录" name="first">
        <el-form ref="form" :model="form1" label-width="80px">
          <el-form-item label="用户名">
            <el-input v-model="form1.userName"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input type="password" v-model="form1.userPwd" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="验证码">
            <el-input style="width:45%;" v-model="form1.code" autocomplete="off"></el-input>
            <img style="height:40px;float:right;width:45%"  @click="showimg" :src="img" />
          </el-form-item>
        </el-form>
      </el-tab-pane>

      <el-tab-pane label="注册" name="second">
        <el-form ref="form" :model="form1" label-width="80px">
          <el-form-item label="用户名">
            <el-input v-model="form1.userName"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input type="password" v-model="form1.userPwd" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="性别">
            <el-input v-model="form1.userSex" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="手机">
            <el-input v-model="form1.userPhone"></el-input>
          </el-form-item>
          <el-form-item label="邮箱">
            <el-input v-model="form1.userEmail"></el-input>
          </el-form-item>
        </el-form>
      </el-tab-pane>
    </el-tabs>

    <template #footer>
      <span class="dialog-footer">
        <el-button @click="cancel1">取 消</el-button>
        <el-button type="primary" @click="submit">提 交</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script>
  import cookie from "js-cookie";
  import indexPage from "../api/indexPage";


  export default {
    data() {
      return {
        activeName: 'first',
        userName:'',
        centerDialogVisible: false,
        centerDialogVisible1: false,
        activeIndex: '/Index',
        input:'',
        img:'',
        code:'',
        form: {
          name: '',
          pwd: '',
        },
        form1: {
          userName: '',
          code:'',
          userPwd: '',
          userSex:'',
          userPhone: '',
          userEmail: ''
        },
      };
    },
    mounted() {
      this.showimg();
      if(cookie.get('userName')){
        this.userName = cookie.get('userName');
      }
    },

    methods: {
      showimg(){
        this.code = this.getCode(4);
        this.img = "http://127.0.0.1:9001/user/verifyPic?code="+this.code
      },
      toUser(){
        this.$router.push('/Blog');
      },
      getCode(n) {
        var all = "azxcvbnmsdfghjklqwertyuiopZXCVBNMASDFGHJKLQWERTYUIOP0123456789";
        var b = "";
        for (var i = 0; i < n; i++) {
          var index = Math.floor(Math.random() * 62);
          b += all.charAt(index);
        }
        return b;
      },


      login(){
        this.centerDialogVisible1 = true
      },

      cancel1(){
        this.form1.userName = null;
        this.form1.userPwd = null;
        this.form1.userSex = null;
        this.form1.userPhone = null;
        this.form1.userEmail = null;
        this.centerDialogVisible1=false;
      },

      handleSelect(key, keyPath) {
        this.activeIndex = key;
        console.log(key, keyPath);
      },

      cancel(){
        this.form.name = null;
        this.form.pwd = null;
        this.form.code = '';
        this.centerDialogVisible=false;
      },

      submit1(){
        if(this.form.code.toLowerCase()!=this.code.toLowerCase()) {
          this.$message.error('验证码错误！')
          return;
        }
        indexPage.adminLogin(this.form).then( response=>{
          this.$router.push('/admin');
        })
      },

      search(){
        this.$router.push({path:'/BiShe',query: {id:this.input}})
      },

      collection(){
        if(cookie.get('userName')){
          this.$router.push('/XueXiXianLu');
        }else{
          this.$message.success("您未登录，请登录后查看！");
        }
      },

      order(){
        if(cookie.get('userName')){
          this.$router.push('/Order');
        }else{
          this.$message.success("您未登录，请登录后查看！");
        }
      },

      ZhouBian(){
        this.$router.push('/ZhouBian');
      },

      Index(){
        this.$router.push('/Index');
      },

      BiShe(){
        this.$router.push('/BiShe');
      },

      submit(){
        if("first" === this.activeName){//登录
          if(this.form1.code.toLowerCase()!=this.code.toLowerCase()) {
            this.$message.error('验证码错误！')
            return;
          }
          indexPage.userLogin(this.form1).then(response=>{
            //alert(response.data.item.userName)
            cookie.set('userName',this.form1.userName)
            this.$message.success("登录成功！");
            this.cancel1()
            this.$router.go(0);
          })
        }else { //注册
          indexPage.register(this.form1).then(response=>{
            cookie.set('userName',this.form1.userName)
            this.$message.success("登录成功！");
            this.cancel1()
            this.$router.go(0);
          })
        }

      },

    }
  }
</script>
