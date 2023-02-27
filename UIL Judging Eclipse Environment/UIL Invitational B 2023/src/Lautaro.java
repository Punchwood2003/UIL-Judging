import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Lautaro {
	public static void main(String[] args) throws IOException {
		new Lautaro().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			out.println(file.readLine().matches("\\(\\d{3}\\) \\d{3}-\\d{4}") ? "Valid Phone Number." : "No Calls for You.");
		}
		file.close();
		out.close();
	}
}
