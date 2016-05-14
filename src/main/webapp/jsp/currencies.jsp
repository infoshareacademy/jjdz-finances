<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <Title>TriTeam Finances - Curencies</Title>
    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <div class="container">
        <nav class="navbar navbar-default navbar-static-top">
            <a class="btn btn-default navbar-btn" href="/main">Home</a>
            <a class="btn btn-default navbar-btn" href="/main?action=forwardFundsMain">Funds</a>
            <a class="btn btn-default navbar-btn" href="/main?action=currenciesSelected">Currencies</a>
            <a class="btn btn-default navbar-right" href="/main?action=adminSelected">Admin</a>
            <a  class="btn btn-default navbar-right" href="/main?action=loginSelected">Login</a>
        </nav>
    </div>
    <div class="container">
        <form action="/" method="get" id="seachFundsForm" role="form">
            <select class="form-control">
                <c:forEach var="LstList" items="${fundList}">
                    <option value=${LstList.fundFile}>${LstList.fundName}</option>
                </c:forEach>
            </select>
            <button type="Go!" class="btn btn-info">
                <span class="glyphicon glyphicon-search"></span> Search
            </button>
        </form>
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/bootstrap.min.js"></script>
</body>
</html>
