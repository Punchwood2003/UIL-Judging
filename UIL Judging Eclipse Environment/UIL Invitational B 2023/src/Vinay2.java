import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.TreeSet;

public class Vinay2 {
	public static void main(String[] args) throws IOException {
		new Vinay2().run();
	}
	
	public void run() throws IOException {
		double startTime = System.currentTimeMillis();
		
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			String line = file.readLine();
			char[] arr = line.toLowerCase().replaceAll("[^a-zA-Z0-9]", "").toCharArray();
			HashMap<Character, Integer> numOcc = new HashMap<Character, Integer>();
			for(int i = 0; i < arr.length; i++) {
				if(numOcc.containsKey(arr[i])) {
					numOcc.put(arr[i], numOcc.get(arr[i]) + 1);
				} else {
					numOcc.put(arr[i], 1);
				}
			}
			int numOdd = 0;
			for(Character c : numOcc.keySet()) {
				if(numOcc.get(c) % 2 != 0) {
					numOdd++;
				}
				if(numOdd > 1) {
					break;
				}
			}
			if(numOdd > 1) {
				out.printf("%s can not be rearranged to form a palindrome.\n", line);
				continue;
			}
			
			String simplified = "";
			for(Character c : numOcc.keySet()) {
				int currNumOcc = numOcc.get(c);
				if(currNumOcc % 2 == 0) {
					for(int i = 0; i < currNumOcc/2; i++) {
						simplified += c;
					}
				}
			}
			permutations = new TreeSet<String>();
			permute(simplified, "");
			out.printf("%s can be rearranged to form %d distinct palindrome(s).\n", line, permutations.size());
		}
		
		out.println(((double) System.currentTimeMillis() - startTime) / 1000 + " seconds");
		file.close();
		out.close();
	}
	
	public TreeSet<String> permutations;
	public void permute(String simplified, String concat) {
		if(simplified.length() == 0) {
			permutations.add(concat);
			return;
		}
		for(int i = 0; i < simplified.length(); i++) {
			if(i == 0) {
				permute(simplified.substring(1), concat + simplified.charAt(i));
			} else if(i == simplified.length()-1) {
				permute(simplified.substring(0, i), concat + simplified.charAt(i));
			} else {
				permute(simplified.substring(0, i) + simplified.substring(i+1), concat + simplified.charAt(i));
			}
		}
	}
}
