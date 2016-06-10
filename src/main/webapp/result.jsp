<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <Title>TriTeam Finances - Funds</Title>

    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>
<div class="container">
    <%@ include file="resources/navbar.jsp" %>
    <div class="container">
        Fund selected:
        <button disabled="disabled">
            <c:out value="${asset}"></c:out>
        </button>
        Year selected:
        <button disabled="disabled">
            <c:out value="${year}"></c:out>
        </button>
        Month selected:
        <button disabled="disabled">
            <c:out value="${month}"></c:out>
        </button>
        <div class="container">
            <h1>Trend for Month</h1>
            <img src="/drawChart?type=month" width="900" height="400" border="0" usemap="#chart">
        </div>
        <div class="container">
            <h1>Trend for Year</h1>
            <img src="/drawChart?type=year" width="900" height="400" border="0" usemap="#chart">
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>

<%@ include file="resources/footer.jsp" %>
</body>
</html>
