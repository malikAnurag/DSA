package assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Bracket {
	Bracket(char type, int position) {
		this.type = type;
		this.position = position;
	}

	boolean Match(char c) {
		if (this.type == '[' && c == ']')
			return true;
		if (this.type == '{' && c == '}')
			return true;
		if (this.type == '(' && c == ')')
			return true;
		return false;
	}

	char type;
	int position;
}

class check_brackets {
	public static void main(String[] args) throws IOException {
		InputStreamReader input_stream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input_stream);
		String text = reader.readLine();
		boolean isValid = true;

		Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
		for (int position = 0; position < text.length(); ++position) {
			char next = text.charAt(position);
			Bracket bracket = new Bracket(next, position + 1);

			if (next == '(' || next == '[' || next == '{') {
				if(position == text.length()-1) {
					System.out.println(position+1);
					isValid = false;
					break;
				}
				
				opening_brackets_stack.push(bracket);
			}

			if (next == ')' || next == ']' || next == '}') {

				if (opening_brackets_stack.isEmpty()) {
					System.out.println(position + 1);
					isValid = false;
					break;
				} else if (!opening_brackets_stack.pop().Match(next)) {
					System.out.println(position + 1);
					isValid = false;
					break;
				}
			}
		}

		if (opening_brackets_stack.isEmpty() && isValid)
			System.out.println("Success");
		
		if(!opening_brackets_stack.isEmpty() && isValid) {
			Bracket bracket = opening_brackets_stack.pop();
			if(bracket.type == '(' || bracket.type == '{' || bracket.type == '[') {
				System.out.println(bracket.position);
			}
		}
		
	}
}
