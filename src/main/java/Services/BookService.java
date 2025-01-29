package Services;

import dao.BookDAO;
import models.Book;

import java.util.List;

/**
 * Service class for book-related business logic.
 */
public class BookService {
   private final BookDAO bookDAO = new BookDAO();
   
   /**
    * Retrieves all books from the DAO.
    * 
    * @return List of books
    */
   
   public List<Book> getAllBooks(){
	   return bookDAO.getAllBooks();
   }
}
