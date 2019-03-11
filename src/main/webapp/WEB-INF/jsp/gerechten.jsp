<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Gerechten"/>
</jsp:include>
<body>
<section class="section">
    <h1 class="title">Gerechten</h1>
    <c:choose>
        <c:when test="${gerechten.size() > 0}">
            <table class="table">
                <thead>
                <tr>
                    <th>Beschrijving</th>
                    <th>Prijs</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="gerecht" items="${gerechten}">
                    <tr>
                        <td>${gerecht.beschrijving}</td>
                        <td>${gerecht.prijs}&euro;</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <h3 class="subtitle">Er staan geen gerechten op het menu</h3>
        </c:otherwise>
    </c:choose>
</section>
</body>
</html>