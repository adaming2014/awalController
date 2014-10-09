/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.controller;

import fr.adaming.awal.controller.interfaces.IDeviceController;
import fr.adaming.awal.dao.interfaces.IDeviceDao;
import fr.adaming.awal.entity.Client;
import fr.adaming.awal.entity.Device;
import java.util.List;

/**
 *
 * @author INTI0227
 */
public class DeviceController extends Controller<IDeviceDao, Device, Integer> implements IDeviceController {

    @Override
    public List<Device> getDevicesByClient(Client client) {
        return dao.getDevicesByClient(client);
    }
}
