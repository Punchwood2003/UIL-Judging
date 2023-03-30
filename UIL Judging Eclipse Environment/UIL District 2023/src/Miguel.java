import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Miguel {
	public static void main(String[] args) throws IOException {
		new Miguel().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			String line = file.readLine();
			char[] arr = line.replaceAll("[^A-Za-z]", "").toUpperCase().toCharArray();
			Arrays.sort(arr);
			boolean[] capital = new boolean[line.length()];
			for(int i = 0; i < line.length(); i++) {
				char letter = line.charAt(i);
				if(letter >= 'A' && letter <= 'Z') {
					capital[i] = true;
				}
			}
			
			for(int i = 0, j = 0; i < line.length(); i++) {
				char curr = line.charAt(i);
				if((curr >= 'A' && curr <= 'Z') || (curr >= 'a' && curr <= 'z')) {
					if(capital[i]) {
						out.print(("" + arr[j++]).toUpperCase());
					} else {
						out.print(("" + arr[j++]).toLowerCase());
					}
				} else {
					out.print(curr);
				}
			}
			out.println();
		}
		file.close();
		out.close();
	}
}
