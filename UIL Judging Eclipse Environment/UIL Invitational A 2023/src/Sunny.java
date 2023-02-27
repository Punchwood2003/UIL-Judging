import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.TreeSet;

public class Sunny {
	public static void main(String[] args) throws IOException { 
		new Sunny().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		TreeMap<String, ArrayList<String>> map = new TreeMap<String, ArrayList<String>>();
		String line = file.readLine();
		while(line != null) {
			int index = line.indexOf(' ');
			String classID = line.substring(0, index);
			String className = line.substring(index+1);
			ArrayList<String> alternatives = new ArrayList<String>();
			if(map.containsKey(className)) {
				alternatives = map.get(className);
			}
			alternatives.add(classID);
			map.put(className, alternatives);
			line = file.readLine();
		}
		file.close();
		for(String className : map.keySet()) {
			ArrayList<String> list = map.get(className);
			Collections.sort(list);
			for(String classID : list) {
				out.printf("%s (%s)\n", className, classID);
			}
		}
		out.close();
	}
}
