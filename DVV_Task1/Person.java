public class Person {
	private String name;
	private int birthYear;
	
	Person() {
		this.name = "";
		this.birthYear = 0;
	}
	
	Person(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public int getBirthYear() {
		return this.birthYear;
	}
	
	public void age() {
		System.out.println("  The person age is " + (2022 - this.birthYear) + " y.o.");
	}
	
	public void input(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
		
		System.out.println("Information about person was setted");
	}
	
	public void output() {
		System.out.println("\nInformation about person: ");
		System.out.println("  Name: " + this.name);
		System.out.println("  The birthday year: " + this.birthYear);
	}
	
	public void changeName(String newName) {
		this.name = newName;
		System.out.println("The name of person was successfully changed to " + newName);
	}
	
	public static void main(String[] args) {
		Person persons[] = new Person[5];
		
		for(int i = 0; i < persons.length; i++) {
			persons[i] = new Person();
		}
		
		persons[0].input("John", 1998);
		persons[1].input("Michael", 1989);
		persons[2].input("Ioan", 2002);
		persons[3].input("Petr", 2012);
		persons[4].input("Georgy", 1969);
		
		for (Person person : persons) {
			person.output();
			person.age();
		}
	}
}
