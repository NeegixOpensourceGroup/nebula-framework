<div style="display: flex; justify-content: center;">
    <img src="https://nebula.neegix.com/nebula.svg" alt="Nebula Logo" width="50" height="50" />
</div>
<h3 style="text-align: center;">
  Nebula Framework
</h3>

## Introduction

Nebula Framework is an enterprise-level backend management development platform developed based on Spring Boot 3.0 and Java 17. It consists of multiple modules, each designed to address specific functional needs, providing a flexible and efficient development experience.

## Module Composition

- **nebula-framework-core**: The core basic module, which can be directly used to build a Web framework.
- **nebula-framework-auth**: A framework integrated with login verification and permission validation.
- **nebula-framework-system**: A system management module developed for the nebula-admin front-end project.
- **nebula-framework-development**: A development management module developed for nebula-admin.
- **nebula-framework-generator**: A code generation plugin based on Maven plugin.

## Features

- **Flexible Modular Design**: The modular design allows developers to choose the appropriate modules based on their needs.
- **Permission Management**: Integrated with a comprehensive login verification and permission validation mechanism to ensure system security.
- **Code Generation**: Provides a code generation tool based on the Maven plugin to improve development efficiency.
- **Enterprise-Level Development**: Based on Spring Boot 3.0 and Java 17, suitable for enterprise-level application development.

## Domain-Driven Design (DDD)

The business code of the entire backend framework follows the DDD (Domain-Driven Design) specification. DDD is a software design approach that closely reflects business requirements in the system design model, emphasizing software development driven by business concepts. Nebula Framework provides a code architecture based on DDD, but this specification is flexible and can be adjusted according to individual or project needs. When necessary, developers can write code in their own way, not confined to a fixed pattern.

## Installation Guide

## Backend Environment Setup

```bash
$ git clone https://gitee.com/neegix-opensource-group/nebula-framework
```

Navigate to the root directory of the aggregated project:
```bash
$ cd nebula-framework
```

Install dependencies:
```bash
mvn clean install
```

Then enter the startup project directory:

```bash
$ cd neblua-framework-organization
```

Modify the configuration file (Development Environment):

```bash
$ vim src/main/resources/application-dev.yml
```

Update the database configuration (change to your own database environment parameters):
```yaml
spring:
    datasource:
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://127.0.0.1:3306/nebula?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true
      username: root
      password: 12345678
```

Start the application:
```bash
$ mvn spring-boot:run
```


## Usage Instructions

For detailed usage instructions, please visit the [Nebula Framework Official Website](https://nebula.neegix.com).

## Contribution

We welcome any form of contribution, including but not limited to code submissions, document improvements, and issue reports. Please follow these steps to contribute:

1. **Fork This Repository**: Fork this project on GitCode, Gitee, or GitHub.
2. **Create a New Branch**: Create a new branch from the `main` branch with a name starting with `Feat_`.
3. **Submit Code**: Make changes to your branch and commit them.
4. **Create a Pull Request**: Submit your changes to us through a Pull Request, waiting for merge.

## Codebase

- GitCode: [https://gitcode.com/NeegixOpensourceGroup/nebula-framework](https://gitcode.com/NeegixOpensourceGroup/nebula-framework)
- Gitee: [https://gitee.com/neegix-opensource-group/nebula-framework](https://gitee.com/neegix-opensource-group/nebula-framework)
- GitHub: [https://github.com/NeegixOpensourceGroup/nebula-framework](https://github.com/NeegixOpensourceGroup/nebula-framework)

## Official Website

[Nebula Framework Official Website](https://nebula.neegix.com)

#### Contact information

<table>
  <tr>
    <th>QQ Group: 996598075</th>

[//]: # (    <th>Discord: <a href="https://discord.gg/WrP5J9Ea7z">https://discord.gg/WrP5J9Ea7z</a></th>)
  </tr>
  <tr>
    <td><img src="https://neegix.com/img/qq_qrcode.jpg" width="200" /></td>

[//]: # (    <td align=center><img src="https://gitee.com/kushu001/pic-go-images/raw/master/images/httpsdiscord.ggWrP5J9Ea7z.png" width="200" /></td>)
  </tr>
</table>