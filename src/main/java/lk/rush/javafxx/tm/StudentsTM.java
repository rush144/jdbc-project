package lk.rush.javafxx.tm;

public class StudentsTM {
    private int ID;
    private String FirstName;
    private String LastName;
    private int Age;

    public StudentsTM(int ID, String firstName, String lastName, int age) {
        this.ID = ID;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

}
