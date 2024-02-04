package botiga.model;

public final class Producte extends ProducteAbstract {
	
	private double preuVenda;
	private int stock;

	
	public Producte() {
		
	}

	public Producte(int idproducte, String nom, double preuVenda, int stock) {
		super(idproducte,nom);
		this.preuVenda = preuVenda;
		this.stock = stock;
	}

	public double getPreuVenda() {
		return preuVenda;
	}

	public void setPreuVenda(double preuVenda) {
		this.preuVenda = preuVenda;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producte " + super.toString() + ",preuVenda=" + preuVenda + ", stock=" + stock;
	}

}
