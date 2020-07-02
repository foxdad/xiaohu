package com.lt.cms.controller;


import com.lt.cms.entity.CrmBanner;
import com.lt.cms.service.CrmBannerService;
import com.lt.utils.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author 小狐同学
 * @since 2020-06-09
 */
@RestController
@RequestMapping("/cms/banner")
//@CrossOrigin
public class CrmAdminBannerController {

    @Autowired
    private CrmBannerService crmBannerService;

    /**
     * 获取所有的banner图片
     * @return
     */
    @GetMapping("/banner/all")
    public ReturnResult getAllBanner() {
        List<CrmBanner> list = crmBannerService.list(null);
        if (CollectionUtils.isEmpty(list)) {
            return ReturnResult.failed("banner获取失败");
        }
        return ReturnResult.success("banner获取成功",list);
    }

    /**
     * 根据id删除banner图片
     * @param id
     * @return
     */
    @DeleteMapping("/removebanner/{id}")
    public ReturnResult deleteBanner(@PathVariable("id") String id ) {
        boolean result = crmBannerService.removeById(id);
        if (!result) {
            return ReturnResult.failed("删除失败");
        }
        return ReturnResult.success("删除成功",result);
    }


}

