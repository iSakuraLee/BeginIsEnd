<script setup>
import {get} from "@/api";
import {ElMessage} from "element-plus";
import router from "@/router";

const logout = () => {
  get('/api/auth/logout', (message) => {
    ElMessage.success(message)
    router.push('/')
  })
}
</script>

<template>
  <div>
    欢迎进入学习平台
  </div>
  <div>
    <el-button @click="logout()" type="danger" plain>退出登陆</el-button>
  </div>
</template>

<style scoped>

</style>