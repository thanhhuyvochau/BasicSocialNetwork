<%-- 
    Document   : post.jsp
    Created on : Mar 21, 2021, 5:23:06 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

    <head>
        <title>New Post</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>
        <%@include file="header.jsp" %>
        
        <div class="container mt-3">
            <h1 style="text-align: center;">Post Article</h1>
            <p style="text-align: center;">Post Something You Want</p>
            <form action="${pageContext.request.contextPath}/MainController?action=add-post" method="POST" enctype = "multipart/form-data">
                <label for="title">Title</label>
                <input id="title" name="txtTitle" class="form-control" type="text" placeholder="Title" value="${requestScope.title}">

                <label for="des">Description</label>
                <input id="des" name="txtDescription" class="form-control" type="text" placeholder="Description" value="${requestScope.description}">


                <div class="form-group">
                    <label for="content">Content</label>
                    <textarea class="form-control" name="txtContent" id="" rows="3">${requestScope.content}</textarea>
                </div>


                <p>Image</p>
                <div class="custom-file mb-3">
                    <input type="file" class="custom-file-input" id="customFile" name="filename">
                    <label class="custom-file-label" for="customFile">Choose file</label>
                </div>


                <div class="mt-3" style="text-align: center;">
                    <button type="submit" class="btn btn-primary btn-lg">Post</button>
                </div>
            </form>
        </div>


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        <script>
            // Add the following code if you want the name of the file appear on select
            $(".custom-file-input").on("change", function () {
                var fileName = $(this).val().split("\\").pop();
                $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
            });
        </script>
        <c:if test="${requestScope.message != null}">
            <script>
        alert("${requestScope.message}")
            </script>
        </c:if>
        <%@include file="footer.jsp" %>
    </body>

</html>