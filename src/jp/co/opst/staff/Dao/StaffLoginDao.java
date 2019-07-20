package jp.co.opst.staff.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import jp.co.opst.staff.Entity.StaffEntity;
import jp.co.opst.staff.Model.StaffLoginModel;

public class StaffLoginDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterTemplate;

	private class StaffRowMapper extends BeanPropertyRowMapper<StaffEntity> {
		@Override
		public StaffEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			StaffEntity en = new StaffEntity();
			en.setId(rs.getInt("STAFF_NO"));
			en.setPass(rs.getString("PASSWORD"));
			en.setName(rs.getString("NAME"));
			en.setAge(rs.getString("AGE"));
			en.setSex(rs.getString("SEX"));
			en.setRegTime(rs.getDate("REGISTER_DATE"));
			en.setUpdTime(rs.getDate("LAST_UPD_DATE"));
			return en;
		}
	}

	public List<StaffEntity> findLogData(StaffLoginModel stamo) {
		String sql = "select * from ONLINE_STAFF where MEMBER_NO = :id AND PASSWORD = :pass ";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("id", Integer.parseInt(stamo.getId()));
		paramMap.addValue("pass", stamo.getPass());
		List<StaffEntity> infList = namedParameterTemplate.query(sql, paramMap, new StaffRowMapper());
		return infList;
	}

}
