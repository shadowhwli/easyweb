# easyweb

## 简介

> Java后台管理系统开发平台。
> 整合SAPJCO3对SAP接口function的调用

<br>

## 更新日志
- **2018-08-01 增加树形表格**

    - easyweb默默开发中

## 使用技术

### 后台
描述 | 框架 
:---|:---
核心框架 | Spring、Spring Boot、Spring MVC
持久层 | MyBatis、MyBatis-Plus、Druid
权限框架 | Shiro、jjwt（用于app接口）
模板引擎 | [beetl](http://ibeetl.com/guide)

### 前端
描述 | 框架 
:---|:---
核心框架 | [Layui](http://www.layui.com/)、[jQuery](http://jquery.cuishifeng.cn/)
路由框架 | [Q.js](https://github.com/itorr/q.js) (纯js轻量级路由框架)
mvvm框架 | [pandyle.js](https://gitee.com/pandarrr/pandyle) (专为jquery编写的mvvm)
主要特色 | 单页面 / 响应式 / 简约 / 极易上手

> 开发工具为IDEA，数据库文件存放在项目的`src/main/resources/static`目录下。


## 项目结构

### 后台接构
```text
|-src
   |-main
      |-java
      |    |-com.wf.ew
      |              |-common     // 核心模块
      |              |     |-config      // 存放SpringBoot配置类
      |              |     |     |-MyBatisPlusConfig.java      // MyBatisPlus配置
      |              |     |     |-SwaggerConfig.java          // Swagger2配置
      |              |     |
      |              |     |-exception   // 自定义异常类，统一异常处理器
      |              |     |-shiro       // shiro配置模块
      |              |     |-oauth       // app接口权限配置模块
      |              |     |-utils       // 工具类包
      |              |     |-BaseController.java    // controller基类
      |              |     |-JsonResult.java        // 结果集封装
      |              |     |-PageResult.java        // 分页结果集封装
      |              |
      |              |-system      // 系统管理模块
      |              |-api         // app接口模块
      |              |-xxxxxx      // 其他业务模块
      |              |
      |              |-EasyWebApplication.java     // SpringBoot启动类
      |              
      |-resources
            |-mapper     // mapper文件
            |    |-system
            |
            |-static     // css、js、图片文件
            |-templates  // html文件
            |
            |-application.properties  // 配置文件
```

## 快速上手
### 后台快速上手

**如何添加自己的业务代码：**

&emsp;&emsp;跟common、system同级建一个包，名字为你的业务模块名称，然后下面依次建
controller、dao、model、service、service.impl等包，然后再resource/mapper下面也
建一个模块文件夹，里面放mapper的xml文件。

- `mapper.xml` 扫描路径是`classpath:mapper/**/*Mapper.xml`
- `druid` 的service扫描路径是 `com.wf.ew.*.service.*`
- `mapper` 的扫描路径是 `com.wf.ew.*.dao` ，<br>
   位于 `common/config/MybatisPlusConfig.java`
   
   
##过程记录
- **构建SringBoot项目,以maven构建**
    - maven中引入spring-boot-start-web依赖
    - 编写入口EasyWebApplication,使用@SpringBootApplication注解
    - 运行main方法按springBoot默认配置启动了项目，默认端口8080
    
- **resources下编写application.properties配置文件(SpringBoot默认自动加载的)**
    - 修改端口server.port=8088
    - 添加多环境配置,编写开发环境、测试环境、生产环境配置文件(application-**.properties)
    - 在主配置中设置启用开发环境配置, spring.active.profiles=dev
    
- **dev下日志配置**
    - 设置日志DEBUG级别logging.level.com.ivo.ew=DEBUG, SpringBoot默认Logback来记录日志, 默认级别INFO
    
- **创建system包为系统管理模块**
    - 创建model包存放系统级相关实体类, 编写实体类(暂不映射到表, 待确定ORM框架)
    - 创建dao包存放数据库交互相关, 编写实体类对应dao操作接口
    
- **DB配置, 连接池使用Druid管理连接**
    - 数据源需要spring-boot-start-jdbc模块, Maven 引入后可以通过properties文件进行数据源配置
    - Maven中引入数据库需要的依赖Druid和msql数据库驱动
    - 在dev的properties中添加数据源配置, 该配置用与开发环境
    - 在主配置文件中设置连接池配置
    
- **mybatis配置, ORM框架选用mybatis, 并使用增强工具Mybatis-Plus**
    - Maven 引入mybatis-spring-boot-starter,该模块包含了spring-boot-start-jdbc模块 
    - 为了增强mybaties再引入mybatis-plus中的mybatis-plus-boot-starter依赖
    - 主配置文件中配置mybatis-plus
    - 关联model实体类和表结构
    - 关联dao接口类和mybatis
    - resources下建mapper/system目录存放mybatis的xml
    - 在common.config包中创建MybatisPlus的config类扫描dao包创建bean
        (.properties中的配置负责加载实体类和加载xml, 通过xml实现dao中的接口, 通过MybatisPlusConfig设置@MapperSca扫描
        dao包才会创建dao中接口的bean, 供service注入调用)
        
- **编写service层接口**
    - 编写User、Role、Authorities、LoginRecord的Service接口
    - 编写简单实现类       
        
- **common包中添加utils包增加一些工具类**
    - maven引入fastjson依赖
    - 加入spring-boot-starter-data-redis
    - 加入UserAgentUtils
    - 添加工具类
    
- **使用shiro做安全管理**
    - maven引入安全依赖
    - common包下建立shiro子包
    - 创建配置类ShiroConfig, shiro配置相关
    - 创建UserRealm集成AuthorizingRealm, 作为安全实体数据源
    - 配置ShiroConfig
    
    