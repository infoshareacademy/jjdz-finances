<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Plans</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-2.2.3.min.js"
            integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo="
            crossorigin="anonymous"></script>

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>




    <!-- Latest compiled and minified CSS -->
    <!--<link href="../css/bootstrap.min.css" rel="stylesheet">-->
    <link rel="stylesheet" href="resources/css/bootstrap-datepicker.css">
    <!-- Optional theme -->
    <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">-->


</head>
<body>





<form class="form-inline">
    <div class="form-group">
        <label>Asset</label>
        <input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
    </div>
    <div class="form-group">
        <label>:</label>
        <input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">
    </div>
    <div class="form-group">

        <div class="input-group date">
            <label>Name</label>
            <input type="text" class="form-control"><span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
        </div>

    </div>


    <button type="submit" class="btn btn-default">Create</button>
</form>






<!-- Latest compiled and minified JavaScript -->

<!--<script src="../js/jquery-2.2.3.min.js"></script>-->

<!--<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.1/js/bootstrap-datepicker.js"></script>-->
<script type="text/javascript">
    $(document).ready(function() {
        $('.date').datepicker({
            todayBtn: true,
            daysOfWeekHighlighted: "0,6",
            autoclose: true
        });
    })
</script>
</body>
</html>