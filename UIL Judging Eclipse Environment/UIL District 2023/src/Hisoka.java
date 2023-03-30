import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Hisoka {
	public static void main(String[] args) throws IOException {
		new Hisoka().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			st = new StringTokenizer(file.readLine());
			double monthlyPayment = Double.parseDouble(st.nextToken());
			double monthlyPercentage = Double.parseDouble(st.nextToken()) / 12.0 / 100.0;
			double numMonths = Double.parseDouble(st.nextToken()) * 12.0;
			double v = monthlyPayment * ((Math.pow(1 + monthlyPercentage, numMonths) - 1) / (monthlyPercentage));
			out.printf("%.2f %.2f %.2f\n", (monthlyPayment * numMonths), (v - (monthlyPayment * numMonths)), (v));
		}
		file.close();
		out.close();
	}
}
