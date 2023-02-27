import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Priyanka {
	public static void main(String[] args) throws IOException { 
		new Priyanka().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			String line = file.readLine();
			String vowels = "";
			String cons = "";
			for(int i = 0; i < line.length(); i++) {
				char currChar = line.charAt(i);
				if(currChar == 'A' || currChar == 'E' || currChar == 'I' || currChar == 'O' || currChar == 'U') {
					vowels += currChar;
				} else {
					cons += currChar;
				}
			}
			String[] vowelsArr = vowels.split("");
			String[] consArr = cons.split("");
			Arrays.sort(vowelsArr);
			Arrays.sort(consArr);
			String res = "";
			for(int i = vowelsArr.length - 1; i >= 0; i--) {
				res += vowelsArr[i];
			}
			for(String currChar : consArr) {
				res += currChar;
			}
			out.println(line.equals(res) ? ("WOO-HOO " + line) : res);
		}
		file.close();
		out.close();
	}
}
