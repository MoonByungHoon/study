package com.mbh.blog.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mbh.blog.model.UserDTO;
import com.mbh.blog.service.UserService;

// 컨트롤러임을 알려준다.
@Controller
// 맵핑은 url 주소 이름을 주입시켜주는(?) 것이다.
@RequestMapping("/user")
public class UserController {

//	자동으로 객체를 초기화 해줌.
	@Autowired
	private UserService userService;

	@RequestMapping("/loginPage")
	public String loginPage() {

// 아래처럼 리턴하게 되면 jsp파일을 찾는 디렉토리 경로를 리턴 하는 것이다.
		return "user/loginPage";
	}

//	기본적으로 모든 맵핑은 get 속성을 가지고 있다. 하지만 직접 적어주는 경우가 있는데
//	이유는 직관적인 가독성과 유지보수 측면에서 사용한다.
	@GetMapping("/registerPage")
	public String registerPage() {

		return "user/registerPage";
	}

//	같은 경로를 가지고 있지만 포스트 방식을 사용하게 되면 값을 받아올때에
//	해당 맵핑 경로로 오게 된다.
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	이렇게 작성하는 것을 간략하게 사용한 기능이다.
	@PostMapping("/register")
	public String registerLogic(UserDTO u) {
		if (userService.usernameIsEquals(u.getUsername())) {
			u.setPassword(convertSha2(u.getPassword()));
			userService.register(u);

//		아래처럼 리턴하면 url 경로를 찾아서 위치를 이동하게 된다.
			return "redirect:/";
		} else {

			return "redirect:/user/registerPage";
		}
	}

	private String convertSha2(String password) {
		String converted = null;
		StringBuilder builder = null;

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(password.getBytes("UTF-8"));

			builder = new StringBuilder();

			for (int i = 0; i < hash.length; i++) {
				builder.append(String.format("%02x", 255 & hash[i]));
			}

			converted = builder.toString();

		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return converted;
	}
}
