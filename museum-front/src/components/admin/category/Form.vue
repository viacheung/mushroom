
<template>
  <el-form ref="form" :model="form" label-width="80px">
    <el-form-item label="公告标题">
      <el-input v-model="form.title" style="width: 500px;"></el-input>
    </el-form-item>
    <el-form-item label="发布人">
      <el-input v-model="form.publisher" style="width: 500px;"></el-input>
    </el-form-item>
    <el-form-item label="公告内容">
      <el-input type="textarea" v-model="form.content" style="width: 500px;"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">提交</el-button>
      <el-button>取消</el-button>
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
        id: '',
        title: '',
        publisher:'',
        content:''
      },
    }
  },


  methods: {
    onSubmit() {
      indexPage.addNotice(this.form).then(response =>{
        this.$message('添加公告成功！');
        this.$router.push('/admin/categoryList');
      })
    },

  },
}
</script>

<style scoped>

</style>
