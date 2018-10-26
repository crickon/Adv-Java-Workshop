/*
 * HackBI Advanced Java and GUI workshop
 * 
 * File Reading and Writing
 * Author: Matthew Grillo (@crickon)
 * Date: October 26, 2018
 */
import java.io.*;

public class FileReading {
	private final static String path = "hackbi.txt";

	public static void main(String[] args) {
		/*
		 * Part 1: File Reading
		 */
		partOne();
		
		/*
		 * Part 2: File Writing
		 */
		//partTwo();
	}

	private static void partOne() {
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			// Exception produced if the path does not lead to a file.
			e.printStackTrace();
			System.exit(0);
		}

		try {
			String line = input.readLine();
			while (line != null) {
				System.out.println(line);
				line = input.readLine();
			}
			// Once all of the lines have been read the reader is useless, so close it.
			input.close();
		} catch (IOException e) {
			// Exception produced if the reader gets interrupted in it's process.
			e.printStackTrace();
		}
	}

	private static void partTwo() {
		Writer writer = null;
		try {
			// First Parameter is the files location (will be created if it doesn't exist).
			// Second Parameter is for appending onto a file (false overwrites the file).
			writer = new FileWriter(path, true);
		} catch (IOException e) {
			System.exit(0);
		}
		// A PrintWriter allows you to use print methods to add text to the file.
		PrintWriter output = new PrintWriter(writer);
		output.println("Now we have added to the end of the file.");
		
		// Always close the PrintWriter, or what is printed will not be written onto the file.
		output.close();
	}
}
