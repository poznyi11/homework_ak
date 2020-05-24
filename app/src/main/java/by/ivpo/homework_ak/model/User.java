package by.ivpo.homework_ak.model;

public class User {
    private int id;
    private String name;
    private String secondName;
    private String phone;

    public User() {

    }

    public User(int id, String name, String secondName, String phone) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
