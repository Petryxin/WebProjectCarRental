<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<c:if test="${emptyFields != null}">You must fill in all fields!<br></c:if>
<h2>Repair bill</h2>
<form action="/finalProject_war/creatBill" method="GET" class="form-dark">

    <div class="form-group row">
        <label for="damage" class="col-sm-1 col-form-label">Damage</label>
        <div class="col-sm-3">
            <input type="text" name="damage" class="form-control" id="damage">
        </div>
    </div>

    <div class="form-group row">
        <label for="amountRepair" class="col-sm-1 col-form-label">Amount repair</label>
        <div class="col-sm-3">
            <input type="number" name="amountRepair" class="form-control"  id="amountRepair"/>
        </div>
    </div>

    <input class="btn btn-warning" type="submit" value="Submit" />
</form>

</body>
</html>
