package application;

public class ReverseString {

	// Recursive method to reverse a string
	public static String reverse(String word) {
		// Base case: if the string is empty, return it
		if (word.isEmpty()) {
			return word;
		}
		// Recursive case: call reverse on the substring and add the first character at
		// the end
		return reverse(word.substring(1)) + word.charAt(0);
	}

	public static void main(String[] args) {
		String word = "hello"; // Example string
		String reversed = reverse(word); // Call the reverse method

		System.out.println("Original: " + word);
		System.out.println("Reversed: " + reversed);
	}
}
