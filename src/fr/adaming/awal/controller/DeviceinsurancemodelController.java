/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.controller;

import fr.adaming.awal.controller.interfaces.IDeviceinsurancemodelController;
import fr.adaming.awal.dao.interfaces.IDeviceInsuranceModeleDao;
import fr.adaming.awal.entity.Deviceinsurancemodel;
import fr.adaming.awal.entity.Modele;
import java.util.List;

/**
 *
 * @author INTI0227
 */
public class DeviceinsurancemodelController 
extends Controller<IDeviceInsuranceModeleDao, Deviceinsurancemodel>
implements IDeviceinsurancemodelController{
    
    public DeviceinsurancemodelController(){
        super(Deviceinsurancemodel.class);
    }

    @Override
    public List<Deviceinsurancemodel> getDeviceInsuranceModelsByModel(Modele modele) {
        return dao.getDeviceInsuranceModelsByModel(modele);
    }
}
