package lab4.LibraryTest;

import lab4.Book.Book;
import lab4.Library.Library;

public class LibraryTest {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Три товарища", "Эрих Мария Ремарк", 1936);
        Book book2 = new Book("Над пропастью во ржи", "Джером Д. Сэлинджер", 1951);
        Book book3 = new Book("1984", "Джордж Оруэлл", 1949);
        Book book4 = new Book("Мастер и Маргарита", "Михаил Булгаков", 1967);
        Book book5 = new Book("Война и Мир", "Лев Толстой", 1867);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        System.out.println("Тест");
        library.printAllBooks();
        System.out.println();

        library.printUniqueAuthors();
        System.out.println();

        library.printAuthorStatistics();
        System.out.println();

        System.out.println("Книги Михаила Булгакова:");
        library.findBooksByAuthor("Михаил Булгаков").forEach(System.out::println);
        System.out.println();

        System.out.println("Книги 1936 года:");
        library.findBooksByYear(1936).forEach(System.out::println);
        System.out.println();

        System.out.println("Удаляем книгу: " + book4);
        library.removeBook(book4);
        library.printAllBooks();
        library.printAuthorStatistics();
    }
}