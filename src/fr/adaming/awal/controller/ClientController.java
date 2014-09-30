/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.controller;

import fr.adaming.awal.controller.interfaces.IControllerClient;
import fr.adaming.awal.entity.Client;
import java.util.List;

/**
 *
 * @author INTI0227
 */
public class ClientController extends Controller<Client>{

    public ClientController() {
        super(Client.class);
    }

}
