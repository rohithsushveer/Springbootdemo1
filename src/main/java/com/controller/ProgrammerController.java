package com.controller;

import java.net.http.HttpResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bean.ProgrammerBean;
import com.dao.ProgrammerDao;

//converts to restapi
@RestController
public class ProgrammerController {
	@Autowired
	ProgrammerDao programmerDao;

	@PostMapping(value ="/addprogrammer")

	public ResponseEntity<ProgrammerBean> addProgrammer(@RequestBody ProgrammerBean programmerBean) {
		int res = programmerDao.addProgrammer(programmerBean);
		if (res > 0) {
			return new ResponseEntity<ProgrammerBean>(programmerBean, HttpStatus.CREATED);
			} else {

			return new ResponseEntity<ProgrammerBean>(programmerBean, HttpStatus.CONFLICT);
		}
	}

	@GetMapping(value = "/getallprogrammers")
	public ResponseEntity<List<ProgrammerBean>> getAllProgrammers() {
		List<ProgrammerBean> programmerList = programmerDao.getAllProgrammers();
		if (programmerList.size() > 0) {
			return new ResponseEntity<List<ProgrammerBean>>(programmerList, HttpStatus.OK);
		}
		return new ResponseEntity<List<ProgrammerBean>>(HttpStatus.NOT_FOUND);
		}

	@DeleteMapping(value ="/deleteprogrammer/{id}")
	public ResponseEntity<Integer> deleteProgrammer(@PathVariable("id") int pId) {
		int res = programmerDao.deleteProgrammer(pId);
		if (res > 0) {
		return new ResponseEntity<>(1, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	@GetMapping(value="/getprogrammerbyid/}{id}")
	public ResponseEntity<ProgrammerBean>getProgrammerById(@PathVariable("id")int pId){
		return null;
		
		
	}
}
