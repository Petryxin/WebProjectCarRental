<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  </head>
  <body>
  <h2>Welcome ${sessionScope.user.firstName}!</h2>
  <table class="table table-dark">
    <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">Brand</th>
      <th scope="col">Model</th>
      <th scope="col">Year Of Issue</th>
      <th scope="col">Engine Volume</th>
      <th scope="col">Payment Per Day</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${car_list}" var="car">
      <c:if test="${car.rentedCar == false}">
      <tr>
        <th scope="row">${car.id}</th>
        <td>${car.brand}</td>
        <td>${car.model}</td>
        <td>${car.yearOfIssue}</td>
        <td>${car.engineVolume}</td>
        <td>${car.paymentPerDay}</td>
        <td>
          <form action="/finalProject_war/carById" method="GET">
            <input type="text" name="id" value="${car.id}" hidden="true"><br/>
            <input class="btn btn-warning" type="submit" value="Choose"/>
          </form>
        </td>
      </tr>
      </c:if>
    </c:forEach>
    </tbody>
  </table>
  </body>
</html>
