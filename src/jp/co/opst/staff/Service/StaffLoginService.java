package jp.co.opst.staff.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.opst.staff.Dao.StaffLoginDao;
import jp.co.opst.staff.Dto.StaffDto;
import jp.co.opst.staff.Entity.StaffEntity;
import jp.co.opst.staff.Model.StaffInfoModel;
import jp.co.opst.staff.Model.StaffLoginModel;
@Service
public class StaffLoginService {
	
	@Autowired
	private StaffLoginDao staffLoginDao; 
	public boolean staffFind(StaffLoginModel stamo) {
		boolean result = true;
		List<StaffEntity> infList = staffLoginDao.findLogData(stamo);
		StaffInfoModel sim = new StaffInfoModel();
		sim.setStList(infList);
		if (sim.getStList().size() == 0) {

			result = false;
		}

		return result;
	}

	public StaffDto staffData(StaffLoginModel stamo) {
		List<StaffEntity> infList = staffLoginDao.findLogData(stamo);
		StaffDto sit = new StaffDto();
		for (StaffEntity en : infList) {
			sit.setId(en.getId());
			sit.setPass(en.getPass());
			sit.setName(en.getName());
			sit.setAge(en.getAge());
			sit.setSex(en.getSex());
			sit.setRegTime(en.getRegTime());
			sit.setUpdTime(en.getUpdTime());
		}
		return sit;

	}

}
