<template>
      <el-card shadow="hover">
        <template #header>
          <div class="card-header">
            <el-tag type="success">
              百度热搜榜（每天更新一次）
            </el-tag>
          </div>
        </template>
        <div v-for="(o,index) in 10" :key="o" class="text item">
          {{index+1}}--
          {{ 'List item ' + o }}
        </div>
      </el-card>
</template>

<script>
export default {
  name: "list"
}
</script>

<style scoped>
.el-card{
  width: 100%;
}
/*.el-card__header{
  margin:0 auto;
}*/
.card-header{
  display: flex;
  justify-content: center;
}


</style>
