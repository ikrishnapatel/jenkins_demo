<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Details</title>
</head>
<body>
    <h2>User Details</h2>
    <form action="/api/addUser" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="name"/><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email"/><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password"/><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Update</button>
    </form>
</body>
</html>