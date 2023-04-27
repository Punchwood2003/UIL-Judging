import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Cynthia {
	public static void main(String[] args) throws IOException {
		new Cynthia().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			int[] nums = Arrays.asList(file.readLine().split(" ")).stream().map(str -> Integer.parseInt(str)).mapToInt(Integer::intValue).toArray();
			double best = Double.MIN_VALUE;
			for(int i = 0; i < 3; i++) {
				double a = nums[i];
				double b = nums[(i+1) % 3];
				double c = nums[(i+2) % 3];
				double area = ((a+b)/2) * c;
				best = (area > best) ? area : best;
			}
			out.printf("%,.2f\n", best);
		}
		file.close();
		out.close();
	}
}
