<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Plans</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <Title>TriTeam Finances - Funds</Title>
    <!-- Bootstrap -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="resources/css/bootstrap-datepicker.css">

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

    <div class="btn-group" role="group" aria-label="...">
        <button type="button" class="btn btn-default">Funds</button>
        <button type="button" class="btn btn-default">Currencies</button>
    </div>

    <form action="/delete" method="post">
    <table class="table table-hover">
        <tr>
            <%--<th></th>--%>
            <th>Asset</th>
            <th>Date of action</th>
            <th>Type of action</th>
            <th>Quantity</th>
            <th colspan="2">Action</th>
        </tr>
        <c:forEach items="${plans}" var="plan">
            <tr>
                <%--<td>--%>

                            <%--<input type="checkbox">--%>

                <%--</td>--%>
                <td><c:out value="${plan.assetEntity.getAsset().getName()}" /></td>
                <%--<td><fmt:formatDate pattern="dd-MM-yyyy" value="${plan.actionTime}"/></td>--%>
                <td><javatime:format value="${plan.actionTime}" style="MS"/></td>
                <td><c:out value="${plan.planActionType}"/></td>
                <td><c:out value="${plan.quantity}"/></td>
                <td>
                    <button type="submit" class="btn btn-default" name="id" value="${plan.id}"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                    <button class="btn btn-default"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span></button>
                </td>
            </tr>
        </c:forEach>
    </table>
        </form>
    <button class="btn btn-default" type="submit">Add</button>


<h2>___</h2>
</div>


<div class="container">
    <form class="form-inline table">
        <div class="form-group">
            <label>Fund</label>
            <input type="text" class="form-control">

            <select class="form-control">
                <c:forEach var="LstList" items="${fundList}">
                    <option value=${LstList.code}>${LstList.name}</option>
                </c:forEach>
            </select>


        </div>
        <%--<div class="form-group">--%>
        <%--<label>:</label>--%>
        <%--<input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">--%>
        <%--</div>--%>
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
            <input type="text" class="form-control">
        </div>
        <%--<div class="form-group">--%>
        <%--<label>:</label>--%>
        <%--<input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">--%>
        <%--</div>--%>
        <div class="form-group">
            <label>Name</label>
            <div class="input-group date">
                <input type="text" class="form-control"><span class="input-group-addon"><i
                    class="glyphicon glyphicon-th"></i></span>
            </div>

        </div>


        <button type="submit" class="btn btn-default">Create</button>

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
