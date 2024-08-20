<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Get Student Name by Email</title>
</head>
<body style="text-align: center">

    <#if StuName!="No such student.">
        <h1 style="margin-top: 20%">The Name of the Student is: </h1>
        <br/>
    </#if>
        <h2>${StuName}</h2>
        <br/>

    <button onclick="window.location.href='/'">Back to Main Page</button>
</body>
</html>