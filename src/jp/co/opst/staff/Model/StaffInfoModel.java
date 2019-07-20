package jp.co.opst.staff.Model;

import java.util.ArrayList;
import java.util.List;

import jp.co.opst.staff.Entity.StaffEntity;

public class StaffInfoModel {
	List<StaffEntity> stList = new ArrayList<StaffEntity>();

	public List<StaffEntity> getStList() {
		return stList;
	}

	public void setStList(List<StaffEntity> stList) {
		this.stList = stList;
	}
}
