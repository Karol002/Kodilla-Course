package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CompanyAndEmployeeFacadeTestSuite {

    @Autowired
    private CompanyFacade companyFacade;
    @Autowired
    private EmployeeFacade employeeFacade;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testFindCompanyByAnyString() throws CompanyException {
        Company softwareMachine = new Company("Software Machine");
        companyDao.save(softwareMachine);

        try {
            companyFacade.findCompanyByAnyString("So");
        } catch (CompanyException e) {
            throw new CompanyException(e.getMessage());
        }
    }

    @Test
    void testFindEmployeeByAnyString() throws EmployeeException {
        Employee johnSmith = new Employee("John", "Smith");
        employeeDao.save(johnSmith);

        try {
            employeeFacade.findEmployeeByAnyString("Jo");
            employeeFacade.findEmployeeByAnyString("th");
        } catch (EmployeeException e) {
            throw new EmployeeException(e.getMessage());
        }
    }
}
