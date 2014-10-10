/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.controller;

import fr.adaming.awal.controller.interfaces.IClientController;
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
    IClientDao clientDao;
    IRepairerDao repairerDao;
    IResellerDao resellerDao;
    IAdminDao adminDao;
            
    @Override
    public User getByEmail(String email) {
        return dao.getByEmail(email);
    }

    @Override
    public IUser getUserTypeByUserId(Integer id) {
        
        Client client = clientDao.getClientByUserId(id);
        Repairer repairer = repairerDao.getRepairerByUserId(id);
        Reseller reseller = resellerDao.getResellerByUSerId(id);
        Admin admin = adminDao.getAdminByUserId(id);
        if(null != client)
            return client;
        if(null != admin)
            return admin;
        if(null!=repairer)
            return repairer;
        if(null!=reseller)
            return reseller;
        return null;  
    
    }
    
}
