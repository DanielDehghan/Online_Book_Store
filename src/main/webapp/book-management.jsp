<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Manage Books</title>
    <link rel="stylesheet" href="styles/bootstrap.min.css">
</head>
<body>
    <jsp:include page="navbar.jsp" />

    <div class="container mt-4">
        <h1 class="text-center">Manage Books</h1>
        <a href="BookServlet?action=new" class="btn btn-success mb-3">Add New Book</a>
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Stock</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.category}</td>
                    <td>${book.price}</td>
                    <td>${book.stock}</td>
                    <td>
                        <a href="BookServlet?action=edit&id=${book.bookID}" class="btn btn-primary">Edit</a>
                        <a href="BookServlet?action=delete&id=${book.bookID}" class="btn btn-danger" onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
