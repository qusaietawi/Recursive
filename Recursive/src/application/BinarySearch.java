package application;

public class BinarySearch {

	public static int binarySearch(int[] array, int target, int low, int high) {
		if (low > high) {
			return -1; // target not found
		}
		int mid = low + (high - low) / 2; // Avoid potential overflow
		if (array[mid] == target) {
			return mid; // target found
		} else if (array[mid] > target) {
			return binarySearch(array, target, low, mid - 1); // search in the left half
		} else {
			return binarySearch(array, target, mid + 1, high); // search in the right half
		}
	}

}
