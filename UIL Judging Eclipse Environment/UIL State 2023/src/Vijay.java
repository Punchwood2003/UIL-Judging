import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Vijay {
	private class Pos implements Comparable<Pos> {
		public int x, y, z;
		
		public Pos(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		public int compareTo(Pos other) {
			int comp = Integer.compare(this.x, other.x);
			if(comp != 0) {
				return comp;
			}
			comp = Integer.compare(this.y, other.y);
			return comp != 0 ? comp : Integer.compare(this.z, other.z);
		}
		
		public String toString() {
			return String.format("(%d, %d, %d)", this.x, this.y, this.z);
		}
	}
	
	private class State implements Comparable<State> {
		public Pos currPos;
		public TreeSet<Pos> recoveredCDs;
		public int time;
		
		public State(Pos curr, TreeSet<Pos> recovered, int time) {
			this.recoveredCDs = recovered;
			this.currPos = curr;
			this.time = time;
		}
		
		public int compareTo(State other) {
			int comp = -1 * Integer.compare(this.recoveredCDs.size(), other.recoveredCDs.size());
			if(comp != 0) {
				return comp;
			}
			comp = Integer.compare(this.time, other.time);
			return (comp == 0) ? this.currPos.compareTo(other.currPos) : comp;
		}
		
		public String toString() {
			return String.format("Pos: %s\nRecovered CDs: %s\nTime: %d", this.currPos.toString(), this.recoveredCDs.toString(), time);
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Vijay().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			int h = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int o = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			char[][][] mat = new char[h][r][c];
			Pos start = null;
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < r; j++) {
					mat[i][j] = file.readLine().toCharArray();
					if(start == null) {
						for(int k = 0; k < c; k++) {
							if(mat[i][j][k] == 'S') {
								start = new Pos(i, j, k);
								break;
							}
						}
					}
				}
			}
			
			int ans = bfs(mat, start, o, s, h, r, c);
			out.println(ans == -1 ? "None shall pass." : String.format("# of steps achieved: %d", ans));
		}
		
		file.close();
		out.close();
	}
	
	public int[] dx = {1, -1, 0, 0, 0, 0};
	public int[] dy = {0, 0, 1, -1, 0, 0};
	public int[] dz = {0, 0, 0, 0, 1, -1};
	
	public int bfs(char[][][] mat, Pos start, int numCDs, int maxTime, int maxX, int maxY, int maxZ) {
		PriorityQueue<State> toSearch = new PriorityQueue<State>();
		toSearch.add(new State(start, new TreeSet<Pos>(), 0));
		
		while(!toSearch.isEmpty()) {
			State currState = toSearch.poll();
			int currTime = currState.time;
			
			if(currTime > maxTime) {
				continue;
			}
			
			Pos currPos = currState.currPos;
			TreeSet<Pos> recoveredCDs = currState.recoveredCDs;
			int x = currPos.x;
			int y = currPos.y;
			int z = currPos.z;
			char currSpot = mat[x][y][z];
			
			if(recoveredCDs.size() == numCDs && currSpot == 'E') {
				return currTime;
			}
			
			if(currSpot == 'O') {
				recoveredCDs.add(currPos);
			}
			
			for(int i = 0; i < 6; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				int newZ = z + dz[i];
				
				if(inBounds(newX, newY, newZ, maxX, maxY, maxZ) && mat[newX][newY][newZ] != '#') {
					toSearch.add(new State(new Pos(newX, newY, newZ), new TreeSet<Pos>(recoveredCDs), currTime+1));
				}
			}
		}
		
		return -1;
	}
	
	private boolean inBounds(int x, int y, int z, int maxX, int maxY, int maxZ) {
		return (0 <= x && x < maxX) && (0 <= y && y < maxY) && (0 <= z && z < maxZ);
	}
}
