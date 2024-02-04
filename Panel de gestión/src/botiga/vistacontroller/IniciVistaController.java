package botiga.vistacontroller;

import botiga.model.ProductesDAO;
import botiga.persona.PersonaDao;
import botiga.persona.ProveidorDAO;

public class IniciVistaController {

	public static void main(String[] args) {

		ProductesDAO productesDAO = new ProductesDAO();
		PersonaDao personaDao = new PersonaDao();
		ProveidorDAO proveidorDAO = new ProveidorDAO();
		ProductesVistaController VistaProductos = new ProductesVistaController(productesDAO);
		ClientVistaController Vistaclientes = new ClientVistaController(personaDao);
		ProveidorVistaController Vistaproveidor = new ProveidorVistaController(proveidorDAO);

		int opcion = 0;

		do {
			System.out.println("0. Salir");
			System.out.println("1. Productes");
			System.out.println("2. Clients");
			System.out.println("3. Proveidors");

			opcion = UtilConsole.demanarInt("Opció:");
			if (opcion == 1) {
				VistaProductos.menu();
			} else if (opcion == 2) {
				Vistaclientes.menu();
			} else if (opcion == 3) {
				Vistaproveidor.menu();
			}

		} while (opcion != 0);
	}
	
}
