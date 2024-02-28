import DAO.BD;
import modelo.Odontologo;
import service.OdontologoService;

public class Main {
    public static void main(String[] args) {
        OdontologoService odontologoService = new OdontologoService();
        BD.createTable();

        Odontologo odontologo = new Odontologo("123456","Luca","Glass");
        Odontologo odontologo1 = new Odontologo("987654", "Sebastian", "Arellano");
        odontologoService.guardar(odontologo);
        odontologoService.guardar(odontologo1);
        odontologoService.buscar(1);
        odontologoService.buscarTodos();
    }
}
