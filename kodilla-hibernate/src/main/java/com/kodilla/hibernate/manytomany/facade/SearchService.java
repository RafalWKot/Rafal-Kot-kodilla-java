package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    public List<String> getCompanyNames(String namePart) {
        return companyDao.retrieveCompanyNameByStringPart(namePart).stream()
                .map(c -> c.getName())
                .collect(Collectors.toList());
    }

    public List<String> getEmployeeNames(String namePart) {
        return employeeDao.retrieveEmployeeByStringPart(namePart).stream()
                .map(e -> e.getLastname())
                .collect(Collectors.toList());
    }
}
