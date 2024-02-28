package test;

import DAO.BD;
import modelo.Odontologo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {

    private OdontologoService odontologoService;

    //iniciando y creando
    @BeforeEach
    public void setUp() {
        odontologoService = new OdontologoService();
        BD.createTable();
    }

    @Test
    public void testGuardarYBuscar() {
        Odontologo odontologo = new Odontologo("123456", "Sebastian","Arellano");
        odontologoService.guardar(odontologo);

        Odontologo odontologoRecuperado = odontologoService.buscar(1);

        assertEquals(odontologo.getMatricula(), odontologoRecuperado.getMatricula());
        assertEquals(odontologo.getNombre(), odontologoRecuperado.getNombre());
        assertEquals(odontologo.getAppellido(),odontologoRecuperado.getAppellido());
    }

    @Test
    public void testBuscarTodos() {
        // Agregar algunos odontologos a la base de datos
        Odontologo odontologo1 = new Odontologo("123456", "Sebastian","Arellano");
        Odontologo odontologo2 = new Odontologo("123456","Luca","Glass");
        odontologoService.guardar(odontologo1);
        odontologoService.guardar(odontologo2);

        // Buscar todos los odontologos y verificar si se recuperaron correctamente
        List<Odontologo> odontologos = odontologoService.buscarTodos();


        assertEquals(2, ((List<?>) odontologos).size());
    }
}
