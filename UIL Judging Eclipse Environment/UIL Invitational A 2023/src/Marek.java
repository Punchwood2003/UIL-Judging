import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Marek {
	public static void main(String[] args) throws IOException { 
		new Marek().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		int numTimes = Integer.parseInt(file.readLine());
		while(numTimes-->0) {
			Stack<Integer> operands = new Stack<Integer>();
			Stack<Character> operators = new Stack<Character>();
			st = new StringTokenizer(file.readLine());
			boolean infinity = false;
			all: while(st.hasMoreTokens()) {
				System.out.println(operands);
				System.out.println(operators);
				String token = st.nextToken();
				char firstChar = token.charAt(0);
				if(firstChar >= '0' && firstChar <= '9') {
					operands.push(Integer.parseInt(token));
				} else if(firstChar == '(') {
					operators.push('(');
				} else if(firstChar == ')') {
					while(operators.peek() != '(') {
						int ans = solve(operators.pop(), operands.pop(), operands.pop());
						if(infinityRes) {
							infinity = true;
							break all;
						}
						operands.push(ans);
					}
					operators.pop();
				} else {
					while(!operators.isEmpty() && precedence(firstChar, operators.peek())) {
						int ans = solve(operators.pop(), operands.pop(), operands.pop());
						if(infinityRes) {
							infinity = true;
							break all;
						}
						operands.push(ans);
					}
					operators.push(firstChar);
				}
			}
			if(infinity) {
				out.println("Infinity.");
			} else {
				while(!operators.isEmpty()) {
					int ans = (solve(operators.pop(), operands.pop(), operands.pop()));
					if(infinityRes) {
						infinity = true;
						break;
					}
					operands.push(ans);
				}
				out.println(infinity ? "Infinity." : operands.pop());
			}
		}
		file.close();
		out.close();
	}
	
	boolean infinityRes;
	
	public int solve(char operator, int num2, int num1) {
		infinityRes = false;
		switch(operator) {
		case '+': {
			return num1 + num2;
		}
		case '-': {
			return num1 - num2;
		}
		case '*': {
			return num1 * num2;
		}
		case '/': {
			if(num2 == 0) {
				infinityRes = true;
				return 0;
			}
			return num1 / num2;
		}
		}
		return 0;
	}
	
	public boolean precedence(char operator1, char operator2) {
		if(operator2 == '(' || operator2 == ')') {
			return false;
		} else if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-')) {
			return false;
		}
		return true;
	}
}
