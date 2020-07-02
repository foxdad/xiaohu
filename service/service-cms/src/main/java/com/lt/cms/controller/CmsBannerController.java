package com.lt.cms.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lt.cms.entity.CrmBanner;
import com.lt.cms.service.CrmBannerService;
import com.lt.utils.ReturnResult;
import com.lt.utils.cacheName.EhcacheUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: CmsBannerController
 * Description:
 * date: 2020/6/9 14:09
 *
 * @author 刘腾
 * @since JDK 1.8
 */
@Api("banner查询")
@RestController
@RequestMapping("/cms/banner")
//@CrossOrigin
public class CmsBannerController {

    @Autowired
    private CrmBannerService crmBannerService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 获取前俩张banner的banner图片
     * @return
     */
    @Cacheable(key = "'towall'",value = EhcacheUtils.MY_CACHE)
    @ApiOperation("获取排名前俩个banner图片")
    @GetMapping("/two/all")
    public ReturnResult getAllBanner() {
        List<CrmBanner> list = null;
        String flag = redisTemplate.opsForValue().get(EhcacheUtils.cmsBannerController);
        if (StringUtils.hasText(flag)) {
            return ReturnResult.success("banner获取成功",JSON.parseArray(flag,CrmBanner.class));
        }else {
            QueryWrapper<CrmBanner> crmBannerQueryWrapper = new QueryWrapper<>();
            //获取俩张banner图片
            crmBannerQueryWrapper.orderByDesc("sort");
            crmBannerQueryWrapper.last("limit 2");

            list = crmBannerService.list(crmBannerQueryWrapper);
            if (CollectionUtils.isEmpty(list)) {
                return ReturnResult.failed("banner获取失败");
            }
            redisTemplate.opsForValue().set(EhcacheUtils.cmsBannerController, JSON.toJSONString(list));
        }
        return ReturnResult.success("banner获取成功",list);
    }
}
