package DAO;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class BDTest {

    @Test
    void crearDB(){
        try {
            Class.forName("org.h2.Driver");
            Connection connection = DriverManager.getConnection("jdbc:h2:./BD_REGISTRO_ODONTOLOGO", "sa", "sa");
            String query = "DROP TABLE IF EXISTS ODONTOLOGO;" +
                    "CREATE TABLE ODONTOLOGO (" +
                    "ID INT AUTO_INCREMENT PRIMARY KEY," +
                    "MATRICULA VARCHAR(100) NOT NULL," +
                    "NOMBRE VARCHAR(100) NOT NULL," +
                    "APELLIDO VARCHAR(100) NOT NULL" +
                    ")";
            Statement statement = connection.createStatement();
            statement.execute(query);
            connection.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}