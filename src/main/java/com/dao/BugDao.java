package com.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.bean.BugBean;

@Repository
public class BugDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	public int addBug(BugBean bugBean) {
		return jdbcTemplate.update("insert into bug(bname, bdesc, btime)values(?,?,?)", bugBean.getbName(), bugBean.getbDesc(), bugBean.getbTime());
		}
	
	private static final class BugMapper implements RowMapper<BugBean>{
	
	@Override
	public BugBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		BugBean bugBean=new BugBean();
		bugBean.setbName(rs.getString("bName"));
		bugBean.setbTime(rs.getInt("bTime"));
		bugBean.setbDesc(rs.getString("bDesc"));
		return bugBean;
	}
}
	
	public List<BugBean>getAllRecords(){
		return jdbcTemplate.query("select * from bug", new BugMapper());
		
	}
	
	public int deleteBug(int bId) {
		return jdbcTemplate.update("delete from bug where bid=?", bId);
	}
//	public int delete(int bId) {
//		return jdbcTemplate.update("bid", bId);
//	}
//	
	

}
