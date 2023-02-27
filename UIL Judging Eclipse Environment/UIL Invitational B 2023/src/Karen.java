import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Karen {
	public static void main(String[] args) throws IOException {
		new Karen().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			out.println((int) Math.pow(Math.round(Math.sqrt(Integer.parseInt(file.readLine()))), 2));
		}
		file.close();
		out.close();
	}
}
