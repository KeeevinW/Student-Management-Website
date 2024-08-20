# Student-Management-Website

## Table of Contents
- [Description](#description)
  - [Technologies Included](#technologies-included)
  - [Front End](#front-end)
  - [Back End](#back-end)
  - [Database](#database)
- [How To Run This Project](#how-to-run-this-project)
  - [Maven](#maven)
  - [Advanced Encryption Standard (AES)](#advanced-encryption-standard-aes)
  - [MySQL](#mysql)
  - [Running the Project](#running-the-project)
    - [Locally](#running-this-project-locally)
    - [Remotely](#running-this-project-remotely)

## Description

This project is a student management website developed during my internship at ICBC Guangxi, Financial Technology Department, mentored by Mr. Wu. It serves as a practical exercise in building web applications using the Java Spring Boot framework and developing programming skills such as implementing multi-table queries and handling exceptions.

### Technologies Included

- Java Spring Boot framework
- RESTful API
- Freemarker (template engine)
- MyBatis (ORM framework)
- SQL & MySQL
- AES (Advanced Encryption Standard) for encryption
- HttpClient

### Front End

The front end is built with the Freemarker template engine, which manages dynamic web pages and interacts with the back end through a RESTful API.

### Back End

The back end is structured into three layers: controller, service, and mapper.

#### Controller Layer

The controller layer, in which the RESTful API is implemented, receives the requests from the front end via the URL and returns responses by calling the service layer.

#### Service Layer

The service layer contains the business logic of the application. It processes data and performs operations by calling the mapper layer (DAO layer).

#### Mapper Layer (DAO Layer)

The mapper layer directly interacts with the database (to perform CRUD operation). This project uses MyBatis as the Object Relational Mapping (ORM) framework.

### Database

The project uses MyBatis for database access and MySQL as the database management system.

## How To Run This Project

### Maven

This project uses Maven to manage dependencies, you can download it from [here](https://maven.apache.org/download.cgi). After tarring or unzipping your downloaded file (depends on what kind of archive you downloaded (.tar.gz or .zip), mine was .tar.gz), extract the file and move it to a local directory:
```bash
mv apache-maven-3.9.8 ~/apache-maven
```
Navigate to the configuration file:
```bash
cd ./apache-maven/conf
```
Open the `settings.xml` file and add a repository mirror site inside the `<mirrors>` tag:
```xml
<mirror>
  <id>central</id>
  <mirrorOf>central</mirrorOf>
  <url>https://repo.maven.apache.org/maven2</url>
</mirror>
```
You can find other Maven mirror repository sites [here](https://blog.csdn.net/qq_38217990/article/details/129257106).\
Then, Add Maven to the path variable in your shell configuration file (`~/.zshrc`, `~/.bash_profile`, etc.):
```sh
export PATH=~/apache-maven/bin:$PATH
```

### Advanced Encryption Standard (AES)

This project uses AES to perform encryption of students' IDs before storing them in the database. The key is assumed to be stored in the shell configuration file as an environment variable `AES_SECRET_KEY`. To get the key, run the `AESKeyGenerator.java` file under the "AES" directory, and copy the key to the shell configuration file:
```sh
export AES_SECRET_KEY=your_AES_secret_key
```

### MySQL

You can download MySQL from [here](https://dev.mysql.com/downloads/mysql/), and [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) if needed.

#### Tables
In MySQL, create a new schema named `PracticeDataBase` and two tables named `Students` and `Stu_Email`, if you prefer a different schema name or different table names, you will need to modify the `StudentMapper.xml` file. In the `Students` table, create two columns named `StuName` and `StuId`, respectively, while in the `Stu_Email` table, create two columns named `StuId` and `StuEmail`, similarly, if you prefer different column names, you will need to modify the `student.java` file.

#### Username and Password

For security measures, do not include sensitive information in a public GitHub repository, the MySQL username and password in the `application.yml` file with `${DB_USERNAME}` and `${DB_PASSWORD}`. To run this project, you should add your MySQL username and password to your shell configuration file as environment variables:
```sh
export DB_USERNAME=your_database_username
export DB_PASSWORD=your_database_password
```

### Running this Project Locally

To run this project, navigate to the project directory:
```sh
cd Student-Management-Website/
```
Run the Spring Boot application:
```sh
mvn spring-boot:run
```
You should see an ASCII Art of "Spring". You can also access the website through `localhost:8080` on your browser.\
Lastly, press `^C` to terminate the process.\
To also run the course enrollment website, navigate to the corresponding directory:
```sh
cd Course-Enrollment-Website/
```
and run the Spring Boot application:
```sh
mvn spring-boot:run
```
You can access the website through `localhost: 8081` on your browser

### Running this Project Remotely
You can also run this project on a virtual machine (VM) using Ubuntu.
#### Prerequisites
- JDK 22
- openssh
- MySQL

In the project's directory, package the project into a JAR (Java Archive) file:
```sh
mvn clean package
```
You should see the `.jar` file under the `target` directory. For multiple applications, package each one separately.

Using `scp` to transfer the files to your VM:
```sh
scp path/to/the/file/jar_file_name.jar vm_username@vm_ip_address:./target/path/
```
Find your VM's IP address using `ip addr`.

After logging in to your VM, set up the environment variable:
```sh
export PATH=~/apache-maven/bin:$PATH
export AES_SECRET_KEY=your_AES_secret_key
export DB_USERNAME=your_database_username
export DB_PASSWORD=your_database_password
# Enclose values containing special characters in single quotes.
```

In macOS, in System Settings -> General -> Advanced, turn on the `Remote Login` toggle, then connect to your local MySQL database from the VM:
```sh
ssh -L 3306:localhost:3306 your_computer_user_name@your_computer_ip_address
```
You will be prompted for your password.

In another terminal window, log into the VM, navigate to the corresponding directory, and run the applications:
```sh
java -jar jar_file_name.jar
```
You should see an ASCII Art of "Spring", and you can access the website through `http://{vm_ip_address}:8080/`.

Feel free to adjust further based on specific needs or preferences!

If you have any questions, contact me via email at [xuanye_wang@ucsb.edu](mailto:xuanye_wang@ucsb.edu).






