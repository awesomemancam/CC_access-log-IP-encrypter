package net.ivarcode.camden;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Encrypter {

	private static String currentDirectory = new File("").getAbsolutePath();
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException { 
		BufferedReader reader = null;
		PrintWriter writer = null;
		int[] nummap = {6, 7, 3, 2, 9, 0, 1, 4, 5, 8};
		
		reader = new BufferedReader(new FileReader(currentDirectory + "\\src\\net\\ivarcode\\camden\\Public-access_log"));
		writer = new PrintWriter(new FileWriter(currentDirectory + "\\src\\net\\ivarcode\\camden\\output-access_log"));
		
		String currLine = "";
		while ((currLine = reader.readLine()) != null) {
			String[] line = currLine.split("\\s+");
			String IP = line[0];
			char[] arr = IP.toCharArray();
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == '.') {
					writer.print(".");
				} else {
					int num = arr[j]-48;
					writer.print(nummap[num]);
				}
			}
			for (int k = 1; k < line.length; k++) {
				writer.print(" "+line[k]);
			}
			writer.println();
		}
		
		
		
		
		/*
		
		
		headerIn = new BufferedReader(new FileReader(gitDir + "\\ivarcode.github.io\\html\\header.html"));
		while ((currentLine = headerIn.readLine()) != null) {
			headerFile.add(currentLine);
		}
		footerIn = new BufferedReader(new FileReader(gitDir + "\\ivarcode.github.io\\html\\footer.html"));
		while ((currentLine = footerIn.readLine()) != null) {
			footerFile.add(currentLine);
		}

		for (i = 0; i < files.length; i++) {
			reader = new BufferedReader(new FileReader(gitDir + "\\ivarcode.github.io\\html\\" + files[i]));
			ArrayList<String> currFile = new ArrayList<String>();
			while ((currentLine = reader.readLine()) != null) {
				currFile.add(currentLine);
			}
			
			writer = new PrintWriter(new FileWriter(gitDir + "\\ivarcode.github.io\\html\\" + files[i]));
			for (j = 0; j < currFile.size(); j++) {
				currentLine = null;
				if (currFile.get(j).equals("			<!--HEADER-->")) {
					for (k = 0; k < headerFile.size(); k++) {
						writer.println(headerFile.get(k));
						writer.flush();
						System.out.println(headerFile.get(k));
					}
				} else if (currFile.get(j).equals("		<!--FOOTER-->")) {
					for (k = 0; k < footerFile.size(); k++) {
						writer.println(footerFile.get(k));
						writer.flush();
						System.out.println(footerFile.get(k));
					}
				} else {
					writer.println(currFile.get(j));
					writer.flush();
					System.out.println(currFile.get(j));
				}
			}
		}*/
		
	}
	
}
