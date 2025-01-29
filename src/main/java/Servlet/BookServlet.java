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
		
		switch(action) {
		case "new":
			showNewForm(request, response);
		case "update":
			
			
			
		}
	}

private void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	List<Book> books = bookService.getAllBooks();
	request.setAttribute("books", books);
	request.getRequestDispatcher("books.jsp").forward(request, response);
}

private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	request.setAttribute("book", null);
	request.getRequestDispatcher("book-form.jsp").forward(request, response);
	
}

private void 



}
