package models;

import Enums.Gender;

public class Reader {
    private Long id;
    private String fullName;
    private String address;
    private Gender gender;

    public Reader() {
    }

    public Reader(Long id, String fullName, String address, Gender gender) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                '}';
    }
}
