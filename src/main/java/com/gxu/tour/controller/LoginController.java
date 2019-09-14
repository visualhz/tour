package com.gxu.tour.controller;

import com.gxu.tour.entity.Admin;
import com.gxu.tour.service.LoginService;
import com.gxu.tour.utils.Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    //登录
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    //登出
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        //删除会话
        session.removeAttribute("loginUser");
        return "redirect:/login";
    }

    //用户注册
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    //用户注册审核
    @PostMapping("/registerCheck")
    public String registerCheck(@RequestParam("username") String username,
                                @RequestParam("password1") String password1,
                                @RequestParam("password2") String password2,
                                Map<String, Object> map,
                                HttpSession session) {
        //判断当前用户的flag是否为1：
        //1：当前用户可以注册新用户，
        //0：当前用户不能注册新用户。
        Admin loginUser = (Admin) session.getAttribute("loginUser");
        Admin admin = loginService.getAdmin(loginUser.getUserName());
        if (admin.getFlag() != 1) {
            map.put("msg", "你不是主管理员，不能注册新用户！");
            return "register";
        }
        if (!password1.equals(password2))
            map.put("msg", "两次输入的密码不匹配");
        //判断用户是否已经存在
        Iterator<Admin> iterator = loginService.getAllAdmin().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getUserName().equals(username)) {
                map.put("msg", "用户已存在！");
                return "register";
            }
        }
        //新建用户实例，进行用户注册。密码经过SHA256进行哈希。
        Admin user = new Admin(username, Encode.str2SHA256(password1), 0);
        loginService.newAdmin(user);
        map.put("msg", "注册成功");
        return "register";
    }

    //登录检查
    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public String loginCheck(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             HttpServletRequest request,
                             Map<String, Object> map) {
        if (username.equals("") || password.equals("")) {
            map.put("msg", "用户名或密码不能为空！");
            return "login";
        }
        Admin admin = loginService.getAdmin(username);
        if (admin == null) {
            map.put("msg", "用户不存在或密码错误！");
            return "login";
        }
        String enPassword = Encode.str2SHA256(password);
        if (!enPassword.equals(admin.getPassword())) {
            map.put("msg", "用户不存在或密码错误！");
            return "login";
        } else {
            //登录成功，设置session。
            Admin loginUser = new Admin(username);
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", loginUser);
            return "redirect:/visitor";
        }
    }

    //返回修改密码视图
    @GetMapping("/resetPSW")
    public ModelAndView resetPSW() {
        return new ModelAndView("resetPSW");
    }
    //修改密码
    @PostMapping("/resetPSW")
    public String resetPSW(@RequestParam("username") String username,
                           @RequestParam("oldPassword") String oldPassword,
                           @RequestParam("newPassword1") String newPassword1,
                           @RequestParam("newPassword2") String newPassword2,
                           Map<String, Object> map) {

        if (username.equals("") || oldPassword.equals("") || newPassword1.equals("")
                || newPassword2.equals("")) {
            map.put("msg", "请检查输入，任意一项输入都不能为空!");
            return "/resetPSW";
        }
        if (!(newPassword1.equals(newPassword2))) {
            map.put("msg", "新密码两次输入不一致！");
            return "/resetPSW";
        }

        Admin user = loginService.getAdmin(username);
        if (user == null ||
                !(Encode.str2SHA256(oldPassword).equals(user.getPassword()))) {
            map.put("msg", "用户不存在或输入的原密码错误!");
            return "/resetPSW";
        }
        if (Encode.str2SHA256(newPassword1).equals(user.getPassword())) {
            map.put("msg", "新密码不能为旧密码！");
            return "/resetPSW";
        }

        user.setPassword(Encode.str2SHA256(newPassword1));
        int affect = loginService.alterAdmin(user);
        if (affect > 0)
            map.put("msg", "修改成功！");
        else
            map.put("msg", "系统出错，修改失败！");
        return "resetPSW";
    }
}
