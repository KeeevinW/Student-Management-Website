<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>List of All Students</title>
	</head>
	<body style="text-align: center">
		<table style="width: 50%">
            <tr>
                <th>Name</th>
                <th>Student ID</th>
				<th>Student Email</th>
            </tr>
			<#list students as student>
				<tr>
					<td>${student.getName()}</td>
					<td>${student.getId()}</td>
					<td>${student.getEmail()}</td>
				</tr>
			</#list>
        </table>

        <a href="/">Back to Main Page</a>
	</body>
</html>