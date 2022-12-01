package com.library;

import java.util.List;

public interface BookDao {

	void menu();

	void addBook(Book b);

	List<Book> getAllBooks();

	List<Book> getAllAvailableBooks();

	int updateBookStatus(int id, String status);

	void returnBook();

	void exit();

}
