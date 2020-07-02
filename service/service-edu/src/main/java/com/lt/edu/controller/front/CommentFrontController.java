package com.lt.edu.controller.front;

import com.lt.config.execptionhandler.LtExecption;
import com.lt.edu.entity.Comment;
import com.lt.edu.entity.vo.comment.CommentVo;
import com.lt.edu.service.CommentService;
import com.lt.utils.ReturnResult;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * ClassName: CommentFrontController
 * Description:
 * date: 2020/6/15 11:11
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Api(produces = "课程分类")
@Validated
@RestController
@RequestMapping("/edu/comment")
//@CrossOrigin
public class CommentFrontController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/getPageList/{courseId}/{page}/{pageSize}")
    public ReturnResult getPageComment (@PathVariable("page")@Min(value = 1,message = "bad request") Long page ,
                                        @PathVariable("pageSize")@Min(value = 1,message = "bad request") Long pageSize,
                                        @PathVariable("courseId")@NotNull(message = "课程没有找到") String courseId) {
//        if (StringUtils.isEmpty(courseId)||page<=0 || pageSize<0) {
//            throw new LtExecption(20001,"数据查询失败");
//        }
        ReturnResult result = commentService.getPageList(page,pageSize,courseId);

        return result;
    }

    /**
     * 实体类采用注解来验证
     *
     * @param commentVo
     * @return
     */
    @PostMapping("/save/Comment")
    public ReturnResult saveComment(@RequestBody CommentVo commentVo) {
        Comment comment = new Comment();
        //复制属性
        BeanUtils.copyProperties(commentVo,comment);
        boolean flag = commentService.save(comment);
        if (flag){
            return ReturnResult.success("评论添加成功",flag);
        }
        return ReturnResult.failed("评论添加失败");
    }

}
