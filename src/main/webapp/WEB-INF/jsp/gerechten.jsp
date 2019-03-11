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
<c:choose>
    <c:when test="${gerechten.size() > 0}">
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Price</th>
            </tr>
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
    </c:when>
    <c:otherwise>
        <h3>Er staan geen gerechten op het menu</h3>
    </c:otherwise>
</c:choose>
</body>
</html>