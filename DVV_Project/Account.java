import java.util.Objects;
import java.util.Scanner;

public class Account {
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private String email;
    private String alternateEmail;
    private Integer mailboxCapacity;

    public Account(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.alternateEmail = "none";
        this.mailboxCapacity = 500;

        generateEmail();
        generatePassword();
    }

    public void generateEmail() {
        String email = this.firstName + "." + this.lastName + "@" + this.department + ".company.com";
        this.email = email.toLowerCase();
    }

    public void generatePassword() {
        int length = getRandomInteger(14, 18);
        final String KEY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        String password = "";

        for (int index = 0; index < length; index++) {
            char symbol = KEY.charAt((int) (Math.random() * KEY.length()));
            password = password.concat(String.valueOf((char) symbol));
        }

        this.password = password;
    }

    public static int getRandomInteger(int min, int max){
        return ((int) (Math.random() * (max - min))) + min;
    }

    public void showInfo() {
        System.out.println("\nName: " + this.firstName + " " + this.lastName + "\nDepartment: " + this.department +
                "\nEmail: " + this.email + "\nPassword: " + this.password +
                "\nMailbox capacity: " + this.mailboxCapacity + " mb\nAlternate email: " + this.alternateEmail);
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMailboxCapacity() {
        return mailboxCapacity;
    }

    public void setMailboxCapacity(Integer mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public static void main(String[] args) {
        String firstName, lastName, option, choice, department, newPassword, alternateEmail, capacity;
        String[] name;
        Account employee;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter new employee name (Name Surname): ");
            option = sc.nextLine();
            name = option.split(" ");

            if(name.length == 2) {
                firstName = name[0];
                lastName = name[1];

                break;
            } else {
                System.out.println("  Error, please enter correct name\n");
            }
        }

        System.out.println("\nDepartment codes");
        System.out.println("  1 for Sales\n  2 for Development\n  3 for Accounting\n  0 for None");

        while (true) {
            System.out.print("Choose department by code: ");
            choice = sc.nextLine();

            if (Objects.equals(choice, "1")) {
                department = "Sales";
                break;
            } else if (Objects.equals(choice, "2")) {
                department = "Development";
                break;
            } else if (Objects.equals(choice, "3")) {
                department = "Accounting";
                break;
            } else if (Objects.equals(choice, "0")) {
                department = "Employee";
                break;
            } else {
                System.out.println("  Error, please enter the correct code\n");
            }
        }

        employee = new Account(firstName, lastName, department);

        while (true) {
            System.out.print("\nChoice an option: ");
            System.out.println("\n  1 - Show info about employee\n  2 - Change password\n  " +
                    "3 - Change mailbox capacity\n  4 - Set alternate email\n  5 - Exit");

            System.out.print("Your answer: ");
            choice = sc.nextLine();

            if (Objects.equals(choice, "1")) {
                employee.showInfo();
            } else if (Objects.equals(choice, "2")) {
                while (true) {
                    System.out.print("\nChoice an option: ");
                    System.out.println("\n  1 - Generate new random password\n  2 - Enter new password\n");

                    System.out.print("Your answer: ");
                    choice = sc.nextLine();

                    if (Objects.equals(choice, "1")) {
                        employee.generatePassword();

                        System.out.println("\nNew password: " + employee.getPassword());
                        break;
                    } else if (Objects.equals(choice, "2")) {
                        System.out.print("\nEnter new password: ");
                        newPassword = sc.nextLine();

                        employee.setPassword(newPassword);

                        System.out.println("\nNew password: " + employee.getPassword());
                        break;
                    } else {
                        System.out.println("  Error, please enter the correct answer");
                    }
                }
            } else if (Objects.equals(choice, "3")) {
                System.out.print("\nEnter new value of mailbox capacity: ");
                capacity = sc.nextLine();

                employee.setMailboxCapacity(Integer.parseInt(capacity));

                System.out.println("\nNew mailbox capacity: " + employee.getMailboxCapacity() + " mb");
            } else if (Objects.equals(choice, "4")) {
                System.out.print("\nEnter alternate email: ");
                alternateEmail = sc.nextLine();

                employee.setAlternateEmail(alternateEmail);

                System.out.println("\nNew alternate email: " + employee.getAlternateEmail());
            } else if (Objects.equals(choice, "5")) {
                break;
            } else {
                System.out.println("  Error, please enter the correct answer");
            }
        }

        sc.close();
    }
}
