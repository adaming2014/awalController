/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.awal.controller;

import fr.adaming.awal.controller.interfaces.IDeviceRepairController;
import fr.adaming.awal.dao.interfaces.IDeviceInsuranceDao;
import fr.adaming.awal.dao.interfaces.IDeviceRepairDao;
import fr.adaming.awal.dao.interfaces.IRepairerDao;
import fr.adaming.awal.entity.Client;
import fr.adaming.awal.entity.Device;
import fr.adaming.awal.entity.Deviceinsurance;
import fr.adaming.awal.entity.Devicerepair;
import fr.adaming.awal.entity.Repairer;
import fr.adaming.awal.util.DeviceRepairerUtil;
import fr.adaming.awal.util.RepairerUtil;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author INTI0227
 */
public class DeviceRepairController extends Controller<IDeviceRepairDao, Devicerepair, Integer> implements IDeviceRepairController {

    private IRepairerDao repairerDao;
    private IDeviceInsuranceDao deviceInsuranceDao;

    @Override
    public List<Devicerepair> getDevicesRepairByClient(final Client client) {
        return dao.getDevicesRepairByClient(client);
    }

    @Override
    public List<Devicerepair> getDevicesRepairByRepairer(final Repairer repairer) {
        return dao.getDevicesRepairByRepairer(repairer);
    }

    @Override
    public boolean create(Devicerepair t) {
        throw new RuntimeException("Don't use that method, use createDeviceRepair instead");
    }

    /**
     *
     * @param entity
     * @throws PackageAlreadyPresentException
     */
    @Override
    public void createDeviceRepair(final Devicerepair entity) throws IDeviceRepairController.PackageAlreadyPresentException {
        Devicerepair devicerepair = dao.getByDeviceAndPackage(entity.getDevice(), entity.getModelpackage());
        if (devicerepair != null) {
            throw new IDeviceRepairController.PackageAlreadyPresentException();
        }

        Repairer repairerChoice1 = null;
        Repairer repairerChoice2 = null;
        for (Repairer repairerTmp : repairerDao.getAll()) {
            if (repairerTmp.getAvailable().equals(RepairerUtil.AVAILABLE)) {
                repairerChoice2 = repairerTmp;

                if (repairerTmp.getFirm().getAddress().getPostcode().equals(entity.getDevice().getClient().getAddress().getPostcode())) {
                    repairerChoice1 = repairerTmp;
                    break;
                }
            }
        }

        if (deviceAsInsurance(entity.getDevice(), entity.getDevice().getClient()) == true) {
            entity.setPrice(0);
        } else {
            entity.setPrice(Integer.valueOf(entity.getModelpackage().getPrice()));
        }

        entity.setRepairer(repairerChoice1 != null ? repairerChoice1 : repairerChoice2);
        entity.setState(DeviceRepairerUtil.STATE_CREATE);
        entity.setDateCreation(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));

        super.create(entity);
    }

    private boolean deviceAsInsurance(final Device device, final Client client) {
        boolean insurance = false;

        for (Deviceinsurance deviceinsurance : deviceInsuranceDao.getDevicesInsuranceByClient(client)) {
            if (deviceinsurance.getDevice().equals(device)) {
                Calendar calLastTime = Calendar.getInstance();
                calLastTime.setTime(deviceinsurance.getBeginDate());
                int duration = deviceinsurance.getDeviceinsurancemodel().getDuration();
                calLastTime.add(Calendar.MONTH, duration);

                System.out.println(" calendar add duration : " + (calLastTime.get(Calendar.MONTH) + 1) + "-" + calLastTime.get(Calendar.DATE) + "-" + calLastTime.get(Calendar.YEAR));
                Calendar calTime = Calendar.getInstance();

                if (calTime.compareTo(calLastTime) <= 0) {
                    insurance = true;
                }
            }
        }

        System.out.println("insurance : " + insurance);
        return insurance;
    }

    @Override
    public void setRepairingState(Devicerepair devicerepair) {
        devicerepair.setState(DeviceRepairerUtil.STATE_REPAIRING);
        devicerepair.setDateInRepair(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));

        dao.makePersistent(devicerepair);
    }

    @Override
    public void setRepairedState(Devicerepair devicerepair) {
        devicerepair.setState(DeviceRepairerUtil.STATE_REPAIRED);
        devicerepair.setDateRepair(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));

        dao.makePersistent(devicerepair);
    }

    @Override
    public void setClosedState(Devicerepair devicerepair) {
        devicerepair.setState(DeviceRepairerUtil.STATE_CLOSED);
        devicerepair.setDateClosed(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));

        dao.makePersistent(devicerepair);
    }

    public IRepairerDao getRepairerDao() {
        return repairerDao;
    }

    public void setRepairerDao(IRepairerDao repairerDao) {
        this.repairerDao = repairerDao;
    }

    public IDeviceInsuranceDao getDeviceInsuranceDao() {
        return deviceInsuranceDao;
    }

    public void setDeviceInsuranceDao(IDeviceInsuranceDao deviceInsuranceDao) {
        this.deviceInsuranceDao = deviceInsuranceDao;
    }

}
