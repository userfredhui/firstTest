#firstTest
[在线演示地址](http://api.penghui.work/vuetest/#/)
* 本项目是和那个vuetest项目配合是一个完整的项目
* 这是第一次写的一个java项目，用的springboot,前后端分离，后台接口都统一封装成
```
{
    code: "0" // '0'代表成功，其他代表错误
    data: {} // 需要的数据
    message: "查询失败" // 如果code不为"0",就填写上message,前端统一处理，提醒给用用看
}
```
* 有登录接口，文章列表，文章的已发布，草稿箱，已删除，用户注册，用户登录，上传头像功能。增加用户角色，启用禁用用户。
* 权限控制，/admin开头的地址只有超级管理员才能有权限访问。
* 数据库的话用那个vueblog.sql在本地的mysql运行下就好。
#### 打包部署到服务器使用命令 mvn clean package 生成.jar文件，在服务器上运行 java -jar