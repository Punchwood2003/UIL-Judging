import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.DoubleStream;

public class Sunil {
	public static void main(String[] args) throws IOException {
		new Sunil().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			st = new StringTokenizer(file.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			double[][] mat = new double[r][c];
			for(int i = 0; i < r; i++) {
				mat[i] = Arrays.asList(file.readLine().split("\t")).stream().map(str -> Double.parseDouble(str)).mapToDouble(Double::doubleValue).toArray();
			}
			double[] rowTotals = new double[r];
			double[] colTotals = new double[c];
			double runningTotal = 0;
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					rowTotals[i] += mat[i][j];
					colTotals[j] += mat[i][j];
					runningTotal += mat[i][j];
				}
			}
			DoubleStream.of(rowTotals).forEach(num -> out.printf("%8.2f", num / c));
			out.println();
			DoubleStream.of(colTotals).forEach(num -> out.printf("%8.2f", num / r));
			out.println();
			out.printf("%8.2f\n", runningTotal / (r * c));
			out.println("=========================");
		}
		file.close();
		out.close();
	}
}
