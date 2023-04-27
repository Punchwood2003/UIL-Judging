import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.TreeSet;

public class Sveta {
	public static void main(String[] args) throws IOException {
		new Sveta().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			int numBits = Integer.parseInt(file.readLine().substring(5));
			String str1 = file.readLine().substring(10);
			String str2 = file.readLine().substring(10);
			String str3 = file.readLine().substring(8);
			file.readLine();
			
			TreeSet<Integer> orBits = new TreeSet<Integer>();
			TreeSet<Integer> andBits = new TreeSet<Integer>();
			TreeSet<Integer> xorBits = new TreeSet<Integer>();
			if(!str1.equals("n/a")) {
				Arrays.asList(str1.split(",")).stream().map(str -> Integer.parseInt(str)).mapToInt(Integer::intValue).forEach(bit -> orBits.add(bit));
			}
			if(!str2.equals("n/a")) {
				Arrays.asList(str2.split(",")).stream().map(str -> Integer.parseInt(str)).mapToInt(Integer::intValue).forEach(bit -> andBits.add(bit));
			}
			if(!str3.equals("n/a")) {
				Arrays.asList(str3.split(",")).stream().map(str -> Integer.parseInt(str)).mapToInt(Integer::intValue).forEach(bit -> xorBits.add(bit));
			}
			
			int count = 0;
			count += orBits.isEmpty() ? 0 : 1;
			count += andBits.isEmpty() ? 0 : 1;
			count += xorBits.isEmpty() ? 0 : 1;
			
			if(count > 1) {
				out.println("This can not be done with a single bitwise operator.");
			} else {
				String bin = "";
				if(!orBits.isEmpty()) {
					for(int i = 0; i < numBits; i++) {
						bin = (orBits.contains(i) ? "1" : "0") + bin;
					}
					out.println("opnd | " + Long.toHexString(Long.parseLong(bin, 2)).toUpperCase());
				} else if(!andBits.isEmpty()) {
					for(int i = 0; i < numBits; i++) {
						bin = (andBits.contains(i) ? "0" : "1") + bin;
					}
					out.println("opnd & " + Long.toHexString(Long.parseLong(bin, 2)).toUpperCase());
				} else {
					for(int i = 0; i < numBits; i++) {
						bin = (xorBits.contains(i) ? "1" : "0") + bin;
					}
					out.println("opnd ^ " + Long.toHexString(Long.parseLong(bin, 2)).toUpperCase());
				}
			}
		}
		file.close();
		out.close();
	}
}
