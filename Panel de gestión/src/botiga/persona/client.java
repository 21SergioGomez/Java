package botiga.persona;

import java.time.LocalDate;

public class client extends persona {

	private boolean enviarPublicitat;

	public client() {
		
	}
	
	public client(String dni, String nom, String cognom, LocalDate dataNaixement, String telefon, String email, Adreca adreca, boolean enviarPublicitat) {
		super(dni, nom, cognom, dataNaixement, telefon, email, adreca);
		this.enviarPublicitat = enviarPublicitat;
	}

	public boolean isEnviarPublicitat() {
		return enviarPublicitat;
	}

	public void setEnviarPublicitat(boolean enviarPublicitat) {
		this.enviarPublicitat = enviarPublicitat;
	}

	@Override
	public String toString() {
		return  "Client "+super.toString() + " ,enviarPublicitat=" + enviarPublicitat;
	}

}