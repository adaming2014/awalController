/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.controller;


import fr.adaming.awal.controller.interfaces.IUserController;

import fr.adaming.awal.dao.interfaces.IAdminDao;
import fr.adaming.awal.dao.interfaces.IClientDao;
import fr.adaming.awal.dao.interfaces.IRepairerDao;
import fr.adaming.awal.dao.interfaces.IResellerDao;
import fr.adaming.awal.dao.interfaces.IUserDao;
import fr.adaming.awal.entity.Admin;
import fr.adaming.awal.entity.Client;
import fr.adaming.awal.entity.Repairer;
import fr.adaming.awal.entity.Reseller;
import fr.adaming.awal.entity.User;
import fr.adaming.awal.entity.interfaces.IUser;

/**
 *
 * @author INTI0227
 */
public class UserController extends Controller<IUserDao, User, Integer> implements IUserController {

    protected IClientDao clientDao;
    protected IRepairerDao repairerDao;
    protected IResellerDao resellerDao;
    protected IAdminDao adminDao;

    @Override
    public User getByEmail(String email) {
        return dao.getByEmail(email);
    }

    @Override
    public IUser getUserTypeByUserId(Integer id) {
        Client client = clientDao.getClientByUserId(id);
        if (null != client) {
            return client;
        }

        Admin admin = adminDao.getAdminByUserId(id);
        if (null != admin) {
            return admin;
        }

        Repairer repairer = repairerDao.getRepairerByUserId(id);
        if (null != repairer) {
            return repairer;
        }

        Reseller reseller = resellerDao.getResellerByUSerId(id);
        if (null != reseller) {
            return reseller;
        }

        return null;
    }

    public IClientDao getClientDao() {
        return  clientDao;
    }

    public void setClientDao(IClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public IRepairerDao getRepairerDao() {
        return repairerDao;
    }

    public void setRepairerDao(IRepairerDao repairerDao) {
        this.repairerDao = repairerDao;
    }

    public IResellerDao getResellerDao() {
        return resellerDao;
    }

    public void setResellerDao(IResellerDao resellerDao) {
        this.resellerDao = resellerDao;
    }

    public IAdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(IAdminDao adminDao) {
        this.adminDao = adminDao;
    }
    

}
