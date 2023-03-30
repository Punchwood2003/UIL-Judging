import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Shreya {
	public static void main(String[] args) throws IOException {
		new Shreya().run();
	}

	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			int[] coins = Arrays.asList(file.readLine().split(" ")).stream().map(str -> Integer.parseInt(str)).mapToInt(Integer::intValue).toArray();
			int target = Integer.parseInt(file.readLine());
			boolean[] flags = new boolean[target + 1];
			flags[0] = true;
			for(int coin : coins) {
				for(int i = target; i >= 0; i--) {
					if(flags[i] && i + coin <= target) {
						flags[i + coin] = true;
					}
				}
			}
			out.println(flags[target] ? "Business as usual." : "Dine and Dash.");
		}
		file.close();
		out.close();
	}
}
