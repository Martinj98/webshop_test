package webshop.soap;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class TestService {
	public int func(String name, int bedrag, String adres) {
		int lastNumber = 0;
		String filename = "C:\\Users\\Lucca.LAPTOP-PKB9NQVU\\EclipseProjects\\webshop\\webshop\\src\\main\\java\\webshop\\soap\\number.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				lastNumber = Integer.parseInt(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter writer;
		try {
			writer = new PrintWriter(filename);
			writer.print("");
			int nextNumber = lastNumber + 1;
			writer.print(nextNumber);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			TimeUnit.SECONDS.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return lastNumber;
	}
}
