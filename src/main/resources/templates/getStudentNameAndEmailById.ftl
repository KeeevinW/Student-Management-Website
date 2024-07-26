<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Get student's name and email by ID</title>
</head>
<body style="text-align: center">

    <#if StuNameAndEmail.StuName!="No such student">
        <h1 style="margin-top: 20%">Get student's name and email by ID</h1>
        <h2>Name: </h2>
        <h3>${StuNameAndEmail.StuName}</h3>
        <br/>
        <h2>Email: </h2>
        <h3>${StuNameAndEmail.StuEmail}</h3>
        <br/>

    <#else>
        <h1 style="margin-top: 20%">${StuNameAndEmail.StuName}</h1>
    </#if>

    <button onclick="window.location.href='/'">Back to Main Page</button>
</body>
</html>