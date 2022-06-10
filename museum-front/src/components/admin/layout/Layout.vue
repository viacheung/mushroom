
<template>
  <el-container style="height: 750px; border: 1px solid #eee">
    <el-aside width="15%" >
      <Aside />
    </el-aside>

    <el-container>
      <el-header >
        <Header />
      </el-header>

      <el-main>
        <Main />
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import Aside from "../aside/Aside";
import Main from "../main/Main";
import Header from "../header/Header";
export default {

  components:{
    Aside,Main,Header
  },

  data() {
    return {

    }
  }
};
</script>

<style>
.el-header {
  line-height: 60px;
  box-shadow: 0 2px 12px 0 rgba(0,0,0,0.1);
}
.el-main{
  box-shadow: 0 2px 12px 0 rgba(0,0,0,0.1);
}
.el-aside{
  box-shadow: 0 2px 12px 0 rgba(0,0,0,0.1);
}


</style>
