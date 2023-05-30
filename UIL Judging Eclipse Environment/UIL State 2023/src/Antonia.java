import java.io.PrintWriter;

public class Antonia {
	public static void main(String[] args) {
		new Antonia().run();
	}
	
	public void run() {
		PrintWriter out = new PrintWriter(System.out);
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String word = "BRAVO UIL COMPSCI";
		char[] letters = word.toCharArray();
		for(char curr : letters) {
			int index = alpha.indexOf(curr);
			if(index != -1) {
				for(int i = 0; i <= index; i++) {
					out.print(curr);
				}
			}
			out.println();
		}
		out.close();
	}
}
