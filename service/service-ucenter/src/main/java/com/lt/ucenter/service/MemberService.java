package com.lt.ucenter.service;

import com.lt.ucenter.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lt.ucenter.entity.vo.LoginVo;
import com.lt.ucenter.entity.vo.RegisterVo;
import com.lt.utils.ReturnResult;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author 小狐
 * @since 2020-06-10
 */
public interface MemberService extends IService<Member> {

    ReturnResult register(RegisterVo registerVo);

    ReturnResult login(LoginVo loginVo,String virtualIp);

    Member getByOpenid(String openid);
}
