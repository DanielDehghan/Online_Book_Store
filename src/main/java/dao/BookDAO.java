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
				Book book = new Book();
				book.setBookID(rs.getInt("BookID"));
				book.setTitle(rs.getString("Title"));
				book.setAuthor(rs.getString("Author"));
				book.setCategory(rs.getString("Category"));
				book.setPrice(rs.getDouble("Price"));
				book.setDescription(rs.getString("Description"));
				book.setStock(rs.getInt("Stock"));
				books.add(book);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
}
