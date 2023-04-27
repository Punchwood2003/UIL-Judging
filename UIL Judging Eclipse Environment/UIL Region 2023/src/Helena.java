import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Helena {
	public static void main(String[] args) throws IOException {
		new Helena().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			int len = Integer.parseInt(st.nextToken());
			int iter = Integer.parseInt(st.nextToken());
			while(iter-->0) {
				String line = file.readLine();
				ArrayList<String> list = new ArrayList<String>();
				for(int i = 0; i < line.length(); i += (len * 2)) {
					if(line.length() - (i + (len * 2)) < 0) {
						double temp = (line.length() - i);
						int div = (int) Math.ceil(temp/2);
						list.add(new StringBuilder(line.substring(i+div)).reverse().toString());
						list.add(new StringBuilder(line.substring(i, i+div)).reverse().toString());
						
					} else {
						list.add(new StringBuilder(line.substring(i+len, i+(len * 2))).reverse().toString());
						list.add(new StringBuilder(line.substring(i, i+len)).reverse().toString());
						
					}
				}
				out.print("'");
				list.stream().forEach(str -> out.print(str));
				out.println("'");
			}
			out.println("=========================");
		}
		file.close();
		out.close();
	}
}
