package lk.rush.javafxx.dto;

public class Studentdto {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Studentdto(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public Studentdto(String firstName, String lastName, int age,int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id=id;
    }

    public Studentdto(int id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public Studentdto setId(int id) {
        this.id = id;
        return null;
    }
}