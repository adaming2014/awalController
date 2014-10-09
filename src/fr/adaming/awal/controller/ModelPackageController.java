/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.controller;

import fr.adaming.awal.controller.interfaces.IModelPackageController;
import fr.adaming.awal.dao.interfaces.IModelPackageDao;
import fr.adaming.awal.entity.Modele;
import fr.adaming.awal.entity.Modelpackage;
import java.util.List;

/**
 *
 * @author INTI0227
 */
public class ModelPackageController extends Controller<IModelPackageDao, Modelpackage, Integer> implements IModelPackageController {

    @Override
    public List<Modelpackage> getPackagesByModel(Modele model) {
        return dao.getPackagesByModel(model);
    }
}
