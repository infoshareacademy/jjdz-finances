<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Reports</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <!-- Bootstrap -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="resources/css/bootstrap-datepicker.css">
    <link href="resources/css/style.css" rel="stylesheet">

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
    <h1>Reports</h1>
    <br><br>

    <form action="/msaReport" method="post" role="form">
        <h4>Most searched assets</h4>
        <button type="Go!" class="btn btn-xs">
            <span class="">Show</span>
        </button>
    </form>
    <br>


    <form action="/maxBuyReport" method="post" role="form">
        <h4>Most often purchased assets</h4>
        <button type="Go!" class="btn btn-xs">
            <span class="">Show</span>
        </button>
    </form>
    <br>


    <form action="/maxSoldReport" method="post" role="form">
        <h4>Most often sold assets</h4>
        <button type="Go!" class="btn btn-xs">
            <span class="">Show</span>
        </button>
    </form>

</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resources/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.1/js/bootstrap-datepicker.js"></script>
<script src="resources/js/main.js"></script>

<%@ include file="resources/footer.jsp" %>



</body>
</html>
