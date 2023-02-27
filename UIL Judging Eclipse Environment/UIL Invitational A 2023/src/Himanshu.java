import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Himanshu {
	public static void main(String[] args) throws IOException { 
		new Himanshu().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		for(int gameNumber = 1; gameNumber <= numTimes; gameNumber++) {
			int dimension = Integer.parseInt(file.readLine());
			String[][] arr = new String[dimension][dimension];
			for(int i = dimension - 1; i >= 0; i--) {
				arr[i] = file.readLine().split(" ");
			}
			
			StringTokenizer p1Tokenizer = new StringTokenizer(file.readLine().substring(3), ",");
			StringTokenizer p2Tokenizer = new StringTokenizer(file.readLine().substring(3), ",");
			file.readLine();
			
			Queue<Integer> p1Moves = new LinkedList<Integer>();
			Queue<Integer> p2Moves = new LinkedList<Integer>();
			while(p1Tokenizer.hasMoreTokens()) {
				p1Moves.offer(Integer.parseInt(p1Tokenizer.nextToken()));
			}
			while(p2Tokenizer.hasMoreTokens()) {
				p2Moves.offer(Integer.parseInt(p2Tokenizer.nextToken()));
			}
			
			HashMap<String, Integer> connections = new HashMap<String, Integer>();
			HashMap<Integer, Integer> shutes = new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> ladders = new HashMap<Integer, Integer>();
			for(int i = 0; i < dimension; i++) {
				if(i % 2 == 0) {
					for(int j = 0; j < dimension; j++) {
						String currSpace = arr[i][j];
						if(currSpace.charAt(0) == 'S' || currSpace.charAt(0) == 'L') {
							int currIndex = (i * dimension) + j;
							if(connections.containsKey(currSpace)) {
								int otherIndex = connections.get(currSpace); 
								if(currSpace.charAt(0) == 'S') {
									shutes.put(currIndex, otherIndex);
								} else {
									ladders.put(otherIndex, currIndex);
								}
							} else {
								connections.put(currSpace, currIndex);
							}
						}
					}
				} else {
					for(int j = dimension - 1; j >= 0; j--) {
						String currSpace = arr[i][j];
						if(currSpace.charAt(0) == 'S' || currSpace.charAt(0) == 'L') {
							int currIndex = (i * dimension) + (dimension - j - 1);
							if(connections.containsKey(currSpace)) {
								int otherIndex = connections.get(currSpace); 
								if(currSpace.charAt(0) == 'S') {
									shutes.put(currIndex, otherIndex);
								} else {
									ladders.put(otherIndex, currIndex);
								}
							} else {
								connections.put(currSpace, currIndex);
							}
						}
					}
				}
			}
			
			int p1Space = 0, p2Space = 0;
			int winningSpace = (dimension * dimension) - 1;
			boolean p1Wins = false, p2Wins = false;
			while(!p1Moves.isEmpty() && !p2Moves.isEmpty()) {
				p1Space += p1Moves.poll();
				p2Space += p2Moves.poll();
				
				if(ladders.containsKey(p1Space)) {
					p1Space = ladders.get(p1Space);
				} else if(shutes.containsKey(p1Space)) {
					p1Space = shutes.get(p1Space);
				}
				
				if(ladders.containsKey(p2Space)) {
					p2Space = ladders.get(p2Space);
				} else if(shutes.containsKey(p2Space)) {
					p2Space = shutes.get(p2Space);
				}
				
				if(p1Space >= winningSpace) {
					p1Wins = true;
				}
				if(p2Space >= winningSpace) {
					p2Wins = true;
				}
				
				if(p1Wins || p2Wins) {
					break;
				}
			}
			
			out.printf("Game #%d: %s\n", gameNumber, (p1Wins && p2Wins) 
					? "Both players win!"
					: (p1Wins)
						? "Player 1 wins!"
						: (p2Wins)
							? "Player 2 wins!"
							: "Neither Player 1 or Player 2 won.");
		}
		file.close();
		out.close();
	}
}
