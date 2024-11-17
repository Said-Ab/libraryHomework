package models;


import java.util.ArrayList;

public class Library {
    private Long id;
    private String name;
    private String address;
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Reader> reader = new ArrayList<>();

    public Library() {
    }

    public Library(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Library(Long id, String name, String address, ArrayList<Book> books, ArrayList<Reader> reader) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.books = books;
        this.reader = reader;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Reader> getReader() {
        return reader;
    }

    public void setReader(ArrayList<Reader> reader) {
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", books=" + books +
                ", Reader=" + reader +
                '}';
    }

}
