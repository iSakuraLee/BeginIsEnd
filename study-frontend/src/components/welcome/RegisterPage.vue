<script setup>

import {Lock, Message, Ship, User} from "@element-plus/icons-vue";
import router from "@/router";
import {reactive} from "vue";


const form = reactive({
  username: '',
  password: '',
  password_repeat: '',
  email: '',
  verify_code: ''
})

const validateUsername = (rule, value, callback) => {
  if (value === '') {
    callback(new Error('用户名为空，请重新输入'))
  } else if (!/^[a-zA-Z0-9\u4e00-\u9fa5]+$/.test(value)) {
    callback(new Error('用户名中不能包含特殊字符'))
  } else {
    callback()
  }
}

const validatePassword = (rule, value, callback) => {
  if (value === '') {
    callback(new Error('请再次输入密码'))
  } else if (value !== form.password) {
    callback(new Error('两次输入的密码不一致'))
  } else {
    callback()
  }
}

const rules = {
  username: [
    {validator: validateUsername, trigger: ['blur','change']},
    {min: 2, max: 8, message: '用户名长度需要在2-8个字符之间', trigger: ['blur', 'change']}
  ],
  password: [
    {required: true, message: '请输入密码', trigger: ['blur', 'change']},
    {min: 6, max: 6, message: '密码长度需要在6-16个字符之间', trigger: ['blur', 'change']}
  ],
  password_repeat: [
    {validator: validatePassword, trigger: ['blur', 'change']}
  ],
  email: [
    {required: true, message: '请输入邮件地址', trigger: ['blur', 'change']},
    {type: 'email', message: '请输入合法的邮件地址', trigger: ['blur', 'change']}
  ]
}

</script>

<template>
  <div style="text-align: center;margin: 0 20px">
    <div style="margin-top: 150px">
      <div style="font-size: 25px">注册</div>
      <div style="font-size: 14px;color: grey">欢迎注册我们的学习平台</div>
    </div>
    <div class="register">
      <el-form :model="form" :rules="rules">
        <el-form-item prop="username">
          <el-input v-model="form.username" type="text" placeholder="用户名">
            <template #prefix>
              <el-icon><User/></el-icon>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="form.password" type="password" placeholder="密码">
            <template #prefix>
              <el-icon><Lock/></el-icon>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item prop="password_repeat">
          <el-input v-model="form.password_repeat" type="password" placeholder="确认密码">
            <template #prefix>
              <el-icon><Lock/></el-icon>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item prop="email">
          <el-input v-model="form.email" type="mail" placeholder="电子邮箱地址">
            <template #prefix>
              <el-icon><message/></el-icon>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item prop="verify_code">
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
        </el-form-item>
      </el-form>
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