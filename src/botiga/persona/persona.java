package botiga.persona;

import java.time.LocalDate;
import java.util.Objects;

public abstract class persona {

	private static int contadorId = -1;
	private int idpersona;
	private String dni;
	private String nom;
	private String cognom;
	private LocalDate dataNaixement;
	private String telefon;
	private String email;
	private Adreca adreca;

	public persona() {
		this.idpersona = ++contadorId;
	}

	public persona(String dni, String nom, String cognom, LocalDate dataNaixement, String telefon, String email,
			Adreca adreca) {
		this();
		this.dni = dni;
		this.nom = nom;
		this.cognom = cognom;
		this.dataNaixement = dataNaixement;
		this.telefon = telefon;
		this.email = email;
		this.adreca = adreca;
	}

	public static int getContadorId() {
		return contadorId;
	}

	public static void setContadorId(int contadorId) {
		persona.contadorId = contadorId;
	}

	public int getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom() {
		return cognom;
	}

	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	public LocalDate getDataNaixement() {
		return dataNaixement;
	}

	public void setDataNaixement(LocalDate dataNaixement) {
		this.dataNaixement = dataNaixement;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Adreca getAdreca() {
		return adreca;
	}

	public void setAdreca(Adreca adreca) {
		this.adreca = adreca;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adreca, cognom, dataNaixement, dni, email, idpersona, nom, telefon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		persona other = (persona) obj;
		return Objects.equals(adreca, other.adreca) && Objects.equals(cognom, other.cognom)
				&& Objects.equals(dataNaixement, other.dataNaixement) && Objects.equals(dni, other.dni)
				&& Objects.equals(email, other.email) && idpersona == other.idpersona && Objects.equals(nom, other.nom)
				&& Objects.equals(telefon, other.telefon);
	}

	@Override
	public String toString() {
		return "idpersona=" + idpersona + ", dni=" + dni + ", nom=" + nom + ", cognom=" + cognom
				+ ", dataNaixement=" + dataNaixement + ", telefon=" + telefon + ", email=" + email + ", adreca="
				+ adreca+ " ";
	}

}
