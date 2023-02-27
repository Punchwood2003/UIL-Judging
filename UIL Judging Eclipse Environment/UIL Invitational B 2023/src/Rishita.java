import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.TreeMap;

public class Rishita {
	public static void main(String[] args) throws IOException {
		new Rishita().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		TreeMap<String, TreeMap<String, String>> map = new TreeMap<String, TreeMap<String, String>>();
		String line = file.readLine();
		while(line != null) {
			String[] arr = line.split(",");
			TreeMap<String, String> inside;
			if(map.containsKey(arr[2])) {
				inside = map.get(arr[2]);
			} else {
				inside = new TreeMap<String, String>();
			}
			inside.put(arr[1], arr[0]);
			map.put(arr[2], inside);
			line = file.readLine();
		}
		file.close();
		
		for(String college : map.keySet()) {
			TreeMap<String, String> inside = map.get(college);
			out.println(college);
			for(String classID : inside.keySet()) {
				out.printf("   %s   %s\n", classID, inside.get(classID));
			}
		}
		out.close();
	}
}
