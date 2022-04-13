package com.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import com.bean.ProgrammerBean;

@Repository
public class ProgrammerDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addProgrammer(ProgrammerBean programmerBean) {
		return jdbcTemplate.update("insert into programmer(pname, pdomain, psalary)values(?,?,?)",
			programmerBean.getpName(), programmerBean.getpDomain(), programmerBean.getpSalary());
	}

	private static final class ProgrammerMapper implements RowMapper<ProgrammerBean> {

		@Override
		public ProgrammerBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			ProgrammerBean programmerBean = new ProgrammerBean();
			programmerBean.setpId(rs.getInt("pId"));
			programmerBean.setpName(rs.getString("pName"));
			programmerBean.setpSalary(rs.getInt("pSalary"));
			programmerBean.setpDomain(rs.getString("pDomain"));
			return programmerBean;
		}
	}
	
	public List<ProgrammerBean> getAllProgrammers() {
		
		return jdbcTemplate.query("select * from programmer", new ProgrammerMapper());
		}
	public int deleteProgrammer(int pId) {
		return jdbcTemplate.update("delete from programmer where pId=?", pId);
		}
	public ProgrammerBean getprogrammerbyid() {
		return jdbcTemplate.queryForObject("select * from programmer where pid=?", new ProgrammerMapper());
		
	}
	public int updateProgrammer(int pId, ProgrammerBean programmerBean) {
		return jdbcTemplate.update("update programmer set pname=?, pdomain=?, psalary=?", 
			   programmerBean.getpName(), programmerBean.getpDomain(), programmerBean.getpSalary());
	}
}