package service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import entity.HisAddress;
import service2.HisAddress2Service;

@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class HisAddress2Test extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private HisAddress2Service hisAddress2Service;
	
	@Test
	public void testInsert() {
		HisAddress addr = new HisAddress();
		addr.setDomain("test");
		addr.setGuid("1111");
		addr = hisAddress2Service.insert(addr);
		System.out.println(addr);
		throw new RuntimeException();
	}
}
