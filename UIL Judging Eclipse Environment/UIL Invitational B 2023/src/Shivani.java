import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;

public class Shivani {
	public static void main(String[] args) throws IOException {
		new Shivani().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			BigInteger b= new BigInteger(file.readLine());
			BigInteger c = b.multiply(b.add(BigInteger.ONE));
			c = c.multiply(b.add(BigInteger.ONE.add(BigInteger.ONE)));
			c = c.divide(new BigInteger("6"));
			out.println(c);
		}
		file.close();
		out.close();
	}
}
