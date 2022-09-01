package com.oa.utils;

import junit.framework.TestCase;
import org.junit.Test;

public class ResponseUtilsTest extends TestCase {

    @Test
    public void testPut() {
        ResponseUtils responseUtils = new ResponseUtils("LoginException", "密码错误").put("class1", "FirstClass").put("class2", "SecondClass");
        System.out.println(responseUtils.toJsonString());
    }

}