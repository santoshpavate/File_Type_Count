import java.io.File;
import java.util.Scanner;

import com.filetypecount.file.DirectoryRead;
import com.filetypecount.file.JavaExcelWrite;

public class Implementation {
	File directory;
	DirectoryRead readDirectory = new DirectoryRead();

	public Implementation(String fileName) {
		directory = new File(fileName);
	}

	public void takeUserInput() {
		System.out
				.println("Enter the extension of the file to search in Directory:");
		Scanner scn = new Scanner(System.in);

		readDirectory.extension = scn.next();

		JavaExcelWrite write = new JavaExcelWrite(readDirectory.reader(directory));
		try {
			write.writeToFile();
			System.out.println("Please check the result file in D: drive");
		} catch (Exception e) {
			System.out.println("Unable to print to File.");
			e.printStackTrace();
		}
	}
}
