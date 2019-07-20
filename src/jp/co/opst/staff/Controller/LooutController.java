package jp.co.opst.staff.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.opst.staff.Model.StaffLoginModel;

@Controller
public class LooutController {
	@RequestMapping("/logout")
	public ModelAndView userLogin(@ModelAttribute StaffLoginModel stamo, HttpSession session) {
		session.removeAttribute("userInfo");
		String message = "ログアウトしました";
		ModelAndView mv = new ModelAndView("Login/loginForm", "logoutStatus", message);
		return mv;
	}
}
