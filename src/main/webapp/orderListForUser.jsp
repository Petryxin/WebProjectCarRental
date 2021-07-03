<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"></head>
<body>
<h2>List orders</h2>
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">Order number</th>
        <th scope="col">Amount</th>
        <th scope="col">Approval</th>
        <th scope="col">Payment</th>
        <th scope="col">Rejection reason</th>
        <th scope="col">Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${personalOrders}" var="order">
        <tr>
            <th scope="row">${order.id}</th>
            <td>${order.amount}</td>
            <td>${order.approval}</td>
            <td>${order.payment}</td>
            <td>${order.rejectionReason}</td>
            <td>${order.orderStatus}</td>

            <c:if test="${order.approval == true && order.payment == false}">
                <td>
                    <form action="/finalProject_war/updatePaymentFieldOfOrder" method="GET">
                        <input type="text" name="id" value="${order.id}" hidden="true"><br/>
                        <input class="btn btn-warning" type="submit" value="Pay"/>
                    </form>
                </td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:if test="${bills.isEmpty() == false}">
<h2>Invoices for payment</h2>
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">Bill number</th>
        <th scope="col">Order number</th>
        <th scope="col">Damage</th>
        <th scope="col">Amount Repair</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${bills}" var="bill">
        <tr>
            <th scope="row">${bill.id}</th>
            <td>${bill.order.id}</td>
            <td>${bill.damage}</td>
            <td>${bill.amountRepair}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</c:if>
    <form action="/finalProject_war/carList" method="GET">
        <input class="btn btn-warning" type="submit" value="New order"/>
    </form>
</body>
</html>
