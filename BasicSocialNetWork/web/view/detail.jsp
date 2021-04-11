<%-- 
    Document   : detail
    Created on : Mar 21, 2021, 4:28:37 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html lang="en">

    <head>
        <title>Post</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>
        <%@include file="header.jsp" %>
        <c:set var="article" value="${requestScope.article}"/>  
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
                background-image: url(${article.getImg()});
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>

        <div class="container">
            <div class="jumbotron jumbotron-fluid">
                <div class="container">

                </div>
            </div>
        </div>
        <div class="container">
            <h1>${article.getTitle()}</h1>
            <p>${article.getContent()}</p>       
        </div>




        <hr/>
        <c:set var="emotionUser" value="${requestScope.actionOfUser}"/>
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <c:if test="${emotionUser == 'like'}">
                        <a href="${pageContext.request.contextPath}/MainController?action=emotion&type=like&txtArticleId=${article.getId()}" class="btn btn-circle text-uppercase"  ><span class="glyphicon glyphicon-send"></span><i class="fas fa-thumbs-up fa-2x"></i></a>
                            </c:if>

                    <c:if test="${emotionUser != 'like'}">
                        <a href="${pageContext.request.contextPath}/MainController?action=emotion&type=like&txtArticleId=${article.getId()}"   class="btn btn-circle text-uppercase"  ><span class="glyphicon glyphicon-send"></span><i class="far fa-thumbs-up fa-2x"></i></a>
                            </c:if>
                        <p style="display: inline-block;">${requestScope.likeNumber}</p>
                </div> 
                <div class="col-sm-3">
                    <c:if test="${emotionUser == 'dislike'}">
                        <a href="${pageContext.request.contextPath}/MainController?action=emotion&type=dislike&txtArticleId=${article.getId()}"   class="btn btn-circle text-uppercase" ><span class="glyphicon glyphicon-send"></span><i class="fas fa-thumbs-down fa-2x"></i></a>
                    </c:if>
                    <c:if test="${emotionUser != 'dislike'}">
                        <a href="${pageContext.request.contextPath}/MainController?action=emotion&type=dislike&txtArticleId=${article.getId()}"   class="btn  btn-circle text-uppercase" ><span class="glyphicon glyphicon-send"></span><i class="far fa-thumbs-down fa-2x"></i></a>
                    </c:if>
                    <p style="display: inline-block;">${requestScope.dislikeNumber}</p>
                </div>



            </div>   
        </div>
        <div class="container mt-3">
            <c:forEach var="comment" items="${requestScope.comments}">
                <div class="well well-lg" style="background:rgb(224, 224, 224); border-radius: 1rem; padding: 1rem;">
                    <h6 class="media-heading text-uppercase reviews">${comment.getEmail()}</h6>
                    <p class="media-comment">
                        ${comment.getCommentContent()}
                    </p>
                    <p>${comment.getDateString()}</p>
                </div>
            </c:forEach>

            <form action="${pageContext.request.contextPath}/MainController" method="get" class="form-horizontal" id="commentForm" role="form">
                <input type="hidden" name="txtArticleId" value="${article.getId()}">
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">Comment</label>
                    <div class="col-sm-12">
                        <input style="height: 5rem; border-radius: 1rem;" type="text" class="form-control" name="txtComment" id="addComment" rows="5"></input>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button name="action" value="comment" class="btn btn-success btn-circle text-uppercase" type="submit" id="submitComment"><span class="glyphicon glyphicon-send"></span>Comment</button>
                    </div>
                </div>
            </form>

        </div>

        <%@include file="footer.jsp" %>





        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>

</html>