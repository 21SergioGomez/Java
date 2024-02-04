package botiga.model;

import java.util.HashMap;

public class ProductesDAO {

	private HashMap<Integer, ProducteAbstract> productes = new HashMap<>();

	/**
	 * 
	 * @param producte
	 * @return the previous value associated with key, or null if there was no
	 *         mapping for key. (A null return can also indicate that the map
	 *         previously associated null with key.)
	 */
	public ProducteAbstract guardar(ProducteAbstract producte) {
		productes.put(producte.getIdproducte(), producte);
		return producte;
	}

	public ProducteAbstract buscar(int idproducte) {
		return productes.get(idproducte);
	}

	public ProducteAbstract esborrar(int idproducte) {
		return productes.remove(idproducte);
	}

	public HashMap<Integer, ProducteAbstract> getProductes() {
		return productes;
	}

}
