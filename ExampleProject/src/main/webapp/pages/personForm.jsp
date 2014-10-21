<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring &lt;form:checkboxes&gt; Checkbox</title>
<style>
.error {
    color: red;
}
  
</style>
</head>
<body>
<form:form method="POST" commandName="personForm">
    <table>
        <tr>
            <td>Fruits :</td>
            <td>
                <form:select path="fruit">
                  <form:option value="Select" label="Select" />
                  <form:option value="Apple" label="Apple" />
                  <form:option value="Mango" label="Mango" />
                </form:select>
            </td>
            <td><form:errors path="fruit" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Hobbies :</td>
            <td><form:select path="hobbies" multiple="true">
                    <form:options items="${hobbiesList}"/>
                </form:select>
            </td>
            <td><form:errors path="hobbies" cssClass="error" /></td>
        </tr>
    </table>
    <tr>
            <td colspan="3"><input type="submit" value="Submit"></td>
        </tr>
</form:form>
</body>
</html>