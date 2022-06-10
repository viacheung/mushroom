<template>
    <el-table :data="items" style="width: 100%" >
        <el-table-column type="index" width="40"></el-table-column>
        <el-table-column property="oid" label="订单号" width="200"></el-table-column>
        <el-table-column property="zname" label="周边名称" width="120"></el-table-column>
        <el-table-column property="price" label="周边价格" width="100"></el-table-column>
        <el-table-column property="uname" label="下单用户" width="200"></el-table-column>
        <el-table-column property="state" label="订单状态" width="100"></el-table-column>
        <el-table-column property="time" label="下单时间"></el-table-column>

        <el-table-column label="操作">
            <template #default="scope">
                <el-button
                        size="mini"
                        type="danger"
                        @click="handleDelete(scope.row)">发货</el-button>
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
            oid: '',
            zname: '',
              uname:'',
            category: '',
            price: '',
            state: '',
            time: ''
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

        if(row.state === '1'){
            this.$message.success("订单状态为1，已发货，无需发货！");
        }else{
            indexPage.fahuo(row.oid).then(response =>{
                this.$message.success("订单发货成功！");
                this.getItems();
            });
        }


    },

    getItems(){
      indexPage.allOrder().then(response =>{
          console.log(response.data.item)
        this.items = response.data.item;
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

