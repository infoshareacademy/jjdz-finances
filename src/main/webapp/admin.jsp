<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <Title>TriTeam Finances - Admin</Title>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>
<%@ include file="resources/navbar.jsp" %>

<div class="container">
    <c:forEach items="${requestScope.admins}" var="admin">

            <c:out value="${admin.name}"/>
            <c:out value="${admin.email}"/>
        <c:out value="${xxxxx}"/>yyy
    </c:forEach>

    <h2>Admins</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Username</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>

        <tr class="success">
            <td>John</td>
            <td>john@example.com</td>
        </tr>
        <tr class="danger">
            <td>Mary</td>
            <td>mary@example.com</td>
        </tr>
        <tr class="info">
            <td>Dooley</td>
            <td>july@example.com</td>
        </tr>
        </tbody>
    </table>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>

<%@ include file="resources/footer.jsp" %>
</body>
</html>
