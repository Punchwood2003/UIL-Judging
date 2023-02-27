import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Damian {
	public static void main(String[] args) throws IOException { 
		new Damian().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			int currNum = Integer.parseInt(file.readLine());
			ArrayList<Integer> factors = new ArrayList<Integer>();
			int maxDiv = (int) Math.sqrt(currNum);
			for(int currDiv = 1; currDiv <= maxDiv; currDiv++) {
				if(currNum % currDiv == 0) {
					factors.add(currDiv);
					int factor2 = currNum / currDiv;
					if(factor2 != currDiv) {
						factors.add(currNum / currDiv);
					}
				}
			}
			Collections.sort(factors);
			for(int currFactor : factors) {
				String factorStr = "" + currFactor;
				boolean add = true;
				for(int i = 0; i < factorStr.length() - 1; i++) {
					if(factorStr.charAt(i) >= factorStr.charAt(i+1)) {
						add = false;
						break;
					}
				}
				if(add) {
					out.printf("%d ", currFactor);
				}
			}
			out.println();
		}
		file.close();
		out.close();
	}
}
