package com.lt.blog.controller;


import com.lt.blog.entity.GroupBlogger;
import com.lt.blog.entity.vo.GroupVo;
import com.lt.blog.service.GroupBloggerService;
import com.lt.utils.ReturnResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 小狐
 * @since 2020-06-28
 */
@Api(produces = "博客分组")
@RestController
@RequestMapping("/blog/group")
public class GroupBloggerController {

    @Autowired
    private GroupBloggerService groupBloggerService;

    @GetMapping("/getAllGroup")
    public ReturnResult getAllGroup() {
        ReturnResult result = groupBloggerService.selectAll();
        return result;
    }

    @GetMapping("/getAllGroup/count")
    public ReturnResult getGroupCount () {
        ReturnResult result = groupBloggerService.getGroupCount();

        return result;
    }

    /**
     * 分组添加
     * TODO 幂等性问题
     * @param groupVo
     * @return
     */
    @PostMapping("/save")
    public ReturnResult saveGroup(@RequestBody GroupVo groupVo) {
        GroupBlogger blogger = new GroupBlogger();
        blogger.setGroupName(groupVo.getGroupName());

        boolean flag = groupBloggerService.save(blogger);

        if (!flag) {
            return ReturnResult.failed("添加新的分类失败");
        }

        return ReturnResult.success("添加新的分类",flag);


    }

}

