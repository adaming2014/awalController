/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.controller;

import fr.adaming.awal.controller.interfaces.IModelPackageController;
import fr.adaming.awal.entity.Modelpackage;

/**
 *
 * @author INTI0227
 */
public class ModelPackageController extends Controller<Modelpackage> implements IModelPackageController {

    public ModelPackageController() {
        super(Modelpackage.class);
    }
}
