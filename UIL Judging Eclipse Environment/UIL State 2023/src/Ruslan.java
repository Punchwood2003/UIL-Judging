import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ruslan {
	public static void main(String[] args) throws IOException {
		new Ruslan().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			HashMap<String, HashSet<String>> graph = new HashMap<String, HashSet<String>>();
			
			String line = file.readLine();
			while(!line.equals("=====")) {
				StringTokenizer st = new StringTokenizer(line);
				
				String a = st.nextToken();
				String b = st.nextToken();
				
				HashSet<String> connections = new HashSet<String>();
				connections.add(b);
				if(graph.containsKey(a)) {
					connections.addAll(graph.get(a));
				}
				graph.put(a, connections);
				
				connections = new HashSet<String>();
				connections.add(a);
				if(graph.containsKey(b)) {
					connections.addAll(graph.get(b));
				}
				graph.put(b, connections);
				
				line = file.readLine();
			}
			
			out.println(dfs(graph));
		}
		
		file.close();
		out.close();
	}
	
	public int dfs(HashMap<String, HashSet<String>> graph) {
		return findAllPaths(graph, "You", "Ruslan", new Stack<String>(), 0);
	}
	
	private int findAllPaths(HashMap<String, HashSet<String>> graph, String currNode, String targetNode, Stack<String> path, int count) {
		path.add(currNode);
		
		for(String toSearch : graph.get(currNode)) {
			if(toSearch.equals(targetNode)) {
				count++;
			} else if(!path.contains(toSearch)) {
				count = findAllPaths(graph, toSearch, targetNode, path, count);
			}
		}
		
		path.pop();
		
		return count;
	}
}
