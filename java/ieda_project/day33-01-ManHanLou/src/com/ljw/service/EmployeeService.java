package com.ljw.service;

import com.ljw.dao.EmployeeDao;
import com.ljw.domain.Employee;

/**
 * @author ljw
 * @version 1.0
 * 调用employeeDao对employee表的各种操作
 */
public class EmployeeService {
    private final EmployeeDao employeeDao = new EmployeeDao();

    public Employee getEmployee(String emp_id, String pwd) {
        String sql = "select * from employees where emp_id = ? and pwd = md5(?)";
        return employeeDao.queryOne(sql, Employee.class, emp_id, pwd);
    }

}
