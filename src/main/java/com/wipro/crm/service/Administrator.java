package com.wipro.crm.service;

import java.sql.Date;
import java.util.List;

import com.wipro.crm.bean.CrmBean;
import com.wipro.crm.dao.CrmDAO;

public class Administrator {

    private CrmDAO dao = new CrmDAO();

    public String addRecord(CrmBean bean) {

        if (bean == null || bean.getCustomerName() == null || bean.getJoinDate() == null) {
            return "INVALID INPUT";
        }

        if (bean.getCustomerName().length() < 2) {
            return "INVALID CUSTOMER NAME";
        }

        if (bean.getEmail() == null || !bean.getEmail().contains("@")) {
            return "INVALID EMAIL";
        }

        if (bean.getPhone() == null || bean.getPhone().length() < 10) {
            return "INVALID PHONE";
        }

        boolean exists = dao.recordExists(bean.getCustomerName(), bean.getJoinDate());

        if (exists) {
            return "ALREADY EXISTS";
        }

        String recordId = dao.generateRecordID(bean.getCustomerName(), bean.getJoinDate());
        bean.setRecordId(recordId);

        return dao.createRecord(bean);
    }

    public CrmBean viewRecord(String customerName, Date joinDate) {
        return dao.fetchRecord(customerName, joinDate);
    }

    public List<CrmBean> viewAllRecords() {
        return dao.fetchAllRecords();
    }
}
