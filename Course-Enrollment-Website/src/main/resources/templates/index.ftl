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
    <h1>Course Enrollment Website</h1>

    <form action="/getcourse" method="get">
        <h3>To get the student's courses list:</h3>
        <br>
        <label for="Name">Name of the student: </label>
        <input id="name" name="name" required>
        <br><br>
        <input type="submit" value="Get all courses">
    </form>
    <br><br>
    <form action="/addcourse" method="post">
        <h3>To add a course:</h3>
        <label for="Name">Name of the student: </label>
        <input id="name" name="name" required>
        <br><br>
        <label for="course">Course to be added: </label>
        <input id="course" name="course" required>
        <br><br>
        <input type="submit" value="Click to add the course">
    </form>
</body>
</html>