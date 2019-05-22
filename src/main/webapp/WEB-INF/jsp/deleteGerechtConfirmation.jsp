<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Delete Gerecht"/>
</jsp:include>
<body>
<jsp:include page="nav.jsp"/>
<section class="section">
    <div class="columns is-desktop">
        <div class="column is-one-third">
            <h1 class="title">Delete Gerecht</h1>
            <form method="post" action="delete?beschrijving=${gerecht.beschrijving}">
                <p class="content">Bent U zeker dat U het gerecht ${gerecht.beschrijving} wilt verwijderen?</p>
                <div class="field is-grouped is-grouped-right">
                    <p class="control">
                        <button class="button is-primary">
                            Yes
                        </button>
                    </p>
                    <p class="control">
                        <a class="button is-light" href="./change">
                            No
                        </a>
                    </p>
                </div>
            </form>
        </div>
    </div>
</section>
</body>
</html>