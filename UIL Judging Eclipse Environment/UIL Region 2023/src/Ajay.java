import java.io.PrintWriter;

public class Ajay {
	public static void main(String[] args) {
		new Ajay().run();
	}
	
	public void run() {
		PrintWriter out = new PrintWriter(System.out);
		out.println("             -----TRAPEZOID-----\r\n"
				+ "            /                   \\\r\n"
				+ "           /                     \\\r\n"
				+ "          T                       T\r\n"
				+ "         R                         R\r\n"
				+ "        A                           A\r\n"
				+ "       P                             P\r\n"
				+ "      E                               E\r\n"
				+ "     Z                                 Z\r\n"
				+ "    O                                   O\r\n"
				+ "   I                                     I\r\n"
				+ "  D                                       D\r\n"
				+ " /                                         \\\r\n"
				+ "/                                           \\\r\n"
				+ "------------------TRAPEZOID------------------");
		out.close();
	}
}
