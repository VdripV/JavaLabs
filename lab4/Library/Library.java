package lab4.Library;

import lab4.Book.Book;
import java.util.*;

public class Library {
    private final List<Book> books;
    private final Set<String> authors;
    private final Map<String, Integer> authorStatistics;

    public Library() {
        books = new ArrayList<>();
        authors = new HashSet<>();
        authorStatistics = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
        authors.add(book.getAuthor());
        authorStatistics.put(book.getAuthor(),
                authorStatistics.getOrDefault(book.getAuthor(), 0) + 1);
    }

    public void removeBook(Book book) {
        if (books.remove(book)) {
            int count = authorStatistics.get(book.getAuthor()) - 1;
            if (count == 0) {
                authors.remove(book.getAuthor());
                authorStatistics.remove(book.getAuthor());
            } else {
                authorStatistics.put(book.getAuthor(), count);
            }
        }
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findBooksByYear(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() == year) {
                result.add(book);
            }
        }
        return result;
    }

    public void printAllBooks() {
        System.out.println("Все книги в библиотеке:");
        books.forEach(System.out::println);
    }

    public void printUniqueAuthors() {
        System.out.println("Уникальные авторы:");
        authors.forEach(System.out::println);
    }

    public void printAuthorStatistics() {
        System.out.println("Статистика по авторам:");
        authorStatistics.forEach((author, count) ->
                System.out.println(author + ": " + count + " книг"));
    }
}