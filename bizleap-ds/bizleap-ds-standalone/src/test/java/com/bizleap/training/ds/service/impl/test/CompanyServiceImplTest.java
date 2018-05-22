package com.bizleap.training.ds.service.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.apache.log4j.Logger;

import com.bizleap.training.ds.loader.DataManager;
import com.bizleap.commons.domain.exception.ServiceUnavailableException;
import com.bizleap.training.ds.loader.impl.test.ServiceTest;
import com.bizleap.training.ds.service.CompanyService;

public class CompanyServiceImplTest extends ServiceTest{
	
	static Logger logger=Logger.getLogger(CompanyServiceImplTest.class);

	//@Ignore
	@Test
	public void testFindByCompanyBoId() throws ServiceUnavailableException, IOException {
		assertNotNull(companyService.findByCompanyBoIdSingle("COMP01"));
		logger.info("Company from List: "+companyService.findByCompanyBoIdSingle("COMP01"));
		assertEquals((companyService.findByCompanyBoIdSingle("COMP01")).getName(),"Apple");
	}
	
	//@Ignore
	@Test
	public void testgetAllCompany() throws ServiceUnavailableException, IOException {
		assertNotNull(companyService.getAllCompany());
		logger.info("Company List: "+companyService.getAllCompany());
		assertTrue(CollectionUtils.isNotEmpty(companyService.getAllCompany()));
		assertEquals(8,employeeService.getAllEmployee().size());
		}
}


