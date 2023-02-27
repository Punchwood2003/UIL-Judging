import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Tushar {
	public static void main(String[] args) throws IOException {
		new Tushar().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][m];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(file.readLine());
				for(int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < m; i++) {
				double sum = 0;
				double t = 0;
				for(int j = 0; (j < n) && (j + i < m); j++) {
					sum += arr[j][j+i];
					t++;
				}
				out.printf("%.2f ", sum / t);
			}
			
			for(int i = 1; i < n; i++) {
				double sum = 0;
				double t = 0;
				for(int j = 0; (i + j < n) && (j < m); j++) {
					sum += arr[i+j][j];
					t++;
				}
				out.printf("%.2f ", sum / t);
			}
			
			out.println();
		}
		file.close();
		out.close();
	}
}
