# Project description

This is a simple Demo of using `Java8`, `Spring Boot` , `Rest API using JSON` and `MongoDB`. Application implements below functionalities:

1.	CRUD users: be able to save name, username, password, email into a database
2.	Add a login / password mechanism to your project. Return 403 if invalid.
3.	Permissions: give the ability to add permissions to user.

	Ex1: Admin is allowed to delete users
	Ex2: Normal user shouldn’t be able to delete user
	Ex3: Normal user should be able to edit its own profile
	Ex4: Not login user shouldn’t be able to access any data 

This also included some demo schedular tasks that include a cronjob that runs on configured time.
The data entered will be saved in `collectionUsers` collection in `MongoDB`. 

## Project architecture

Application consists of:

* `LoginController` which handles request for authentication from `user-data.html` page
* `LoginRepository` - repository interface for persistence and retrieving `Users` from `MongoDB`
* `UserController` which handles request for saving and updating/deleting users from `index.html` page, `login-data.html` page respectively.
* `UserResource` - is `REST` endpoint for retrieving `Users`
* `UserRepository` - repository interface for persistence and retrieving `Users` from `MongoDB`


Because it's a simple demo for storing and retrieving users to/from database, `UserRepository` injected directly in 
`UserController` and `UserResource`. `LoginRepository’ injected directly in `LoginController`



## How to run project locally

#####To build, or run project java and MongoDB should be installed.
From the root folder of the project just run ./gradlew build Compiled springboot-mongo-demo.jar file can be found at build/libs

#####To run the project with gradle:

From the root folder of the project run the following command in terminal:

```bash
gradlew bootRun
```



## How to work with the application

After application is started open the following into any browser [http://localhost:8080](http://localhost:8080). This will be entered into a form to add users in the mongoDB.

The user needs to login to the application via below url
[http://localhost:8080/home](http://localhost:8080/home)

For testing purpose and to integrate REST API ,application include below functionality which is beyond the scope of requirement.
Application also provides `REST` API for retrieving all users or user by `userID`.  
To retrieve all users:
[http://localhost:8080/api/users](http://localhost:8080/api/users) 
  
To retrieve user by ID:   
[http://localhost:8080/api/users/user_id](http://localhost:8080/api/users/user_id)   
`user_id` should be replaced by real `ID` from the main page.


## Containerizing into a Docker container
The docker file is included in the docker folder of project.

### How to run application in Docker

This section describes how to run this application and `MongoDB` in Docker containers.   


#### Create network

```bash
docker network create spring_demo_net
```

#### Run MongoDB in Docker

Create folder for storing Mongo DB data:

```bash
mkdir -p ~/mongo-data
```

Run Mongo in container:
Before starting `MongoDB` in Docker make sure Mongo is not started on the host where container will be started.

```bash
docker run --name spring-demo-mongo --network=spring_demo_net -v /home/ubuntu/mongo-data:/data/db -d mongo  
```

#### Build project and copy jar file to docker folder

To build current project and copy `jar` file to the `docker` folder of current project:

```bash
./gradlew clean build && cp build/libs/springboot-mongo-demo.jar docker/
```

`docker` folder contains a `Dockerfile` from which application's image will be created

#### Build application's image

Go to `docker` folder of this project and build image:

```bash
cd docker && docker build --tag=spring-demo-1.0 .
```

#### Run Spring Boot in Docker

To run build application `jar` file in Docker:

```bash
docker run -d --name spring-demo --network=spring_demo_net -p 8080:8080  spring-demo-1.0 
```

#### Verify application and Mongo started correctly

Open [http://localhost:8080/](http://localhost:8080/) into any browser, add new user and verify new user is displayed.
Open [http://localhost:8080/home](http://localhost:8080/home) into any browser for login into application,editing the profile and deleting the profile (by admin).

To verify `MongoDB`'s container logs:

```bash
docker logs spring-demo-mongo
```

To verify Spring Boot Application's logs:

```bash
docker logs spring-demo
```



## Assumptions
1.	Running the project locally assumes that `java` and `MongoDB` are installed locally.
2.	Docker is successfully installed in the machine. Please note that Docker is compactable will OS version, prefer to use OS for ubuntu machine


## Constraints
The UI validations (for eg:username should be unique) are not included.
The ‘role’ field in user form should be entered as ‘admin’or ‘normal’.
Swagger is not implemented due to time constraints.Security validation/decoding or encoding mechanism to the password storage in DB isnot enabled.

## Issues faced and learning
Unable to install docker on Windows 10 home edition. Then I created Windows server 2016 on AWS cloud environment and I was still unable install docker due to some limitation of virtualization on Windows server. Finally I was successful spinning an Ubuntu server on AWS cloud environment and successfully installed the docker.



"# Spring-boot-Mongodb-Project" 
"# Spring-boot-Mongodb-Project" 
