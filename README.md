# Project description

This is a simple Demo of using `Java8`, `Spring Boot` , `Rest API using JSON` and `MongoDB`. Application below functionalities:

1.	CRUD users: be able to save name, username, password, email into a database
2.	Add a login / password mechanism to your project. Return 403 if invalid.
3.	Permissions: give the ability to add permissions to user.
	Ex: Admin is allowed to delete users
	Ex2: Normal user shouldn’t be able to delete user
	Ex3: Normal user should be able to edit its own profile
	Ex4: Not login user shouldn’t be able to access any data 
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

 To run the project with gradle:

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
Open [http://localhost:8080/home](http://localhost:8080/home) into any browser, add new user and verify new user is displayed.

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
The UI validations (for eg:username should be unique) are not included due to time constraint
The ‘role’ field in user form should be entered as ‘admin’or ‘normal’.
Swagger and scheduled job is not implemented due to time constraints.

## Issues faced and learning
Unable to install docker on Windows 10 home edition. Then I created Windows server 2016 on AWS cloud environment and I was still unable install docker due to some limitation of virtualization on Windows server. Finally I was successful spinning an Ubuntu server on AWS cloud environment and successfully installed the docker.

## Timeline
######Software installations on my laptop:
Jdk 1.8,
Mongodb,
Intellij idea,
Gradle,
Spring boot
	
Time taken:5 hours

######Docker learning and installation:
Creating ubuntu and windows virtual machine on AWS cloud env,
Docker installation,
Installing mongodb and java8 on ubuntu VM,
Creating docker container 					
Time taken : 5hours

######Coding and development						
Time taken: 8hours

######Testing and trouble shooting issues 				
Time taken: 4hours
######Documentation							
Time taken: 2hours

######Total time taken	:						24hours
 







"# Spring-boot-Mongodb-Project" 
"# Spring-boot-Mongodb-Project" 
