<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h2>All Employees</h2>
<br>

<table>

    <tr>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Department</th>
        <th>JobTitle</th>
        <th>Gender</th>
    </tr>

    <c:forEach var="emp" items="${allEmployees}">

        <c:url var="updateButton" value="/updateInfo">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>

        <tr>
            <td>${emp.firstName}</td>
            <td>${emp.lastName}</td>
            <td>${emp.department}</td>
            <td>${emp.jobTitle}</td>
            <td>${emp.gender}</td>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'"/>

                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'"/>
            </td>

        </tr>

    </c:forEach>

</table>

<br>

<input type="button" value="Add"
       onclick="window.location.href='addNewEmployee'"/>


</body>


</html>