package com.lt;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ListTest
 * Description:
 * date: 2020/6/10 9:53
 *
 * @author 刘腾
 * @since JDK 1.8
 */
public class ListTest {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList();
        integerList.add(1);
        integerList.add(2);
        System.out.println(integerList.toString());
    }
}
