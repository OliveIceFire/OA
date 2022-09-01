package com.oa.utils;

import junit.framework.TestCase;
import org.junit.Test;

public class Md5UtilsTest extends TestCase {

    @Test
    public void testMd5Digest() {
        System.out.println(Md5Utils.md5Digest("123456"));
    }


    public void testMd5Digest2() {
        System.out.println(Md5Utils.md5Digest("123456", 888));
    }
}