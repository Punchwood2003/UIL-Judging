import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Alan {
	public static void main(String[] args) throws IOException { 
		new Alan().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			double f = Integer.parseInt(file.readLine());
			double k = (5.0/9.0) * (f - 32.0) + 273.15;
			out.printf("%d degrees Fahrenheit is equal to %.2f Kelvin\n", (int) f, k);
		}
		file.close();
		out.close();
	}
}
