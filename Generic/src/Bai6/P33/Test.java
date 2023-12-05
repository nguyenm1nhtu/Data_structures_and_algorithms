package Bai6.P33;

import java.util.Scanner;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        Manager customer = new Manager();

        listOfBooks(customer);
        option(customer);
    }

    public static void listOfBooks(Manager customer) {
        System.out.print("List of Books: \n");
        Set<String> keys = customer.availableBooks.keySet();
        int index = 1;
        for (String key : keys) {
            System.out.println(index + ") " + customer.availableBooks.get(key));
            index++;
        }
        System.out.print("\n\n");
    }

    public static void buyBooks(Manager customer) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the book you want to buy: (if not enter 'exit' to exit)");
        String name = sc.nextLine();
        customer.buyBooks(name);
        while (!(name.equalsIgnoreCase("EXIT"))) {
            name = sc.nextLine();
            customer.buyBooks(name);
        }
        System.out.println();
        option(customer);
    }

    public static void viewPurchasedBooks(Manager customer) {
        if (customer.purchasedBooks.size() == 0) {
            System.out.println("Oops! Looks like you haven't bought any books yet.\n");
        } else {
            System.out.println("Your list of books: ");
            customer.yourPurchasedBooks();
            System.out.println();
        }
        option(customer);
    }

    public static void readingBooks(Manager customer) {
        if (customer.purchasedBooks.size() == 0) {
            System.out.println("Oops! Looks like you haven't bought any books yet.\n");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Which book you want to read ? (if you don't enter 'exit')");
            String name = sc.nextLine();
            if (!(name.equalsIgnoreCase("exit"))) {
                customer.readingPurchasedBook(name);
            } else {
                System.out.println(" ");
            }
        }
        option(customer);
    }

    public static void option(Manager customer) {
        System.out.print("""
                Here is your option:\s
                1) Buy books.
                2) View your purchased book.
                3) Reading your purchased book.
                4) Exit.
                """);
        System.out.print("Enter the number equivalent to your selection: ");
        Scanner sc = new Scanner(System.in);
        try {
            int option = sc.nextInt();
            System.out.println();
            switch (option) {
                case 1 -> {
                    buyBooks(customer);
                    System.out.println();
                }
                case 2 -> {
                    viewPurchasedBooks(customer);
                    System.out.println();
                }
                case 3 -> {
                    readingBooks(customer);
                    System.out.println();
                }
                case 4 -> System.out.print("Thank you for visiting our website ( •̀ ω •́ )✧\n\n");
                default -> {
                    System.out.println("Wrong number, please enter again!\n");
                    option(customer);
                }
            }
        } catch (Exception ex) {
            System.out.println("\nPlease enter again!\n");
            option(customer);
        }
    }
}
