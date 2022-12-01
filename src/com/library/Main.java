package com.library;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			int choice;
			Menulist m = new Menulist();
			m.menu();
			Scanner sc = new Scanner(System.in);

			while (true) {
				System.out.println();
				Thread.sleep(1000);
				System.out.println("Enter your choice: ");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					m.addBook();
					break;
				case 2:
					m.showAllBooks();
					;
					break;
				case 3:
					m.showAllAvailableBooks();
					break;
				case 4:
					m.borrowBook();
					break;
				case 5:
					m.returnBook();
					break;
				case 6:
					m.exit();
					System.exit(0);
				default:
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
