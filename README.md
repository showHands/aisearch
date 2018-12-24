# aisearch

**_redis缓存_**

springboot 缓存基础知识讲解：https://blog.csdn.net/qq_32867467/article/details/82944506
springboot 集成redis做缓存： https://www.jianshu.com/p/2513f625fcae


**_swagger2_**:

http://www.cnblogs.com/paddix/p/8204916.html
Swagger是世界上最流行的API工具，并且Swagger的目的是支撑整个API生命周期的开发，包括设计、文档以及测试和部署。
项目集成Swaggerh后，只需要在代码上加上swagger注解，就可以自动生成API说明文档。减轻了维护接口文档的工作，对于
整个项目后续的维护来说即省时又省力

项目启动后Swagger的访问路径：http://127.0.0.1:8080/swagger-ui.html


**_日志管理：_**

https://blog.csdn.net/ws_dj_love/article/details/80227486
logback-spring.xml,实现了通过读取配置指定日志输出路径并且支持打印sql脚本


**_mybatis逆向工程：_**
resource/generatorConfig.xml
resource/mybatisGeneratorinit.properties

分页：
PageHelper

**_AOP实现日志拦截：_**
支持打印请求方法、参数及响应结果。

**_跨站点脚本编制_**
XssFilter

**_支持跨站请求_**
CrossFilter, 重写response

**_打包方式：_**
java jar aisearch0.0.1.jar
注：打包前将pom.xml中的逆向工程配置注释掉，否则会重复生成generatorConfig.xml中的实体类、*Mapper.xml






