/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.controller;

import fr.adaming.awal.controller.interfaces.IClientController;
import fr.adaming.awal.dao.interfaces.IClientDao;
import fr.adaming.awal.entity.Client;
import fr.adaming.awal.entity.Firm;
import java.util.List;

/**
 *
 * @author INTI0227
 */
public class ClientController extends Controller<IClientDao, Client, Integer> implements IClientController {

    @Override
    public Client getClientByMail(String mail) {
        return dao.getClientByMail(mail);
    }

    @Override
    public List<Client> getClientsByFirm(Firm firm) {
        return dao.getClientsByFirm(firm);
    }
}
