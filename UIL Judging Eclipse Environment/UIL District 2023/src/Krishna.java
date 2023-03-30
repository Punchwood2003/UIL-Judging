import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Krishna {
	public static void main(String[] args) throws IOException {
		new Krishna().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		
		int[] prefixSum1 = new int[100];
		prefixSum1[0] = 1;
		for(int i = 1; i < 100; i++) {
			prefixSum1[i] = prefixSum1[i-1] + (i+1); 
		}
		
		int[] prefixSum2 = new int[100];
		prefixSum2[0] = prefixSum1[0];
		for(int i = 1; i < 100; i++) {
			prefixSum2[i] = prefixSum2[i-1] + prefixSum1[i];
		}
			
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			st = new StringTokenizer(file.readLine());
			int left = Integer.parseInt(st.nextToken()) - 1;
			int right = Integer.parseInt(st.nextToken()) - 1;
			if(left - 1 < 0) {
				out.println(prefixSum2[right]);
			} else {
				out.println(prefixSum2[right] - prefixSum2[left-1]);
			}
		}
		file.close();
		out.close();
	}
}
