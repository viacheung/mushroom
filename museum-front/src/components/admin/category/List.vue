<template>
  <el-table :data="categoryList" style="width: 100%">
    <el-table-column property="id" label="公告id" width="150"></el-table-column>
    <el-table-column property="title" label="公告标题" width="150"></el-table-column>
    <el-table-column property="content" label="公告标题" width="400"></el-table-column>
    <el-table-column property="release_time" label="创建时间"> </el-table-column>
    <el-table-column label="操作">
      <template #default="scope">
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


    handleDelete(row) {
      indexPage.delNotice(row.id).then(response=>{
        this.$message('添加公告成功！');
        this.getCategoryList();
      });
    },

    getCategoryList(){
      indexPage.allNotice(this.page,this.limit).then(response =>{
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
