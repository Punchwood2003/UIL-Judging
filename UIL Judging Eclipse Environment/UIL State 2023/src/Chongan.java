import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Chongan {
	private class Crayon implements Comparable<Crayon> {
		private String color;
		private int numCrayons;
		
		public Crayon(String color, int numCrayons) {
			this.color = color;
			this.numCrayons = numCrayons;
		}
		
		public String getColor() {
			return this.color;
		}
		
		public int compareTo(Crayon other) {
			return Integer.compare(this.numCrayons, other.numCrayons);
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Chongan().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			int numCrayons = 6;
			
			Crayon[] bucket = new Crayon[numCrayons];
			for(int i = 0; i < numCrayons; i++) {
				bucket[i] = new Crayon(st.nextToken(), Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(bucket);
			out.println(bucket[numCrayons-1].getColor());
		}
		
		file.close();
		out.close();
	}
}
