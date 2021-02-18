package project;

public class Person implements Comparable<Person> {

	private String firstName, lastName;
	private int id;
	
	public Person(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " (" + id + ")";
	}

	@Override
	public int compareTo(Person o) {
		int lastNameComparison = this.lastName.compareToIgnoreCase(o.lastName);
		int firstNameComparison = this.firstName.compareToIgnoreCase(o.firstName);

		if (lastNameComparison == 0) {
			if (firstNameComparison == 0) {
				if (this.id < o.id) {
					return -1;
				} else if (this.id > o.id) {
					return 1;
				} else { 			// id is same
					return 0;
				}
			} else {				// firstName is different
				return firstNameComparison;
			}
		} else {					// lastName is different
			return lastNameComparison;
		}
	}
}
