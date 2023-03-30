import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Liza {
	public static void main(String[] args) throws IOException {
		new Liza().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			String assignmentName = file.readLine();
			int numStudents = Integer.parseInt(file.readLine());
			ArrayList<Person> students = new ArrayList<Person>();
			double total = 0;
			for(int i = 0; i < numStudents; i++) {
				st = new StringTokenizer(file.readLine(), ",");
				students.add(new Person(st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken())));
				total += students.get(i).getScore();
			}
			Collections.sort(students);
			double average = total / numStudents;
			double median = (students.size() % 2 == 0) 
					? (students.get((students.size() / 2) - 1).getScore() + students.get(students.size() / 2).getScore()) / 2.0 
							: students.get(students.size() / 2).getScore();
			
			out.println(assignmentName);
			out.println(students.get(0));
			out.println(students.get(1));
			out.println(students.get(2));
			out.printf("MEAN SCORE: %.2f\n", average);
			out.printf("MEDIAN SCORE: %.1f\n", median);
			out.println();
		}
		file.close();
		out.close();
	}
}
class Person implements Comparable<Person> {
	private String firstName, lastName;
	private int score;
	
	public Person(String lname, String fname, int s) {
		this.firstName = fname;
		this.lastName = lname;
		this.score = s;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public int compareTo(Person other) {
		int comp1 = Integer.compare(other.score, this.score);
		int comp2 = this.lastName.compareTo(other.lastName);
		return comp1 == 0 ? (comp2 == 0 ? (this.firstName.compareTo(other.firstName)) : (comp2)) : (comp1);
	}
	
	public String toString() {
		return this.firstName + " " + this.lastName + ": " + this.score;
	}
}