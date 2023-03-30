import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Vanessa {
	public static void main(String[] args) throws IOException {
		new Vanessa().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			int[] coins = Arrays.asList(file.readLine().split(",")).stream().map(str -> Integer.parseInt(str)).mapToInt(Integer::intValue).toArray();
			int target = Integer.parseInt(file.readLine());
			file.readLine();
			out.println(knapsack(target, coins.length, coins));
		}
		file.close();
		out.close();
	}
	
	public int knapsack(int target, int index, int[] coins) {
		if(target == 0) { 
			return 1;
		} else if(target < 0) {
			return 0;
		} else if(index <= 0) {
			return 0;
		}
		return knapsack(target, index - 1, coins) + knapsack(target - coins[index - 1], index, coins);
	}
}
