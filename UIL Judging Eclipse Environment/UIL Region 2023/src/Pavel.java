import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Pavel {
	class Pos {
		public int r, c, s, t;
		public Pos(int r, int c, int s, int t) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.t = t;
		}
	}

	public static void main(String[] args) throws IOException {
		new Pavel().run();
	}

	private char[][] maze;
	private int[][][] smaze;
	private int r, c, s, startR, startC, endR, endC;

	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			maze = new char[r][c];
			smaze = new int[4][r][c];

			for(int i = 0; i < r; i++) {
				maze[i] = file.readLine().trim().toCharArray();
				Arrays.fill(smaze[0][i], Integer.MAX_VALUE);
				Arrays.fill(smaze[1][i], Integer.MAX_VALUE);
				Arrays.fill(smaze[2][i], Integer.MAX_VALUE);
				Arrays.fill(smaze[3][i], Integer.MAX_VALUE);
				for(int j = 0; j < c; j++) {
					char curr = maze[i][j];
					if(curr == 'S') {
						startR = i;
						startC = j;
					} else if(curr == 'E') {
						endR = i;
						endC = j;
					}
				}
			}
			
			int numMoves = bfs();
			if(numMoves == -1) {
				out.println("Aw, rats!");
				out.println("I'll see you in the Gulag Pavel.");
			} else {
				out.printf("%d steps.\n", numMoves);
				if(numMoves < s) {
					out.println("I have had enough of these snakes.");
				} else {
					out.println("I'll see you in the Gulag Pavel.");
				}
			}
		}

		file.close();
		out.close();
	}

	private int[] dr = {0, -1, 0, 1};
	private int[] dc = {-1, 0, 1, 0};

	private int bfs() {
		Queue<Pos> toSearch = new LinkedList<Pos>();

		toSearch.add(new Pos(startR, startC, 1, 0));

		while(!toSearch.isEmpty()) {
			Pos curr = toSearch.poll();
			int currR = curr.r;
			int currC = curr.c;
			int currS = curr.s;
			int currT = curr.t;
			
			if(currT < smaze[currS-1][currR][currC]) {
				smaze[currS-1][currR][currC] = currT;
				int newS = currS + 1;
				if(newS > 4) {
					newS = 1;
				}
				for(int i = 0; i < 4; i++) {
					int newR = currR + dr[i];
					int newC = currC + dc[i];

					if(inBounds(newR, newC) && (maze[newR][newC] == '.' || maze[newR][newC] == 'E' || maze[newR][newC] == getCycle(currS))) {
						toSearch.add(new Pos(newR, newC, newS, currT + 1));
					}
				}
			}
		}
		
		int res = Math.min(smaze[0][endR][endC], Math.min(smaze[1][endR][endC], Math.min(smaze[2][endR][endC], smaze[3][endR][endC])));
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	private boolean inBounds(int r, int c) {
		return r >= 0 && r < this.r && c >= 0 && c < this.c;
	}

	private char getCycle(int s) {
		switch(s) {
		case 1: {
			return '2';
		}
		case 2: {
			return '3';
		}
		case 3: {
			return '4';
		}
		case 4: {
			return '1';
		}
		}
		return '\0';
	}
}
