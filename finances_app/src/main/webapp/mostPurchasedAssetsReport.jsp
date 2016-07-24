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
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <Title>TriTeam Finances - assets</Title>
    <!-- Bootstrap -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<%@ include file="resources/navbar.jsp" %>

<div class="container">
    <h1>Report</h1>

    <div class="container">
        <h2>Most often purchased assets</h2>
        <table class="table table-condensed">
            <thead>
            <tr>
                <th>Name of Asset</th>
                <th>Amount of Purchased Assets</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${mostPurchasedAssets}" var="item">
                <tr>
                    <td>${item.nameAsset}</td>
                    <td>${item.sum}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resources/js/bootstrap.min.js"></script>

<%@ include file="resources/footer.jsp" %>
</body>
</html>
