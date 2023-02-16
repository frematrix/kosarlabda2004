package kosarlabda2004;

import java.time.LocalDate;

public class Merkozes {
	
	private String hazai;
	private String idegen;
	private byte hazai_pont;
	private byte idegen_pont;
	private String helyszin;
	private LocalDate idopont;
	
	public Merkozes(String hazai, String idegen, byte hazai_pont, byte idegen_pont, String helyszin,
			LocalDate idopont) {
		this.hazai = hazai;
		this.idegen = idegen;
		this.hazai_pont = hazai_pont;
		this.idegen_pont = idegen_pont;
		this.helyszin = helyszin;
		this.idopont = idopont;
	}

	public String getHazai() {
		return hazai;
	}

	public String getIdegen() {
		return idegen;
	}

	public byte getHazai_pont() {
		return hazai_pont;
	}

	public byte getIdegen_pont() {
		return idegen_pont;
	}

	public String getHelyszin() {
		return helyszin;
	}

	public LocalDate getIdopont() {
		return idopont;
	}

	

}
