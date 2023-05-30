import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Hong {
	public static void main(String[] args) throws IOException {
		new Hong().run();
	}
	
	private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }
	
	public String convert(int num) {
		int l =  map.floorKey(num);
        if ( num == l ) {
            return map.get(num);
        }
        return map.get(l) + convert(num-l);
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		List<Integer> arabic = Arrays.asList(file.readLine().split(" ")).stream().map(str -> Integer.parseInt(str)).collect(Collectors.toList());
		arabic.stream().forEach(num -> out.printf("%d -> %s\n", num, convert(num)));
		
		file.close();
		out.close();
	}
}
