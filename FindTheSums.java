/*
* FindTheSums.java
* Author: Kellen Brown
* Statement of Academic Honesty: *
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from anywhere other than the authorized
* sources. I recognize that any unauthorized sharing, assistance,
* or plagiarism will be handled in accordance with both the
* University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based on
* an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing or posting
* of source code at any time for this project is prohibited. */
public class FindTheSums {

	public static String arrayToString(int[][] a) {
		String arrayString = "";
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				arrayString = j < a[i].length - 1 ? arrayString + a[i][j] + " " : arrayString + a[i][j];
			}
			if (i < a.length - 1) {
				arrayString += "\n";
			}
			
		}
		return arrayString;
	}
	
	public static int[][] horizontalSums(int[][] a, int sumToFind) {
		int[][] horizontalArray = new int[a.length][];
		int numColumns = 0;
		for (int i = 0; i < a.length; i++) {
			horizontalArray[i] = new int[a[i].length];
		}
	
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				horizontalArray[i][j] = 0;
				numColumns = a[i].length;
			}
		}
		int sum = 0;
		
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < numColumns; ++j) {
				int startIndex = j;
				for (int k = j; k < numColumns; k++) {
					sum += a[i][k];
					if (sum == sumToFind) {
						int endIndex = k;
						for (int l = startIndex; l <= endIndex; l++) {
							horizontalArray[i][l] = a[i][l];
						}
						startIndex = k + 1;
						sum = 0;
						}
					else if (sum > sumToFind) {
						sum = 0;
						startIndex = k + 1;
					}
					else if ((k == numColumns - 1) && sum != 0) {
						sum = 0;
					}
				}
			}
		}
		
		return horizontalArray;
	}
	
	public static int[][] verticalSums(int[][] a, int sumToFind) {
		int[][] verticalArray = new int[a.length][];
		int numColumns = 0;
		for (int i = 0; i < a.length; i++) {
			verticalArray[i] = new int[a[i].length];
		}
	
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				verticalArray[i][j] = 0;
				numColumns = a[i].length;
			}
		}
		int sum = 0;
		
		
		for (int i = 0; i < numColumns; i++) {
			for (int j = 0; j < a.length; ++j) {
				int startIndex = j;
				for (int k = j; k < a.length; k++) {
					sum += a[k][i];
					if (sum == sumToFind) {
						int endIndex = k;
						for (int l = startIndex; l <= endIndex; l++) {
							verticalArray[l][i] = a[l][i];
						}
						startIndex = k + 1;
						sum = 0;
						}
					else if (sum > sumToFind) {
						sum = 0;
						startIndex = k + 1;
					}
					else if ((k == a.length - 1) && sum != 0) {
						sum = 0;
					}
				}
			}
		}
		
		return verticalArray;
		
	}
	
	public static void main(String[] args) {
		
		
	}

}
