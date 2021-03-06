/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.controller;

import fr.adaming.awal.controller.interfaces.IDeviceInsuranceController;
import fr.adaming.awal.dao.interfaces.IDeviceInsuranceDao;
import fr.adaming.awal.entity.Client;
import fr.adaming.awal.entity.Deviceinsurance;
import java.util.List;

/**
 *
 * @author INTI0227
 */
public class DeviceInsuranceController extends Controller<IDeviceInsuranceDao, Deviceinsurance, Integer> implements IDeviceInsuranceController {

    @Override
    public List<Deviceinsurance> getDevicesInsuranceByClient(Client client) {
        return dao.getDevicesInsuranceByClient(client);
    }
}
