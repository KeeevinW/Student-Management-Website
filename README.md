# Student-Management-Website

## Table of Contents
- [Description](#description)
  - [Front End](#front-end)
  - [Back End](#back-end)
  - [Database](#database)
- [How To Run This Project](#how-to-run-this-project)
  - [Maven](#maven)
  - [Advanced Encryption Standard (AES)](#advanced-encryption-standard-aes)
  - [MySQL](#mysql)
  - [Running the Project](#running-the-project)

## Description

This project is a student management website developed during my internship at ICBC Guangxi, Financial Technology Department. It serves as a practical exercise in building web applications using the Java Spring Boot framework, implementing multi-table queries, as well as encrypting sensitive data.

### Front End

The front end is built with the Freemarker template engine, which manages dynamic web pages and interacts with the back end through a RESTful API.

### Back End

The back end is structured into three layers: controller, service, and mapper.

### Database

The project uses MyBatis for database access and MySQL as the database management system.

## How To Run This Project

### Maven

This project uses Maven to manage dependencies, you can download it from [here](https://maven.apache.org/download.cgi). After tarring or unzipping your downloaded file (depends on what kind of archive you downloaded (.tar.gz or .zip), mine was .tar.gz), move it to a local directory by
```bash
mv apache-maven-3.9.8 ~/apache-maven
```
Then change the directory to the conf file by
```bash
cd ./apache-maven/conf
```
and type `ls` to see the file list. In the settings.xml file, add a repository mirror site inside the \<mirrors\> tag, I used the central mirror site
```xml
<mirror>
  <id>central</id>
  <mirrorOf>central</mirrorOf>
  <url>https://repo.maven.apache.org/maven2</url>
</mirror>
```
You can find other Maven mirror repository sites [here](https://blog.csdn.net/qq_38217990/article/details/129257106).\
Last but not least, add Maven to the path variable in your shell configuration file (~/.zshrc, ~/.bash_profile, etc.) by adding this line
```sh
export PATH=~/apache-maven/bin:$PATH
```

### Advanced Encryption Standard (AES)

This project uses AES to perform encryption of students' IDs before storing them in the database. The key is assumed to be stored in the shell configuration file as an environment variable `AES_SECRET_KEY`. To get the key, run the "AESKeyGenerator.java" file under the "AES" directory, and copy the key to the shell configuration file
```sh
export AES_SECRET_KEY=your_AES_secret_key
```

### MySQL

You can download MySQL from [here](https://dev.mysql.com/downloads/mysql/), and [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) if you want.

#### Tables
In MySQL, create a new schema named "PracticeDataBase" and two tables named "Students" and "Stu_Email", if you prefer a different schema name or different table names, you will need to modify the StudentMapper.xml file. In the "Students" table, create two columns named "StuName" and "StuId", respectively, while in the "Stu_Email" table, create two columns named "StuId" and "StuEmail", similarly, if you prefer different column names, you will need to modify the student.java file.

#### Username and Password

For security measures, you should avoid including sensitive information in a public GitHub repository, so I replaced my MySQL username and password in the application.yml file with `${DB_USERNAME}` and `${DB_PASSWORD}`. To run this project, you should add your MySQL username and password to your shell configuration file as environment variables
```sh
export DB_USERNAME=your_database_username
export DB_PASSWORD=your_database_password
```

### Running the Project

To run Spring Boot, navigate the directory to this project, e.g.
```bash
cd Student-Management-Website/
```
and type
```bash
mvn spring-boot:run
```
in the terminal to run the Spring Boot application. You should see an ASCII Art of "Spring"  and "BUILD SUCCESS" in green after typing "^C" to terminate this process.












