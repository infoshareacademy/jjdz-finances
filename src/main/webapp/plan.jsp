<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>

<html>
<head>
    <title>Plans</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
          integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-2.2.3.min.js"
            integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo="
            crossorigin="anonymous"></script>

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
            crossorigin="anonymous"></script>


    <!-- Latest compiled and minified CSS -->
    <!--<link href="../css/bootstrap.min.css" rel="stylesheet">-->
    <link rel="stylesheet" href="resources/css/bootstrap-datepicker.css">
    <!-- Optional theme -->
    <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">-->


</head>
<body>
<%@ include file="resources/navbar.jsp" %>

<div class="container">
    <form action="/modify-plans" method="post">
    <table class="table table-hover">
        <tr>
            <th></th>
            <th>Asset</th>
            <th>Date of action</th>
            <th>Type of action</th>
            <th>Quantity</th>
            <th colspan="2">Action</th>
        </tr>
        <c:forEach items="${plans}" var="plan">
            <tr>
                <td>
                            <input type="checkbox">
                </td>
                <td><c:out value="${plan.assetEntity.getAsset().getName()}" /></td>
                <%--<td><fmt:formatDate pattern="dd-MM-yyyy" value="${plan.actionTime}"/></td>--%>
                <td><javatime:format value="${plan.actionTime}" style="MS"/></td>
                <td><c:out value="${plan.planActionType}"/></td>
                <td><c:out value="${plan.quantity}"/></td>
                <td>
                    <button type="submit" class="btn btn-default" >Delete</button>
                    <button type="submit" class="btn btn-default" >Edit</button>
                </td>
            </tr>
        </c:forEach>
    </table>
        </form>
<h4>- - - - - </h4>
</div>

<div class="container">
    <form class="form-inline table">
        <div class="form-group">
            <label>Fund</label>
            <select class="form-control">
                <c:forEach var="LstList" items="${fundList}">
                    <option value=${LstList.code}>${LstList.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>Name</label>
            <div class="input-group date">
                <input type="text" class="form-control"><span class="input-group-addon"><i
                    class="glyphicon glyphicon-th"></i></span>
            </div>

        </div>
        <button type="submit" class="btn btn-default">Create</button>
    </form>
    <form class="form-inline table">
    <div class="form-group">
        <label>Currency</label>
        <select class="form-control">
            <c:forEach var="LstList" items="${fundList}">
                <option value=${LstList.code}>${LstList.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label>Name</label>
        <div class="input-group date">
            <input type="text" class="form-control"><span class="input-group-addon"><i
                class="glyphicon glyphicon-th"></i></span>
        </div>

    </div>
    <button type="submit" class="btn btn-default">Create</button>
    </form>



<!-- Latest compiled and minified JavaScript -->

<!--<script src="../js/jquery-2.2.3.min.js"></script>-->

<!--<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.1/js/bootstrap-datepicker.js"></script>-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.1/js/bootstrap-datepicker.js"></script>
<script src="resources/js/main.js"></script>
</body>
</html>
