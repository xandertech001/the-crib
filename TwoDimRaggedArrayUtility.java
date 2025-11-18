

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public final class TwoDimRaggedArrayUtility {

	public TwoDimRaggedArrayUtility() {
	}

	public static double[][] readFile(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);

		// Temporary array with max size
		String[][] temp = new String[10][10];
		int rowCount = 0;

		while (scanner.hasNextLine() && rowCount < 10) {
			String line = scanner.nextLine().trim();
			if (!line.isEmpty()) {
				String[] elements = line.split(" ");
				for (int i = 0; i < elements.length && i < 10; i++) {
					temp[rowCount][i] = elements[i];
				}
				rowCount++;
			}
		}
		scanner.close();

		if (rowCount == 0)
			return null; // empty file case

		double[][] data = new double[rowCount][];

		for (int r = 0; r < rowCount; r++) {
			int colCount = 0;
			while (colCount < 10 && temp[r][colCount] != null) {
				colCount++;
			}

			data[r] = new double[colCount];

			for (int c = 0; c < colCount; c++) {
				data[r][c] = Double.parseDouble(temp[r][c]);
			}
		}

		return data;
	}

	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(outputFile);

		for (double[] row : data) {
			for (int c = 0; c < row.length; c++) {
				writer.print(row[c]);
				if (c < row.length - 1)
					writer.print(" ");
			}
			writer.println();
		}

		writer.close();
	}

	public static double getTotal(double[][] data) {
		double total = 0;
		for (double[] row : data) {
			for (double val : row) {
				total += val;
			}
		}
		return total;
	}

	public static double getAverage(double[][] data) {
		double total = 0;
		int count = 0;

		for (double[] row : data) {
			for (double val : row) {
				total += val;
				count++;
			}
		}
		return total / count;
	}

	public static double getRowTotal(double[][] data, int row) {
	    double total = 0;
	    for (double val : data[row]) {
	        total += val;
	    }
	    return total;
	}

	public static double getColumnTotal(double[][] data, int col) {
		double total = 0;

		for (double[] row : data) {
			if (col < row.length) {
				total += row[col];
			}
		}
		return total;
	}

	public static double getHighestInRow(double[][] data, int row) {
		double highest = data[row][0];
		for (double val : data[row]) {
			if (val > highest)
				highest = val;
		}
		return highest;
	}

	public static int getHighestInRowIndex(double[][] data, int row) {
		int index = 0;
		for (int c = 1; c < data[row].length; c++) {
			if (data[row][c] > data[row][index])
				index = c;
		}
		return index;
	}

	public static double getLowestInRow(double[][] data, int row) {
		double lowest = data[row][0];
		for (double val : data[row]) {
			if (val < lowest)
				lowest = val;
		}
		return lowest;
	}

	public static int getLowestInRowIndex(double[][] data, int row) {
		int index = 0;
		for (int c = 1; c < data[row].length; c++) {
			if (data[row][c] < data[row][index])
				index = c;
		}
		return index;
	}

	public static double getHighestInColumn(double[][] data, int col) {
		boolean firstFound = false;
		double highest = 0;

		for (double[] row : data) {
			if (col < row.length) {
				if (!firstFound) {
					highest = row[col];
					firstFound = true;
				} else if (row[col] > highest) {
					highest = row[col];
				}
			}
		}
		return highest;
	}

	public static int getHighestInColumnIndex(double[][] data, int col) {
		int index = -1;
		double highest = 0;
		boolean firstFound = false;

		for (int r = 0; r < data.length; r++) {
			if (col < data[r].length) {
				if (!firstFound) {
					highest = data[r][col];
					index = r;
					firstFound = true;
				} else if (data[r][col] > highest) {
					highest = data[r][col];
					index = r;
				}
			}
		}
		return index;
	}

	public static double getLowestInColumn(double[][] data, int col) {
		boolean firstFound = false;
		double lowest = 0;

		for (double[] row : data) {
			if (col < row.length) {
				if (!firstFound) {
					lowest = row[col];
					firstFound = true;
				} else if (row[col] < lowest) {
					lowest = row[col];
				}
			}
		}
		return lowest;
	}

	public static int getLowestInColumnIndex(double[][] data, int col) {
		int index = -1;
		double lowest = 0;
		boolean firstFound = false;

		for (int r = 0; r < data.length; r++) {
			if (col < data[r].length) {
				if (!firstFound) {
					lowest = data[r][col];
					index = r;
					firstFound = true;
				} else if (data[r][col] < lowest) {
					lowest = data[r][col];
					index = r;
				}
			}
		}
		return index;
	}

	public static double getHighestInArray(double[][] data) {
		double highest = data[0][0];
		for (double[] row : data) {
			for (double val : row) {
				if (val > highest)
					highest = val;
			}
		}
		return highest;
	}

	public static double getLowestInArray(double[][] data) {
		double lowest = data[0][0];
		for (double[] row : data) {
			for (double val : row) {
				if (val < lowest)
					lowest = val;
			}
		}
		return lowest;
	}
}
