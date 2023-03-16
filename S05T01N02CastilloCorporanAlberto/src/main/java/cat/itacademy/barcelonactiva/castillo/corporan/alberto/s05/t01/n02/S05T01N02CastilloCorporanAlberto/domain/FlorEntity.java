package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "flor")
//@ApiModel("Model User")
public class FlorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pk_florID;

	@Column(name = "Nombre", nullable = false, length = 45)
	@NotEmpty()
	private String nomFlor;

	@Column(name = "Pais", nullable = false, length = 45)
	@NotEmpty()
	private String paisFlor;

	public FlorEntity(String nomFlor, String paisFlor) {
		this.nomFlor = nomFlor;
		this.paisFlor = paisFlor;
	}

	public FlorEntity() {

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

	@Override
	public String toString() {
		return "FlorEntity [pk_florID=" + pk_florID + ", nomFlor=" + nomFlor + ", paisFlor=" + paisFlor + "]";
	}

}
