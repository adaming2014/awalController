/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.controller;

import fr.adaming.awal.controller.interfaces.IResellerController;
import fr.adaming.awal.entity.Reseller;

/**
 *
 * @author INTI0227
 */
public class ResellerController extends Controller<Reseller> implements IResellerController {

    public ResellerController() {
        super(Reseller.class);
    }
}
