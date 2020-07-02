# xiaohu
有小伙伴一起写个更好的Deo吗？
扫码加微信（微信ID：Fox Miss Your），备注小狐，讨论模块的增加与改版。
![image](https://jiuge-guli.oss-cn-shanghai.aliyuncs.com/mmqrcode1593145350347.png)

  ## 项目介绍

  小狐同学,该项目是一个前后端分离的微服务的入门案例,项目采用 Spring Cloud + Vue开发，该项目希望有更好的小伙伴一起来改进
  ### 项目地址:
  
 ## 项目技术栈
 ##### 后端技术栈
  1. Spring Boot 
  2. MyBatis Plus
  3. MySQL
  4. Redis
  5. Ehcache
  6. Spring Security(待整合中)
  7. Spring Cloud
  8. ...
 #### 前端技术栈 
  1. Vue
  2. Element UI
  3. axios
  4. vur-router
  5. vue-cli
  6. ...
  
  #### 快速启动
    1. clone项目到本地 
    2. 导入数据库脚本
    3. 修改application-dev.yml文件下面的数据库路径Nacos(不是连接远程地址就可以不用修改)
    4. 不需要修改前端地址,前端的axios的所有请求都通过网关地址连接通信，修改了网关的api-getway模块的端口号需要到 
        前端项目下的/utils/request.js文件修改请求getway的路径
    5. 打开 Intellij IDEA中打开xiaohu项目,采用 Run Dashboard 启动所有模块(如果启动多个导致卡顿，可以单个功能的参考，api-getway模块一定要起来)
    6. 这些模块都起来，要测试模块中的注册，视频点播，对象存储需修改 service-oss,servcie-vedio的oss.properties的配置数据,
        注册模块的短信功能依赖阿里短信服务，
        需自己修改service层的配置，自己的阿里云短信配置，如果没有配置，可以采用redis模仿存储ZSet类型来模拟服务端有短信功能
    
 #### 项目说明
    该项目有些模块待编写的如后台管理的Spring Security,权限设计(表已经有了),评论模块的后台，
    而在前台展示项目中还有有个模块待小伙伴一起来编写啊，
    项目的视频评论的回复功能，表设计的有点缺陷此功能暂时不能使用，
    因为该项目只是展示某些功能点，如日志收集，操作日志就没有记录
    
    
  
     
 
 
  
