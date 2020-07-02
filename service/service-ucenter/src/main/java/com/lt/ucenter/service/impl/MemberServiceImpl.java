package com.lt.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lt.ucenter.entity.Member;
import com.lt.ucenter.entity.vo.LoginVo;
import com.lt.ucenter.entity.vo.RegisterVo;
import com.lt.ucenter.mapper.MemberMapper;
import com.lt.ucenter.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lt.utils.JwtUtils;
import com.lt.utils.ReturnResult;
import com.lt.utils.cacheName.EhcacheUtils;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author 小狐
 * @since 2020-06-10
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 注册
     * @param registerVo
     * @return
     */
    @Override
    public ReturnResult register(RegisterVo registerVo) {

        //判断验证码是否正确
        String redsiResult = redisTemplate.opsForZSet().range(registerVo.getMobile(), 0, -1).toArray()[0].toString();
        if (!registerVo.getCode().equals(redsiResult)) {
            return ReturnResult.failed("验证码不正确");
        }
        //判断是否已经注册过了
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile",registerVo.getMobile());
        Integer count = baseMapper.selectCount(queryWrapper);
        if (count>0) {
            return ReturnResult.failed("此用户已注册");
        }
        //加密的密码
        registerVo.setPassword(DigestUtils.md5DigestAsHex(registerVo.getPassword().getBytes()).toString());
        Member member = new Member();
        BeanUtils.copyProperties(registerVo,member);
        int insert = baseMapper.insert(member);
        if (insert>0) {
            return ReturnResult.success("注册成功",insert);
        }
        return ReturnResult.failed("服务器错误");
    }

    /**
     * TODO token存入到redis中
     * 登录
     * @param loginVo
     * @return
     */
    @Override
    public ReturnResult login(LoginVo loginVo,String virtualIp) {
        //查询数据库数据
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile",loginVo.getMobile());
        queryWrapper.eq("password",DigestUtils.md5DigestAsHex(loginVo.getPassword().getBytes()));
        Member member = baseMapper.selectOne(queryWrapper);
        if (member==null) {
//            if(StringUtils.hasText(loginVo.getOperid())) {
//                return ReturnResult.failed("此账号还没有注册");
//            }
            return ReturnResult.failed("账号或密码不正确");
        }
        //修改登录地址的ip
        member.setIpAddr(virtualIp);
        //判断是否要来绑定微信号
        if(loginVo.getOperid()!=null) {
            //先删除待有次operid的用户
            QueryWrapper<Member> deleteWraper = new QueryWrapper<>();
            deleteWraper.eq("openid",loginVo.getOperid());
            baseMapper.delete(deleteWraper);
            member.setOpenid(loginVo.getOperid());
        }
        baseMapper.updateById(member);
        //返回令牌
        String jwtToken = JwtUtils.getJwtToken(member.getId(), member.getNickname());
        System.out.println("令牌是：--："+jwtToken);

        return ReturnResult.success("登录成功",jwtToken);
    }

    @Override
    public Member getByOpenid(String openid) {
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openid", openid);

        Member member = baseMapper.selectOne(queryWrapper);
        return member;
    }
}
