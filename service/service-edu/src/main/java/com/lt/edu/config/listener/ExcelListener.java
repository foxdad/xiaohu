package com.lt.edu.config.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lt.config.execptionhandler.LtExecption;
import com.lt.edu.entity.Subject;
import com.lt.edu.entity.vo.SubjectVo;
import com.lt.edu.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName: ExcelListener
 * Description:
 * date: 2020/5/25 16:27
 *
 * @author 刘腾
 * @since JDK 1.8
 */
public class ExcelListener extends AnalysisEventListener<SubjectVo> {

    public SubjectService subjectService;

    public ExcelListener() {
    }

    public ExcelListener(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    //一行一行的读取
    @Override
    public void invoke(SubjectVo subjectVo, AnalysisContext analysisContext) {
//        subjectService.save(subjectVo)
        //excle里面没有数据时
        if (subjectVo == null) {
            throw new LtExecption(20001,"课程添加失败");
        }
        //一级分类是否有(数据库没有就添加)
        Subject subject = this.existsParent(subjectService,subjectVo.getOneSubject());
        if (subject==null) {
            subject = new Subject();
            //一级分类名字
            subject.setTitle(subjectVo.getOneSubject());
            subject.setParentId("0");
            subjectService.save(subject);
        }
        String sId =  subject.getId();
        System.out.println(sId);
        //二级分类添加(数据库没有就添加)
        Subject subjectTwo = existsTwoParent(subjectService,subjectVo.getTwoSubject(),sId);
        if (subjectTwo==null) {
            subjectTwo = new Subject();
            //二级分类名字
            subjectTwo.setTitle(subjectVo.getTwoSubject());
            subjectTwo.setParentId(sId);
            subjectService.save(subjectTwo);
        }
    }
    //判断一级
    public Subject existsParent(SubjectService subjectService,String name) {
        QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title",name);
        queryWrapper.eq("parent_id","0");
        Subject subject = subjectService.getOne(queryWrapper);
        return subject;
    }
    //判断二级
    public Subject existsTwoParent(SubjectService subjectService,String name,String pid) {
        QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title",name);
        queryWrapper.eq("parent_id",pid);
        Subject subject = subjectService.getOne(queryWrapper);
        return subject;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
