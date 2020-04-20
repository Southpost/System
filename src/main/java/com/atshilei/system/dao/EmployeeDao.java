package com.atshilei.system.dao;


import com.atshilei.system.entities.Department;
import com.atshilei.system.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Repository
@Component
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1, new Department(101, "计算机学院")));
        employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1, new Department(102, "软件学院")));
        employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0, new Department(103, "环境设计")));
        employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0, new Department(104, "艺术类")));
        employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1, new Department(105, "科技园")));
    }

    private static Integer initId = 1006;

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    //查询所有员工
    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee get(Integer id) {
        return employees.get(id);
    }

    public void delete(Integer id) {
        employees.remove(id);
    }
}
