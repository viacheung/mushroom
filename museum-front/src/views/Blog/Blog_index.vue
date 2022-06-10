<template>
  <div class="page1">
    <div class="myContainer">
      <div class="form1">
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="用户名">
            <el-input v-model="form.userName" :disabled="true" style="width: 500px;"></el-input>
          </el-form-item>
          <el-form-item label="用户密码">
            <el-input v-model="form.userPwd"  style="width: 500px;"></el-input>
          </el-form-item>
          <el-form-item label="用户性别">
            <el-input v-model="form.userSex"  style="width: 500px;"></el-input>
          </el-form-item>
          <el-form-item label="用户手机">
            <el-input v-model="form.userPhone"  style="width: 500px;"></el-input>
          </el-form-item>
          <el-form-item label="用户邮箱">
            <el-input v-model="form.userEmail"  style="width: 500px;"></el-input>
          </el-form-item>
          <el-form-item label="注册时间">
            <el-input v-model="form.creation" :disabled="true" style="width: 500px;"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="update">修改信息</el-button>
            <el-button type="success" @click="logout">退出登录</el-button>
          </el-form-item>
        </el-form>
      </div>

    </div>
  </div>
</template>

<script>
import indexPage from "../../api/indexPage";
import cookie from "js-cookie";

export default {
  name: "Blog_index",
  data() {
    return {
      form: {
        userName: '',
        userPwd: '',
        userSex:'',
        userPhone: '',
        userEmail: '',
        creation:'',
      },
    }
  },

  created() {
    if(cookie.get('userName')){
      this.onSubmit(cookie.get('userName'))
    }

  },

  methods: {
    onSubmit(userName) {
      indexPage.getUserByName(userName).then(response =>{
        this.form = response.data.item
      })
    },

    update(){
      indexPage.updateUser(this.form).then(response =>{
        this.$message.success("用户信息已更新，请刷新后重新登录！");
        cookie.remove('userName')
        this.$router.push('/index');
      })
    },

    logout(){
      cookie.remove('userName')
      this.$router.push('/index');
    },

  },
}
</script>

<style scoped>
.page1 {
  background-image: url('../../assets/bg1.jpg')
}

.myContainer{
  margin: auto;
  overflow: hidden;
  width: 700px;
  min-height: 800px;
}
.form1 {
  background-color: wheat;
  border-radius: 5px;
  text-align: center;
  margin-top: 40px;
  padding: 20px 20px;
}

</style>
