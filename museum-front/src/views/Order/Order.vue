<template>
    <div class="cont">
        <el-table :data="items" style="width: 100%" >
            <el-table-column type="index" width="40"></el-table-column>
            <el-table-column property="oid" label="订单号" width="200"></el-table-column>
            <el-table-column property="zname" label="周边名称" width="120"></el-table-column>
            <el-table-column property="price" label="周边价格" width="100"></el-table-column>
            <el-table-column property="uname" label="下单用户" width="200"></el-table-column>
            <el-table-column property="state" label="订单状态" width="100"></el-table-column>
            <el-table-column property="time" label="下单时间"></el-table-column>


        </el-table>
    </div>

</template>

<script>
    import cookie from "js-cookie";
    import indexPage from "../../api/indexPage";

    export default {
        name: "Order",

        data(){
            return {
                activeName:'first',
                img:'',
                userName:'',
                isCollection: '',
                items:[],
                enshrine:{},
                textarea: '',
            }
        },

        created() {
            this.getItemsByName(cookie.get('userName'))
        },
        methods: {
            getItemsByName(uid) {
                indexPage.getOrderByName(uid).then(response => {
                    console.log(response.data.item)
                    this.items = response.data.item;

                })
            },
        }


    }
</script>

<style scoped>

    .cont {
        margin-left: 100px;
        margin-right: 100px;
        background-color: #00aaff;
    }
</style>
