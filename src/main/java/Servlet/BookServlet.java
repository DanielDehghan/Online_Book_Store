package Servlet;

import models.Book;
import Services.BookService;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet for handling book-related requests.
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final BookService bookService = new BookService();

@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
        try {
            if (action == null) {
                action = "list"; // Default action
            }
            
		switch (action) {
        case "new":
            showNewForm(request, response);
            break;
        case "insert":
            insertBook(request, response);
            break;
        case "delete":
            deleteBook(request, response);
            break;
        case "edit":
            showEditForm(request, response);
            break;
        case "update":
            updateBook(request, response);
            break;
        case "manage": 
            manageBooks(request, response);
            break;
        default:
            listBooks(request, response);
            break;
    }
} catch (Exception e) {
    throw new ServletException(e);
}
	}
/**
 * Displys books in manage books
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException
 */
private void manageBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Book> books = bookService.getAllBooks();
    request.setAttribute("books", books);
    request.getRequestDispatcher("book-management.jsp").forward(request, response);
}

/**
 * Retrieves and displays a list of all books.
 */
private void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	List<Book> books = bookService.getAllBooks();
	request.setAttribute("books", books);
	request.getRequestDispatcher("books.jsp").forward(request, response);
}


/**
 * Displays the form for adding a new book.
 */
private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	request.setAttribute("book", null);
	request.getRequestDispatcher("book-form.jsp").forward(request, response);
	
}


/**
 * Inserts a new book into the database.
 */
private void insertBook(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
    Book book = new Book();
    book.setTitle(request.getParameter("title"));
    book.setAuthor(request.getParameter("author"));
    book.setCategory(request.getParameter("category"));
    book.setPrice(Double.parseDouble(request.getParameter("price")));
    book.setDescription(request.getParameter("description"));
    book.setStock(Integer.parseInt(request.getParameter("stock")));

    bookService.addBook(book); // Add book through the service
    response.sendRedirect("BookServlet?action=list");
}

/**
 * Displays the form for editing an existing book.
 */
private void showEditForm(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    int bookID = Integer.parseInt(request.getParameter("id"));
    Book book = bookService.getBookById(bookID);
    request.setAttribute("book", book); // Pre-fill form with book details
    request.getRequestDispatcher("book-form.jsp").forward(request, response);
}

/**
 * Updates an existing book in the database.
 */
private void updateBook(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
    int bookID = Integer.parseInt(request.getParameter("id"));
    Book book = new Book();
    book.setBookID(bookID);
    book.setTitle(request.getParameter("title"));
    book.setAuthor(request.getParameter("author"));
    book.setCategory(request.getParameter("category"));
    book.setPrice(Double.parseDouble(request.getParameter("price")));
    book.setDescription(request.getParameter("description"));
    book.setStock(Integer.parseInt(request.getParameter("stock")));

    bookService.updateBook(book); // Update book through the service
    response.sendRedirect("BookServlet?action=list");
}

/**
 * Deletes a book from the database.
 */
private void deleteBook(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
    int bookID = Integer.parseInt(request.getParameter("id"));
    bookService.deleteBook(bookID); // Delete book through the service
    response.sendRedirect("BookServlet?action=list");
}

}
