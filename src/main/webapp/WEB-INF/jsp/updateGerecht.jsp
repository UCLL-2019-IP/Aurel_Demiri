<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Update Gerecht"/>
</jsp:include>
<body>
<jsp:include page="nav.jsp"/>
<section class="section">
    <div class="columns is-desktop">
        <div class="column is-half">
            <h1 class="title">Update Gerecht</h1>
            <c:if test="${errors.size() > 0 }">
                <div class="notification is-danger">
                    <ul>
                        <c:forEach var="error" items="${errors}">
                            <li>${error.defaultMessage}</li>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>
            <form method="post" action="update?oudeBeschrijving=${gerecht.beschrijving}">
                <div class="field is-horizontal">
                    <div class="field-label">
                        <label class="label" for="beschrijving">Beschrijving</label>
                    </div>
                    <div class="field-body">
                        <div class="field">
                            <div class="control">
                                <input class="input" type="text" required maxlength="50" id="beschrijving"
                                       name="beschrijving" value="${gerecht.beschrijving}">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="field is-horizontal">
                    <div class="field-label">
                        <label class="label" for="prijs">Prijs</label>
                    </div>
                    <div class="field-body">
                        <div class="field">
                            <div class="control">
                                <input class="input" type="number" required min="0.1" max="10" step="0.01" id="prijs"
                                       name="prijs" value="${gerecht.prijs}">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="field is-horizontal">
                    <div class="field-label">
                        <label class="label" for="type">Type</label>
                    </div>
                    <div class="field-body">
                        <div class="field">
                            <div class="control">
                                <div class="select">
                                    <select id="type" name="type" required>
                                        <option value="" selected="selected" hidden="hidden">Choose here</option>
                                        <option value="DAGSCHOTEL">Dagschotel</option>
                                        <option value="SOEP">Soep</option>
                                        <option value="VEGGIE">Veggie</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="field is-grouped is-grouped-right">
                    <p class="control">
                        <a class="button is-light" href="./change">
                            Cancel
                        </a>
                    </p>
                    <p class="control">
                        <button class="button is-primary">
                            Update
                        </button>
                    </p>
                </div>
            </form>
        </div>
    </div>
</section>
</body>
</html>