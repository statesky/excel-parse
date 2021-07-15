package com.sina.算法;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 14.
 *
 * @author zhangbin
 * @version 1.0, 2020-09-05
 * @since excel-test 1.0.0
 */
public class 最长公共前缀 {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，则返回""
     */
    public static String solution(List<String> stringList) {
        if (stringList == null || stringList.size() == 0) {
            return "";
        }
        if (stringList.size() == 1) {
            return stringList.get(0);
        }
        String s = stringList.get(0);
        int length = s.length();
        for (int i = 1; i < stringList.size(); i++) {
            while (length > 0) {
                boolean flag = stringList.get(i).length() >= length && s.substring(0, length).equals(stringList.get(i).substring(0, length));
                if (flag) {
                    break;
                }
                length--;
            }
        }
        return s.substring(0, length);
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("asdf");
        stringList.add("asd");
        stringList.add("s");
        String s = solution(stringList);
        System.out.println(s);
    }
}
