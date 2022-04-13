package com.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bean.BugBean;
import com.dao.BugDao;

@RestController
public class BugController {
	@Autowired
	BugDao bugDao;

	@PostMapping(value = "/addbug")
	public BugBean addBug(BugBean bugBean) {
		int res = bugDao.addBug(bugBean);

		return bugBean;
	}
	@GetMapping(value="/getbug")
	public List<BugBean> getAllRecords() {
		return bugDao.getAllRecords();

	}
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String>deleteBug(@PathVariable("id") int id){ 
		System.out.println(id);
		int res=bugDao.deleteBug(id);
		return new ResponseEntity<String>("record deleted", HttpStatus.OK);
	}
}
