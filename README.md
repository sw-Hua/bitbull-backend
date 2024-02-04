# bitbull-backend

### Building Java Microservices from Scratch

https://hackernoon.com/building-java-microservices-from-scratch



### HTTP请求的方法

| HTTP Verb | CRUD           | Entire Collection (e.g. /customers)                          | Specific Item (e.g. /customers/{id})                         |
| :-------- | :------------- | :----------------------------------------------------------- | :----------------------------------------------------------- |
| POST      | Create         | 201 (Created), 'Location' header with link to /customers/{id} containing new ID. | 404 (Not Found), 409 (Conflict) if resource already exists.. |
| GET       | Read           | 200 (OK), list of customers. Use pagination, sorting and filtering to navigate big lists. | 200 (OK), single customer. 404 (Not Found), if ID not found or invalid. |
| PUT       | Update/Replace | 405 (Method Not Allowed), unless you want to update/replace every resource in the entire collection. | 200 (OK) or 204 (No Content). 404 (Not Found), if ID not found or invalid. |
| PATCH     | Update/Modify  | 405 (Method Not Allowed), unless you want to modify the collection itself. | 200 (OK) or 204 (No Content). 404 (Not Found), if ID not found or invalid. |
| DELETE    | Delete         | 405 (Method Not Allowed), unless you want to delete the whole collection—not often desirable. | 200 (OK). 404 (Not Found), if ID not found or invalid.       |





### Quick Start

https://spring.io/quickstart



### 初始化创建一个微服务

```
https://start.spring.io/
```



**Building Java Microservices from Scratch:**

https://hackernoon.com/building-java-microservices-from-scratch



### Spring Security 账号密码

**Login: **

```
login
```

**Password: **

````
pass
````



## Launching

先要将package打包（Package）

```bash
docker-compose up -d
```





在使用`docker-compose up -d`命令启动服务后，你可以通过执行`docker-compose down`命令来停止并移除所有由`docker-compose.yml`文件定义的服务的容器。这个命令不仅会停止容器，还会移除容器、网络、卷和默认创建的镜像。如果你只想停止容器但不移除它们，可以使用`docker-compose stop`命令。这样，容器会被停止但不会被移除，可以再次用`docker-compose start`命令重新启动。



## 开发流程

#### 1. 开发阶段

- **后端开发**：使用Spring Boot和Spring Cloud Eureka来构建微服务架构的后端应用。Spring Boot用于简化新Spring应用的初始搭建以及开发过程，集成Spring Cloud Eureka用于服务发现，集成Sentinel进行流量控制和断路器功能。

- **前端开发**：使用Angular来开发前端界面。Angular是现代JavaScript框架，用于构建高效、动态的单页面应用（SPA）。

- **API设计**：定义前后端交互的API接口。使用RESTful风格，确保前后端能够有效通信。

  

#### 2. 容器化

- **Docker化应用**：将后端和前端的应用各自容器化。为每个微服务、前端应用创建Dockerfile，构建Docker镜像。
- **本地测试**：在本地使用Docker Compose来运行和测试整个应用，确保容器间的网络、存储等资源分配正确无误。

#### 3. CI/CD集成

- **Jenkins配置**：搭建Jenkins服务器，配置用于自动化构建、测试和部署的流水线。可以包括代码的自动化编译、测试、构建Docker镜像、推送镜像到Docker Registry等步骤。
- **集成测试和自动部署**：配置Jenkins流水线自动执行集成测试，确保代码质量。成功通过测试后，自动部署到Kubernetes集群。

#### 4. 压力测试

- 使用JMeter对应用进行压力测试，确保性能满足需求。

#### 5. Kubernetes部署

- **AWS EKS配置**：在AWS上配置Elastic Kubernetes Service（EKS）或自建Kubernetes集群。配置必要的网络、存储和安全策略。
- **部署到Kubernetes**：编写Kubernetes部署配置文件（如Deployment、Service、Ingress等），将应用部署到Kubernetes集群。使用Helm等工具可以简化部署过程。
- **服务发现与负载均衡**：利用Kubernetes的服务发现和负载均衡特性，确保应用的高可用和伸缩性。

#### 6. 监控与运维

- **日志和监控**：配置日志管理（如ELK栈）和监控（如Prometheus和Grafana）来监控应用和集群的健康状况。
- **持续运维**：根据应用的运行情况，进行持续的性能调优、故障排查和版本更新。



## 系统架构图

Sting Working
