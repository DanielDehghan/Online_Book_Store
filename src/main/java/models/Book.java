package models;

/**
 * Represents a book in the bookstore.
 */
public class Book {
	private int bookID;
	private String title;
	private String author;
	private String category;
	private double price;
	private String description;
	private int stock;


public int getBookID() {
	return bookID;
}

public void setBookID(int bookID) {
	this.bookID = bookID;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
}