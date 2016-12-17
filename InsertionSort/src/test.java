

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.*;

public class test {

	/**
	 * @param args
	 */
	@SuppressWarnings("null")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// reading command line input file into buffered reader
			BufferedReader buf = new BufferedReader(new FileReader(args[0]));
			ArrayList<String> numbers = new ArrayList<String>();
			String Fetchedlines = null;
			String[] numbersArray;
			Double temp;
			while (true) {
				// Reading line from buffered reader
				Fetchedlines = buf.readLine();
				// Break when it reaches EOF
				if (Fetchedlines == null) {
					break;
				} else {
					// adding numbers separated by comma to array
					numbersArray = Fetchedlines.split(";");
					// Adding numbers to arraylist
					for (String each : numbersArray) {
						if (!"".equals(each)) {
							numbers.add(each);
						}
					}
				}
			}
			// creating an output file
			PrintWriter out = new PrintWriter(new FileWriter("answers.txt"));

			System.out.println("testttt");
			String x, y;
			// Insertion sort on arraylist
			for (int i = 1; i < numbers.size(); i++) {
				for (int j = i; j > 0; j--) {
					// Comparing the values by parsing to float variables
					if (Double.parseDouble(numbers.get(j)) < Double
							.parseDouble(numbers.get(j - 1))) {
						// swapping the values if key element is greater
						x = numbers.get(j);
						y = numbers.get(j - 1);
						numbers.set(j, y);
						numbers.set(j - 1, x);

					}
				}
			}
			int length = numbers.size();

			// concatenating all the numbers except the last number with ';'

			for (int i = 0; i < numbers.size(); i++) {

				if (length - i == 1) {
					out.print(numbers.get(i));
				} else {
					out.print(numbers.get(i) + "; ");
				}

			}
			// closing the buffered reader and print writer
			out.close();
			buf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}