<div style="display: flex; justify-content: center;">
    <img src="https://nebula.neegix.com/nebula.svg" alt="Nebula Logo" width="50" height="50" />
</div>
<h3 style="text-align: center;">
  Nebula Framework
</h3>


## 介绍

Nebula Framework 是一套基于 Spring Boot 3.0 和 Java 17 开发的企业级后台管理开发平台。并且以DDD(领域驱动设计)为理念，它由多个模块组成，每个模块都针对特定的功能需求设计，以提供灵活且高效的开发体验。

## 模块组成

- **nebula-framework-core**：核心基础模块，可以直接用来搭建 Web 框架。
- **nebula-framework-auth**：集成了登录验证及权限验证的框架。
- **nebula-framework-system**：为 nebula-admin 前端项目开发的系统管理模块。
- **nebula-framework-development**：为 nebula-admin 开发的开发管理模块。
- **nebula-framework-generator**：基于 Maven 插件的代码生成插件。

## 功能特点

- **灵活的模块化设计**：模块化的设计使得开发者可以根据需求选择合适的模块进行集成。
- **权限管理**：集成了完善的登录验证及权限验证机制，保障系统安全。
- **代码生成**：提供基于 Maven 插件的代码生成工具，提高开发效率。
- **企业级开发**：基于 Spring Boot 3.0 和 Java 17，适合企业级应用开发。

## 领域驱动设计（DDD）

整个后台框架的业务代码遵循 DDD（领域驱动设计）规范。DDD 是一种软件设计方法，它将业务需求紧密地反映在系统设计的模型中，强调以业务概念为驱动的软件开发。Nebula Framework 提供了一套基于 DDD 的代码架构，但这个规范是灵活的，可以根据个人或项目的不同需求进行调整。在必要的时候，开发者可以根据自己的方式编写代码，不拘泥于固定的模式。

## 安装教程
## 后端环境搭建

```bash
$ git clone https://gitee.com/neegix-opensource-group/nebula-framework
```

进入聚合项目根目录：
```bash
$ cd nebula-framework
```



安装依赖

```bash
  mvn clean install
```

然后进入启动项目目录：
```bash
$ cd neblua-framework-organization
```

修改配置文件(**开发环境**)
```bash
$ vim src/main/resources/application-dev.yml
```

修改数据库配置（改成自己的数据库相关环境参数）
```bash
spring:
    datasource:
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://127.0.0.1:3306/nebula?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true
      username: root
      password: 12345678
```

启动
```bash
  mvn spring-boot:run
```

- [nebula-framework-generator 安装指南](https://nebula.neegix.com/nebula/nebula-framework/nebula-framework-generator/)

## 使用说明

详细使用说明请访问 [Nebula Framework 官网](https://nebula.neegix.com)。

## 参与贡献

我们欢迎任何形式的贡献，包括但不限于代码提交、文档改进、问题报告等。请遵循以下步骤参与贡献：

1. **Fork 本仓库**：在 GitCode、Gitee 或 GitHub 上 Fork 本项目。
2. **新建分支**：从 `main` 分支新建一个以 `Feat_` 开头的分支。
3. **提交代码**：在您的分支上进行代码更改，并提交 Commit。
4. **新建 Pull Request**：将您的更改通过 Pull Request 的形式提交给我们，等待合并。

## 代码库

- GitCode: [https://gitcode.com/NeegixOpensourceGroup/nebula-framework](https://gitcode.com/NeegixOpensourceGroup/nebula-framework)
- Gitee: [https://gitee.com/neegix-opensource-group/nebula-framework](https://gitee.com/neegix-opensource-group/nebula-framework)
- GitHub: [https://github.com/NeegixOpensourceGroup/nebula-framework](https://github.com/NeegixOpensourceGroup/nebula-framework)

## 官网

[Nebula Framework 官网](https://nebula.neegix.com)

#### 联系信息

<table>
  <tr>
    <th>QQ 群: 996598075</th>

[//]: # (    <th>Discord: <a href="https://discord.gg/WrP5J9Ea7z">https://discord.gg/WrP5J9Ea7z</a></th>)
  </tr>
  <tr>
    <td><img src="https://neegix.com/img/qq_qrcode.jpg" width="200" /></td>

[//]: # (    <td align=center><img src="https://gitee.com/kushu001/pic-go-images/raw/master/images/httpsdiscord.ggWrP5J9Ea7z.png" width="200" /></td>)
  </tr>
</table>