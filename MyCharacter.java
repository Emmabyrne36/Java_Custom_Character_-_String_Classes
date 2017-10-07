public class MyCharacter {
	// Returns true if ch is a lowercase character ('a' to 'z'); false otherwise.
	public static boolean isLowerCase(char ch) {
		if (ch >= 'a' && ch <= 'z'){
			return true;
		} else {
			return false;
		}
	}

	// Returns true if ch is an uppercase character ('A' to 'Z'); false otherwise.
	public static boolean isUpperCase(char ch) {
		if (ch >= 'A' && ch <= 'Z'){
			return true;
		} else {
			return false;
		}
	}

	// Returns true if ch is a digit ('0' to '9'); false otherwise.
	public static boolean isDigit(char ch) {
		if (ch >= '0' && ch <= '9'){
			return true;
		} else {
			return false;
		}
	}

	// Returns true if ch is a space (' ') or tab ('\t') character; false otherwise.
	public static boolean isWhitespace(char ch){
		if (ch == ' ' || ch == '\t'){
			return true;
		} else {
			return false;
		}
	}

	// Returns the lowercase equivalent of ch, if any; otherwise, ch itself is returned.
	public static char toLowerCase(char ch) {
		//Re-using the method above isUppercase
		// If a character is uppercase, convert to lowercase by adding 32 to it - 32 is the difference (in ASCII) between an uppercase letter and its corresponding lowercase letter
		if (isUpperCase(ch)){
			int ch2 = ch;
			ch2 += 32;
			return (char)ch2;
		} else {
			return ch;
		}
	}

	// Returns the uppercase equivalent of ch, if any; otherwise, ch itself is returned.
	//Using class made above
	public static char toUpperCase(char ch) {
		// If a character is lowercase, convert to lowercase by subtracting 32 to it - 32 is the difference (in ASCII) between an lowercase letter and its corresponding uppercase letter
		if (isLowerCase(ch)){
			int ch2 = ch;
			ch2 -= 32;
			return (char)ch2;
		} else {
			return ch;
		}
	}
}