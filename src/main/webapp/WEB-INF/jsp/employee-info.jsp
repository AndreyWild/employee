<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<body>
<h2>Employee Info</h2>
<br>

<%--Создает форму с атрибутами--%>
<form:form action="saveEmployee" modelAttribute="employee">

    <%--    Создает скрытую форму id--%>
    <form:hidden path="id"/>

    <%--    Создает формы с параметрами работника--%>
    FirstName<form:input path="firstName"/>
    <br><br>
    LastName<form:input path="lastName"/>
    <br><br>
    Department<form:input path="department"/>
    <br><br>
    JobTitle<form:input path="jobTitle"/>
    <br><br>
    Gender<form:input path="gender"/>
    <br><br>
    <%--    Создает кнопу OK--%>
    <input type="submit" value="OK">

</form:form>

</body>
</html>
