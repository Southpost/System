package com.atshilei.system.controller;

import com.atshilei.system.dao.DepartmentDao;
import com.atshilei.system.dao.EmployeeDao;
import com.atshilei.system.entities.Department;
import com.atshilei.system.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工，返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //添加员工页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加员工页面之前，查询出所有的部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工添加实现
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //来到修改页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        //查到部门，显示正确
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    //修改功能的实现
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除功能的实现
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }


}
