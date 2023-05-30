import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Romina {
	public static void main(String[] args) throws IOException {
		new Romina().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int[][] mat = new int[r][c];
			for(int i = 0; i < r; i++) {
				mat[i] = Arrays.asList(file.readLine().split("\t")).stream().map(str -> Integer.parseInt(str)).mapToInt(Integer::intValue).toArray();
			}
			
			int offset = 0;
			while(true) {
				double total = 0;
				double ct = 0;
				// Right
				for(int i = offset; i < c - offset; i++) {
					total += mat[offset][i];
					ct++;
				}
				if(ct != 0) {
					out.printf("%.2f ", total / ct);
				} else {
					break;
				}
				total = 0;
				ct = 0;
				// Down
				for(int i = offset + 1; i < r - offset; i++) {
					total += mat[i][c - offset - 1];
					ct++;
				}
				if(ct != 0) {
					out.printf("%.2f ", total / ct);
				} else {
					break;
				}
				total = 0;
				ct = 0;
				// Left
				for(int i = c - offset - 2; i >= offset; i--) {
					total += mat[r - offset - 1][i];
					ct++;
				} 
				if(ct != 0) {
					out.printf("%.2f ", total / ct);
				} else {
					break;
				}
				total = 0;
				ct = 0;
				// Up
				for(int i = r - offset - 2; i >= offset+1; i--) {
					total += mat[i][offset];
					ct++;
				}
				if(ct != 0) {
					out.printf("%.2f ", total / ct);
				} else {
					break;
				}
				
				offset++;
			}
			out.println();
		}
		
		file.close();
		out.close();
	}
}
