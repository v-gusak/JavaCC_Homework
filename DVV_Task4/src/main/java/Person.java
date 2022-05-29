public class Person {
    private String lastName;
    private String firstName;
    private String patronymic;
    private int age;

    public Person(String lastName, String firstName, String patronymic, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() throws IncorrectUsernameException {
        if ((this.lastName == null || this.firstName == null || this.patronymic == null) ||
            (this.lastName == "" || this.firstName == "" || this.patronymic == "")) {
            throw new IncorrectUsernameException("Incorrect username");
        }
        return this.lastName + " " + this.firstName + " " + this.patronymic;
    }

    public boolean isAdult() {
        if (this.getAge() >= 18) {
            return true;
        } else {
            return false;
        }
    }
}
