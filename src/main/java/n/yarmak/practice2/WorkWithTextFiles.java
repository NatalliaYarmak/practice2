package n.yarmak.practice2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WorkWithTextFiles {
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		System.out.println("Please, enter parameters:");
		System.out.println("1) file name - mandatory parameter,");
		System.out.println("2) number of lines - optional parameter.");
		System.out.println("Whitespace is a delimiter.");
		String line = scanner.nextLine();
		String [] params = line.split(" ");
		String filePath = params[0];
		int lineNumber = 10;
		if (params.length > 1)
			try{
				lineNumber = Integer.parseInt(params[1]);
			}  catch (NumberFormatException e) {
				System.out.println("Number of lines cannot be parsed. Default value will used.");
			}
		scanner.close();
		readLinesFromFile(filePath, lineNumber);
	}
	
	public static void readLinesFromFile(String filePath, int lineNumber) {
		Scanner scanner;
		try {
			scanner = new Scanner (new File(filePath));
			int i = 0;
			while (scanner.hasNext() && i < lineNumber){
				i++;
				System.out.println(scanner.nextLine());		
			}
			if (i != lineNumber)
				System.out.println("File " + filePath + " contains less than " + lineNumber + " lines");
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File " + filePath + " is not found.");
		}
	}
}
