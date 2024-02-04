package botiga.persona;

import java.time.LocalDate;

public class proveidor extends persona {

	private double dtoProntoPago;

	public proveidor() {
		super();
	}

	public proveidor(String dni, String nom, String cognom, LocalDate dataNaixement, String telefon,	String email, Adreca adreca, double dtoProntoPago) {
		super(dni, nom, cognom, dataNaixement, telefon, email, adreca);
		this.dtoProntoPago = dtoProntoPago;
	}

	public double getDtoProntoPago() {
		return dtoProntoPago;
	}

	public void setDtoProntoPago(double dtoProntoPago) {
		this.dtoProntoPago = dtoProntoPago;
	}

	@Override
	public String toString() {
		return "Proveidor " + super.toString() + " ,dtoProntoPago=" + dtoProntoPago;
	}

}
