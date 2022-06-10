<template>
  <div class="myContainer">
    <el-divider><i class="el-icon-mobile-phone"></i></el-divider>
    <el-row :gutter="20">
      <el-col :span="8">
        <MoYuShiKe_list />
      </el-col>
      <el-col :span="8">
        <div class="grid-content bg-purple-light">
          <MoYuShiKe_list />
      </div>
      </el-col>

      <el-col :span="8"><div class="grid-content bg-purple">
        <MoYuShiKe_list />
      </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import MoYuShiKe_list from "./MoYuShiKe_list";
export default {
  components:{
    MoYuShiKe_list
  }
}
</script>

<style scoped>
.myContainer{
  margin-top: 20px;
  margin-left: 142px;
  margin-right: 142px;
}


.el-col {
  border-radius: 4px;
}

</style>
