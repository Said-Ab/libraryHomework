package Services;


import models.Book;

import java.util.ArrayList;

public interface BookService {
    String saveBook(Long libraryId, Book book);
    ArrayList<Book>getAll(Long libraryId);
    Book getBookById(Long libraryId,Long bookId);
    String deleteBook(Long libraryId,Long bookId);
    void clearBookByLibraryId(Long libraryId);
}