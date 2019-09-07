package root;

import java.util.ArrayList;
import java.util.Hashtable;
import automaton.Automaton;
import services.FileService;

public class Main {

	public static void main(String[] args) {
		// Auxiliar instances
		Automaton automaton = new Automaton();
		FileService fileService = new FileService();
		
		// Valiables used in directory and filenames menagement
		String sourceFileName = (args.length < 1) ? "prog.txt" : args[0];
		String outputFileName = (args.length < 1) ? "prog-check.txt" : fileService.externalFileName(args[0]);
		String filesDirectory = fileService.getFileDirectory(args.length < 1);

		ArrayList<String> arrlstWords = fileService.readLines(filesDirectory + sourceFileName);

		Hashtable<String, Boolean> validatedWords = automaton.validate(arrlstWords);

		// Building file lines
		for (int i = 0; i < validatedWords.size(); i++) {
			String validatedWord = arrlstWords.get(i);
			String validation = (validatedWords.get(validatedWord)) ? "OK" : "Inválido";
			arrlstWords.set(i, validatedWord + " - " + validation + "\n");
		}

		String path = fileService.getOutputFileDirectory() + outputFileName;

		if (fileService.writeInterspersedLines(arrlstWords, path)) {
			System.out.println("\n\nYour file was successfully create on: \n\t" + path);
			System.out.println("\n(Refresh the project if you are not seeing the file)");
		}
				
	}
}
