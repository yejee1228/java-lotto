package com.lotto.web.serverImples;

import com.lotto.web.daoImples.ConsumerDAOImpl;
import com.lotto.web.daos.ConsumerDAO;
import com.lotto.web.domains.ConsumerBean;
import com.lotto.web.servers.ConsumerService;

public class ConsumerServiceImpl implements ConsumerService {
	private ConsumerDAO dao;
	
	public ConsumerServiceImpl() {
		dao = new ConsumerDAOImpl();
		}
	
	@Override
	public void registerConsumer(ConsumerBean param) {
		dao.insertConsumer(param);
		
	}

	

}
