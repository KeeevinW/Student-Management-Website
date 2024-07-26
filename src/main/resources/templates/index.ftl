<!-- <script>
    import 'mdui/mdui.css';
    import 'mdui';

    import 'mdui/components/text-field.js';
</script> -->

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Student Management</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <style>
            .container {
                display: flex;
                justify-content: space-around;
                text-align: center;
            }
            .column {
                flex: 1;
                margin: 10px;
            }

            body {
                text-align: center;
            }
        </style>
	</head>

	<body>
        <h1>Student Management</h1>

        <div class="container">
            <div class="column">
                <!-- add students 异步提交
                <form id="Add">
                    <h2>To add students:</h2>
                    <label for="Name">Name of the student:</label>
                    <input type="text" id="Name" name="name">
                    <br>
                    <label for="StuId">ID of the student:</label>
                    <input type="text" id="StuId" name="id">
                    <br>
                    <input type="submit" value="Click to add student">
                    <p id="StuAdd"></p>
                </form>

                <script>
                    $(document).ready(function(){

                        $("#Add").on("submit",function(event){
                            event.preventDefault();

                            //get the form data
                            var formData = $(this).serialize(); //serialize() converts a JavaScript object into a JSON string

                            $.ajax({
                                url: '/api/student',
                                type: 'POST',
                                data: formData,
                                success: function(response){
                                    document.getElementById("StuAdd").innerHTML=response;
                                    document.getElementById("Name").value="";
                                    document.getElementById("StuId").value="";
                                }
                            });

                        });
                    });
                </script> -->


                <!-- add students 同步提交 -->
                <form action="/addstudent" method="post">
                    <h2>To add students: </h2>
                    <label for="Name">Name of the student: </label>
                    <input type="text" id="Name" name="name">
                    <br><br>
                    <label for="StuId">ID of the student: </label>
                    <input type="text" id="StuId" name="id" required>
                    <br><br>
                    <label for="StuEmail">Email of the student: </label>
                    <input type="email" id="StuEmail" name="email">
                    <br><br>
                    <input type="submit" value="Click to add student">
                    <p id="StuAdd"></p>
                </form>

                <br><br>

                <form id="deleteForm">
                    <h2>To delete students:</h2>
                    <label for="deleteId">ID of the student: </label>
                    <input type="text" id="deleteId">
                    <br><br>
                    <input type="submit" value="Click to delete student">
                    <p id="StuDele"></p>
                </form>

                <script>
                    document.getElementById('deleteForm').onsubmit = function(event){
                        event.preventDefault();

                        var pathVar = document.getElementById('deleteId').value;

                        fetch('api/deletestudent/' + encodeURIComponent(pathVar), {
                        method: 'DELETE',
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    })
                        .then(response => response.text())
                        .then(data => {
                            if(data!="Student not found"){
                                document.getElementById("StuDele").innerHTML="Success: " + data;

                            }else{
                                document.getElementById("StuDele").innerHTML="Fail: " + data;
                            }
                            document.getElementById("deleteId").value="";
                        })
                    };
                </script>

                <br><br>


                <form id="updateStu">
                    <h2>To update students info:</h2>
                    <label for="updateID">ID of the student: </label>
                    <input id="updateID" name="updateID" required>
                    <br><br>
                    <label for="updateName">Name of the student: </label>
                    <input id="updateName" name="updateName">
                    <br><br>
                    <label for="updateEmail">Email of the student: </label>
                    <input id="updateEmail" name="updateEmail" type="email">
                    <br><br>
                    <input type="submit" value="Click to Update Student Info">
                    <p id="Update"></p>
                </form>
                <script>
                    $(document).ready(function(){
                        $("#updateStu").on("submit",function(event){
                            event.preventDefault();

                            var pathVar = encodeURIComponent(document.getElementById("updateID").value);
                            var formData = {
                                name: $("#updateName").val(),
                                email: $("#updateEmail").val()
                            }

                            $.ajax({
                                url: "api/updatestudent/" + pathVar,
                                type: "PUT",
                                contentType: "application/json",
                                data: JSON.stringify(formData),
                                success: function(response){
                                    document.getElementById("Update").innerHTML = response;
                                    document.getElementById("updateID").value = "";
                                    document.getElementById("updateName").value = "";
                                    document.getElementById("updateEmail").value = "";
                                }
                            });
                        });
                    });
                </script>
            </div>

            <div class="column">
                <!-- get students 异步提交 -->
                <!-- <form id="getAll">
                    <br>
                    <input type="submit" value="Get all students">
                    <p id="allStu"></p>
                </form>

                <script>
                    $(document).ready(function(){

                        $("#getAll").on("submit",function(event){
                            event.preventDefault();

                            //get the form data
                            var formData = $(this).serialize(); //serialize() converts a JavaScript object into a JSON string

                            $.ajax({
                                url: '/api/student',
                                type: 'GET',
                                data: formData,
                                success: function(response){

                                    if(response.length == 0){
                                        document.getElementById("allStu").innerHTML="Currently no student added\n";
                                    }else{
                                        var t = "<ul>";
                                        response.forEach(function(stu){
                                            t += "<li> ID: " + stu.id + ", Name: " + stu.name + "</li>";
                                        });
                                        t += "</ul>";
                                        document.getElementById("allStu").innerHTML=t;
                                    }

                                }
                            });

                        });
                    });
                </script> -->
                <br/>
                <h2>To get/search for students: </h2>
                <br/>
                <form id="getStuNameByEmail" action="/getstudent/byemail" method="get">
                    <h3>To get the student's name by email</h3>
                    <label for="name">Email of the student: </label>
                    <input type="email" id="email" name="email">
                    <br><br>
                    <input type="submit" value="Click to get the student's name">
                </form>
                <br/>
                <form id="getStuEmailByName" action="/getstudent/byname" method="get">
                    <h3>To get the student's email by name</h3>
                    <label for="name">Name of the student: </label>
                    <input type="text" id="name" name="name">
                    <br><br>
                    <input type="submit" value="Click to get the student's email">
                </form>
                <br/>
                <form id="getStuNameAndEmailById" action="/getstudent/byid" method="get">
                    <h3>To get the student's name and email by id</h3>
                    <label for="id">ID of the student: </label>
                    <input type="text" id="id" name="id">
                    <br><br>
                    <input type="submit" value="Click to get the student's name and email">
                </form>
                <br/>
                <!-- get students 表单提交 -->
                <form id="getAll" action="/getstudent" method="get">
                    <h3>To get all students:</h3>
                    <input type="submit" value="Get all students">
                </form>

            </div>
        </div>
	</body>
</html>