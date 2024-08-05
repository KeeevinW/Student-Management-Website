<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Get the student's courses list</title>
    <style>
        body {
            text-align: center;
        }
    </style>
</head>
<body>

<table class="center" style="width: 50%">
    <tr>
        <th>Courses</th>
    </tr>
    <#list StuCourse as course>
        <td>${course}</td>
    </#list>
</table>


<button onclick="window.location.href='/'">Back to Main Page</button>
</body>
</html>