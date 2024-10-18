package application;

public class GCD {
	// Recursive method to calculate GCD
	public static int gcd(int a, int b) {
		// Base case: if b is 0, the GCD is a
		if (b == 0) {
			return a;
		}
		// Recursive case: call gcd with b and the remainder of a divided by b
		return gcd(b, a % b);
	}

	public static void main(String[] args) {
		int num1 = 56; // Example number 1
		int num2 = 98; // Example number 2

		int result = gcd(num1, num2); // Call the recursive GCD method

		System.out.println("The GCD of " + num1 + " and " + num2 + " is: " + result);
	}
}
