import DAO.IDao;
import modelo.Odontologo;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColeccionOdontologoDAO implements IDao {
    private Map<Integer, Odontologo> odontologos;

    public ColeccionOdontologoDAO() {
        this.odontologos = new HashMap<>();
    }




    @Override
    public Object guardar(Odontologo  odontologo) {
        odontologos.put(odontologo.G(), odontologo)
    }

    @Override
    public Object buscar(Integer id) {
        return null;
    }

    @Override
    public List buscarTodos() {
        return null;
    }
}
