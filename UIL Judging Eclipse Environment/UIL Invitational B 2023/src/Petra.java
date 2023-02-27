import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Petra {
	public static void main(String[] args) throws IOException {
		new Petra().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			String line = file.readLine();
			int normal = Integer.parseInt(line);
			int reverse = Integer.parseInt(new StringBuilder(line).reverse().toString());
			out.println(gcd(normal, reverse));
		}
		file.close();
		out.close();
	}
	
	public int gcd(int a, int b) {
		return (b == 0) ? (a) : (gcd(b, a % b));
	}
}
