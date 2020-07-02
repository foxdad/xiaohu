package com.lt.edu.entity.vo.subject;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: TwoSubject
 * Description:
 * date: 2020/5/26 11:53
 *
 * @author 刘腾
 * @since JDK 1.8
 */
@Data
public class TwoSubject implements Serializable {

//    private List<TwoSubject> childrenList;
    private String id;

    private String title;
}
