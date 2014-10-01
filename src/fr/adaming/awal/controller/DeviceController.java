/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.controller;

import fr.adaming.awal.controller.interfaces.IDeviceController;
import fr.adaming.awal.dao.interfaces.IDeviceDao;
import fr.adaming.awal.entity.Device;

/**
 *
 * @author INTI0227
 */
public class DeviceController extends Controller<IDeviceDao, Device> implements IDeviceController {

    public DeviceController() {
        super(Device.class);
    }
}
