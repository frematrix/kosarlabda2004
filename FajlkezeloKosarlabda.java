package kosarlabda2004;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FajlkezeloKosarlabda {

	public List<Merkozes> beolvasas(String fajl, String elvalaszto) {
		
		List<Merkozes> beolvasottMerkozesek = new ArrayList<Merkozes>();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajl), "UTF-8"));
			
			br.readLine();
			
			while (br.ready()) {
				
				String[] csvSor = br.readLine().split(elvalaszto);
				
				Merkozes ujMerkozes = new Merkozes(
						csvSor[0], 
						csvSor[1], 
						Byte.parseByte(csvSor[2]), 
						Byte.parseByte(csvSor[3]), 
						csvSor[4], 
						LocalDate.parse(csvSor[5]));
				
				beolvasottMerkozesek.add(ujMerkozes);
				
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("A fájl nem található.");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("A fájlban olvashatatlan karakterek szerepelnek.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("I/O hiba!");
			e.printStackTrace();
		}
		
	
		
		return beolvasottMerkozesek;
		
		
		
	}
	
	

}
