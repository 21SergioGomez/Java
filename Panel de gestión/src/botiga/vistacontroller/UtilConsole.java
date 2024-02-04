package botiga.vistacontroller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import botiga.model.ProducteAbstract;
import botiga.persona.Adreca;

public class UtilConsole {

	static Scanner sc = new Scanner(System.in);

	public static int demanarInt(String etiqueta) {
		int entero = 0;
		boolean isEntero = false;

		do {
			System.out.print(etiqueta);
			if (sc.hasNextInt()) {
				entero = Integer.parseInt(sc.nextLine());
				isEntero = true;
			} else {
				// para saltar el valor introducido (que no es entero)
				sc.nextLine();
			}
		} while (!isEntero);

		return entero;
	}

	public static double demanarDouble(String etiqueta) {
		double decimal = 0;
		boolean isDouble = false;

		do {
			System.out.print(etiqueta);
			if (sc.hasNextDouble()) {
				// decimal = Double.parseDouble(sc.nextLine()); peta per numberFormatException
				// OPCIO 1 decimal =
				// NumberFormat.getInstance().parse(sc.nextLine()).doubleValue();
				// OPCIO 2
				decimal = sc.nextDouble();
				sc.nextLine(); // limpiar el \n
				isDouble = true;
			} else {
				// para saltar el valor introducido (que no es entero)
				sc.nextLine();
			}
		} while (!isDouble);

		return decimal;
	}

	public static String demanarString(String etiqueta) {
		String cadena = "";
		boolean isString = false;

		do {
			System.out.print(etiqueta);
			if (sc.hasNext()) {
				cadena = sc.nextLine();
				isString = true;
			} else {
				// para saltar el valor introducido (que no es String)
				sc.nextLine();
			}
		} while (!isString);

		return cadena;
	}

	public static String demanarDNI(String etiqueta) {
		String dni;
		boolean dniOK = false;
		do {
			dni = demanarString(etiqueta);
			dniOK = validarDNI(dni);
		} while (!dniOK);

		return dni;
	}

	private static boolean validarDNI(String dni) {
		String lletres = "TRWAGMYFPDXBNJZSQVHLCKET";

		if (dni.matches("[0-9]{7,8}[A-Z a-z]")) {
			int numDNI = Integer.parseInt(dni.substring(0, dni.length() - 1));
			char lletraDNI = dni.charAt(dni.length() - 1);
			int mod = numDNI % 23;
			if (lletres.charAt(mod) == lletraDNI)
				return true;
		}

		return false;
	}

	public static LocalDate demanarLocalDate(String etiqueta) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		String dataString = "";
		LocalDate data = null;
		boolean isDate = false;

		do {
			dataString = demanarString(etiqueta);
			try {
				data = LocalDate.parse(dataString, dtf);
				isDate = true;
			} catch (DateTimeParseException e) {
				System.out.println("Fecha incorrecta, formato correcto dd/mm/aaaa");
				System.out.println(e.getMessage());
			}

		} while (!isDate);

		return data;
	}

	public static String demanarEmail(String etiqueta) {
		// https://howtodoinjava.com/java/regex/java-regex-validate-email-address/
		String email;
		do {
			email = demanarString(etiqueta);
		} while (!email.matches("^(.+)@(.+)$"));

		return email;
	}

	public static String demanarTelefonMobil(String etiqueta) {
		String telefon;
		do {
			telefon = demanarString(etiqueta);
		} while (!telefon.matches("[6-7][0-9]{8}"));

		return telefon;
	}

	public static String demanarCP(String etiqueta) {
		String cp;
		do {
			cp = demanarString(etiqueta);
		} while (!cp.matches("[0-9]{5}"));

		return cp;
	}

	public static boolean demanarBoolean(String etiqueta) {
		boolean resultado = false;
		boolean entradaValida = false;

		do {
			System.out.print(etiqueta + " (Sí/S/true o No/N/false): ");
			String entrada = sc.nextLine().trim().toLowerCase();

			if (entrada.equals("si") || entrada.equals("s") || entrada.equals("true")) {
				resultado = true;
				entradaValida = true;
			} else if (entrada.equals("no") || entrada.equals("n") || entrada.equals("false")) {
				resultado = false;
				entradaValida = true;
			} else {
				System.out.println("Entrada inválida. Introduce 'Sí'/'S'/'true' o 'No'/'N'/'false'.");
			}
		} while (!entradaValida);

		return resultado;
	}

	public static Adreca pediradreca() {

		String poblacion = UtilConsole.demanarString("Poblacion:");
		String provincia = UtilConsole.demanarString("Provincia:");
		String cp = UtilConsole.demanarString("CP:");
		String domicili = UtilConsole.demanarString("Domicili:");
		Adreca adreca = new Adreca(poblacion, provincia, cp, domicili);
		return adreca;
	}
}
