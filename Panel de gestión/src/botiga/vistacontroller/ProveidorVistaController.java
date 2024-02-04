package botiga.vistacontroller;

import java.time.LocalDate;
import java.util.Scanner;

import botiga.persona.Adreca;
import botiga.persona.PersonaDao;
import botiga.persona.ProveidorDAO;
import botiga.persona.client;
import botiga.persona.persona;
import botiga.persona.proveidor;

public class ProveidorVistaController {

	private ProveidorDAO proveidorDAO;

	public ProveidorVistaController(ProveidorDAO proveidorDAO) {
		this.proveidorDAO = proveidorDAO;
	}

	public void menu() {
		Scanner scanner = new Scanner(System.in);

		int opcion = 0;

		do {
			System.out.println("");
			System.out.println("Proveidors");
			System.out.println("=======");
			System.out.println("0. Tornar");
			System.out.println("1. Afegir proveidor");
			System.out.println("2. Buscar proveidor");
			System.out.println("3. Modificar proveidor");
			System.out.println("4. Esborrar proveidor");
			System.out.println("5. Mostrar tots els proveidor");
			opcion = UtilConsole.demanarInt("Opció:");
			if (opcion == 1) {

				String nom = UtilConsole.demanarString("Nom:");
				String cognom = UtilConsole.demanarString("Cognom:");
				String dni = UtilConsole.demanarDNI("DNI:");
				LocalDate fecha = UtilConsole.demanarLocalDate("Data naixement:");
				String telefon = UtilConsole.demanarTelefonMobil("Telefon:");
				String email = UtilConsole.demanarEmail("Email:");
				Adreca adreca = UtilConsole.pediradreca();
				Double dtoProntoPago = UtilConsole.demanarDouble("Dto?");
				
				proveidor proveedor = new proveidor(dni, nom, cognom, fecha, telefon, email, adreca, dtoProntoPago);
				
				proveidorDAO.guardar(proveedor);

			} else if (opcion == 2) {
				int idpersona = UtilConsole.demanarInt("ID Persona:");
				persona persona = proveidorDAO.buscar(idpersona);
				if (persona != null) {
					System.out.println(persona);
				} else {
					System.out.println("Proveidor inexistent");
				}
			} else if (opcion == 3) {
				int idpersona = UtilConsole.demanarInt("ID proveedor:");
				persona persona = proveidorDAO.buscar(idpersona);
				if (persona != null) {
					System.out.println("Dades actuals:");
					System.out.println(persona);
					
					String nom = UtilConsole.demanarString("Nom:");
					String cognom = UtilConsole.demanarString("Cognom:");
					String dni = UtilConsole.demanarDNI("DNI:");
					LocalDate fecha = UtilConsole.demanarLocalDate("Data naixement:");
					String telefon = UtilConsole.demanarTelefonMobil("Telefon:");
					String email = UtilConsole.demanarEmail("Email:");
					String poblacion = UtilConsole.demanarString("Poblacion:");
					String provincia = UtilConsole.demanarString("Provincia:");
					String cp = UtilConsole.demanarString("CP:");
					String domicili = UtilConsole.demanarString("Domicili:");
					Double dtoProntoPago = UtilConsole.demanarDouble("Dto?");
					
					persona.setNom(nom);
					persona.setCognom(cognom);
					persona.setDni(dni);
					persona.setDataNaixement(fecha);
					persona.setTelefon(telefon);
					persona.setEmail(email);
					persona.getAdreca().setPoblacio(poblacion);
					persona.getAdreca().setProvincia(provincia);
					persona.getAdreca().setCp(cp);
					persona.getAdreca().setDomicili(domicili);
					((proveidor)persona).setDtoProntoPago(dtoProntoPago);;
					
					System.out.println("Proveedor actualitzat.");
					
					System.out.println(persona);
				} else {
					System.out.println("Proveidor inexistent");
				}
			} else if (opcion == 4) {
				int idpersona = UtilConsole.demanarInt("ID Persona:");
				if (proveidorDAO.esborrar(idpersona) != null) {
					System.out.println("Proveidor esborrat correctament");
				} else {
					System.out.println("Proveidor inexistent");
				}
			} else if (opcion == 5) {
				mostrarClientes();
			}
		} while (opcion != 0);
	}

	private void mostrarClientes() {
		for (proveidor proveidors : proveidorDAO.getProveidor().values()) {
			System.out.println(proveidors);
		}
	}

}
