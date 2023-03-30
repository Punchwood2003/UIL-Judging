import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Janice {
	public static void main(String[] args) throws IOException {
		new Janice().run();
	}
	public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			String line1 = file.readLine();
			char[] msg1 = line1.toCharArray();
			char[] msg2 = file.readLine().toCharArray();
			int[] key = new int[line1.replaceAll(" ", "").length()];
			char[] msg3 = file.readLine().toCharArray();
			char[] msg4 = new char[msg3.length];

			for(int i = 0, j = 0; i < msg1.length; i++) {
				if(msg1[i] != ' ') {
					key[j++] = msg2[i] - msg1[i];
				}
			}
			for(int i = 0, j = 0; i < msg3.length; i++) {
				if(msg3[i] != ' ') {
					msg4[i] = (char) ((((msg3[i] - 'A') - key[j] + ('Z' - 'A' + 1)) % ('Z' - 'A' + 1)) + 'A');
					j = (j+1) % key.length;
				} else {
					msg4[i] = ' ';
				}
				out.print(msg4[i]);
			}
			out.println();
		}
		file.close();
		out.close();
	}
}
