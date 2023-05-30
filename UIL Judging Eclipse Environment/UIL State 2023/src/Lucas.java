import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Lucas {
	public static void main(String[] args) throws IOException {
		new Lucas().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			char[] letters = file.readLine().toCharArray();
			int[] occ = new int[26];
			for(char letter : letters) {
				occ[letter-'a']++;
			}
			
			int total = 0;
			for(int i = 0; i < occ.length; i++) {
				total += (occ[i] * occ[i] * (i+1));
			}
			
			out.println(total);
		}
		
		file.close();
		out.close();
	}
}
