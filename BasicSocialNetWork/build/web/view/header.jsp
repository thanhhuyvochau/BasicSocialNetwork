<%-- 
    Document   : header.jsp
    Created on : Mar 21, 2021, 3:24:42 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        
        <style>
            .notification {
                
                color: white;
                text-decoration: none;
               
                position: relative;
                display: inline-block;
                border-radius: 2px;
            }

            .notification:hover {
                background: gray;
            }

            .notification .badge {
                position: absolute;
                top: -10px;
                right: -10px;
                padding: 5px 10px;
                border-radius: 50%;
                background: red;
                color: white;
            }
        </style>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/MainController"><i class="fab fa-facebook-square fa-3x"></i></a>
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/MainController">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/MainController?action=mypostRedirect">My Post</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/MainController?action=addPostRedirect">Add Post</a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="notification nav-link ">
                            <span>Notification</span>
                            <span class="badge">3</span>
                        </a>
                    </li>
                     <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/MainController?action=logout">Logout</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/MainController">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="txtSearch">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="action" value="search">Search</button>
                </form>
            </div>
        </nav>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
