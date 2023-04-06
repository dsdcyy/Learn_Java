package com.ljw.domain;

import java.util.Date;

/**
 * @author ljw
 * @version 1.0
 * employees表的java_bean
 */
public class Employee {
    private Integer id;
    private String emp_id;
    private String name;
    private Integer age;
    private String sex;
    private String pwd;
    private String job;
    private Date hiredate;
    private Integer dept_id;

    public Employee() {
    }

    public Employee(Integer id, String emp_id, String name, Integer age, String sex, String pwd, String job, Date hiredate, Integer dept_id) {
        setId(id);
        setEmp_id(emp_id);
        setName(name);
        setAge(age);
        setSex(sex);
        setPwd(pwd);
        setJob(job);
        setHiredate(hiredate);
        setDept_id(dept_id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }
}
