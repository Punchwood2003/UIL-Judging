import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Sofia {
	public static void main(String[] args) throws IOException {
		new Sofia().run();
	}

	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int numTimes = Integer.parseInt(file.readLine());
		for(int i = 1; i <= numTimes; i++) {
			StringTokenizer line = new StringTokenizer(file.readLine());
			double t = Double.parseDouble(line.nextToken());
			double h = Double.parseDouble(line.nextToken());

			double heatIndex = (t + 0.5 * (t + 61.0 + ((t - 68.0) * 1.2) + (h * 0.094))) / 2;

			if(heatIndex >= 80) {
				heatIndex = -42.379 + (2.04901523 * t) 
						+ (10.14333127 * h) - (0.22475541 * t * h) 
						- (6.83783 * Math.pow(10, -3) * Math.pow(t, 2)) 
						- (5.481717 * Math.pow(10, -2) * Math.pow(h, 2)) 
						+ (1.22874 * Math.pow(10, -3) * Math.pow(t, 2) * h) 
						+ (8.5282 * Math.pow(10, -4) * t * Math.pow(h, 2)) 
						- (1.99 * Math.pow(10, -6) * Math.pow(t, 2) * Math.pow(h, 2));
				if(h < 13 && (80 <= t && t <= 112)) {
					heatIndex -= ((13 - h ) / 4) * Math.sqrt((17 - Math.abs(t - 95)) / 17);
				} else if(h > 85 && (80 <= t && t <= 87)) {
					heatIndex -= ((h - 85) / 10) * ((87 - t) / 5);
				}
			}

			out.printf("Test case #%d: %s\n", i, (heatIndex > 140 || heatIndex < 75) ? (String.format("Heat Index %.1f NOT VALID!", heatIndex)) : (String.format("%.1f", heatIndex)));
		}

		file.close();
		out.close();
	}
}
