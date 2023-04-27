import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Kamil {
	public Comparator<String> compare = (str1, str2) -> {
		int ptr1 = str1.length() - 1;
		int ptr2 = str2.length() - 1;
		while(ptr1 >= 0 && ptr2 >= 0) {
			String char1 = str1.substring(ptr1, ptr1 + 1).toLowerCase();
			String char2 = str2.substring(ptr2, ptr2 + 1).toLowerCase();
			int comp = char1.compareTo(char2);
			if(comp == 0) {
				ptr1--;
				ptr2--;
				continue;
			}
			return comp;
		}
		return Integer.compare(str1.length(), str2.length());
	};
	
	public static void main(String[] args) throws IOException {
		new Kamil().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			String[] arr = file.readLine().split(" ");
			Arrays.sort(arr, compare);
			Arrays.asList(arr).stream().forEach(str -> out.print(str + " "));
			out.println();
		}
		file.close();
		out.close();
	}
}
