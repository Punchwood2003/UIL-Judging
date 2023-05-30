import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class Kumar {
	public static void main(String[] args) throws IOException {
		new Kumar().run();
	}
	
	public BigInteger gcd(BigInteger a, BigInteger b) {
		if(b.equals(BigInteger.ZERO)) {
			return a;
		}
		return gcd(b, a.mod(b));
	}
	
	public BigInteger getNumeratorRepeating(String nonrepeating, String repeating) { 
		String combined = nonrepeating + repeating;
		BigInteger combinedNum = new BigInteger(combined);
		BigInteger nonrepeatingNum = (nonrepeating.length() != 0) 
				? new BigInteger(nonrepeating) 
				: BigInteger.ZERO;
		return combinedNum.subtract(nonrepeatingNum);
	}
	
	public BigInteger getDenominatorRepeating(String nonrepeating, String repeating) {
		StringBuilder combined = new StringBuilder();
		int nonrepeatingLen = nonrepeating.length();
		int repeatingLen = repeating.length();
		
		for(int i = 0; i < repeatingLen; i++) {
			combined.append('9');
		}
		for(int i = 0; i < nonrepeatingLen; i++) {
			combined.append('0');
		}
		
		return new BigInteger(combined.toString());
	}
	
	public BigInteger getDenominatorNonrepeating(int len) {
		StringBuilder denominator = new StringBuilder("1");
		
		for(int i = 0; i < len; i++) {
			denominator.append('0');
		}
		
		return new BigInteger(denominator.toString());
	}
	
	public String getRepeating(String line) {
		String ans = "";
		String repeating = "";
		int len = 0;
		for(int i = 1; (i <= 4) && (line.length() >= 3 * i); i++) {
			repeating = line.charAt(line.length() - i) + repeating;
			len++;
			String substr1 = line.substring(line.length() - (2 * len), line.length() - len);
			String substr2 = line.substring(line.length() - (3 * len), line.length() - (2 * len));
			
			if(repeating.equals(substr1) && repeating.equals(substr2)) {
				ans = repeating;
			}
		}
		return ans;
	}
	
	public String getNonrepeating(String line, String repeating) {
		return line.substring(0, line.indexOf(repeating));
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			String line = file.readLine().substring(1);
			int len = line.length();
			if(line.equals("0")) {
				out.printf(".0 is equivalent to 0/1\n");
			} else if(line.contains("...")) {
				line = line.substring(0, line.length() - 3);
				String repeating = getRepeating(line);
				String nonrepeating = getNonrepeating(line, repeating);
				
				BigInteger a = getNumeratorRepeating(nonrepeating, repeating);
				BigInteger b = getDenominatorRepeating(nonrepeating, repeating);
				BigInteger gcd = gcd(a, b);
				
				out.printf(".%s... is equivalent to %s/%s\n", line, (a.divide(gcd).toString()), (b.divide(gcd).toString()));
			} else {
				BigInteger a = new BigInteger(line);
				BigInteger b = getDenominatorNonrepeating(len);
				BigInteger gcd = gcd(a, b);
				
				out.printf(".%s is equivalent to %s/%s\n", line, (a.divide(gcd).toString()), (b.divide(gcd).toString()));
			}
		}
		
		file.close();
		out.close();
	}
}
