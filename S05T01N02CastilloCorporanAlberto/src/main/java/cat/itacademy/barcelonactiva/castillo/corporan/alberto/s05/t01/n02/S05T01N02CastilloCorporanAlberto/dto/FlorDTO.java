package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlorDTO {
	private int pk_florID;
	private String nomFlor;
	private String paisFlor;
	private String tipusFlor;

	private List<String> listPais = new ArrayList<String>(Arrays.asList("Alemania", "Asutria", "Bélgica", "Chipre",
			"Croacia", "Dinamarca", "España", "Eslovaquia", "Eslovenia", "Estonia", "Firlandia", "Francia", "Grecia",
			"Hungría", "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta", "Países Bajos", "Polonia",
			"Portugal", "República Checa", "Rumania", "Suecia"));

	public FlorDTO(String nomFlor, String paisFlor) {
		this.nomFlor = nomFlor;
		this.paisFlor = paisFlor;
	}

	public FlorDTO() {

	}

	public String addTipus() {
		boolean encontrado = false;
		String resultado = null;

		for (String i : this.listPais) {

			if (i.equalsIgnoreCase(this.paisFlor)) {
				encontrado = true;

			}

		}

		if (encontrado) {

			resultado = "UE";
		} else {
			resultado = "Fora EU";
		}

		return resultado;
	}

	public int getPk_florID() {
		return pk_florID;
	}

	public void setPk_florID(int pk_florID) {
		this.pk_florID = pk_florID;
	}

	public String getNomFlor() {
		return nomFlor;
	}

	public void setNomFlor(String nomFlor) {
		this.nomFlor = nomFlor;
	}

	public String getPaisFlor() {
		return paisFlor;
	}

	public void setPaisFlor(String paisFlor) {
		this.paisFlor = paisFlor;
	}

	public String getTipusFlor() {
		return tipusFlor;
	}

	public void setTipusFlor(String tipusFlor) {
		this.tipusFlor = tipusFlor;
	}

	@Override
	public String toString() {
		return "FlorDTO [pk_florID=" + pk_florID + ", nomFlor=" + nomFlor + ", paisFlor=" + paisFlor + ", tipusFlor="
				+ tipusFlor + ", listPais=" + listPais + "]";
	}

}
