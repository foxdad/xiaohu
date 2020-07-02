package com.lt.ucenter.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lt.ucenter.entity.Member;
import com.lt.ucenter.entity.vo.LoginVo;
import com.lt.ucenter.entity.vo.RegisterVo;
import com.lt.ucenter.service.MemberService;
import com.lt.utils.DayUtils;
import com.lt.utils.JwtUtils;
import com.lt.utils.ReturnResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author 小狐
 * @since 2020-06-10
 */
@Api(description = "登录接口")
@Validated
@RestController
@RequestMapping("/api/ucenter/member")
//@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * TODO实体类验证
     * @param loginVo
     * @param request
     * @return
     */
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public ReturnResult login(@RequestBody LoginVo loginVo, HttpServletRequest request) {
        if (loginVo==null) {
            return ReturnResult.failed("登录信息有误");
        }
        //获取用户登录ip
        String virtualIp = request.getRemoteAddr();
        //登录返回
        return memberService.login(loginVo,virtualIp);
    }

    /**
     * 实体类验证
     * @param registerVo
     * @return
     */
    @ApiOperation("用户注册")
    @PostMapping("/register")
    public ReturnResult register(@RequestBody RegisterVo registerVo) {
        if (registerVo==null) {
            return ReturnResult.failed("注册失败");
        }
        if (StringUtils.isEmpty(registerVo.getMobile()) ||
            StringUtils.isEmpty(registerVo.getPassword()) ||
            StringUtils.isEmpty(registerVo.getNickname()) ||
            StringUtils.isEmpty(registerVo.getCode())) {
            return ReturnResult.failed("请填写完整的注册信息");
        }
        ReturnResult result = memberService.register(registerVo);
        return result;
    }
    /**
     * 获取用户信息
     * @param request
     * @return
     */
    @ApiOperation("获取用户信息")
    @GetMapping("/getuserInfo")
    public ReturnResult getUserInfo (HttpServletRequest request) {

        String memberIdByJwtToken = JwtUtils.getMemberIdByJwtToken(request);
        Member result = memberService.getById(memberIdByJwtToken);
        if (result==null) {
            return ReturnResult.failed("获取信息失败");
        }
        return ReturnResult.success("获取用户信息成功",result);

    }

    /**
     * 获取昨天注册的人数
     * @return
     */
    @GetMapping("/countRegister")
    public ReturnResult countRegisterUser () {
        QueryWrapper<Member> memberQueryWrapper = new QueryWrapper<>();
        memberQueryWrapper.between("gmt_create", DayUtils.getYesterDay(),DayUtils.getNowDay());
        int count = memberService.count(memberQueryWrapper);

        return ReturnResult.success("查询成功",count);
    }



}

