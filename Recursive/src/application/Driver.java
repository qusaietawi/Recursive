package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Driver extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Create UI elements
		Label resultLabel = new Label("Result will be displayed here");

		// GCD section
		Label gcdLabel = new Label("GCD Calculation");
		TextField gcdInput1 = new TextField();
		gcdInput1.setPromptText("Enter first number");
		TextField gcdInput2 = new TextField();
		gcdInput2.setPromptText("Enter second number");
		Button gcdButton = new Button("Calculate GCD");

		// Reverse String section
		Label reverseLabel = new Label("Reverse String");
		TextField reverseInput = new TextField();
		reverseInput.setPromptText("Enter string to reverse");
		Button reverseButton = new Button("Reverse String");

		// Binary Search section
		Label binarySearchLabel = new Label("Binary Search");
		TextField arrayInput = new TextField();
		arrayInput.setPromptText("Enter comma-separated array (e.g., 1, 2, 3, 4)");
		TextField binarySearchInput = new TextField();
		binarySearchInput.setPromptText("Enter number to search");
		Button binarySearchButton = new Button("Binary Search");

		// Sum of Digits section
		Label sumDigitsLabel = new Label("Sum of Digits");
		TextField sumDigitsInput = new TextField();
		sumDigitsInput.setPromptText("Enter number");
		Button sumDigitsButton = new Button("Sum Digits");

		// Clear button to reset inputs and result
		Button clearButton = new Button("Clear");

		// Result label
		resultLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

		// GCD Button Action
		gcdButton.setOnAction(e -> {
			try {
				int num1 = Integer.parseInt(gcdInput1.getText());
				int num2 = Integer.parseInt(gcdInput2.getText());
				if (num1 < 0 || num2 < 0) {
					resultLabel.setText("Please enter positive numbers.");
				} else {
					int result = GCD.gcd(num1, num2);
					resultLabel.setText("The GCD of " + num1 + " and " + num2 + " is: " + result);
				}
			} catch (NumberFormatException ex) {
				resultLabel.setText("Please enter valid integers for GCD.");
			}
		});

		// Reverse String Button Action
		reverseButton.setOnAction(e -> {
			String word = reverseInput.getText();
			if (word.isEmpty()) {
				resultLabel.setText("Please enter a valid string.");
			} else {
				String reversed = ReverseString.reverse(word);
				resultLabel.setText("Reversed string: " + reversed);
			}
		});

		// Binary Search Button Action
		binarySearchButton.setOnAction(e -> {
			try {
				String[] inputArray = arrayInput.getText().split(",");
				int[] array = new int[inputArray.length];
				for (int i = 0; i < inputArray.length; i++) {
					array[i] = Integer.parseInt(inputArray[i].trim());
				}
				int target = Integer.parseInt(binarySearchInput.getText());
				int result = BinarySearch.binarySearch(array, target, 0, array.length - 1);
				if (result != -1) {
					resultLabel.setText("Target found at index: " + result);
				} else {
					resultLabel.setText("Target not found.");
				}
			} catch (NumberFormatException ex) {
				resultLabel.setText("Please enter valid integers for array and target.");
			}
		});

		// Sum Digits Button Action
		sumDigitsButton.setOnAction(e -> {
			try {
				int number = Integer.parseInt(sumDigitsInput.getText());
				if (number < 0) {
					resultLabel.setText("Please enter a positive number.");
				} else {
					int sum = SumDigits.sumDigits(number);
					resultLabel.setText("Sum of digits: " + sum);
				}
			} catch (NumberFormatException ex) {
				resultLabel.setText("Please enter a valid number.");
			}
		});

		// Clear button action
		clearButton.setOnAction(e -> {
			gcdInput1.clear();
			gcdInput2.clear();
			reverseInput.clear();
			arrayInput.clear();
			binarySearchInput.clear();
			sumDigitsInput.clear();
			resultLabel.setText("Result will be displayed here");
		});

		// Layout
		VBox gcdLayout = new VBox(10, gcdLabel, gcdInput1, gcdInput2, gcdButton);
		VBox reverseLayout = new VBox(10, reverseLabel, reverseInput, reverseButton);
		VBox binarySearchLayout = new VBox(10, binarySearchLabel, arrayInput, binarySearchInput, binarySearchButton);
		VBox sumDigitsLayout = new VBox(10, sumDigitsLabel, sumDigitsInput, sumDigitsButton);

		// Main layout
		VBox mainLayout = new VBox(20, gcdLayout, reverseLayout, binarySearchLayout, sumDigitsLayout, clearButton,
				resultLabel);
		mainLayout.setStyle("-fx-padding: 10px;");

		Scene scene = new Scene(mainLayout, 500, 600);
		primaryStage.setTitle("Enhanced Utility Methods");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
