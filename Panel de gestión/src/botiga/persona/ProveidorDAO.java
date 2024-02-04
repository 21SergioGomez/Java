package botiga.persona;

import java.util.HashMap;

public class ProveidorDAO {

	private HashMap<Integer, proveidor> proveidors = new HashMap<>();
	
	public proveidor guardar(proveidor proveidor) {
		proveidors.put(proveidor.getIdpersona(), proveidor);
		return proveidor;
	}
	
	public persona buscar (int idpersona) {
		return proveidors.get(idpersona);
	}
	
	public persona esborrar (int idpersona) {
		return proveidors.remove(idpersona);
	}
	
	public HashMap<Integer, proveidor> getProveidor() {
        return proveidors;
    }
}
