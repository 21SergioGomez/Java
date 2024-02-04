package botiga.vistacontroller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import botiga.model.Pack;
import botiga.model.ProducteAbstract;
import botiga.persona.Adreca;
import botiga.persona.PersonaDao;
import botiga.persona.client;
import botiga.persona.persona;

public class ClientVistaController {

	private PersonaDao personaDAO;

	public ClientVistaController(PersonaDao personaDAO) {
		this.personaDAO = personaDAO;
	}

	public void menu() {
		Scanner scanner = new Scanner(System.in);

		int opcion = 0;

		do {
			System.out.println("");
			System.out.println("Clients");
			System.out.println("=======");
			System.out.println("0. Tornar");
			System.out.println("1. Afegir client");
			System.out.println("2. Buscar client");
			System.out.println("3. Modificar client");
			System.out.println("4. Esborrar client");
			System.out.println("5. Mostrar tots els clients");
			opcion = UtilConsole.demanarInt("Opció:");
			if (opcion == 1) {

				String nom = UtilConsole.demanarString("Nom:");
				String cognom = UtilConsole.demanarString("Cognom:");
				String dni = UtilConsole.demanarDNI("DNI:");
				LocalDate fecha = UtilConsole.demanarLocalDate("Data naixement:");
				String telefon = UtilConsole.demanarTelefonMobil("Telefon:");
				String email = UtilConsole.demanarEmail("Email:");
				Adreca adreca = UtilConsole.pediradreca();
				Boolean publicitat = UtilConsole.demanarBoolean("Vols publicitat");

				client persona = new client(dni, nom, cognom, fecha, telefon, email, adreca, publicitat);

				personaDAO.guardar(persona);
			} else if (opcion == 2) {
				int idpersona = UtilConsole.demanarInt("ID Persona:");
				persona persona = personaDAO.buscar(idpersona);
				if (persona != null) {
					System.out.println(persona);
				} else {
					System.out.println("Client inexistent");
				}
			} else if (opcion == 3) {
				int idpersona = UtilConsole.demanarInt("ID Persona:");
				persona persona = personaDAO.buscar(idpersona);
				if (persona != null) {
					System.out.println("Dades actuals:");
					System.out.println(persona);
					
					String nom = UtilConsole.demanarString("Nou nom:");
					String cognom = UtilConsole.demanarString("Nou cognom:");
					String dni = UtilConsole.demanarDNI("Nou DNI:");
					LocalDate fecha = UtilConsole.demanarLocalDate("Nou data naixement:");
					String telefon = UtilConsole.demanarTelefonMobil("Nou telefon:");
					String email = UtilConsole.demanarEmail("Nou email:");
					String poblacion = UtilConsole.demanarString("Nou poblacion:");
					String provincia = UtilConsole.demanarString("Nou provincia:");
					String cp = UtilConsole.demanarString("Nou CP:");
					String domicili = UtilConsole.demanarString("Nou domicili:");
					Boolean publicitat = UtilConsole.demanarBoolean("Nou vols publicitat");
					
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
					((client)persona).setEnviarPublicitat(publicitat);
					
					System.out.println("Client actualitzat.");
					
					System.out.println(persona);
					
				} else {
					System.out.println("Client inexistent");
				}
			} else if (opcion == 4) {
				int idpersona = UtilConsole.demanarInt("ID Persona:");
				if (personaDAO.esborrar(idpersona) != null) {
					System.out.println("Client esborrat correctament");
				} else {
					System.out.println("Client inexistent");
				}
			} else if (opcion == 5) {
				mostrarClientes();
			}
		} while (opcion != 0);
	}

	private void mostrarClientes() {
		for (client clientes : personaDAO.getPersonas().values()) {
			System.out.println(clientes);
		}
	}

}
