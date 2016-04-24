<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/bootstrap.min.js"></script>
    <Title>TriTeam Finances -1 ;)</Title>
</head>

<body>
<div class="container">
    <h2>Funds</h2>
    <!--Search Funds -->
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
</body>
</html>