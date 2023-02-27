import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Justin {
	public static void main(String[] args) throws IOException { 
		new Justin().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			st = new StringTokenizer(file.readLine());
			double price = Double.parseDouble(st.nextToken());
			double downPayment = Double.parseDouble(st.nextToken());
			double r = Double.parseDouble(st.nextToken()) / 1200;
			double n = Double.parseDouble(st.nextToken());
			double a = price - downPayment;
			double p = Double.parseDouble(String.format("%.2f", (a * r) / (1 - Math.pow((1 + r), (n * -1)))));
			out.printf("$%9.2f $%9.2f $%9.2f\n", p, ((p * n) + downPayment), (((p * n) + downPayment) - price));
		}
		file.close();
		out.close();
	}
}
