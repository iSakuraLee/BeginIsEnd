<script setup>

import {Lock, Message, Ship, User} from "@element-plus/icons-vue";
import router from "@/router";


const form = reactive({
  username: '',
  password: '',
  password_repeat: '',
  email: '',
  verify_code: ''
})
</script>

<template>
  <div style="text-align: center;margin: 0 20px">
    <div style="margin-top: 150px">
      <div style="font-size: 25px">注册</div>
      <div style="font-size: 14px;color: grey">欢迎注册我们的学习平台</div>
    </div>
    <div class="register">
      <el-input v-model="form.username" type="text" style="margin-top: 10px" placeholder="用户名">
        <template #prefix>
          <el-icon><User/></el-icon>
        </template>
      </el-input>
      <el-input v-model="form.password" type="password" style="margin-top: 10px" placeholder="密码">
        <template #prefix>
          <el-icon><Lock/></el-icon>
        </template>
      </el-input>
      <el-input v-model="form.password_repeat" type="password" style="margin-top: 10px" placeholder="确认密码">
        <template #prefix>
          <el-icon><Lock/></el-icon>
        </template>
      </el-input>
      <el-input v-model="form.email" type="mail" style="margin-top: 10px" placeholder="电子邮箱地址">
        <template #prefix>
          <el-icon><message/></el-icon>
        </template>
      </el-input>
    </div>
    <div style="margin-top: 10px">
      <el-row :gutter="10" style="width: 100%">
        <el-col :span="17" style="width: 70%">
          <el-input v-model="form.verify_code" type="mail" placeholder="请输入验证码">
            <template #prefix>
              <el-icon><Ship/></el-icon>
            </template>
          </el-input>
        </el-col>
        <el-col :span="6" style="width: 30%">
          <el-button type="success">获取验证码</el-button>
        </el-col>
      </el-row>
    </div>
    <div style="margin-top: 70px">
      <el-button style="width: 270px; font-size: 18px" type="warning" plain>立即注册</el-button>
    </div>
    <div  style="margin-top: 20px">
      <span style="font-size: 15px;line-height: 15px;">已有账号？ </span>
      <el-link type="primary" @click="router.push('/')" style="font-size: 15px; font-weight: bold; translate: 0 -3px">立即登陆</el-link>
    </div>
  </div>
</template>

<style scoped>
  .register {
    margin-top: 50px;
  }
</style>