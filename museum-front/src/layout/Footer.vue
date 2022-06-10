<template>
  <el-divider></el-divider>
  <el-space wrap class="wrap">
    <span v-for="item in items">
     {{item}}
    </span>
  </el-space>
</template>

<script>
export default {
  name: "Footer",
  data() {
    return {
      items: ['企业服务','关于我们','联系我们','讲师招募','帮助中心','意见反馈','慕课大学','代码托管','友情链接'
      ,'Copyright© 2021 imooc.com','京ICP备 12003892号-11','京公网安备11010802030151号','营业执照'],
    };
  }
}
</script>

<style scoped>

.wrap {
  margin-left: 120px;
  font-size: smaller;
  color: #909399;
}

</style>
