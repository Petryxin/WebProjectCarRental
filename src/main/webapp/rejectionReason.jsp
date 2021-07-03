<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<c:if test="${emptyFields != null}">You must fill in all fields!<br></c:if>
<form action="/finalProject_war/rejectOrder" method="GET" class="form-dark">

    <div class="form-group row">
        <label for="reason" class="col-sm-1 col-form-label">Rejection reason</label>
        <div class="col-sm-2">
            <input type="text" name="reason" class="form-control" id="reason">
        </div>
    </div>
    <input class="btn btn-warning" type="submit" value="Send" />
</form>
</body>
</html>
