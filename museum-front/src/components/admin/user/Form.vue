
<template>
  <el-form ref="form" :model="form" label-width="80px">
    <el-form-item label="用户名">
      <el-input v-model="form.userName" :disabled="true" style="width: 500px;"></el-input>
    </el-form-item>
    <el-form-item label="用户密码">
      <el-input v-model="form.userPwd" :disabled="true" style="width: 500px;"></el-input>
    </el-form-item>
    <el-form-item label="用户性别">
      <el-input v-model="form.userSex" :disabled="true" style="width: 500px;"></el-input>
    </el-form-item>
    <el-form-item label="用户手机">
      <el-input v-model="form.userPhone" :disabled="true" style="width: 500px;"></el-input>
    </el-form-item>
    <el-form-item label="用户邮箱">
      <el-input v-model="form.userEmail" :disabled="true" style="width: 500px;"></el-input>
    </el-form-item>
    <el-form-item label="注册时间">
      <el-input v-model="form.creation" :disabled="true" style="width: 500px;"></el-input>
    </el-form-item>
  </el-form>
</template>

<script>
import indexPage from "../../../api/indexPage";

export default {
  name: "Form",
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

    this.onSubmit()
  },

  methods: {
    onSubmit() {
      indexPage.getUserByName(this.$route.query.id).then(response =>{
        this.form = response.data.item
      })
    },

  },
}
</script>

<style scoped>

</style>
