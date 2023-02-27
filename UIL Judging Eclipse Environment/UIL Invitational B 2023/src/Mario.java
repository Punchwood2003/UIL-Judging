import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Mario {
	public static void main(String[] args) throws IOException {
		new Mario().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			int shift = Integer.parseInt(st.nextToken());
			String word = st.nextToken();
			if(word.length() < shift) {
				out.println("error");
			} else if(word.length() / 2 < shift) {
				out.println(new StringBuilder(word).reverse().toString());
			} else {
				StringBuilder first = new StringBuilder(word.substring(0, shift));
				StringBuilder last = new StringBuilder(word.substring(word.length() - shift));
				String middle = word.substring(shift, word.length() - shift);
				out.println(last.reverse().toString() + middle + first.reverse().toString());
			}
		}
		file.close();
		out.close();
	}
}
