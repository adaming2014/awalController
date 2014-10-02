/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.controller;

import fr.adaming.awal.controller.interfaces.IClientController;
import fr.adaming.awal.dao.interfaces.IClientDao;
import fr.adaming.awal.entity.Client;

/**
 *
 * @author INTI0227
 */
public class ClientController extends Controller<IClientDao, Client> implements IClientController {

    public ClientController() {
        super(Client.class);
    }

    @Override
    public Client getClientByMail(String mail) {
        return dao.getClientByMail(mail);
    }
}
