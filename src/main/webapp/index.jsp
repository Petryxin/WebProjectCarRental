<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<c:if test="${userNotFound != null}">User not found, try again!<br></c:if>

<form action="/finalProject_war/login" method="GET" class="form-dark">

    <div class="form-group row">
        <label for="login" class="col-sm-1 col-form-label">Login</label>
        <div class="col-sm-2">
            <input type="text" name="login" class="form-control" id="login">
        </div>
    </div>

    <div class="form-group row">
        <label for="password" class="col-sm-1 col-form-label">Password</label>
        <div class="col-sm-2">
            <input type="password" name="password" id="password" class="form-control"/>
        </div>
    </div>

    <input class="btn btn-warning" type="submit" value="Submit" />
</form>

</body>
</html>
