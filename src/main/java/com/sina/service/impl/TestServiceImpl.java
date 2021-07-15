package com.sina.service.impl;

import com.sina.service.TestService;

/**
 * The xxx class for xxx.
 *
 * @author zhangbin
 * @version 1.0, 2020-06-11
 * @since excel-test 1.0.0
 */
public class TestServiceImpl implements TestService<Integer> {

    ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
    @Override
    public Integer getT() {
        return null;

    }
}
