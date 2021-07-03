<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
  <body>
  <c:if test="${emptyFields != null}">You must fill in all fields!<br></c:if>

  <form action="/finalProject_war/updateUser" method="GET" class="form-dark">

      <div class="form-group row">
          <label for="carInfo" class="col-sm-1 col-form-label">Car</label>
          <div class="col-sm-3">
              <input type="text" name="infoOfCar" readonly class="form-control-plaintext" id="carInfo"
                     value="${selected_car.brand} ${selected_car.model}, ${selected_car.yearOfIssue}, V = ${selected_car.engineVolume}, Cost per day -  ${selected_car.paymentPerDay}">
          </div>
      </div>

      <c:if test="${user.passportNumber != null}">
      <div class="form-group row">
          <label for="inputFirstName" class="col-sm-1 col-form-label">First name</label>
          <div class="col-sm-3">
          <input type="text" name="firstName" readonly class="form-control-plaintext" id="inputFirstName" placeholder="First name"
                 value="${user.firstName}" >
          </div>
      </div>

      <div class="form-group row">
          <label for="inputLastName" class="col-sm-1 col-form-label">Last name</label>
          <div class="col-sm-3">
          <input type="text" name="lastName" readonly class="form-control-plaintext"  id="inputLastName"  placeholder="Last name"
                 value="${user.lastName}"/>
          </div>
      </div>

      <div class="form-group row">
          <label for="inputPassportNumber" class="col-sm-1 col-form-label">Passport Number</label>
          <div class="col-sm-3">
              <input type="text" name="passportNumber" readonly class="form-control-plaintext"  id="inputPassportNumber"
                     value="${user.passportNumber}"/>
          </div>
      </div>
      </c:if>

      <c:if test="${user.passportNumber == null}">
          <div class="form-group row">
              <label for="inputFirstName1" class="col-sm-1 col-form-label">First name</label>
              <div class="col-sm-3">
                  <input type="text" name="firstName" class="form-control" id="inputFirstName1" placeholder="First name">
              </div>
          </div>

          <div class="form-group row">
              <label for="inputLastName1" class="col-sm-1 col-form-label">Last name</label>
              <div class="col-sm-3">
                  <input type="text" name="lastName" class="form-control"  id="inputLastName1"  placeholder="Last name"/>
              </div>
          </div>

          <div class="form-group row">
              <label for="inputPassportNumber1" class="col-sm-1 col-form-label">Passport Number</label>
              <div class="col-sm-3">
                  <input type="text" name="passportNumber" class="form-control"  id="inputPassportNumber1"/>
              </div>
          </div>
      </c:if>

      <div class="form-group row">
          <label for="inputNumberOfDays" class="col-sm-1 col-form-label">Number of days</label>
          <div class="col-sm-3">
              <input type="number" name="numberOfDays" class="form-control"  id="inputNumberOfDays"/>
          </div>
      </div>

      <input class="btn btn-warning" type="submit" value="Submit" />
  </form>

  </body>
</html>
