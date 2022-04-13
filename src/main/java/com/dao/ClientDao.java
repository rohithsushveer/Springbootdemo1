package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ClientBean;

@Repository
public class ClientDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addClient(ClientBean clientBean) {
		
		return jdbcTemplate.update("insert into client(cname, cneed, pid)values(?,?,?)",clientBean.getcName(), clientBean.getcNeed(), clientBean.getpId());	
	}
}
