# springmvc-spring-mybatis
spring整合mybatis
 - ide是eclipse
 - 使用JDK8
 - spring.version=5.1.8.RELEASE
 - mybatis.version=3.5.1
 - 使用mysql连接，当然可以在jdbc.properties修改使用Oracle驱动
 - 只实现登录注册、登录拦截和上传功能，user表结构在\src\main\resources\sqlscript\user.sql
 - BaseController注册了时间格式转换绑定，把请求中的时间字符串转Date
 - 这是最简洁的框架模型，其他功能比如日志等需要自己添加
 - 下载解压后如果项目名称有-master结尾，去掉再导入
