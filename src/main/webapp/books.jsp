<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<html>
<head>
    <title>Book List</title>
    <link rel="stylesheet" href="styles/styles.css">
</head>
<body>
    <jsp:include page="navbar.jsp"/>

    <div class="container mt-4">
        <h1 class="text-center">📖 Available Books</h1>
        <div class="row">
            <c:forEach var="book" items="${books}">
                <div class="col-md-3">
                    <div class="card mb-4">
                        <img src="images/book-placeholder.png" class="card-img-top" alt="${book.title}">
                        <div class="card-body">
                            <h5 class="card-title">${book.title}</h5>
                            <p class="card-text">${book.author}</p>
                            <a href="#" class="btn btn-primary">View Details</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
