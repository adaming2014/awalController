/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.controller;

import fr.adaming.awal.controller.interfaces.IRepairerController;
import fr.adaming.awal.dao.interfaces.IRepairerDao;
import fr.adaming.awal.entity.Repairer;

/**
 *
 * @author INTI0227
 */
public class RepairerController extends Controller<IRepairerDao, Repairer> implements IRepairerController {

    public RepairerController() {
        super(Repairer.class);
    }
}
