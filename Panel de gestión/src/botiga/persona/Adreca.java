package botiga.persona;

import java.util.Objects;

public class Adreca {
	private String poblacio;
	private String provincia;
	private String cp;
	private String domicili;
	
	public Adreca() {
		super();
	}
	
	public Adreca(String poblacio, String provincia, String cp, String domicili) {
		super();
		this.poblacio = poblacio;
		this.provincia = provincia;
		this.cp = cp;
		this.domicili = domicili;
	}

	public String getPoblacio() {
		return poblacio;
	}

	public void setPoblacio(String poblacio) {
		this.poblacio = poblacio;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getDomicili() {
		return domicili;
	}

	public void setDomicili(String domicili) {
		this.domicili = domicili;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cp, domicili, poblacio, provincia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adreca other = (Adreca) obj;
		return Objects.equals(cp, other.cp) && Objects.equals(domicili, other.domicili)
				&& Objects.equals(poblacio, other.poblacio) && Objects.equals(provincia, other.provincia);
	}

	@Override
	public String toString() {
		return " poblacio=" + poblacio + ", provincia=" + provincia + ", cp=" + cp + ", domicili=" + domicili + " ";
	}
	
	
}
