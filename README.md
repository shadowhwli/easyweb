# easyweb

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
    
    
