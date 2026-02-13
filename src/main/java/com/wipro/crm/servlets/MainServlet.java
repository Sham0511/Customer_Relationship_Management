package com.wipro.crm.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.wipro.crm.bean.CrmBean;
import com.wipro.crm.service.Administrator;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    private Administrator admin = new Administrator();

    public String addRecord(HttpServletRequest request) throws Exception {

        CrmBean bean = new CrmBean();

        bean.setCustomerName(request.getParameter("customerName"));
        bean.setEmail(request.getParameter("email"));
        bean.setPhone(request.getParameter("phone"));
        bean.setStatus(request.getParameter("status"));
        bean.setRemarks(request.getParameter("remarks"));

        Date joinDate = Date.valueOf(request.getParameter("joinDate"));
        bean.setJoinDate(joinDate);

        return admin.addRecord(bean);
    }

    public CrmBean viewRecord(HttpServletRequest request) {

        String name = request.getParameter("customerName");
        Date joinDate = Date.valueOf(request.getParameter("joinDate"));

        return admin.viewRecord(name, joinDate);
    }

    public List<CrmBean> viewAllRecords(HttpServletRequest request) {
        return admin.viewAllRecords();
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String operation = req.getParameter("operation");

        try {

      
            if ("newRecord".equals(operation)) {

                String result = addRecord(req);

                if ("FAIL".equals(result) ||
                    result.equals("INVALID INPUT") ||
                    result.equals("INVALID CUSTOMER NAME") ||
                    result.equals("INVALID EMAIL") ||
                    result.equals("INVALID PHONE") ||
                    result.equals("ALREADY EXISTS")) {

                    resp.sendRedirect("error.html");
                } else {
                    resp.sendRedirect("success.html");
                }
            }
            else if ("viewRecord".equals(operation)) {

                CrmBean bean = viewRecord(req);

                if (bean == null) {
                    req.setAttribute("message",
                            "No matching records exists! Please try again!");
                } else {
                    req.setAttribute("record", bean);
                }

                RequestDispatcher rd =
                        req.getRequestDispatcher("displayCustomer.jsp");
                rd.forward(req, resp);
            }
            else if ("viewAllRecords".equals(operation)) {

                List<CrmBean> list = viewAllRecords(req);

                if (list.isEmpty()) {
                    req.setAttribute("message",
                            "No records available!");
                } else {
                    req.setAttribute("records", list);
                }

                RequestDispatcher rd =
                        req.getRequestDispatcher("displayAllCustomers.jsp");
                rd.forward(req, resp);
            }

        } catch (Exception e) {
            resp.sendRedirect("error.html");
        }
    }
}
