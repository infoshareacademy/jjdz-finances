<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <Title>TriTeam Finances - Main</Title>
    <!-- Bootstrap -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <%@ include file="resources/navbar.jsp" %>
    <div class="container">
        <div class="text-center">
            <h1>Assets Analyzer 2.0 - WielBłąd ;)</h1>
        </div>
        <img src="/resources/img/error.gif" class="imgAsset">
        <div class="container">
            <div class="text-center">
                Przepraszamy, wystąpił błąd aplikacji.<br>
                Będziemy bardzo wdzięczni za opisanie w jakiej sytuacji zaistniał problem.<br>
                Twoja sugestie pozwolą nam znacznie przyśpieszyć wyeliminowanie błędu.<br>
                <b>Dziękujemy.</b><br>
            </div>
        </div>
        <div class="container">
            <div class="text-center">
                <div class="form-group">
                    <label for="comment">Comment:</label>
                    <textarea class="form-control" rows="5" id="comment"></textarea>
                    <a class="btn btn-default" href="main">Submit</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resources/js/bootstrap.min.js"></script>

<%@ include file="resources/footer.jsp" %>

</body>
</html>
