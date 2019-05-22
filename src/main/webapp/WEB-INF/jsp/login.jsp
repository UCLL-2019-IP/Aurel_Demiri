<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
    <c:redirect url="/gerechten"/>
</sec:authorize>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Login"/>
</jsp:include>
<body>
<div class="hero">
    <div class="hero-body">
        <div class="columns is-centered">
            <div class="column is-one-quarter card">
                <c:if test="${param.error != null}">
                    <div class="notification is-danger">
                        Invalid username and/or password.
                    </div>
                </c:if>
                <c:if test="${param.logout != null}">
                    <div class="notification is-primary">
                        You have been logged out.
                    </div>
                </c:if>
                <form method="post" action="login">
                    <div class="field">
                        <label class="label" for="username">Username</label>
                        <div class="control has-icons-left">
                            <span class="icon is-small is-left">
                                <i class="fa fa-envelope"></i>
                            </span>
                            <input id="username" name="username" class="input" type="text" placeholder="Username"/>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label" for="password">Password</label>
                        <div class="control has-icons-left">
                            <span class="icon is-small is-left">
                                <i class="fa fa-lock"></i>
                            </span>
                            <input id="password" name="password" class="input" type="password" placeholder="Password"/>
                        </div>
                    </div>
                    <div class="field">
                        <p class="control">
                            <input type="submit" class="button is-primary" value="Login"/>
                        </p>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>