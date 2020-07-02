package com.lt.edu.mapper;

import com.lt.edu.entity.Subject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lt.edu.entity.vo.subject.OneSubject;
import com.lt.edu.entity.vo.subject.TwoSubject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * <p>
 * 课程科目 Mapper 接口
 * </p>
 *
 * @author 刘腾
 * @since 2020-05-25
 */

public interface SubjectMapper extends BaseMapper<Subject> {

    List<OneSubject> getAllSubject(@Param("id") String id);
}
