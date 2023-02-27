import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Cho {
	public static void main(String[] args) throws IOException { 
		new Cho().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			String line = file.readLine();
			int[] numOcc = new int[26 * 2];
			int maxOcc = 0;
			char maxChar = '\0';
			for(int i = 0; i < line.length(); i++) {
				char currChar = line.charAt(i);
				if((currChar >= 'A' && currChar <= 'Z') || (currChar >= 'a' && currChar <= 'z')) {
					int index = (currChar - 'A' > 26) ? (26 + currChar - 'a') : (currChar - 'A');
					numOcc[index]++;
					if((numOcc[index] > maxOcc) || ((numOcc[index] == maxOcc) && (currChar < maxChar))) {
						maxOcc = numOcc[index];
						maxChar = currChar;
					}
				}
			}
			out.println(maxChar);
		}
		file.close();
		out.close();
	}
}
