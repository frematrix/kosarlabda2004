package kosarlabda2004;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoProgramKosarlabda {

	public static void main(String[] args) {
		
		List<Merkozes> merkozesek = new ArrayList<Merkozes>();
		FajlkezeloKosarlabda fajlkezelObj = new FajlkezeloKosarlabda();
		merkozesek = fajlkezelObj.beolvasas("eredmenyek.csv", ";");
		
		realMadrid(merkozesek);
		
		dontetlen(merkozesek);
		
		barcelonaiCsapatNeve(merkozesek);
		
		datumSzerintiMerkozesek(merkozesek);
		
		sokMerkozesHelyszine(merkozesek);

	}

	private static void sokMerkozesHelyszine(List<Merkozes> merkozesek) {
		
		Map<String, Integer> sokMerkozes = new HashMap<String, Integer>();
		
		for (Merkozes merkozes : merkozesek) {
			
			if (sokMerkozes.containsKey(merkozes.getHelyszin())) {
				sokMerkozes.replace(merkozes.getHelyszin(), sokMerkozes.get(merkozes.getHelyszin())+1);
			}
			else {
				sokMerkozes.put(merkozes.getHelyszin(), 1);
			}
		}
		
		System.out.println("7. feladat: ");
		
		for (Map.Entry<String, Integer> item : sokMerkozes.entrySet()) {
			
			if (item.getValue()>=20) {
				System.out.println(item.getKey() + ": " + item.getValue());
			}
			
		}
		
	}

	private static void datumSzerintiMerkozesek(List<Merkozes> merkozesek) {
		
		System.out.println("6. feladat: ");
		
		List<Merkozes> datumosMerkozesek = new ArrayList<Merkozes>();
		
		LocalDate datum = LocalDate.parse("2004-11-21");
		
		for (int i = 0; i < merkozesek.size(); i++) {
			
			if (merkozesek.get(i).getIdopont().isEqual(datum)) {
				
				datumosMerkozesek.add(merkozesek.get(i));
				
			}
			
		}
		for (Merkozes merkozes : datumosMerkozesek) {
			
			System.out.println(merkozes.getHazai()+"-"+merkozes.getIdegen()+" ("+merkozes.getHazai_pont()+
					":"+merkozes.getIdegen_pont()+")");
		}
		
		
		
	}

	private static void barcelonaiCsapatNeve(List<Merkozes> merkozesek) {
		
		String csapatNeve = null;
		for (int i = 0; i < merkozesek.size(); i++) {
			
			if (merkozesek.get(i).getHazai().contains("Barcelona")) {
				csapatNeve = merkozesek.get(i).getHazai();
			}
		}
		System.out.println("\n5. feladat: barcelonai csapat neve: " + csapatNeve);
	}

	private static void dontetlen(List<Merkozes> merkozesek) {
		
		boolean dontetlen = false;
		for (int i = 0; i < merkozesek.size(); i++) {
			
			if (merkozesek.get(i).getHazai_pont()==merkozesek.get(i).getIdegen_pont()) {
				dontetlen = true;
			}
			else {
				dontetlen = false;
			}
		}
		System.out.print("4. feladat: Volt döntetlen? ");
		System.out.print(dontetlen==true?"igen":"nem");
		
	}

	private static void realMadrid(List<Merkozes> merkozesek) {
		
		int hazai = 0;
		int idegen = 0;
		
		for (int i = 0; i < merkozesek.size(); i++) {
			
			if (merkozesek.get(i).getHazai().equals("Real Madrid")) {
			
				hazai++;
			}
			else if (merkozesek.get(i).getIdegen().equals("Real Madrid")) {
				
				idegen++;
			}
			
		}
		
		System.out.println("3. feladat: Real Madrid: Hazai: " + hazai + ", Idegen: " + idegen);
	}

}
