import java.io.IOException;
import java.io.PrintWriter;

public class Bogdan {
	public static void main(String[] args) throws IOException {
		new Bogdan().run();
	}
	
	public void run() throws IOException {
		PrintWriter out = new PrintWriter(System.out);
		out.println("-------------------------------------------------------------\r\n"
				+ "                  1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 2 2 2 2 3 3\r\n"
				+ "1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1\r\n"
				+ "-------------------------------------------------------------\r\n"
				+ "S M T W T F S S M T W T F S S M T W T F S S M T W T F S S M T\r\n"
				+ "U O U E H R A U O U E H R A U O U E H R A U O U E H R A U O U\r\n"
				+ "N N E D U I T N N E D U I T N N E D U I T N N E D U I T N N E\r\n"
				+ "-------------------------------------------------------------\r\n"
				+ "N N A B A B N N A B A B A N N N B A B A N N B A B A B N N A B\r\n"
				+ "o o         o o           o o o         o o           o o   i\r\n"
				+ "    D D D D     D D D D D       D D D D     D D D D D     D r\r\n"
				+ "C C a a a a C C a a a a a C C C a a a a C C a a a a a C C a t\r\n"
				+ "l l y y y y l l y y y y y l l l y y y y l l y y y y y l l y h\r\n"
				+ "a a         a a           a a a         a a           a a   d\r\n"
				+ "s s         s s           s s s         s s           s s   a\r\n"
				+ "s s         s s           s s s         s s           s s   y\r\n"
				+ "-------------------------------------------------------------");
		out.close();
	}
}
