# 本项目
通过此项目的联系熟悉了MVC架构的原理，数据库编程，常用的设计模式，软件项目的开发过程，以及如何管理项目、进行版本控制以及项目在heroku上的部署和简单的软件测试

[这里查看项目演示](https://ucassepractice.herokuapp.com/)
BY 李言，曹义魁
## 说明
目前使用的库和数据库：

- 使用layui和Jquery作为前端库
- 使用java作为后台开发的语言
- 使用Mysql作为数据库

使用的java版本为java8，mysql的版本为5.7

使用前请查看java和mysql的版本

>     java -version
>     mysql -version


项目使用Maven来管理项目中的jar包，同时也方便我们在heroku上的部署

- [Maven下载](http://maven.apache.org/)
- [Maven远程仓库](https://mvnrepository.com/)
## 使用
**1.学生登陆：**

账号：`123456@qq.com`

密码：`123456`

**2.管理员登陆：**

账号：`admin`

密码：`admin`

## 部署

- 小型的项目（100M左右）可以免费使用
heroku来部署我们的项目
- 申请heroku账号，注意需要一张信用卡，因为我们需要为我们的项目add-on一些组件，比如sql数据库
- 进入个人控制台并create new app，然后在Resources菜单下add-on JawsDB MySQL作为项目的数据库，在JawsDB MySQL中可以看到数据库的连接信息，如主机名，用户名，端口，以及一个数据库名，注意我们在JawsDB MySQL中的权限是受限制的，我们只能在提供的数据库下做数据库操作，而不是自己创建一个新的数据库
- 使用Navicat连接上所给的数据库，并在所给的数据库下面运行sql文件
在项目文件夹下创建procfile文件，procfile文件是为了方便heroku在部署时识别我们的项目，注意是无格式的，添加以下代码，heroku使用jetty作为运行servlet的容器

>     web: java $JAVA_OPTS -jar target/dependency/jetty-runner.jar --port $PORT target/yourprojectname.war

- 在github上创建远程仓库，并将项目变成本地仓库提交到远程仓库

- 通过heroku连接github，选择我们要部署的项目，期间可以通过下列命令查看项目的运行情况
>     heroku logs --app 应用名称 --tail

## 测试
