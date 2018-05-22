package com.bizleap.training.ds.service.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.bizleap.commons.domain.exception.ServiceUnavailableException;
import com.bizleap.training.ds.loader.impl.test.ServiceTest;
import com.bizleap.training.ds.service.EmployeeService;

public class EmployeeServiceImplTest extends ServiceTest {
	
	static Logger logger=Logger.getLogger(EmployeeServiceImplTest.class);
	
	//@Ignore
	@Test
	public void testFindByEmployeeBoId() throws ServiceUnavailableException {
		assertNotNull(employeeService.findByEmployeeBoId("PER01"));
		logger.info("Employee from List: "+employeeService.findByEmployeeBoId("PER01"));
		assertEquals((employeeService.findByEmployeeBoIdSingle("PER01")).getName(),"Alice Kim");
	}
	
	//@Ignore
	@Test
	public void testgetAllEmployee() throws ServiceUnavailableException, IOException {
		assertNotNull(employeeService.getAllEmployee());
		logger.info("Employee List: "+employeeService.getAllEmployee());
		assertTrue(CollectionUtils.isNotEmpty(employeeService.getAllEmployee()));
		assertEquals(8,employeeService.getAllEmployee().size());
		}
}
