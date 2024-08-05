<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course Management Website</title>

    <style>
        body {
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Course Management Website</h1>

    <form action="/getcourse" method="get">
        <h3>To get the student's courses list:</h3>
        <br>
        <input id="name" name="name">
        <br>
        <input type="submit" value="Get all courses">
    </form>

    <form action="/addcourse" method="post">
        <h2>Student's Name:</h2>
        <br>
        <input id="name" name="name">
        <br>
        <input id="course" name="course">
        <br>
        <input type="submit" value="Click to add the course">
    </form>
</body>
</html>