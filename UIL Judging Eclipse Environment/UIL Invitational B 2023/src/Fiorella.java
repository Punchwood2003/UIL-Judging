import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Fiorella {
	public static void main(String[] args) throws IOException {
		new Fiorella().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			double w = Integer.parseInt(st.nextToken());
			double x = Integer.parseInt(st.nextToken());
			double y = Integer.parseInt(st.nextToken());
			double z = Integer.parseInt(st.nextToken());
			double G = Integer.parseInt(st.nextToken());
			out.println((int) (Math.log10((G - z) / (w * y)) / Math.log10(x)));
		}
		file.close();
		out.close();
	}
}
