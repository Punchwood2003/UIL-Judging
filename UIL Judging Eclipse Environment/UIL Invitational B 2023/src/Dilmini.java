import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Dilmini {
	public static void main(String[] args) throws IOException {
		new Dilmini().run();
	}
	
	public void run() throws IOException {
		PrintWriter out = new PrintWriter(System.out);
		out.println("__________$$$$$$$$$$\r\n"
				+ "_________$_________$$\r\n"
				+ "_________$_$$$$$$$_$$\r\n"
				+ "_________$_$_____$_$$\r\n"
				+ "_________$_$_____$_$$\r\n"
				+ "_________$_$_____$_$$\r\n"
				+ "_________$_$_____$_$$\r\n"
				+ "_________$_$$$$$$$_$$\r\n"
				+ "_________$_________$$\r\n"
				+ "__________$$$$$$$$$$\r\n"
				+ "_________$_________$$\r\n"
				+ "________$_1__2__3_$$$\r\n"
				+ "_______$_4__5__6_$$$\r\n"
				+ "______$_7__8__9_$$$\r\n"
				+ "_____$_*__0__#_$$$\r\n"
				+ "____$_________$$$\r\n"
				+ "_____$$$$$$$$$$$\r\n"
				+ "______$$$$$$$$$");
		out.close();
	}
}
