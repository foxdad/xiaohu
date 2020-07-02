package com.lt.edu.service;

import com.lt.edu.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lt.edu.entity.vo.subject.OneSubject;
import com.lt.edu.entity.vo.subject.TwoSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author 刘腾
 * @since 2020-05-25
 */
public interface SubjectService extends IService<Subject> {

    void addSubject(MultipartFile multipartFile,SubjectService subjectService);

    List<OneSubject> getAllSubject();
}
