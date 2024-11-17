package Services.ServicesIMLS;

import Database.Database;
import Services.BookService;
import models.Book;
import models.Library;

import java.util.ArrayList;


public class BookImpl implements BookService {
    @Override
    public String saveBook(Long libraryId, Book book) {
        for (Library library : Database.libraries) {
            if (library.getId() == libraryId) {
                library.getBooks().add(book);
                return "success";
            }
        }
        return "failure";
    }

    @Override
    public ArrayList<Book> getAll(Long libraryId) {
        for (Library library : Database.libraries) {
            if (library.getId() == libraryId) {
                return library.getBooks();
            }
        }
        return null;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        for (Library library : Database.libraries) {
            if (library.getId() == libraryId) {
                for (Book book : library.getBooks()) {
                    if (book.getId() == bookId) {
                        return book;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for (Library library : Database.libraries) {
            if (library.getId() == libraryId) {
                for (Book book : library.getBooks()) {
                    if (book.getId() == bookId) {
                        library.getBooks().remove(book);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void clearBookByLibraryId(Long libraryId) {
        for (Library library : Database.libraries) {
            if (library.getId() == libraryId) {
                library.getBooks().clear();
            }
        }
    }
}