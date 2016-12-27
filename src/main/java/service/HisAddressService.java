package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.HisAddress;
import helper.MzDataSource;
import mapper.HisAddressMapper;

@Service
public class HisAddressService {

	@Autowired
	private HisAddressMapper hisAddressMapper;
	
	@Transactional
	@MzDataSource("dataSourceB")
	public HisAddress getAddressById(Long id) {
		return hisAddressMapper.getAddressById(id);
	}
	
	@Transactional
	@MzDataSource("dataSourceA")
	public HisAddress insert(HisAddress hisAddress) {
		hisAddressMapper.insert(hisAddress);
		return hisAddress;
	}
}
