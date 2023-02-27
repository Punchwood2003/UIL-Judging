import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Feng {
	public static void main(String[] args) throws IOException { 
		new Feng().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			st = new StringTokenizer(file.readLine(), ":");
			double hour = Double.parseDouble(st.nextToken());
			double minute = Double.parseDouble(st.nextToken());
			double minuteDeg = (minute >= 0 && minute <= 15) 
					? (90 - (minute * 6)) 
					: (450 - (minute * 6)); 
			double hourDeg = (hour >= 1 && hour <= 3)
					? (90 - (hour * 30))
					: (450 - (hour * 30));
			double hourChange = minute / 2.0;
			hourDeg = (hour != 3)
					? (hourDeg - hourChange)
					: (360 - hourChange);
			hourDeg %= 360;
			out.printf("Hour: %.1f Minute: %.1f\n", hourDeg, minuteDeg);
		}
		file.close();
		out.close();
	}
}
