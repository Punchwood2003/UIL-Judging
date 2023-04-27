import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Javier {
	public static void main(String[] args) throws IOException {
		new Javier().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			st = new StringTokenizer(file.readLine());
			int top = Integer.parseInt(st.nextToken());
			int bottom = Integer.parseInt(st.nextToken());
			char print = st.nextToken().charAt(0);
			boolean isLeft = st.nextToken().charAt(0) == 'L';
			int max = Math.max(top, bottom);
			for(int i = top; i != bottom;) {
				if(!isLeft) {
					for(int j = 0; j < max - i; j++) {
						out.print(' ');
					}
				}
				for(int j = 0; j < i; j++) {
					out.print(print);
				}
				out.println();
				
				if (top < bottom) {
					i++;
				} else {
					i--;
				}
			}
			if(!isLeft) {
				for(int j = 0; j < max - bottom; j++) {
					out.print(' ');
				}
			}
			for(int i = 0; i < bottom; i++) {
				out.print(print);
			}
			out.println();
		}
		file.close();
		out.close();
	}
}
