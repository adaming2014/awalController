/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.controller;

import fr.adaming.awal.controller.interfaces.IDeviceRepairController;
import fr.adaming.awal.dao.interfaces.IDeviceRepairDao;
import fr.adaming.awal.entity.Client;
import fr.adaming.awal.entity.Device;
import fr.adaming.awal.entity.Devicerepair;
import fr.adaming.awal.entity.Modelpackage;
import java.util.List;

/**
 *
 * @author INTI0227
 */
public class DeviceRepairController extends Controller<IDeviceRepairDao, Devicerepair, Integer> implements IDeviceRepairController {

    @Override
    public List<Devicerepair> getDevicesRepairByClient(final Client client) {
        return dao.getDevicesRepairByClient(client);
    }

    @Override
    public Devicerepair getByDeviceAndPackage(final Device device, final Modelpackage modelPackage) {
        return dao.getByDeviceAndPackage(device, modelPackage);
    }
}
