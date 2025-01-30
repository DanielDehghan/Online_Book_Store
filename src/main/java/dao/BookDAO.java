package dao;

import models.Book;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// This is Data Access Object class
public class BookDAO {

/*
 * Fetches all books from the database
 * 
 * @return List of Books
 */
	
	public List<Book> getAllBooks(){
		List<Book> books = new ArrayList<>();
		String query = "SELECT * FROM Books";
		
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery()){
			
			while(rs.next()) {
				books.add(mapResultSetToBook(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
	
	/**
	 * Retrieves a book by its ID
	 * 
	 * @param BookID the ID of the book
	 * @return the Book object, or null if not found
	 */
	public Book getBookbyId(int bookID) {
		 String query = "SELECT * FROM Books WHERE BookID = ?";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query)) {

	            ps.setInt(1, bookID);
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    return mapResultSetToBook(rs);
	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	}
	
	/**
	 * Inserts a new book into the database
	 * 
	 * @param book the book to be inserted
	 */
	public void insertBook(Book book) {
		String query = "INSERT INTO Books (Title,Author, Category, Price, Description, Stock) VALUES (?,?,?,?,?,?)";
		
		try(Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query)){
			
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getCategory());
            ps.setDouble(4, book.getPrice());
            ps.setString(5, book.getDescription());
            ps.setInt(6, book.getStock());
            ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
    /**
     * Updates an existing book in the database.
     * 
     * @param book the book with updated information
     */
	public void UpdateBook(Book book) {
		String query = "UPDATE Books SET Title = ?, Author = ?, Category = ?, Price = ?, Description = ?, Stock = ? WHERE BookID = ?";
		
		try(Connection conn = DBConnection.getConnection();
		    PreparedStatement  ps = conn.prepareStatement(query)){
			
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getCategory());
            ps.setDouble(4, book.getPrice());
            ps.setString(5, book.getDescription());
            ps.setInt(6, book.getStock());
            ps.setInt(7, book.getBookID());
            ps.executeUpdate();
            
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
    /**
     * Deletes a book from the database by its ID.
     * 
     * @param bookID the ID of the book to be deleted
     */
	public void deleteBook(int bookID) {
		String query = "DELETE FROM Books WHERE BookID = ?";
		
		try(Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query)){
			
			ps.setInt(1, bookID);
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
    /**
     * Updates an existing book in the database.
     * 
     * @param book the book with updated information
     */
    public void updateBook(Book book) {
        String query = "UPDATE Books SET Title = ?, Author = ?, Category = ?, Price = ?, Description = ?, Stock = ? WHERE BookID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getCategory());
            ps.setDouble(4, book.getPrice());
            ps.setString(5, book.getDescription());
            ps.setInt(6, book.getStock());
            ps.setInt(7, book.getBookID());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * Maps a ResultSet row to a book object
	 * 
	 * @param rs the ResultSet
	 * @return the Book Object
	 * @throws SQLException if a database access error occurs
	 */
	private Book mapResultSetToBook(ResultSet rs) throws SQLException{
		Book book = new Book();
		book.setBookID(rs.getInt("BookID"));	
		book.setTitle(rs.getString("Title"));
		book.setAuthor(rs.getString("Author"));
		book.setCategory(rs.getString("Category"));
		book.setPrice(rs.getDouble("Price"));
		book.setDescription(rs.getString("Description"));
		book.setStock(rs.getInt("Stock"));
		return book;
	}
}
