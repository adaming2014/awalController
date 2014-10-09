/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.controller;

import fr.adaming.awal.controller.interfaces.IController;
import fr.adaming.awal.dao.interfaces.IDao;
import fr.adaming.awal.entity.interfaces.IEntity;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author INTI0227
 * @param <D>
 * @param <T>
 * @param <I>
 */
public class Controller<D extends IDao<T, I>, T extends IEntity<I>, I extends Serializable> implements IController<T, I> {

    protected D dao;

    @Override
    public List<T> getAll() {
        return dao.getAll();

    }

    @Override
    public boolean create(T t) {
        dao.makePersistent(t);
        return true;
    }

    @Override
    public boolean update(T t) {
        dao.makePersistent(t);
        return true;
    }

    @Override
    public boolean delete(T t) {
        dao.makeTransient(t);
        return true;
    }

    @Override
    public boolean delete(I i) {
        dao.makeTransient(dao.getById(i));
        return true;
    }

    @Override
    public T getById(I i) {
        return dao.getById(i);
    }

    public Controller() {
    }

    public D getDao() {
        return dao;
    }

    public void setDao(D dao) {
        this.dao = dao;
    }

}
