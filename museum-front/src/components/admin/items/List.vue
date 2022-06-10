<template>
  <el-table :data="items" style="width: 100%" >
    <el-table-column type="index" width="40"></el-table-column>
    <el-table-column property="culturalRelicId" label="文物编号" width="80"></el-table-column>
    <el-table-column property="culturalRelicName" label="文物名称" width="120"></el-table-column>
    <el-table-column property="culturalRelicType" label="文物类型" width="100"></el-table-column>
    <el-table-column property="culturalRelicDescription" label="文物描述" width="200"></el-table-column>
    <el-table-column label="文物图片" width="150">
      <template #default="scope">
        <img :src="imgs[scope.$index]" style="margin-left: 2px;width: 100px;height: 100px">
      </template>
    </el-table-column>
    <el-table-column property="culturalRelicNumber" label="被收藏量" width="100"></el-table-column>
    <el-table-column property="culturalRelicTime" label="发布时间"></el-table-column>

    <el-table-column label="操作">
      <template #default="scope">
        <el-button
            size="mini"
            @click="handleEdit(scope.row)">编辑</el-button>
        <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

  <div class="block">
    <el-pagination layout="prev, pager, next"  :page-count="total" @current-change="currentPage" > </el-pagination>
  </div>
</template>

<script>
import items from "../../../api/items";
import indexPage from "../../../api/indexPage";


export default {
  data() {
    return {
      imgs:[],
      items: [
          {
            culturalRelicId: '',
            culturalRelicName: '',
            culturalRelicType: '',
            culturalRelicDescription: '',
            img: '',
            culturalRelicTime: '',
            culturalRelicNumber: '',
          },
      ],
      page: 1,
      limit: 10,
      total: 0
    }
  },
  mounted() {
    this.getItems();
  },


  methods: {
    handleEdit(row) {
      console.log(row);
      this.$router.push({path:'/admin/itemsForm',query: {id:row.culturalRelicId}})
    },

    handleDelete(row) {
      indexPage.delCulturalRelic(row.culturalRelicId).then(response =>{
        this.$message.success("删除文物成功！");
        this.getItems();
      });

    },

    getItems(){
      indexPage.allCulturalRelic(this.page,this.limit).then(response =>{
        this.items = response.data.items.data;
        this.imgs = [];
        for (let i = 0 ;i< this.items.length;i ++){
          this.imgs.push(require("../../../assets/newCu/"+this.items[i].img))
        }
        this.total = Math.ceil(response.data.items.count /this.limit);
      });
    },


    currentPage(val){
      this.page = val;
      this.getItems();
    }

  }
}
</script>

<style>
.block{
  margin-top: 20px;
  text-align: center;
}
</style>

