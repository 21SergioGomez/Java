package botiga.model;

import java.util.ArrayList;
import java.util.Objects;

public final class Pack extends ProducteAbstract {

    private ArrayList<Producte> productesDelPack = new ArrayList<>();
    
	private double porcDto;
	
	public Pack() {
		super();
	}

	public Pack(int idproducte,String nom, ArrayList<Producte> productesDelPack, double porcDto) {
		super(idproducte,nom);
		this.productesDelPack = productesDelPack;
		this.porcDto = porcDto;
	}

	public ArrayList<Producte> getProductesDelPack() {
		return productesDelPack;
	}

	public void setProductesDelPack(ArrayList<Producte> productesDelPack) {
		this.productesDelPack = productesDelPack;
	}

	public double getPorcDto() {
		return porcDto;
	}

	public void setPorcDto(double porcDto) {
		this.porcDto = porcDto;
	}
	
	public void afegirProducte(Producte producte) {
		productesDelPack.add(producte);
	}
	
	public void esborrarProducte(Producte producte) {
		productesDelPack.remove(producte);
	}

	@Override
	public String toString() {
		return "Pack "+ super.toString() +" " + productesDelPack + ", porcDto=" + porcDto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(productesDelPack);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pack other = (Pack) obj;
		return Objects.equals(productesDelPack, other.productesDelPack);
	}

}