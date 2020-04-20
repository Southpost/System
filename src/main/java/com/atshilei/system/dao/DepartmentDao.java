package com.atshilei.system.dao;

import com.atshilei.system.entities.Department;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Repository
@Component
public class DepartmentDao {

    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();

        departments.put(101, new Department(101, "计算机学院"));
        departments.put(102, new Department(102, "软件学院"));
        departments.put(103, new Department(103, "环境设计"));
        departments.put(104, new Department(104, "艺术类"));
        departments.put(105, new Department(105, "科技园"));
    }

    public Collection<Department> getDepartments() {
        return departments.values();
    }

    public Department getDepartment(Integer id) {
        return departments.get(id);
    }

}
