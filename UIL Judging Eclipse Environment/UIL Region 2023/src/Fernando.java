import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Fernando {
	public static void main(String[] args) throws IOException {
		new Fernando().run();
	}

	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			TreeSet<Integer> factors = new TreeSet<Integer>();
			Queue<Integer> toSearch = new LinkedList<Integer>();
			StringTokenizer st = new StringTokenizer(file.readLine());
			int max = Integer.parseInt(st.nextToken());
			char except = st.nextToken().charAt(0);
			int upper = (int) Math.ceil(Math.sqrt(max));

			for(int i = 2; i <= upper; i++) {
				toSearch.add(i);
			}

			if(!contains(1, except)) {
				factors.add(1);
			}
			if(!contains(max, except)) {
				factors.add(max);
			}

			while(!toSearch.isEmpty()) {
				int curr = toSearch.poll();
				if(max % curr == 0) {
					int other = max / curr;
					if(!contains(curr, except)) {
						factors.add(curr);
					}
					if(!contains(other, except)) {
						factors.add(other);
					}
				}
			}

			if(factors.isEmpty()) {
				out.print("NONE");
			} else {
				factors.stream().forEach(curr -> out.print(curr + " "));
			}
			out.println();
		}

		file.close();
		out.close();
	}

	public boolean contains(int curr, char except) {
		return ("" + curr).indexOf(except) != -1;
	}
}
