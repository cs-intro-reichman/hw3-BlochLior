/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String str1Processed = preProcess(str1);
		String tempStr2 = preProcess(str2);
		if (str1Processed.length() != tempStr2.length()) {
			return false;
		}

		// Outer loop - iterate every char in str1processed
		for (int i = 0; i < str1Processed.length(); i++) {
			char ch1 = str1Processed.charAt(i);
			int matchIdx = tempStr2.indexOf(ch1);
			if (matchIdx != -1) {
				String partBefore = tempStr2.substring(0, matchIdx);
				String partAfter = tempStr2.substring(matchIdx + 1);
				tempStr2 = partBefore + partAfter;
			} else {
				return false;
			}
			
		}

		return tempStr2.length() == 0;
	}
	   
	// remove specific idx value from string - for anagrams
	public static String removeFirstOccurence(String originalString, char charToRemove) {
		int charIdx = originalString.indexOf(charToRemove);
		if (charIdx == -1) {
			return originalString;
		}
		String partBefore = originalString.substring(0, charIdx);
		String partAfter = originalString.substring(charIdx+1);
		return partBefore + partAfter;
	}
	
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted.
	// For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String returnStr = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isLetter(ch)) {
				returnStr += Character.toLowerCase(ch);
			}
		}
		return returnStr;
	}

	
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String tempStr = str;
		String randomAnagram = "";
		while (tempStr.length() > 0) {
			int randomIdx = randomIdx(tempStr.length());
			char ch = tempStr.charAt(randomIdx);
			randomAnagram += ch;
			String partBefore = tempStr.substring(0, randomIdx);
			String partAfter = tempStr.substring(randomIdx+1);
			tempStr = partBefore + partAfter;
		}
		return randomAnagram;
	}

	// randomize idx of character, helper
	public static int randomIdx(int length) {
		return (int)(Math.random()*length);
	}
}
