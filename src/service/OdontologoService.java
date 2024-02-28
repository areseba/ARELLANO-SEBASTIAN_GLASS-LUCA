package service;

import DAO.IDao;

import DAO.implementation.OdontologoIDAOH2;
import modelo.Odontologo;

import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoIDao;

    //constructor y lo iniciamos
    public OdontologoService(){
        this.odontologoIDao = new OdontologoIDAOH2();
    }
    //creamos los metodos
    public Odontologo guardar(Odontologo odontologo){
        //delegar la responsabilidad de guardar al DAO
        return odontologoIDao.guardar(odontologo);
    }

    public Odontologo buscar(Integer id){
        //delegar la responsabilidad de buscar al DAO
        return odontologoIDao.buscar(id);
    }

    public List<Odontologo> buscarTodos(){
        //delegar la responsabilidad de buscar todos al DAO
        return odontologoIDao.buscarTodos();
    }

}


