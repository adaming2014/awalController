/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.controller;

import fr.adaming.awal.controller.interfaces.IUserController;
import fr.adaming.awal.entity.User;

/**
 *
 * @author INTI0227
 */
public class UserController extends Controller<User> implements IUserController {

    public UserController() {
        super(User.class);
    }
}
