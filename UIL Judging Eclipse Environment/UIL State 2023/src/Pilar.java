import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Pilar {
	public static void main(String[] args) throws IOException {
		new Pilar().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			int[] dim = Arrays.asList(file.readLine().split("[,:]")).stream().map(str -> Integer.parseInt(str)).mapToInt(Integer::intValue).toArray();
			int xOffset = -1 * dim[0];
			int yOffset = -1 * dim[2];
			int zOffset = -1 * dim[4];
			
			int xRange = dim[1]-dim[0]+1;
			int yRange = dim[3]-dim[2]+1;
			int zRange = dim[5]-dim[4]+1;
			
			double[][][] mat = new double[xRange][yRange][zRange];
			for(int i = 0; i < xRange; i++) {
				for(int j = 0; j < yRange; j++) {
					mat[i][j] = Arrays.asList(file.readLine().split(",")).stream().map(str -> Double.parseDouble(str)).mapToDouble(Double::doubleValue).toArray();
				}
			}
			
			int numQueries = Integer.parseInt(file.readLine());
			while(numQueries-->0) {
				int[] query = Arrays.asList(file.readLine().split("[,:]")).stream().map(str -> Integer.parseInt(str)).mapToInt(Integer::intValue).toArray();
				
				int xRangeQ = query[1]-query[0]+1;
				int yRangeQ = query[3]-query[2]+1;
				int zRangeQ = query[5]-query[4]+1;
				
				double total = 0;
				for(int i = query[0]+xOffset; i <= query[1]+xOffset; i++) {
					for(int j = query[2]+yOffset; j <= query[3]+yOffset; j++) {
						for(int k = query[4]+zOffset; k <= query[5]+zOffset; k++) {
							total += mat[i][j][k];
						}
					}
				}
				
				out.printf("%d:%.2f\n", (xRangeQ * yRangeQ * zRangeQ), total);
			}
			
			out.println("====================");
		}
		
		file.close();
		out.close();
	}
}
