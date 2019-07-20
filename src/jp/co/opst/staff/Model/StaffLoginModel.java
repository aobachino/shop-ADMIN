package jp.co.opst.staff.Model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.GroupSequence;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jp.co.opst.staff.Entity.StaffEntity;
import jp.co.opst.staff.Model.StaffLoginModel.Group1;

@GroupSequence({ Group1.class, StaffLoginModel.class })
public class StaffLoginModel {
	public interface Group1 {
	}

	@Pattern(regexp = "[0-9]*", message = "数字のみで入力してください", groups = Group1.class)
	private String id;
	@Size(max = 32, message = "32文字以内で入力してください")
	@Pattern(regexp = "[a-zA-z0-9]*", message = "アルファベットと数字のみで入力してください", groups = Group1.class)
	private String pass;

	List<StaffEntity> staffList = new ArrayList<StaffEntity>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<StaffEntity> getStaffList() {
		return staffList;
	}

	public void setUserList(List<StaffEntity> staffList) {
		this.staffList = staffList;
	}

}
