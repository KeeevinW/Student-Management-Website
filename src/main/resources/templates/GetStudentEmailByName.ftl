<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Get Student Email by Name</title>
</head>
<body style="text-align: center">
    <#if StuEmail != "No student found / This student doesn't have an email address.">
        <h1 style="margin-top: 20%">The Email of the Student is: </h1>
        <br/>
        <h2>${StuEmail}</h2>

    <#else>
        <h2 style="margin-top: 20%">${StuEmail}</h2>
    </#if>
    <br/>
    <button onclick="window.location.href='/'">Back to Main Page</button>
</body>
</html>