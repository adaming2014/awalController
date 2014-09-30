/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.controller.implementation;

import fr.adaming.awal.controller.interfaces.IController;
import fr.adaming.awal.dao.generiq.Dao;
import fr.adaming.awal.dao.interfaces.IDao;
import java.util.List;

/**
 *
 * @author INTI0227
 */
public class Controller<T> implements IController<T>{

    Class<T> entityclass;
    Dao dao;
    public Controller(Class<T> entityclass) {
        this.entityclass = entityclass;
    }

    
    @Override
    public List<T> getAll() {
        return dao.getAll();
        
    }

    @Override
    public boolean create(T t) {
        return dao.create(t);
    }

    @Override
    public boolean update(T t) {
        return dao.update(t);
    }

    @Override
    public boolean delete(T t) {
         return dao.delete(t);
    }

    @Override
    public boolean delete(int i) {
        return dao.delete(i);
    }

    @Override
    public T getById(int i) {
        return (T) dao.getById(i);
    }
    
}
