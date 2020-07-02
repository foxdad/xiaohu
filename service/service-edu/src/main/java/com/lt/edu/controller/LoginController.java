package com.lt.edu.controller;

import com.lt.utils.ReturnResult;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LoginController
 * Description:
 * date: 2020/5/21 15:45
 *
 * @author 刘腾
 * @since JDK 1.8
 */
@Controller
@RestController
//@CrossOrigin
@Api(description = "登录")
@RequestMapping("/edu/user")
public class LoginController {
    @PostMapping("/login")
    public ReturnResult login() {
        Map<String ,String > data = new HashMap<>();
        data.put("token","admin");
        return ReturnResult.success("成功",data);
    }
    @GetMapping("/info")
    public ReturnResult getInfo () {
        Map<String ,String > data = new HashMap<>();
        data.put("roles","admin");
        data.put("name","admin");
        return ReturnResult.success("成功",data);
    }
}
