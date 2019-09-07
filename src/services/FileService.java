package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileService {

	public ArrayList<String> readLines(String filePath) {
		ArrayList<String> fileLines = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				fileLines.add(line);
			}
		} catch (Exception error) {
			System.out.println("Error: " + error.getMessage());
		}
		return fileLines;
	}

	public void writeLines(ArrayList<String> lines, String filePath) {
		try (FileWriter fw = new FileWriter(filePath)) {
			for (String line : lines) {
				fw.write(line);
			}
		} catch (Exception error) {
			System.out.println("Error: " + error.getMessage());
		}
	}

	public boolean writeInterspersedLines(ArrayList<String> lines, String filePath) {
		try (FileWriter fw = new FileWriter(filePath)) {
			File file = new File(filePath);
			file.createNewFile(); // if file already exists will do nothing
			
			for (String line : lines) {
				fw.write(line);
				fw.write("\n");
			}
			return true;
		} catch (Exception error) {
			System.out.println("Error: " + error.getMessage());
			return false;
		}
	}

	public String externalFileName(String input) {
		String output = "";
		String[] arrInp = input.split("[.]");
		if (arrInp.length > 2 || arrInp.length <= 0) {
			throw new RuntimeException("The file name received is invalid.\n\tInput received: " + input + "\n");
		} else {
			output = arrInp[0] + "-check." + arrInp[1];
		}
		return output;
	}

	public String getFileDirectory(boolean isNullArgs) {
		String filesDirectory = System.getProperty("user.dir");

		filesDirectory += (isNullArgs) ? "\\src\\files\\" : "\\files\\";

		return filesDirectory;
	}
	
	public String getOutputFileDirectory() {
		String filesDirectory = System.getProperty("user.dir");

		int idxOut = filesDirectory.indexOf("out");
		if(idxOut != -1) {
			filesDirectory = filesDirectory.substring(0,filesDirectory.indexOf("out"));			
		}
		filesDirectory += "\\src\\files\\" ;
		
		return filesDirectory;
	}
}
