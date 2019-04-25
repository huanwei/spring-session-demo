package cn.harmonycloud.demo.springbootsession.springbootsessiondemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Cyan on 2019/4/24 .
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam("username") String username,
                                        @RequestParam("password") String password,
                                        @RequestParam("info") String info,
                                        HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (null != session.getAttribute("username") && !"".equals(session.getAttribute("username"))) {
            // 已经登录逻辑
            return new ResponseEntity<>("已登录，不要重复登录", HttpStatus.OK);
        }

        // 未登录逻辑
        session.setAttribute("username", username);
        session.setAttribute("info", info);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/info")
    public ResponseEntity<String> info(HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (null != session.getAttribute("username") && !"".equals(session.getAttribute("username"))) {
            // 已经登录逻辑
            return new ResponseEntity<>(session.getAttribute("username") + " : " + session.getAttribute("info").toString(), HttpStatus.OK);
        }
        return new ResponseEntity<>("暂未登录", HttpStatus.OK);
    }
}
