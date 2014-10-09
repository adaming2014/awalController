/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.controller;

import fr.adaming.awal.controller.interfaces.IAdminController;
import fr.adaming.awal.dao.interfaces.IAdminDao;
import fr.adaming.awal.entity.Admin;

/**
 *
 * @author INTI0227
 */
public class AdminController extends Controller<IAdminDao, Admin, Integer> implements IAdminController {

}
