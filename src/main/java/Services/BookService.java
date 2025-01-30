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
   
   /**
    * Retrieves a book by its ID.
    * 
    * @param bookID the ID of the book
    * @return the Book object, or null if not found
    */
   public Book getBookById(int bookID) {
	   return bookDAO.getBookById(bookID);
   }
   
   /**
    * Adds a new book to the database.
    * 
    * @param book the book to be added
    */
   public void addBook(Book book) {
       bookDAO.insertBook(book);
   }
   
   /**
    * Updates an existing book in the database.
    * 
    * @param book the book with updated information
    */
   public void updateBook(Book book) {
       bookDAO.updateBook(book);
   }
   
   /**
    * Deletes a book from the database by its ID.
    * 
    * @param bookID the ID of the book to be deleted
    */
   public void deleteBook(int bookID) {
       bookDAO.deleteBook(bookID);
   }
}
