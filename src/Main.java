import Enums.Gender;
import Enums.Genre;
import Services.BookService;
import Services.LibraryService;
import Services.ReaderService;
import Services.ServicesIMLS.BookImpl;
import Services.ServicesIMLS.LibraryImpl;
import Services.ServicesIMLS.ReaderImpl;
import models.Book;
import models.Library;
import models.Reader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {


            BookService bookService = new BookImpl();
            LibraryService libraryService = new LibraryImpl();
            ReaderService readerService = new ReaderImpl();

            while (true) {
                try {
                    Scanner scanner1 = new Scanner(System.in);
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("   \nCHOOSE\n1.Library\n2.Book\n3.Reader");
                    int menu = scanner.nextInt();
                    scanner.nextLine();
                    switch (menu) {
                        case 1:
                            try {
                                boolean check = true;
                                while (check) {
                                    System.out.println("Library settings\n1.Add library\n2.Get library by Id\n3.Update library\n4.Delete library\n5.Exit from library settings");
                                    switch (scanner.nextInt()) {
                                        case 1:
                                            try {

                                                System.out.println("add library\n");
                                                System.out.println("write id");
                                                long id = scanner1.nextLong();
                                                System.out.println("write library name");
                                                String name = scanner2.nextLine();
                                                System.out.println("write address");
                                                String address = scanner2.nextLine();
                                                libraryService.saveLibrary(new Library(id, name, address));
                                            } catch (Exception e) {
                                                System.out.println("Ошибка при добавлении библиотеки: " + e.getMessage());
                                                scanner.nextLine();
                                            }
                                            break;
                                        case 2:
                                            try {


                                                System.out.println("get library by id");
                                                System.out.println(libraryService.getLibrary(scanner1.nextLong()));
                                            } catch (Exception e) {
                                                System.out.println("Ошибка:" + e.getMessage());
                                            }
                                            break;
                                        case 3:
                                            try {


                                                System.out.println("update library by id");
                                                System.out.println("write id");
                                                long id1 = scanner1.nextLong();
                                                System.out.println("write library name");
                                                String name1 = scanner2.nextLine();
                                                System.out.println("write address");
                                                String address1 = scanner2.nextLine();
                                                libraryService.updateLibrary(id1, new Library(id1, name1, address1));
                                            } catch (Exception e) {
                                                System.out.println("Ошибка:" + e.getMessage());
                                                scanner.nextLine();
                                            }
                                            break;
                                        case 4:
                                            try {
                                                System.out.println("delete library by id");
                                                System.out.println(libraryService.deleteLibrary(scanner1.nextLong()));
                                            } catch (Exception e) {
                                                System.out.println("Ошибка:" + e.getMessage());
                                                scanner.nextLine();
                                            }
                                            break;
                                        case 5:
                                            check = false;
                                            break;
                                    }
                                    if (!check) {
                                        break;
                                    }
                                }

                            } catch (Exception e) {
                                System.out.println("Ошибка при добавлении библиотеки: " + e.getMessage());
                            }
                            scanner.nextLine();
                            break;
                        case 2:
                            try {
                                boolean check1 = true;
                                while (check1) {
                                    System.out.println("\nBook settings\n1.Add book\n2.Get book by id\n3.Get all\n4.Delete book\n5.delete all books\n6.Exit from Book settings");
                                    switch (scanner1.nextInt()) {
                                        case 1:
                                            try {
                                                System.out.println("Add book");
                                                System.out.println("write your library ID");
                                                Long ID = scanner1.nextLong();
                                                System.out.println("Book id");
                                                long idBook = scanner1.nextLong();
                                                System.out.println("Book name");
                                                String name = scanner2.nextLine();
                                                System.out.println("author");
                                                String author = scanner2.nextLine();
                                                System.out.println("Доступные жанры: ");
                                                for (Genre g : Genre.values()) {
                                                    System.out.println("- " + g);
                                                }
                                                String genre = scanner2.nextLine().toUpperCase();
                                                Genre genre1 = Genre.valueOf(genre);
                                                bookService.saveBook(ID, new Book(idBook, name, author, genre1));
                                            } catch (IllegalArgumentException e) {
                                                System.out.println("Некорректный жанр! Пожалуйста, выберите из доступных: FICTION, SCIENCE и т.д.");
                                            } catch (Exception e) {
                                                System.out.println("Ошибка при добавлении книги: " + e.getMessage());
                                                scanner.nextLine();
                                            }
                                            break;
                                        case 2:
                                            try {


                                                System.out.println("Get book by Id");
                                                System.out.println("write your library ID");
                                                Long libraryId = scanner1.nextLong();
                                                System.out.println("Book id");
                                                long getId = scanner1.nextLong();
                                                bookService.getBookById(libraryId, getId);
                                            } catch (Exception e) {
                                                System.out.println("Ошибка: " + e.getMessage());
                                                scanner.nextLine();
                                            }
                                            break;
                                        case 3:
                                            try {


                                                System.out.println("Get all");
                                                System.out.println("write library Id");
                                                bookService.getAll(scanner1.nextLong());
                                            } catch (Exception e) {
                                                System.out.println("Ошибка: " + e.getMessage());
                                                scanner.nextLine();
                                            }
                                        case 4:
                                            try {

                                                System.out.println("Delete book");
                                                System.out.println("write your library ID");
                                                Long library = scanner1.nextLong();
                                                System.out.println("Book id");
                                                long delBook = scanner1.nextLong();
                                                bookService.deleteBook(library, delBook);
                                            } catch (Exception e) {
                                                System.out.println("Ошибка: " + e.getMessage());
                                                scanner.nextLine();
                                            }
                                            break;
                                        case 5:
                                            try {
                                                System.out.println("Delete all");
                                                System.out.println("write library id");
                                                bookService.clearBookByLibraryId(scanner1.nextLong());
                                            } catch (Exception e) {
                                                System.out.println("Ошибка: " + e.getMessage());
                                                scanner.nextLine();
                                            }
                                            break;

                                        case 6:
                                            System.out.println("Exit");
                                            check1 = false;
                                            break;
                                    }
                                    if (!check1) {
                                        break;
                                    }


                                }
                            } catch (Exception e) {
                                System.out.println("Ошибка при добавлении книги: " + e.getMessage());
                            }
                            scanner.nextLine();
                            break;
                        case 3:
                            try {

                                boolean check2 = true;
                                while (check2) {
                                    System.out.println("Reader settings\n1.Save Reader\n2.Get all Readers\n3.Get Reader by id\n4.Update Reader\n5.Assign Reader to library\n6.Exit");

                                    switch (scanner.nextInt()) {
                                        case 1:
                                            try {

                                                System.out.println("Save Reader");
                                                System.out.println("write id");
                                                long id = scanner1.nextLong();
                                                System.out.println("write name");
                                                String name = scanner2.nextLine();
                                                System.out.println("write address");
                                                String address = scanner2.nextLine();
                                                System.out.println("gender only MALE & FEMALE");
                                                String gender = scanner2.nextLine().toUpperCase();
                                                Gender gender1 = Gender.valueOf(gender);
                                                readerService.saveReader(new Reader(id, name, address, gender1));
                                            } catch (IllegalArgumentException e) {
                                                System.out.println("Некорректный пол! Пожалуйста, выберите MALE или FEMALE.");
                                            } catch (Exception e) {
                                                System.out.println("Ошибка при сохранении читателя: " + e.getMessage());
                                                scanner.nextLine();
                                            }
                                            break;
                                        case 2:
                                            try {

                                                System.out.println("Get all readers");
                                                readerService.getAllReaders();
                                            } catch (Exception e) {
                                                System.out.println("Ошибка: " + e.getMessage());
                                                scanner.nextLine();
                                            }
                                            break;
                                        case 3:
                                            try {

                                                System.out.println("Get reader by id");
                                                System.out.println("write id");

                                                readerService.getReaderById(scanner1.nextLong());
                                            } catch (Exception e) {
                                                System.out.println("Ошибка: " + e.getMessage());
                                                scanner.nextLine();
                                            }
                                            break;
                                        case 4:
                                            try {


                                                System.out.println("Update reader");
                                                System.out.println("write id");
                                                long id1 = scanner1.nextLong();
                                                System.out.println("write name");
                                                String name1 = scanner2.nextLine();
                                                System.out.println("write address");
                                                String address1 = scanner2.nextLine();
                                                System.out.println("gender only MALE & FEMALE");
                                                String genderU = scanner2.nextLine().toUpperCase();
                                                Gender genderU1 = Gender.valueOf(genderU);
                                                readerService.updateReader(id1, new Reader(id1, name1, address1, genderU1));
                                            } catch (IllegalArgumentException e) {
                                                System.out.println("Некорректный пол! Пожалуйста, выберите MALE или FEMALE.");
                                            } catch (Exception e) {
                                                System.out.println("Ошибка: " + e.getMessage());
                                                scanner.nextLine();
                                            }
                                            break;
                                        case 5:
                                            try {
                                                System.out.println("Assign reader to library");
                                                System.out.println("write reader id");
                                                long readerId = scanner1.nextLong();
                                                System.out.println("write library id to assign");
                                                long libraryId = scanner1.nextLong();
                                                readerService.assignReaderToLibrary(readerId, libraryId);
                                            } catch (Exception e) {
                                                System.out.println("Ошибка: " + e.getMessage());
                                                scanner.nextLine();
                                            }
                                            break;
                                        case 6:
                                            check2 = false;

                                    }
                                    if (!check2) {
                                        break;
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Ошибка при добавлении читателя: " + e.getMessage());
                            }
                            scanner.nextLine();
                        default: {
                            System.out.println("Неконкретный выбор");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                    scanner.nextLine();
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            scanner.nextLine();
        }finally {
        scanner.close();
        }
    }
}