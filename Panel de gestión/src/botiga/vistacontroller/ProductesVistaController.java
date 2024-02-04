package botiga.vistacontroller;

import botiga.model.ProductesDAO;

import java.util.ArrayList;
import java.util.Scanner;

import botiga.model.Pack;
import botiga.model.Producte;
import botiga.model.ProducteAbstract;

public class ProductesVistaController {

	private ProductesDAO productesDAO;

	public ProductesVistaController(ProductesDAO productesDAO) {
		this.productesDAO = productesDAO;
	}

	public void menu() {
		Scanner scanner = new Scanner(System.in);

		int opcion = 0;

		do {
			System.out.println("");
			System.out.println("PRODUCTES");
			System.out.println("=======");
			System.out.println("0. Tornar");
			System.out.println("1. Afegir");
			System.out.println("2. Buscar");
			System.out.println("3. Modificar");
			System.out.println("4. Esborrar");
			System.out.println("5. Imprimir productes");
			opcion = UtilConsole.demanarInt("Opció:");
			if (opcion == 1) {
				afegir();
			} else if (opcion == 2) {
				int idproducte = UtilConsole.demanarInt("ID Producte:");
				ProducteAbstract prodAux = productesDAO.buscar(idproducte);
				if (prodAux != null) {
					System.out.println(prodAux);
				} else {
					System.out.println("Producte inexistent");
				}
			} else if (opcion == 3) {
				int idproducte = UtilConsole.demanarInt("ID Producte:");
				ProducteAbstract prodAux = productesDAO.buscar(idproducte);

				if (prodAux != null) {
					System.out.println("Dades actuals:");
					System.out.println(prodAux);

					String nom = UtilConsole.demanarString("Nom del producte o pack:");
					prodAux.setNom(nom);

					if (prodAux instanceof Producte) {
						double preuVenda = UtilConsole.demanarDouble("Preu venda:");
						int stock = UtilConsole.demanarInt("Stock:");

						((Producte) prodAux).setPreuVenda(preuVenda);
						((Producte) prodAux).setStock(stock);
					}
					else if (prodAux instanceof Pack) {
						double porcentajeDescuento = UtilConsole.demanarDouble("Percentatge descompte:");
						((Pack) prodAux).setPorcDto(porcentajeDescuento);
					}

					productesDAO.guardar(prodAux);
					System.out.println("Producte o pack modificat correctament");
				} else {
					System.out.println("Producte o pack inexistent");
				}
			} else if (opcion == 4) {
				int idproducte = UtilConsole.demanarInt("ID Producte:");
				if (productesDAO.esborrar(idproducte) != null) {
					System.out.println("Producte esborrat correctament");
				} else {
					System.out.println("Producte inexistent");
				}
			} else if (opcion == 5) {
				// productesDAO.mostrarTodos();
				mostrarProductes();
			}
		} while (opcion != 0);
	}

	private void mostrarProductes() {
		for (ProducteAbstract producte : productesDAO.getProductes().values()) {
			System.out.println(producte);
		}
	}

	private void afegir() {
		System.out.println("Que vol's afegir productes(1) o packs(2)?");
		int opcion = UtilConsole.demanarInt("Opció:");
		if (opcion == 1) {
			int idproducte = UtilConsole.demanarInt("ID Producte:");
			String nom = UtilConsole.demanarString("Nom del producte:");
			double preuVenda = UtilConsole.demanarDouble("Preu venda:");
			int stock = UtilConsole.demanarInt("Stock:");

			Producte producte = new Producte(idproducte, nom, preuVenda, stock);

			productesDAO.guardar(producte);
		} else if (opcion == 2) {
			int idproducte = UtilConsole.demanarInt("ID Pack:");
			String nom = UtilConsole.demanarString("Nom del pack:");
			ArrayList<String> nombresProductos = new ArrayList<>();
			String nombreProducto;
			do {
				nombreProducto = UtilConsole.demanarString("Nom del producte (o 0 per acabar):");
				if (!nombreProducto.equals("0")) {
					nombresProductos.add(nombreProducto);
				}
			} while (!nombreProducto.equals("0"));

			// Convertir los nombres de productos en objetos Producte
			ArrayList<Producte> productosDelPack = new ArrayList<>();
			for (String nombre : nombresProductos) {
				boolean productoEncontrado = false;
				for (ProducteAbstract producto : productesDAO.getProductes().values()) {
					if (producto instanceof Producte && ((Producte) producto).getNom().equals(nombre)) {
						productosDelPack.add((Producte) producto);
						productoEncontrado = true;
						break;
					}
				}
				if (!productoEncontrado) {
					System.out.println("El producte " + nombre + " no existeix. Introdueix un producte vàlid.");
					// Puedes decidir cómo manejar la situación en la que el producto no existe.
					// Puedes ignorar el producto o solicitar un nuevo nombre, según tus requisitos.
				}
			}

			double porcentajeDescuento = UtilConsole.demanarDouble("Percentatge descompte:");
			Pack pack = new Pack(idproducte, nom, productosDelPack, porcentajeDescuento);

			// Guardar el pack en el DAO
			productesDAO.guardar(pack);
		}
	}
}
