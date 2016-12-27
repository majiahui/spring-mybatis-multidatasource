package service2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.HisAddress;
import helper.MzDataSource;
import mapper.HisAddressMapper;

@Service
public class HisAddress2Service {

	@Autowired
	private HisAddressMapper hisAddressMapper;
	
	@MzDataSource("dataSourceB")
	public HisAddress getAddressById(Long id) {
		return hisAddressMapper.getAddressById(id);
	}
	
	@MzDataSource("dataSourceA")
	public HisAddress insert(HisAddress hisAddress) {
		hisAddressMapper.insert(hisAddress);
		return hisAddress;
	}
}
