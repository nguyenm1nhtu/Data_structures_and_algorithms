package Bai6.P33;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager {

    List<Books> purchasedBooks;
    Map<String,Books> availableBooks;

    public Manager() {
        availableBooks = new HashMap<>();
        purchasedBooks= new ArrayList<>();

        BooksContent();
    }

    public void BooksContent() {
        availableBooks.put("The Godfather".toUpperCase(), new Books("The Godfather", "Mario Puzo", 200000));
        availableBooks.put("The Three Musketeers".toUpperCase(), new Books("The Three Musketeers", "Alexandre Dumas cha",180000));
        availableBooks.put("Wuthering Heights".toUpperCase(), new Books("Wuthering Heights", "Emily Bronte", 100000));
        availableBooks.put("Sans Famille".toUpperCase(), new Books("Sans Famille", "Hector Malot", 120000));
        availableBooks.put("Harry Potter".toUpperCase(), new Books("Harry Potter", "J. K. Rowling", 500000));
        availableBooks.put("Sherlock Holmes".toUpperCase(), new Books("Sherlock Holmes", " Arthur Conan Doyle", 170000));
    }

    public void buyBooks(String name) {
        if (availableBooks.containsKey(name.toUpperCase())) {
            purchasedBooks.add(availableBooks.get(name.toUpperCase()));
            System.out.println("The " + name + " have add to your list!");
        } else if (name.equalsIgnoreCase("EXIT")){
            System.out.print("");
        } else {
            System.out.println("Sorry we don't have this book right now!");
        }
    }

    public void yourPurchasedBooks() {
        for (Books bk : purchasedBooks) {
            System.out.println(bk);
        }
    }

    public void readingPurchasedBook(String name) {
        for (Books bk : purchasedBooks) {
            if (bk.getName().equalsIgnoreCase(name)) {
                fileBooks(name.toUpperCase());
            } else if (name.equalsIgnoreCase("EXIT")){
                System.out.print("");
            } else {
                System.out.println("You have not purchased this book!\n");
            }
        }
    }

    private void fileBooks(String name) {
        if (name.equals("THE GODFATHER")) {
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File("The_Godfather.pdf");
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (name.equals("HARRY POTTER")) {
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File("Harry_Potter.pdf");
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (name.equals("SANS FAMILLE")) {
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File("Sans_Famille.pdf");
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (name.equals("SHERLOCK HOLMES")) {
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File("Sherlock_Holmes.pdf");
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (name.equals("THE THREE MUSKETEERS")) {
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File("The_Three_Musketeers.pdf");
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (name.equals("WUTHERING HEIGHTS")) {
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File("Wuthering_Heights.pdf");
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}


