import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Gael {
	public static void main(String[] args) throws IOException { 
		new Gael().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			
			String line = file.readLine();
			out.println(line);
			for(int i = 1; i < line.length() - 1; i++) {
				out.print(line.charAt(i));
				for(int j = 1; j < line.length() - 1; j++) {
					out.print(" ");
				}
				out.print(line.charAt(line.length() - i - 1));
				out.println();
			}
			out.println(new StringBuilder(line).reverse().toString());
		}
		file.close();
		out.close();
	}
}
