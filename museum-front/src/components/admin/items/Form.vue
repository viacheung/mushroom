
<template>
  <el-form ref="form" :model="items" label-width="80px">
    <el-form-item label="文物名称">
      <el-input v-model="items.culturalRelicName" style="width: 500px;"></el-input>
    </el-form-item>
    <el-form-item label="文物类型">
      <el-input v-model="items.culturalRelicType" style="width: 500px;"></el-input>
    </el-form-item>

    <el-form-item label="文物图片">
      <el-upload class="upload-demo" action="http://127.0.0.1:9001/admin/save" v-model="items.img"
          name="file" :on-success="success" :on-error="error" :limit="1" list-type="picture" :file-list="fileList">
        <el-button  type="primary">点击上传</el-button>
        <template #tip>
          <div class="el-upload__tip">
            只能上传一张 jpg/png 格式图片
          </div>
        </template>
      </el-upload>
    </el-form-item>

    <el-form-item label="文物描述">
      <el-input type="textarea" v-model="items.culturalRelicDescription" :rows="10"  style="width: 500px;"></el-input>
    </el-form-item>




    <el-form-item>
      <el-button type="primary" @click="onSubmit">下一步</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>

</template>

<script>


import items from "../../../api/items";
import indexPage from "../../../api/indexPage";

export default {

  data() {
    return {
      fileList: [
      ],
      category: [
        {id:"123", title:"java"},
      ],
      items: {
        culturalRelicName: '',
        culturalRelicType: '',
        culturalRelicDescription: '',
        img: ''
      }
    }
  },

  mounted() {
    this.setValue();



  },

  methods: {
    onSubmit() {
      if(this.$route.query.id){
        indexPage.updateCulturalRelic(this.items).then(response=>{
          this.$message.success("修改文物成功！");
          this.$router.push('/admin/itemsList');
        })
      }else{
        indexPage.addCulturalRelic(this.items).then( response=>{
          this.$message.success("添加文物成功！");
          this.$router.push('/admin/itemsList');
        })
      }
    },

    success(response){
      this.items.img = response;
    },

    error(){
      this.$message.error('上传失败! （http失败）')
    },





    setValue(){
      if(this.$route.query.id){
        indexPage.getCulturalRelic(this.$route.query.id).then(response=>{
          this.items = response.data.item
        })
      }
    },

    onsuccess(response){
      this.fileList.name = response.data.name;
      console.log(response.data.name)
    }



  }
}
</script>

<style>
.el-form{
  margin-left: 20px;
}
#div1{
  width: 1020px;
}


</style>
