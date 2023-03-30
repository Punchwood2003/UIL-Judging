import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Christine {
	public static void main(String[] args) throws IOException {
		new Christine().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int[] nums = Arrays.asList((file.readLine() + " " + file.readLine() + " " + file.readLine() + " " + file.readLine() + " " + file.readLine() + " " + file.readLine()).split(" ")).stream().map(st -> Integer.parseInt(st)).mapToInt(Integer::intValue).toArray();
		file.close();
		
		for(int i = 0; i < nums.length - 1; i++) {
			int left = nums[i];
			int right = nums[i+1];
			if(left > right) {
				for(int j = left; j >= right; j--) {
					out.print(j + " ");
				}
			} else if(left < right) {
				for(int j = left; j <= right; j++) {
					out.print(j + " ");
				}
			} else {
				out.print(left);
			}
			out.println();
		}
		out.close();
	}
}
