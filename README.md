# 抖音商城微服务项目

## 项目介绍
基于Spring Cloud Alibaba的微服务商城系统，实现抖音电商相关功能，集成AI大模型实现智能推荐和客服功能。

## 技术栈
- Spring Boot 2.6.13
- Spring Cloud 2021.0.5
- Spring Cloud Alibaba 2021.0.4.0
- MySQL 8.0
- Redis 6.0
- Nacos 2.1.0
- MyBatis-Plus 3.5.2
- Docker
- 通义/deepseek API
- RabbitMQ
- Elasticsearch

## 项目结构
bash
douyin-mall-cloud
├── mall-common # 公共服务
│ ├── common-core # 核心包
│ ├── common-redis # Redis工具包
│ └── common-swagger # 接口文档
├── mall-gateway # 网关服务
├── mall-auth # 认证服务
├── mall-user # 用户服务
├── mall-product # 商品服务
├── mall-order # 订单服务
├── mall-payment # 支付服务
├── mall-cart # 购物车服务
└── mall-ai # AI服务模块


## 环境要求
- JDK 17
- Maven 3.6+
- MySQL 8.0+
- Redis 6.0+
- Nacos 2.1.0+
- RabbitMQ 3.8+
- Elasticsearch 7.x

## 开发环境搭建
1. 安装JDK 17
2. 安装Maven 3.6+
3. 安装MySQL 8.0
4. 安装Redis 6.3
5. 安装Nacos 2.1.0
6. 安装RabbitMQ
7. 安装Elasticsearch

## 项目运行
1. 启动Nacos
2. 启动Redis
3. 启动MySQL
4. 启动RabbitMQ
5. 启动Elasticsearch
6. 运行数据库脚本
7. 启动网关服务
8. 启动其他服务

## 功能模块
- 用户管理
    - 用户注册登录
    - 个人信息管理
    - 收货地址管理
- 商品管理
    - 商品分类
    - 商品搜索
    - 商品详情
- 订单管理
    - 订单创建
    - 订单支付
    - 订单跟踪
- 购物车模块
    - 加入购物车
    - 购物车管理
    - 商品结算
- 支付管理
    - 在线支付
    - 退款管理
- AI 功能模块
    - 智能商品推荐
    - AI 客服对话
    - 个性化营销

## 开发进度
- [ ] 项目初始化
- [ ] 公共模块开发
- [ ] 用户服务开发
- [ ] 商品服务开发
- [ ] 订单服务开发
- [ ] 支付服务开发
- [ ] 购物车服务开发
- [ ] AI模块开发
    - [ ] 智能推荐系统
    - [ ] AI客服系统

## 团队成员
- 项目负责人：xxx
- 开发人员：xxx

## 版本历史
- v1.0.0 项目初始化（2024-02-20）
- v1.1.0 添加购物车模块（计划中）
- v1.2.0 集成AI功能（计划中）

## 注意事项
1. 遵循代码规范
2. 及时提交代码
3. 编写单元测试
4. 做好文档记录
5. AI模块需要注意API调用限制和成本控制