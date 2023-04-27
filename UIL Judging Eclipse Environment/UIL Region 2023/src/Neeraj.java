import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class Neeraj {
	public static void main(String[] args) throws IOException {
		new Neeraj().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			String line = file.readLine();
			int len = line.length()-1;
			BigInteger a = new BigInteger(line.substring(1));
			
			String temp = "1";
			for(int i = 0; i < len; i++) {
				temp += "0";
			}
			
			BigInteger b = new BigInteger(temp);
			BigInteger gcd = gcd(a, b);
			
			out.printf("%s is equal to %s/%s\n", line, (a.divide(gcd).toString()), (b.divide(gcd).toString()));
		}
		file.close();
		out.close();
	}
	
	public BigInteger gcd(BigInteger a, BigInteger b) {
		if(b.equals(BigInteger.ZERO)) {
			return a;
		}
		return gcd(b, a.mod(b));
	}
}
