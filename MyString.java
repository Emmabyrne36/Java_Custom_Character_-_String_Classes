public class MyString {
	// Returns a new string with the characters in str converted to lowercase.
	public static String toLowerCase(String str) {
		// If a character in str is uppercase, convert to lowercase and add to str2
		// If a character is already lowercase just add to str2 without converting it
		String str2 = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(MyCharacter.isUpperCase(ch)){
				str2 += MyCharacter.toLowerCase(ch);
			} else {
				str2 += ch;
			}
		}
		return str2;
	}

	// Returns a new string with the characters in str converted to uppercase.
	public static String toUpperCase(String str) {
		String str2 = "";
		// If a character in str is lowercase, convert it to uppercase, add to str2
		// If a character is already uppercase, add it to str2 without converting
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(MyCharacter.isLowerCase(ch)){
				str2 += MyCharacter.toUpperCase(ch);				
			} else {
				str2 += ch;
			}
		}
		return str2;
	}



	// Returns true if the two strings s1 and s2 are equal; false otherwise. 
	// Two strings are considered equal if they are of the same length and 
	// corresponding characters in the two strings are equal.
	public static boolean equals(String s1, String s2) {
		String testString = "";
		// If the length of s1 isn't the same as s2, return false
		if (s1.length() != s2.length()) {
			return false;
		} else {
			// Iterate through both strings, if the characters are equal add to testString
			for (int i = 0; i < s1.length() && i < s2.length(); i++) {
				if (s1.charAt(i) == s2.charAt(i)) {
					testString += s1.charAt(i);
				} else {
					break;
				}
			}
		}

		// Checking if testString length is the same as the original strings, if it is, both strings are equal so return true
		if (testString.length() == s1.length() && testString.length() == s2.length()) {
			return true;
		}
		return false;
	}



	// Returns true if the two strings s1 and s2 are equal ignoring case; false 
	// otherwise. Two strings are considered equal if they are of the same length 
	// and corresponding characters in the two strings are equal ignoring case.
	public static boolean equalsIgnoreCase(String s1, String s2) {
		//Convert strings to lowercase, then compare if they are equal or not2
		// Using the toLowerCase method from above
		String s1Lowercase = toLowerCase(s1);
		String s2Lowercase = toLowerCase(s2);
		
		// Using the equals method from above, if the new lowercase strings are equal return true
		if (equals(s1Lowercase, s2Lowercase)) {
			return true;
		}
		return false;
	}

	// Returns a new string with every occurrence of character ch1 in str replaced 
	// with character ch2.	
	public static String replace(String str, char ch1, char ch2) {
		String strReplace = "";
		// Iterate through str, if a character is not equal to ch1, add it to strReplace, otherwise add ch2 to strReplace instead
		// This way every time ch1 appears, ch2 will be added to strReplace instead of it
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ch1) { 
				strReplace += str.charAt(i);
			} else {
				strReplace += ch2;
			}
		}
		return strReplace;
	}


	// Returns a new string with all leading and trailing whitespace characters (space 
	// or tab characters) in str removed.
	public static String trim(String str) {
		String newString = "";
		//Add the point at which it hits a character to an index, break, then make new loop and print from between those two points
		int startIndex = 0; // This will contain the index number of where the string starts - without whitespace
		int endIndex = 0; // This will contain the index number of where the string ends - the last letter in the string, not whitespace

		//To iterate through a string in reverse adapted from http://stackoverflow.com/questions/580269/reverse-iteration-through-arraylist-gives-indexoutofboundsexception
		// Iterate from right to left of str, if the character is whitespace, add one to endIndex, break otherwise
		for (int j = str.length() - 1; j >= 0; j--) { 
			char ch2 = str.charAt(j);
			if (MyCharacter.isWhitespace(ch2)) {
				endIndex += 1;
			} else {
				break;
			}
		}

		// Iterate through str normally, if a character is whitespace add one to startIndex, else break
		for (int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			if (MyCharacter.isWhitespace(ch)) {
				startIndex += 1;
			} else {
				break;
			}
		}

		// Now iterate through the original string from the two points where there is no whitespace, startIndex and endIndex
		// Add to a new string (newString) and this will be the original string but without leading or trailing whitespace
		for (int i = startIndex; i < str.length() - endIndex; i++) {
			char ch = str.charAt(i);
			newString += ch;
		}

		return newString;
	}


	// Returns true if str starts with the specified prefix; false otherwise.
	public static boolean startsWith(String str, String prefix) {
		String startsWithPrefix = "";

		// Iterate through str and prefix, if the characters are the same, add to startsWithPrefix
		for (int i = 0; i < str.length() && i < prefix.length(); i++) {
			if (str.charAt(i) == prefix.charAt(i)) {
				startsWithPrefix += str.charAt(i);
			} else {
				break;
			}
		}

		// Using the equals method from above, if the string startsWithPrefix equals prefix, return true
		if (equals(startsWithPrefix, prefix)){
			return true;
		}
		return false;
	}


	// Returns true if str ends with the specified suffix; false otherwise.
	public static boolean endsWith(String str, String suffix) {
		String testString = "";
		String newString = "";

		// Check if the length of the suffix is longer than the str, if it is then return false
		// If not, take away length of suffix from str - this is the point where we will iterate from in the for loop (this will be the suffix of str)
		int newLength = str.length() - suffix.length();
		if (str.length() < suffix.length()) {
			return false;			
		} else {
			//Iterate from newLength (the potential suffix of str) to the end of str, add to the string testString
			for (int i = newLength; i < str.length(); i++) {
				testString += str.charAt(i);
			}

			// Iterate through both testString and suffix and add any characters which are identical to the string newString	
			for (int i = 0; i < testString.length() && i < suffix.length(); i++) {
				if (testString.charAt(i) == suffix.charAt(i)) {
					newString += testString.charAt(i);
				} else {
					break;
				}
			}

			// Using the equals method from above, if newString does not equal the suffix, return false
			if (!equals(newString, suffix)) {
				return false;
			}
		}
		return true;
	}
}