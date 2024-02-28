package DAO;

public class BD {

    private static final String SQL_CREATE_TEABE = "DROP IF EXISTS ODONTOLOGO,"+
            "CREATE TABLE ODONTOLOGO ("+
            "ID INT AUTO_INCREMENT PRIMARY KEY,"+
            "MATRICULA VARCHAR(100) NOT NULL,"+
            "NOMBRE VARCHAR(100) NOT NULL,"+
            "APELLIDO VARCHAR(100) NOT NULL"+
        ")";
}
