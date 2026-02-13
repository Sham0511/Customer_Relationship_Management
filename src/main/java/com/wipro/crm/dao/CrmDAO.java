package com.wipro.crm.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.wipro.crm.bean.CrmBean;
import com.wipro.crm.util.DBUtil;

public class CrmDAO {
	public String createRecord(CrmBean CrmBean) {
		String sql = "INSERT INTO crm_tbl (RECORDID,CUSTOMERNAME,EMAIL,PHONE,JOIN_DATE,STATUS,REMARKS)values(?,?,?,?,?,?,?)";
		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, CrmBean.getRecordId());
			ps.setString(2, CrmBean.getCustomerName());
			ps.setString(3, CrmBean.getEmail());
			ps.setString(4, CrmBean.getPhone());
			ps.setDate(5, CrmBean.getJoinDate());
			ps.setString(6, CrmBean.getStatus());
			ps.setString(7, CrmBean.getRemarks());

			int rows = ps.executeUpdate();
			if (rows > 0) {
				return CrmBean.getRecordId();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "FAIL";
	}

	public CrmBean fetchRecord(String customerName,Date joinDate) {
		CrmBean crm = null;

		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con
						.prepareStatement("SELECT * FROM CRM_TBL WHERE CustomerName = ? AND Join_Date = ?")) {
			ps.setString(1, customerName);
			ps.setDate(2, new java.sql.Date(joinDate.getTime()));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				crm = new CrmBean();
				crm.setRecordId(rs.getString("RECORDID"));
				crm.setCustomerName(rs.getString("CUSTOMERNAME"));
				crm.setEmail(rs.getString("EMAIL"));
				crm.setPhone(rs.getString("PHONE"));
				crm.setJoinDate(rs.getDate("JOIN_DATE"));
				crm.setStatus(rs.getString("STATUS"));
				crm.setRemarks(rs.getString("REMARKS"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return crm;
	}

	public String generateRecordID(String customerName, Date joinDate) {

		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		String temp = format.format(joinDate);

		String namePart = customerName.substring(0, 2).toUpperCase();

		String seq = "";
		String sql = "SELECT CRM_SEQ.NEXTVAL FROM DUAL";

		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			if (rs.next()) {
				seq = String.valueOf(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return temp + namePart + seq;
	}

	public boolean recordExists(String customerName, Date joinDate) {
		CrmBean bean = fetchRecord(customerName, joinDate);
		return bean != null;
	}

	public List<CrmBean> fetchAllRecords() {
		List<CrmBean> list = new ArrayList<>();
		String val = "Select * from crm_tbl";
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(val);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				CrmBean bean = new CrmBean();
				bean.setRecordId(rs.getString("RECORDID"));
				bean.setCustomerName(rs.getString("CUSTOMERNAME"));
				bean.setEmail(rs.getString("EMAIL"));
				bean.setPhone(rs.getString("PHONE"));
				bean.setJoinDate(rs.getDate("JOIN_DATE"));
				bean.setStatus(rs.getString("STATUS"));
				bean.setRemarks(rs.getString("REMARKS"));
				;

				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
}
