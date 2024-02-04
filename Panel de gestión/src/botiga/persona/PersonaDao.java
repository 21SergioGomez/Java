package botiga.persona;

import java.util.HashMap;

public class PersonaDao {

    private HashMap<Integer, client> personas = new HashMap<>();

    public client guardar(client persona) {
        personas.put(persona.getIdpersona(), persona);
        return persona;
    }

    public persona buscar(int idpersona) {
        return personas.get(idpersona);
    }

    public persona esborrar(int idpersona) {
        return personas.remove(idpersona);
    }

    public HashMap<Integer, client> getPersonas() {
        return personas;
    }
}

