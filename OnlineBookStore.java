package com;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    double price;
    int quantity;

    public Book(String title, String author, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }
}

public class OnlineBookStore {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Add some initial books
        books.add(new Book("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", 441.00, 10));
        books.add(new Book("Quiet: The Power of Introverts in a World That Can't Stop Talking ", "Susan Cain", 1369.00, 8));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 329.00, 12));
         
        while (true) {
            System.out.println("\nOnline Bookstore Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Search for a book");
            System.out.println("3. Purchase a book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            

            switch (choice) {
                case 1:
                	System.out.print("Enter book title: ");
                    String title = scanner.next();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    books.add(new Book(title, author, price, quantity));
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.next();
                    boolean found = false;
                    for (Book book : books) {
                        if (book.title.equalsIgnoreCase(searchTitle)) {
                            System.out.println("Book found:");
                            System.out.println("Title: " + book.title);
                            System.out.println("Author: " + book.author);
                            System.out.println("Price: ₹" + book.price);
                            System.out.println("Quantity: " + book.quantity);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter book title to purchase: ");
                    String purchaseTitle = scanner.next();
                    found = false;
                    for (Book book : books) {
                        if (book.title.equalsIgnoreCase(purchaseTitle)) {
                            if (book.quantity > 0) {
                                System.out.println("Book purchased successfully!");
                                book.quantity--;
                            } else {
                                System.out.println("Book is out of stock.");
                            }
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the bookstore...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }z
        }
    }
}