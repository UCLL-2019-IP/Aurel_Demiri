<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Gerechten"/>
</jsp:include>
<body>
<jsp:include page="nav.jsp"/>
<section class="section">
    <h1 class="title">Gerechten Overzicht</h1>
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
    <sec:authorize access="hasRole('ADMIN')">
        <a class="button is-primary is-medium" href="/gerechten/change">Change Gerechten</a>
    </sec:authorize>
</section>
</body>
</html>