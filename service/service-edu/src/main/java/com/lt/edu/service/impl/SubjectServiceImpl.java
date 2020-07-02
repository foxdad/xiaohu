package com.lt.edu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.lt.edu.config.listener.ExcelListener;
import com.lt.edu.entity.Subject;
import com.lt.edu.entity.vo.SubjectVo;
import com.lt.edu.entity.vo.subject.OneSubject;
import com.lt.edu.entity.vo.subject.TwoSubject;
import com.lt.edu.mapper.SubjectMapper;
import com.lt.edu.service.SubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author 刘腾
 * @since 2020-05-25
 */
@Service
@Slf4j
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {
    @Autowired
    SubjectMapper subjectMapper;

    @Override
    public void addSubject(MultipartFile multipartFile,SubjectService subjectService) {
        try{
            InputStream inputStream = multipartFile.getInputStream();
            EasyExcel.read(inputStream, SubjectVo.class,new ExcelListener(subjectService)).sheet().doRead();
        }catch (Exception e){
            log.error("解析Excel出错");
            e.printStackTrace();
        }

    }

    @Override
    public List<OneSubject> getAllSubject() {
        String id = "0";

        List<OneSubject>  list = subjectMapper.getAllSubject(id);
        return list;
    }
}
