package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ClientBean;
import com.dao.ClientDao;

@RestController
public class ClientController {
	@Autowired
	ClientDao clientDao;

	@PostMapping(value = "/addclient")
	public ResponseEntity<ClientBean> addClient(@RequestBody ClientBean clientBean) {
		System.out.println("::Hello");
		return null;

	}
}
