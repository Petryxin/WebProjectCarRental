<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h2>List orders</h2>
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">Order number</th>
        <th scope="col">Car number</th>
        <th scope="col">User number</th>
        <th scope="col">Approval</th>
        <th scope="col">Payment</th>
        <th scope="col">Rejection reason</th>
        <th scope="col">Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orderList}" var="order">
        <tr>
            <th scope="row">${order.id}</th>
            <td>${order.car.id}</td>
            <td>${order.userWeb.id}</td>
            <td>${order.approval}</td>
            <td>${order.payment}</td>
            <td>${order.rejectionReason}</td>
            <td>${order.orderStatus}</td>

            <c:if test="${order.approval == false && order.rejectionReason == null}">
            <td>
                <form action="/finalProject_war/approveOrder" method="GET">
                    <input type="text" name="id" value="${order.id}" hidden="true"><br/>
                    <input class="btn btn-warning" type="submit" value="Approve"/>
                </form>
            </td>
            <td>
                <form action="/finalProject_war/rejectionOrderById" method="GET">
                    <input type="text" name="id" value="${order.id}" hidden="true"><br/>
                    <input class="btn btn-warning" type="submit" value="Reject"/>
                </form>
            </td>
            </c:if>

            <c:if test="${order.approval == true && order.payment == true && order.orderStatus == 'RENTED'}">
                <td>
                    <form action="/finalProject_war/closeOrder" method="GET">
                        <input type="text" name="orderId" value="${order.id}" hidden="true"><br/>
                        <input class="btn btn-warning" type="submit" value="Complete"/>
                    </form>
                </td>
                <td>
                    <form action="/finalProject_war/checkBill" method="GET">
                        <input type="text" name="userId" value="${order.userWeb.id}" hidden="true"><br/>
                        <input type="text" name="orderId" value="${order.id}" hidden="true">
                        <input class="btn btn-warning" type="submit" value="Create bill"/>
                    </form>
                </td>
            </c:if>

            <c:if test="${order.orderStatus == 'CAR_BEING_REPAIRED'}">
                <td>
                    <form action="/finalProject_war/changeCarStatus" method="GET">
                        <input type="text" name="carId" value="${order.car.id}" hidden="true"><br/>
                        <input type="text" name="orderId" value="${order.id}" hidden="true">
                        <input class="btn btn-warning" type="submit" value="Car repaired"/>
                    </form>
                </td>
            </c:if>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
