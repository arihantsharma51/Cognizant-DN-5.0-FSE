package exercise6;

public class Main {

    public static void main(String[] args) {

        Book[] books = {

                new Book(101, "Java", "James Gosling"),
                new Book(102, "Python", "Guido van Rossum"),
                new Book(103, "C Programming", "Dennis Ritchie"),
                new Book(104, "Spring Boot", "Rod Johnson")

        };

        LibraryManager manager = new LibraryManager(books);

        System.out.println("===== Linear Search =====");

        Book result1 = manager.linearSearch("Python");

        if (result1 != null) {

            System.out.println(result1);

        } else {

            System.out.println("Book Not Found");

        }

        System.out.println("\n===== Binary Search =====");

        Book result2 = manager.binarySearch("Python");

        if (result2 != null) {

            System.out.println(result2);

        } else {

            System.out.println("Book Not Found");

        }

    }

}
