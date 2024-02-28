package DAO.implementation;

import DAO.BD;
import DAO.IDao;
import modelo.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class OdontologoIDAOH2 implements IDao<Odontologo> {

    //conectamos logger
    private static Logger LOGGER = Logger.getLogger(OdontologoIDAOH2.class);

    //creamos el string del crud
    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGO (matricula, nombre, apellido) VALUES (?, ?, ?)";

    private static final String SQL_SELECT = "SELECT * FROM ODONTOLOGO WHERE id = ?";

    private static final String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGO";

    //sobrescribimos los metodos
    @Override
    public Odontologo guardar(Odontologo odontologo) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        //levantamos el driver el driver y contactarnos
        try {
            connection = BD.getConnection();


            //2 crear una sentencia
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT,
                    Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, odontologo.getMatricula());
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3,odontologo.getAppellido());
            LOGGER.info("Odontologo: " + odontologo.getNombre() + " " + odontologo.getAppellido() + " con Matricula: " + odontologo.getMatricula() + "se ingreso correctamente ");

            //ejecutar la sentencia
            psInsert.executeUpdate();


        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public Odontologo buscar(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologo odontologo = null;

        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }

        //1 levantar el driver y contactarnos
        try {
            connection = BD.getConnection();


            //2 crear una sentencia
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            preparedStatement.setLong(1, id);


            //ejecutar la sentencia
            ResultSet resultadoBuscar = preparedStatement.executeQuery();

            //4 evaluar los resultados
            while (resultadoBuscar.next()){
                Integer idOdontologo = resultadoBuscar.getInt("id");
                String matricula = resultadoBuscar.getString("matricula");
                String nombre = resultadoBuscar.getString("nombre");
                String apellido = resultadoBuscar.getString("apellido");
                odontologo = new Odontologo();
                odontologo.setId(idOdontologo);
                odontologo.setMatricula(matricula);
                odontologo.setNombre(nombre);
                odontologo.setAppellido(apellido);
                LOGGER.info(" Se encontro al Odontologo: " + odontologo.getNombre() + " " + odontologo.getAppellido() + " con Matricula: " + odontologo.getMatricula());

            }
        } catch (Exception e) {
            LOGGER.error("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologo> odontologos = new ArrayList();

        //1 levantar el driver y contactarnos
        try {
            connection = BD.getConnection();

            //2 crear una sentencia
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);

            //ejecutar la sentencia
            ResultSet resultadoBuscarTodos = preparedStatement.executeQuery();

            //4 evaluar los resultados
            while (resultadoBuscarTodos.next()){
                Integer idOdontologo = resultadoBuscarTodos.getInt("id");
                String matricula = resultadoBuscarTodos.getString("matricula");
                String nombre = resultadoBuscarTodos.getString("nombre");
                String apellido = resultadoBuscarTodos.getString("apellido");

                Odontologo odontologo = new Odontologo();
                odontologo.setId(idOdontologo);
                odontologo.setMatricula(matricula);
                odontologo.setNombre(nombre);
                odontologo.setAppellido(apellido);

                odontologos.add(odontologo);
                LOGGER.info("Se encontraron " + odontologo.getMatricula());
            }

        } catch (Exception e) {
            LOGGER.error("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return odontologos;
    }

}
