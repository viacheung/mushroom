<template>
    <el-table :data="items" style="width: 100%" >
        <el-table-column type="index" width="40"></el-table-column>
        <el-table-column property="id" label="周边编号" width="200"></el-table-column>
        <el-table-column property="name" label="周边名称" width="120"></el-table-column>
        <el-table-column property="category" label="周边类型" width="80"></el-table-column>
        <el-table-column property="price" label="周边价格" width="50"></el-table-column>
        <el-table-column property="content" label="周边描述" width="200"></el-table-column>
        <el-table-column label="周边图片" width="150">
            <template #default="scope">
                <img :src="imgs[scope.$index]" style="margin-left: 2px;width: 100px;height: 100px">
            </template>
        </el-table-column>
        <el-table-column property="culturalRelicTime" label="发布时间"></el-table-column>

        <el-table-column label="操作">
            <template #default="scope">
                <el-button
                        size="mini"
                        type="danger"
                        @click="handleDelete(scope.row)">下架</el-button>
            </template>
        </el-table-column>
    </el-table>
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
            id: '',
            name: '',
            category: '',
            price: '',
            img: '',
            culturalRelicTime: ''
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
      indexPage.delZhoubian(row.id).then(response =>{
        this.$message.success("周边下架成功！");
        this.getItems();
      });

    },

    getItems(){
      indexPage.allZhouBian().then(response =>{
          console.log(response.data.items)
        this.items = response.data.items;
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

