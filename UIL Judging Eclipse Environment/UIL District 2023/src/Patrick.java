import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Patrick {
	public static void main(String[] args) throws IOException {
		new Patrick().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		String line = file.readLine();
		while(line != null) {
			st = new StringTokenizer(line);
			String start = st.nextToken();
			int numTimes = Integer.parseInt(st.nextToken()) - 1;
			while(numTimes-->0) {
				start = iterate(start);
			}
			out.println(start);
			line = file.readLine();
		}
		file.close();
		out.close();
	}
	
	public String iterate(String original) {
		String output = "";
		int running = Integer.MAX_VALUE;
		int count = 0;
		for(int i = 0; i < original.length(); i++) {
			int curr = Integer.parseInt(original.substring(i, i+1));
			if(curr == running) {
				count++;
			} else {
				if(i != 0) {
					output += "" + count + running;
				}
				count = 1;
				running = curr;
			}
		}
		output += "" + count + running;
		return output;
	}
}
