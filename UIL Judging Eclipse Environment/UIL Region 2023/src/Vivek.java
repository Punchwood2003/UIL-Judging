import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Vivek {
	public static void main(String[] args) throws IOException {
		new Vivek().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			double z = Double.parseDouble(st.nextToken());
			double g = Double.parseDouble(st.nextToken());
			int numSystems = Integer.parseInt(file.readLine());
			int possible = 0;
			while(numSystems-->0) {
				st = new StringTokenizer(file.readLine());
				st.nextToken();
				boolean isMechanic = Boolean.parseBoolean(st.nextToken());
				if(isMechanic) {
					double a = Double.parseDouble(st.nextToken());
					double b = Double.parseDouble(st.nextToken());
					double c = Double.parseDouble(st.nextToken());
					if(dist(x, y, z, a, b, c) <= g) {
						possible++;
					}
				}
			}
			
			out.println(possible > 0 ? (String.format("We made it Rick: %d", possible)) : ("SS Madame de Pompadour"));
		}
		file.close();
		out.close();
	}
	
	public double dist(double x1, double y1, double z1, double x2, double y2, double z2) {
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2) + Math.pow(z1-z2, 2));
	}
}
