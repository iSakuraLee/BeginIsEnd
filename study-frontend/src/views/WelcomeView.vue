<script setup>

</script>

<template>
  <div style="width: 100vw; height: 100vh;overflow: hidden;display: flex">
    <div style="flex: 1;background-color: dodgerblue">
      <el-image style="width: 100%;height: 100%" fit="cover" src="https://img1.baidu.com/it/u=2463514011,1142503686&fm=253&fmt=auto&app=138&f=JPEG?w=888&h=500"/>
    </div>
    <div class="welcome-title">
      <div style="font-size: 50px;font-weight: bold">欢迎来我们的学习平台</div>
      <div style="margin-top: 10px;font-size: 40px">Something wonderful is about to happen.</div>
    </div>
    <div style="width: 400px;background-color: white">
      <router-view/>
    </div>
  </div>
</template>

<style scoped>
.welcome-title {
  position: absolute;
  bottom: 30px;
  left: 30px;
  color: white;
  text-shadow: 0 0 10px black;
}
</style>