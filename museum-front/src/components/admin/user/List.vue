<template>
  <el-table :data="categoryList" style="width: 100%">
    <el-table-column property="userName" label="用户名" width="100"></el-table-column>
    <el-table-column property="userSex" label="性别" width="100"></el-table-column>
    <el-table-column property="userPhone" label="手机号" width="200"></el-table-column>
    <el-table-column property="userEmail" label="邮箱" width="300"></el-table-column>
    <el-table-column property="creation" label="注册时间"> </el-table-column>
    <el-table-column label="操作">
      <template #default="scope">
        <el-button
            size="mini"
            @click="handleEdit(scope.row)"
        >查看</el-button>
        <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.row)"
        >删除</el-button
        >
      </template>
    </el-table-column>
  </el-table>
  <div class="block">
    <el-pagination layout="prev, pager, next"  :page-count="total" @current-change="currentPage" > </el-pagination>
  </div>
</template>

<script>

import indexPage from "../../../api/indexPage";

export default {
  data() {
    return {
      categoryList: [
        {
          id: '',
          title: '',
          createTime: '',
        }
      ],
      page: 1,
      limit: 10,
      total: 5
    }
  },

  created() {
    this.getCategoryList();
  },

  methods: {
    handleEdit(row) {
      console.log(row);
      this.$router.push({path:'/admin/userForm',query: {id:row.userName}})
    },

    handleDelete(row) {
      indexPage.delUser(row.userName).then(response=>{
        this.$message('删除用户成功！');
        this.getCategoryList();
      });
    },

    getCategoryList(){
      indexPage.allUser(this.page,this.limit).then(response =>{
         this.categoryList = response.data.items.data;
         this.total = Math.ceil(response.data.items.count /this.limit) ;
      })
    },
    currentPage(val){
      this.page = val;
      this.getCategoryList();
    }
  },
}
</script>

<style>
.block{
  margin-top: 20px;
  text-align: center;
}
</style>
