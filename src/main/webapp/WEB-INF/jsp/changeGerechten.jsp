<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="${pageContext.response.locale}">
<spring:message code="menu.edit" var="pagetitle"/>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="${pagetitle}"/>
</jsp:include>
<body class="main">
<jsp:include page="nav.jsp"/>
<section class="section">
    <h1 class="title">${pagetitle}</h1>
    <c:choose>
        <c:when test="${gerechten.size() > 0}">
            <table class="table">
                <thead>
                <tr>
                    <th><spring:message code="description"/></th>
                    <th><spring:message code="price"/></th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="gerecht" items="${gerechten}">
                    <tr>
                        <td>${gerecht.beschrijving}</td>
                        <td>${gerecht.prijs}&euro;</td>
                        <td>
                            <a class="button is-light"
                               href="update?beschrijving=${gerecht.beschrijving}"><spring:message code="edit"/></a>
                        </td>
                        <td>
                            <a class="button is-danger"
                               href="delete?beschrijving=${gerecht.beschrijving}"><spring:message code="delete"/></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <h3 class="subtitle"><spring:message code="menu.empty"/></h3>
        </c:otherwise>
    </c:choose>
    <a class="button is-primary is-medium" href="add"><spring:message code="meal.add"/></a>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>