import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Emily {
	public static void main(String[] args) throws IOException {
		new Emily().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			int a = Integer.parseInt(st.nextToken());
			char operator = st.nextToken().charAt(0);
			int b = Integer.parseInt(st.nextToken());
			switch(operator) {
			case '+' : {
				out.printf("%d %c %d = %d\n", a, operator, b, (a+b));
				break;
			}
			case '-' : {
				out.printf("%d %c %d = %d\n", a, operator, b, (a-b));
				break;
			}
			case '/' : {
				out.printf("%d %c %d = %d remainder %d\n", a, operator, b, (a/b), (a%b));
				break;
			}
			default : {
				out.printf("%d %c %d = %d\n", a, operator, b, (a*b));
			}
			}
		}
		file.close();
		out.close();
	}
}
