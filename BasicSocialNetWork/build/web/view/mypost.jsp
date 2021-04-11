<%-- 
    Document   : homepage.jsp
    Created on : Mar 21, 2021, 2:46:05 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

    <head>
        <title>My Post</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>
        <%@include file="header.jsp" %>

        <c:if test="${requestScope.message != null}">
            <script>
                alert("${requestScope.message}");
            </script>
        </c:if>
        <style>
            html,
            body {
                margin: 0;
                padding: 0;
                border: 0;
            }

            .jumbotron {
                width: 100% !important;
                height: 60vh;
                background-image: url(../image/login-background.jpg);
                background-repeat: no-repeat;
                background-size: cover;
            }

            .carousel-inner>.item>img {
                width: 100%;
                height: 570px;
            }
        </style>
        <div class="container">
            <div class="row justify-content-center">
                <h1>Your Post</h1>
            </div>
        </div>
        <div class="container mt-5">
            <c:forEach var="article" items="${requestScope.articles}">

                <form id="ArticleForm" action="${pageContext.request.contextPath}/MainController" method="post">
                    <div class="card mb-3">
                        <img style="height: 15rem; object-fit: cover;" class="card-img-top" src="${article.getImg()}" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">${article.getTitle()}</h5>
                            <p class="card-text">${article.getDescription()}</p>
                            <button type="button" class="btn btn-primary btn-xl"  onclick="read()">Read More</button>
                            <button  type="button" class="btn btn-warning btn-xl" onclick="confirmx()">Delete</button>
                            <p class="card-text"><small class="text-muted">${article.getDateString()} by ${article.getEmail()}</small></p>
                        </div>
                    </div>
                    <input type="hidden" name="txtArticleId" value="${article.getId()}">
                </form>
            </c:forEach>
            <c:set var="page" value="${requestScope.page}"/> 
            <div class="row">
                <div class="col-sm-12 mt-5">
                    <nav aria-label="Page navigation example ">
                        <ul class="pagination justify-content-center">

                            <c:if test="${page.getIndexPage() > 1}">
                                <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/MainController?action=mypostRedirect&index=${page.getIndexPage()-1}">Previous</a></li>
                                </c:if>

                            <c:if test="${page.getLastPage() > page.getIndexPage() }">
                                <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/MainController?action=mypostRedirect&index=${page.getIndexPage()+1}">Next</a></li>
                                </c:if>

                        </ul>
                    </nav>
                </div>

            </div>
        </div>

        <div class="container">
            <div class="row justify-content-md-center">
                <h3>${requestScope.messageBottom}</h3>  
            </div>

        </div>

        <script>
            function confirmx() {
                var form = document.getElementById("ArticleForm");
                var ax = form.action;
                var r = confirm("Do you want to delete ?");
                if (r === true) {
                    ax = "${pageContext.request.contextPath}/MainController?action=delete";
                    form.action = ax;
                    form.submit();
                }
            }


            function read() {
                var form = document.getElementById("ArticleForm");
                ax = "${pageContext.request.contextPath}/MainController?action=detail";
                form.action = ax;
                form.submit();

            }




        </script>
        <%@include  file="footer.jsp" %>
        <style>
            .footer-content {
                margin-top: 40px;
            }
        </style>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>

</html>