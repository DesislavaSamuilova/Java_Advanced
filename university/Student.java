package university;

public class Student {
    private String firstName;
    private String lastName;
    private String bestSubject;

    public Student(String firstName, String lastName, String bestSubject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestSubject = bestSubject;
    }

    public void setBestSubject(String bestSubject) {
        this.bestSubject = bestSubject;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBestSubject() {
        return bestSubject;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Student: " + firstName + " " + lastName + ", " + bestSubject;
    }
}