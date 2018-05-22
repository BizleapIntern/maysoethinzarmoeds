package com.bizleap.training.ds.loader.impl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizleap.commons.domain.Company;
import com.bizleap.commons.domain.exception.ServiceUnavailableException;
import com.bizleap.training.ds.loader.CompanySaver;
import com.bizleap.training.ds.loader.DataManager;
import com.bizleap.commons.domain.utils.Printer;
import com.bizleap.training.ds.service.CompanyService;
import com.bizleap.training.ds.service.dao.impl.AbstractDaoImpl;

@Service("companySaver")
public class CompanySaverImpl implements CompanySaver {
	private static Logger logger = Logger.getLogger(AssociationMapperImpl.class);
	private static Printer printer = new Printer(logger);
	
	List<Company> companyList;
	
	@Autowired
	CompanyService companyService;
	
	@Override
	public void savePass1() throws ServiceUnavailableException, IOException {
		printer.line2(companyList.toString());
		for(Company company:getCompanyList()) {
			printer.line("About to save: "+company);
			printer.line("Company successfully saved.");
			companyService.saveCompany(company);
		}
	}
	
	private List<Company> getCompanyList() {
		// TODO Auto-generated method stub
		return this.companyList;
	}

	@Override
	public void setCompanyList(List<Company> companyList) {
		this.companyList=companyList;
	}

}
