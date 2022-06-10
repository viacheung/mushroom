<template>
  <el-row class="tac">
      <el-menu  class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
              unique-opened router>

        <el-menu-item index="/">
          <el-menu-item >
            <img title="" src="../../../assets/logo.png" style="margin-left: 2px;width: 50px;height: 50px">
          </el-menu-item>
        </el-menu-item>
        <el-submenu index="1">
          <template #title>
            <i class="el-icon-s-platform"></i>
            <span>文物管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="/admin/itemsList">文物列表</el-menu-item>
            <el-menu-item index="/admin/itemsForm">添加文物</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-submenu index="2">
          <template #title>
            <i class="el-icon-cpu"></i>
            <span>公告管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="/admin/categoryList">公告列表</el-menu-item>
            <el-menu-item index="/admin/categoryForm">添加公告</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-submenu index="3">
          <template #title>
            <i class="el-icon-document"></i>
            <span>用户管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="/admin/userList">用户管理</el-menu-item>
            <el-menu-item index="/admin/userForm">用户信息</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-submenu index="4">
          <template #title>
            <i class="el-icon-s-platform"></i>
            <span>周边管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="/admin/ZhouBianList">周边列表</el-menu-item>
            <el-menu-item index="/admin/ZhouBianForm">添加周边</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-submenu index="5">
            <template #title>
                <i class="el-icon-cpu"></i>
                <span>订单管理</span>
            </template>
            <el-menu-item-group>
                <el-menu-item index="/admin/OrderList">订单列表</el-menu-item>
<!--                <el-menu-item index="/admin/categoryForm">周边评价</el-menu-item>-->
            </el-menu-item-group>
        </el-submenu>
      </el-menu>





  </el-row>
</template>

<script>
  export default {
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>

<style>
.el-menu-vertical-demo{
  width: 100%;
}

</style>
