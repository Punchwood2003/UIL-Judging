import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Gabriel {
	public static void main(String[] args) throws IOException {
		new Gabriel().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			int size = Integer.parseInt(st.nextToken());
			StringBuilder sentence = new StringBuilder();
			while(st.hasMoreTokens()) {
				sentence.append(st.nextToken());
			}
			
			if(sentence.length() < (size * size * size)) {
				out.println("NOT ENOUGH LETTERS");
			} else {
				for(int i = 0; i < size; i++) {
					for(int j = 0; j < size; j++) {
						for(int k = 0; k < size; k++) {
							out.print(sentence.charAt((i * size * size) + (j * size) + k));
						}
						out.print(" ");
					}
					out.println();
				}
			}
		}
		file.close();
		out.close();
	}
}
