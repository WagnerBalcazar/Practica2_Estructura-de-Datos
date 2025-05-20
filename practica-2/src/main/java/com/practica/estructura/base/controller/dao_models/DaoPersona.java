package com.practica.estructura.base.controller.dao_models;
import com.practica.estructura.base.controller.dao.AdapterDao;
import com.practica.estructura.base.controller.dataStruct.list.LinkedList;

import com.practica.estructura.models.Persona;

public class DaoPersona extends AdapterDao<Persona> {
    private Persona obj;
     private LinkedList<Persona> listAll;

    public DaoPersona() {
        super(Persona.class);
        // TODO Auto-generated constructor stub
    }

    // getter and setter
    public Persona getObj() {
        if (obj == null) {
            this.obj = new Persona();

        }
        return this.obj;
    }

    public void setObj(Persona obj) {
        this.obj = obj;
    }

    public Boolean save() {
        try {
            obj.setId(listAll().getLength() + 1);
            this.persist(obj);
            return true;
        } catch (Exception e) {
            
            return false;
            // TODO: handle exception
        }
    }

    public Boolean update(Integer pos) {
        try {
            this.update(obj, pos);
            return true;
        } catch (Exception e) {
            
            return false;
            // TODO: handle exception
        }
    }

    public LinkedList<Persona> getlistAll() {
        if (listAll == null) {
            this.listAll = listAll(); 
            // se llama el metodo de el adapter Dao
        }
        return listAll;

    }


}