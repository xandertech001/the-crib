public class Acrobatic extends Person {
	private String job;

	public Acrobatic(String name, int age, int yearsWorked, String job) {
		super(name, age, yearsWorked);
		this.job = job;
	}

	public String getJob() {
		return job;
	}

	@Override
	public String toString() {
		return String.format("Name: " + getName() + "\n" + "Age: " + getAge() + "\n" + "Years Worked: "
				+ getYearsWorked() + "\n" + "Job: " + getJob());
	}
}
