import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Bianca {
	public static void main(String[] args) throws IOException { 
		new Bianca().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			st = new StringTokenizer(file.readLine());
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			out.printf("%.2f\n", Math.sqrt(a*a + b*b));
		}
		file.close();
		out.close();
	}
}
