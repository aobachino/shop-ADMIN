package jp.co.opst.staff.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.opst.staff.Dto.StaffDto;
import jp.co.opst.staff.Model.StaffLoginModel;
import jp.co.opst.staff.Service.StaffLoginService;

@Controller
public class LoginController {

	@Autowired
	private StaffLoginService staffLoginService;

	@RequestMapping("/loginForm")
	public String showForm() {

		return "Login/loginForm";
	}

	@RequestMapping(path = "/loginStaff", method = RequestMethod.POST)
	public ModelAndView loginConf(@Valid @ModelAttribute StaffLoginModel stamo, BindingResult errors,
			HttpSession session) {

		if (errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("Main/menu");
			return mv;
		} else if (stamo.getId() == "" || stamo.getPass() == "") {
			String message = "必須入力です";
			ModelAndView mv = new ModelAndView("Login/loginForm", "error", message);
			return mv;
		} else {
			boolean staModel = staffLoginService.staffFind(stamo);
			if (staModel) {

				StaffDto sit = staffLoginService.staffData(stamo);
				session.setAttribute("staffInfo", sit);
				ModelAndView pr = new ModelAndView("MainMenu/menu");
				return pr;

			} else {
				// ログイン失敗
				String message = "ログインできませんでした";
				ModelAndView pr = new ModelAndView("Login/loginForm", "loginnot", message);
				return pr;
			}
		}
	}
}
