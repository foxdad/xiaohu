package com.lt.edu.controller.front;


import com.lt.config.execptionhandler.LtExecption;
import com.lt.edu.entity.CommentChilder;
import com.lt.edu.entity.vo.comment.CommentChilderVo;
import com.lt.edu.service.CommentChilderService;
import com.lt.utils.ReturnResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 小狐
 * @since 2020-06-16
 */
@Validated
@RestController
@RequestMapping("/edu/commentchilder")
//@CrossOrigin
public class CommentChilderFrontController {
    @Autowired
    private CommentChilderService commentChilderService;

    /**
     *
     * @param page
     * @param pageSize
     * @param courseId
     * @return
     */
    @GetMapping("/getchilder/{courseId}/{parentId}/{page}/{pageSize}")
    public ReturnResult getCommentChilder (@PathVariable("page")@Min(value = 1,message = "bad request") Long page , @PathVariable("pageSize")@Min(value = 1,message = "bad request")  Long pageSize,
                                           @PathVariable("courseId") String courseId, @PathVariable("parentId") String parentId) {
//        if (StringUtils.isEmpty(courseId)||page<=0 || pageSize<0) {
//            throw new LtExecption(20001,"数据查询失败");
//        }
        ReturnResult result = commentChilderService.getPageList(page,pageSize,courseId,parentId);

        return result;
    }


    /**
     * 回复楼主代码
     * @param commentChilderVo
     * @return
     */
    @PostMapping("/save/commentChilder")
    public ReturnResult saveCommentChilder (@RequestBody CommentChilderVo commentChilderVo) {
        CommentChilder commentChilder = new CommentChilder();
        //copy属性
        BeanUtils.copyProperties(commentChilderVo,commentChilder);
        //是否添加成功
        boolean flag = commentChilderService.save(commentChilder);
        if (flag) {
            return ReturnResult.success("评论成功",flag);
        }
        return ReturnResult.failed("评论失败");
    }

}

