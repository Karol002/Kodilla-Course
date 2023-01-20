package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeFacade.class);
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeFacade(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void findEmployeeByAnyString(final String anyString) throws EmployeeException {
        LOGGER.info("Searching for a employee with the indicated string: " + anyString);
        List<Employee> employeesFirstName = employeeDao.findEmployeeByFirstNameAndAnyString("%" + anyString + "%");


        if ( employeesFirstName.size() == 0) {
            LOGGER.error(EmployeeException.EMPLOYEE_NOT_FOUND);
            throw new EmployeeException(EmployeeException.EMPLOYEE_NOT_FOUND);
        }
    }
}
