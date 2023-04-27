import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Louis {
	public static void main(String[] args) throws IOException {
		new Louis().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			double[] arr = Arrays.asList(file.readLine().split(" ")).stream().map(str -> Double.parseDouble(str)).mapToDouble(Double::doubleValue).toArray();
			double a = arr[0];
			double b = arr[1];
			double c = arr[2];
			
			if(a == 0) {
				out.println("Function is not quadratic");
				continue;
			}
			
			double discriminant = (b * b) - (4 * a * c);
			if(discriminant == 0) {
				double root = (-1 * b) / (2 * a);
				out.printf("Function has 1 root at %.3f", root);
			} else if(discriminant > 0) {
				double root1 = ((-1 * b) + Math.sqrt(discriminant)) / (2 * a);
				double root2 = ((-1 * b) - Math.sqrt(discriminant)) / (2 * a);
				out.printf("Function has 2 roots at %.3f and %.3f", (root1 < root2 ? root1: root2), (root1 < root2 ? root2: root1));
			} else {
				out.print("Function has no roots");
			}
			
			double cvx = (-1 * b) / (2 * a);
			if(a < 0) {
				out.printf(" with max of %.3f at %.3f\n", f(arr, cvx), cvx);
			} else {
				out.printf(" with min of %.3f at %.3f\n", f(arr, cvx), cvx);
			}
		}
		file.close();
		out.close();
	}
	
	public double f(double[] arr, double cvx) {
		return arr[0] * (cvx * cvx) + arr[1] * (cvx) + arr[2];
	}
}
