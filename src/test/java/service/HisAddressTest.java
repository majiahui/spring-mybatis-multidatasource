package service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import entity.HisAddress;
import helper.DatabaseContextHolder;

@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class HisAddressTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private HisAddressService hisAddressService;
	
//	@Before
	public void setDataSource() {
		DatabaseContextHolder.setDataSourceType(DatabaseContextHolder.DATA_SOURCE_1);
	}
	
	@Test
	public void testGetAddressById() {
		HisAddress address = hisAddressService.getAddressById(223L);
		System.out.println(address);
	}
	
	@Test
	public void testInsert() {
		HisAddress addr = new HisAddress();
		addr.setDomain("test");
		addr.setGuid("1111");
		addr = hisAddressService.insert(addr);
		System.out.println(addr);
		throw new RuntimeException();
	}
}
