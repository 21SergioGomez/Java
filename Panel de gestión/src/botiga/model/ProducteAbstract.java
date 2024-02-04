package botiga.model;

import java.util.Objects;

public abstract class ProducteAbstract {
	private int idproducte;
	private String nom;
	
	public ProducteAbstract() {
		
	}

	public ProducteAbstract(int idproducte, String nom) {
		this();
		this.idproducte= idproducte;
		this.nom = nom;
	}

	public int getIdproducte() {
		return idproducte;
	}

	public void setIdproducte(int idproducte) {
		this.idproducte = idproducte;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "idproducte=" + idproducte + ", nom=" + nom;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idproducte);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)	
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProducteAbstract other = (ProducteAbstract) obj;
		return idproducte == other.idproducte;
	}
	
}
