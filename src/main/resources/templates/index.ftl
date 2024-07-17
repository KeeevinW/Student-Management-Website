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
	</head>

	<body style="text-align: center;">
        <h1>Student Management</h1>

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
        <form action="/student" method="post">
            <h2>To add students:</h2>
            <label for="Name">Name of the student:</label>
            <input type="text" id="Name" name="name">
            <br>
            <label for="StuId">ID of the student:</label>
            <input type="text" id="StuId" name="id">
            <br>
            <label for="StuEmail">Email of the student:</label>
            <input type="email" id="StuEmail" name="email">
            <br>
            <input type="submit" value="Click to add student">
            <p id="StuAdd"></p>
        </form>



        <br><br>
        
        <form id="deleteForm">
            <h2>To delete students:</h2>
            <label for="StuId">ID of the student:</label>
            <input type="text" id="deleteId">
            <br>
            <input type="submit" value="Click to delete student">
            <p id="StuDele"></p>
        </form>

        <script>
            document.getElementById('deleteForm').onsubmit = function(event){
                event.preventDefault();

                var pathVar = document.getElementById('deleteId').value;
                
                fetch('api/student/' + encodeURIComponent(pathVar), {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(response => response.text())
                .then(data => {
                    if(data!="student not found"){
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
            <label for="StuId">ID of the student:</label>
            <input id="updateID" name="updateID">
            <br>
            <label for="StuName">Name of the student:</label>
            <input id="updateName" name="updateName">
            <br>
            <label for="StuEmail">Email of the student:</label>
            <input id="updateEmail" name="updateEmail" type="email">
            <br>
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
                        url: "api/student/" + pathVar,
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

        <!-- get students 表单提交 -->
        <form id="getAll" action="/student" method="get">
            <br>
            <input type="submit" value="Get all students">
        </form>

        
        

	</body>
</html>