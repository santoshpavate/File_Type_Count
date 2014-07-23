import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class DirectoryRead {

	public String extension;
	private HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

	private int count = 0;
	private int serialNo = 0;

	public HashMap<Integer, ArrayList<String>> reader(File directory) {
		count = 0;
		ArrayList<String> temp = new ArrayList<String>();

		for (File file : directory.listFiles()) {
			temp = new ArrayList<String>();

			if (file.isFile() && file.getName().endsWith(extension)) {
				// Module Name
				temp.add(file.getParent().substring(
						file.getParent().lastIndexOf("\\") + 1,
						file.getParent().length()));

				// File Name
				temp.add(file.getName());

				// File Type
				temp.add(extension);

				// File Path
				temp.add(file.getAbsolutePath());

				// Number of files read in the same directory
				temp.add(String.valueOf(++count));

				map.put(serialNo++, temp);
			}

			if (file.isDirectory()) {
				reader(file);
			}
		}
		return map;
	}
}
