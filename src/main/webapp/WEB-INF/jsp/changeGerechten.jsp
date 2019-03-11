<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Change Gerechten"/>
</jsp:include>
<body>
<section class="section">
    <h1 class="title">Change Gerechten</h1>
    <c:choose>
        <c:when test="${gerechten.size() > 0}">
            <table class="table">
                <thead>
                <tr>
                    <th>Beschrijving</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="gerecht" items="${gerechten}">
                    <tr>
                        <td>${gerecht.beschrijving}</td>
                        <td>
                            <a class="button" href="update?beschrijving=${gerecht.beschrijving}">Update</a>
                        </td>
                        <td>
                            <form method="post" action="delete?beschrijving=${gerecht.beschrijving}">
                                <button class="button is-danger" type="submit">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <h3 class="subtitle">Er staan geen gerechten op het menu</h3>
        </c:otherwise>
    </c:choose>
    <a class="button is-primary is-medium" href="add">Add Gerecht</a>
</section>
</body>
</html>