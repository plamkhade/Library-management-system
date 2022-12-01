package com.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Menulist {
	BookDao bd = new BookDaoImp();

	public void menu() {
		try {
			System.out.println();
			System.out.println(
					"                                                                                                    ");
			System.out.println(
					"*****************************************************Welcome To My Library******************************************************************************************");
			System.out.println(
					"                                                                                                    ");
			System.out.println(
					"---------------------------------------------------Made By:Priyanka Lamkhade---------------------------------------------------------------------------");
			Thread.sleep(1000);
			System.out.println("\n1.AddBook");

			Thread.sleep(1000);
			System.out.println("\n2.ShowAllBooks");

			Thread.sleep(1000);
			System.out.println("\n3.ShowAllAvailableBooks");

			Thread.sleep(1000);
			System.out.println("\n4.BorrowBook");

			Thread.sleep(1000);
			System.out.println("\n5.ReturnBook");

			Thread.sleep(1000);
			System.out.println("\n6. Exit");
			
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void addBook() {
		Book b = new Book();

		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter book Id:  ");
			b.setId(sc.nextInt());

			System.out.println("Enter Author Name: ");
			b.setAuther(sc.next());

			System.out.println("Enter Title: ");
			b.setTitle(sc.next());

			b.setStatus("available");

			bd.addBook(b);

			System.out.println("Record inserted successfully..............");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void showAllBooks() {

		List<Book> lb = bd.getAllBooks();
		Iterator<Book> it = lb.iterator();
		System.out.println(" id" + "   " + "Auther" + "   " + " Title" + " " + " Status");
		System.out.println("***********************************************************************");
		Book b;
		while (it.hasNext()) {
			b = it.next();
			System.out.println(b.getId() + "   " + b.getAuther() + "   " + b.getTitle() + "  " + b.getStatus());
		}

	}

	public void showAllAvailableBooks() {
		List<Book> lb = bd.getAllAvailableBooks();
		Iterator<Book> it = lb.iterator();

		Book b;
		if (lb.size() > 0) {
			System.out.println(" id" + "   " + "Auther" + "   " + " Title" + " " + " Status");
			System.out.println("---------------------------------------------------------------------------");
			while (it.hasNext()) {
//			System.out.println(it.next());
				b = it.next();
				System.out.println(b.getId() + "   " + b.getAuther() + "   " + b.getTitle() + "  " + b.getStatus());
			}
		} else {
			System.out.println("No Available Books");
		}
	}

	public void borrowBook() {
		
		this.showAllAvailableBooks();
		Scanner sc = new Scanner(System.in);
		System.out.println("************************************");
		System.out.println("Enter book id to borrow: ");
		int id = sc.nextInt();

		int r = bd.updateBookStatus(id, "unavailable");
		System.out.println(r);
		if (r == 1) {
			System.out.println("Book with id " + id + " borrowed successfully............");
		} else {
			System.out.println("Failed to borrow book with id " + id + ".");
		}


	}

	public void returnBook() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter book id to return");
		int id = sc.nextInt();

		int r = bd.updateBookStatus(id, "available");
		if (r == 1) {
			System.out.println("Book with id " + id + " returned successfully.");
		} else {
			System.out.println("Failed to return book with id " + id + ".");
		}

	}

public void exit() {
	System.out.println();
	System.out.println("************************************Thank You for Visiting***************************************************");
}


}
