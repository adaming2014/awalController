/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.controller;

import fr.adaming.awal.controller.interfaces.IFirmController;
import fr.adaming.awal.dao.interfaces.IFirmDao;
import fr.adaming.awal.entity.Firm;

/**
 *
 * @author INTI0227
 */
public class FirmController extends Controller<IFirmDao, Firm, Integer> implements IFirmController {

}
