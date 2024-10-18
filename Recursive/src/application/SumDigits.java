package application;

public class SumDigits {

	// Recursive method to sum the digits of a number
	public static int sumDigits(int num) {
		// Base case: if the number is a single digit, return it
		if (num < 10) {
			return num;
		}
		// Recursive case: sum the last digit with the sum of the rest
		return sumDigits(num / 10) + num % 10;
	}

	public static void main(String[] args) {
		int number = 1234; // Example number
		int sum = sumDigits(number); // Call the method to sum digits
		System.out.println("Sum of digits of " + number + " is: " + sum);
	}
}
