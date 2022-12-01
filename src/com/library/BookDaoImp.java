package com.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDaoImp implements BookDao {

	private String getStatus;

	@Override
	public void menu() {

	}

	@Override
	public void addBook(Book b) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
			PreparedStatement ps = con.prepareStatement("insert into book value(?, ?, ?, ?)");

			ps.setInt(1, b.getId());
			ps.setString(2, b.getAuther());
			ps.setString(3, b.getTitle());
			ps.setString(4, b.getStatus());

			int i = ps.executeUpdate();
			

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public List<Book> getAllBooks() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from book");

			List<Book> lb = new ArrayList<>();
			Book b;
			while (rs.next()) {
				b = new Book();
				b.setId(rs.getInt(1));
				b.setAuther(rs.getString(2));
				b.setTitle(rs.getString(3));
				b.setStatus(rs.getString(4));
				lb.add(b);
			}
			return lb;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

	@Override
	public List<Book> getAllAvailableBooks() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from book where status='available' ");

			List<Book> lb = new ArrayList<>();
			Book b;
			while (rs.next()) {
				b = new Book();
				b.setId(rs.getInt(1));
				b.setAuther(rs.getString(2));
				b.setTitle(rs.getString(3));
				b.setStatus(rs.getString(4));
				lb.add(b);
			}
			return lb;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

	@Override
	public int updateBookStatus(int id, String status) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
			PreparedStatement ps = con.prepareStatement("update book set status=? where id = ? and status != ?");
			ps.setString(1, status);
			ps.setInt(2, id);
			ps.setString(3, status);
			return ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return -1;

	}

	@Override
	public void returnBook() {
		// TODO Auto-generated method stub

	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}

}