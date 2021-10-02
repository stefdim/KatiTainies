<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.0/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="/css/style.css" />
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link 
            href="https://fonts.googleapis.com/css2?family=Lobster&family=Rubik&display=swap"
            rel="stylesheet"
            />
        <link
            href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&family=Sen:wght@400;700;800&display=swap"
            rel="stylesheet"
            />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
            />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <title>All Users</title>
    </head>
    <body style="background-color: #151515;">
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-dark " >
                <div class="container" style="margin-right: 55px;">
                    <a class="navbar-brand" href="<%=request.getContextPath()%>/home" style="color: #25bd0a;">katiTainies</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavDropdown">
                        <ul class="navbar-nav ms-auto text-center">
                            <li class="nav-item">
                                <a class="nav-link"  href="<%=request.getContextPath()%>/home">Home</a>
                            </li>                                                       
                        </ul>
                    </div>
                </div>
                <hr>
            </nav>
            <div style="display: none" id="home"></div>
            <div  class="movie-list-container" style="margin-right: 55px;">
                <br>
                <div id="users" class="container mb-3 mt-3">
                    <h1 class="movie-list-title ms-auto text-center" style="font-size: 2rem;" >ALL USERS</h1>
                    <table class="table table-sm table-dark" style="width: 100%;" id="usersTable" >
                        <thead>
                            <tr>
                                <th>Username</th>
                                <th>Enabled</th>
                                <th>Email</th>
                                <th>Change users status</th> 
                                <th>Delete user</th> 
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${users}" var="user">
                                <tr>
                                    <td>${user.username}</td>
                                    <td>${user.enabled}</td>
                                    <td>${user.email}</td>
                                    <td><form method="POST" action="<%=request.getContextPath()%>/admin/edit">
                                            <input type="hidden" name="username" value="${user.username}">
                                            <button type="submit" class="card-link btn btn-outline-success">Change Access</button></form></td>
                                    <td><a href="<%=request.getContextPath()%>/admin/delete/${user.username}" class="card-link btn btn-outline-danger">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                        <tfoot>
                            <tr>
                                <th>Username</th>
                                <th>Enabled</th>
                                <th>Email</th>
                                <th>Change users status</th>
                                <th>Delete user</th>
                            </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
        </div>
        <section>
            <footer class="text-center text-white footer-dark" >
                <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
                    © 2021 Copyright:
                     <p class="topleft"><sec:authentication property="principal.username" /></p> 
                    <a class="text-white" href="#">CB 13</a>
                </div>
            </footer>
        </section>               
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.11.0/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.11.0/js/dataTables.bootstrap4.min.js"></script>
        <script>
            $('#usersTable').DataTable();
        </script>
    </body>
</html>
