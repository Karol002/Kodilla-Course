package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);
    private final CompanyDao companyDao;

    @Autowired
    public CompanyFacade(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public void findCompanyByAnyString(final String anyString) throws CompanyException {
        LOGGER.info("Searching for a company with the indicated string: " + anyString);
        List<Company> companies = companyDao.findCompanyByAnyString("%" + anyString + "%");

        if (companies.size() == 0) {
            LOGGER.error(CompanyException.COMPANY_NOT_FOUND);
            throw new CompanyException(CompanyException.COMPANY_NOT_FOUND);
        }
    }
}
