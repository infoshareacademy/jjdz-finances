<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <Title>TriTeam Finances - Funds</Title>
    <!-- Bootstrap -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="resources/css/bootstrap-datetimepicker.css">

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
    <form class="form-inline table" action="/crudServlet" method="post">
    <input class="hidden" name="token" value="${token}"/>
        <div class="form-group">
            <label>Asset</label>
            <select class="form-control" name="selectAsset" value="${assetName}">
                <c:forEach var="LstList" items="${fundList}">
                    <option value="${LstList.code}" ${LstList.code == code ? 'selected="selected"' : ""}>${LstList.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>Action</label>
            <select class="form-control" name="action">
                <option value="BUY" ${actionType == "BUY" ? 'selected="selected"' : ""}>BUY</option>
                <option value="SELL" ${actionType =="SELL" ? 'selected="selected"' : ""}>SELL</option>
            </select>
        </div>
        <div class="form-group">
            <label>Date</label>
            <div class='input-group date' id='datetimepicker4'>
                <input  type='text' class="form-control" name="date" value="<javatime:format value="${date}" style="SS"/>"/>


                <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
            </div>
        </div>
        <div class="form-group">
            <label>Quantity</label>
            <input class="form-control" name="quantity" value="${planCreationDto.getQuantity()}">
        </div>
        <c:choose>
        <c:when test="${PlanId != null}">

            <input type="hidden" name="PlanId" value="${PlanId}"/>

        </c:when>
        </c:choose>

        <button type="submit" class="btn btn-default" name="buttonSave" value="save">Save</button>
    </form>

</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/moment.js"></script>
<script src="resources/js/bootstrap-datetimepicker.min.js"></script>
<script src="resources/js/main.js"></script>

<%@ include file="resources/footer.jsp" %>

</body>
</html>
