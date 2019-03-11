<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gerechten</title>
</head>
<body>
<h1>Gerechten</h1>
<table>
    <thead>
    <th>Name</th>
    <th>Price</th>
    </thead>
    <tbody>
    <c:forEach var="gerecht" items="${gerechten}">
        <tr>
            <td>${gerecht.name}</td>
            <td>${gerecht.price}&euro;</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>