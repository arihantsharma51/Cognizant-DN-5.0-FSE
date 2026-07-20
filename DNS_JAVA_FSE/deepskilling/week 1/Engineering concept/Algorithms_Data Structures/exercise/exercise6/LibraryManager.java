package exercise6;

import java.util.Arrays;
import java.util.Comparator;

public class LibraryManager {

    private Book[] books;

    public LibraryManager(Book[] books) {
        this.books = books;
    }

    // Linear Search
    public Book linearSearch(String title) {

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {

                return book;

            }

        }

        return null;

    }

    // Binary Search
    public Book binarySearch(String title) {

        Arrays.sort(books, Comparator.comparing(Book::getTitle));

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int compare = books[mid].getTitle().compareToIgnoreCase(title);

            if (compare == 0) {

                return books[mid];

            } else if (compare < 0) {

                low = mid + 1;

            } else {

                high = mid - 1;

            }

        }

        return null;

    }

}