/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.controller;

import fr.adaming.awal.controller.interfaces.IAddressController;
import fr.adaming.awal.entity.Address;

/**
 *
 * @author INTI0227
 */
public class AddressController extends Controller<Address> implements IAddressController {

    public AddressController() {
        super(Address.class);
    }
}
