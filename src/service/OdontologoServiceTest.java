package service;

import DAO.BD;
import modelo.Odontologo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {

    private OdontologoService odontologoService;

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

        //assertNotNull(avionRecuperado);
        assertEquals(odontologo.getMatricula(), odontologoRecuperado.getMatricula());
        assertEquals(odontologo.getNombre(), odontologoRecuperado.getNombre());
        assertEquals(odontologo.getAppellido(),odontologoRecuperado.getAppellido());
    }

    @Test
    public void testBuscarTodos() {
        // Agregar algunos aviones a la base de datos
        Odontologo odontologo1 = new Odontologo("123456", "Sebastian","Arellano");
        Odontologo odontologo2 = new Odontologo("Airbus", "A320", "y7890", new java.sql.Date(new java.util.Date().getTime()));
        odontologoService.guardar(odontologo1);
        odontologoService.guardar(odontologo2);

        // Buscar todos los aviones y verificar si se recuperaron correctamente
        List<Odontologo> aviones = odontologoService.buscarTodos();

        assertNotNull(aviones);
        assertEquals(2, ((List<?>) aviones).size());
    }
