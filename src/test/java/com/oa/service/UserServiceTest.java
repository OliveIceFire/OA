package com.oa.service;

import com.oa.entity.User;
import junit.framework.TestCase;
import org.junit.Test;

public class UserServiceTest extends TestCase {

    private UserService userService = new UserService();

    @Test
    public void testCheckLogin() {
        User user = userService.checkLogin("test", "test");
        System.out.println(user);
    }

    @Test
    public void testCheckLogin1() {
        User user = userService.checkLogin("admin", "admin");
        System.out.println(user);
    }

    @Test
    public void testCheckLogin2() {
        User user = userService.checkLogin("root", "root");
        System.out.println(user);
    }

    @Test
    public void testCheckLogin_Error() {
        User user = userService.checkLogin("root", "roo");
        System.out.println(user);
    }

    @Test
    public void testCheckLogin_Error2() {
        User user = userService.checkLogin("root", "roo");
        System.out.println(user);
    }

    @Test
    public void testCheckLoginSalt() {
        User user = userService.checkLogin("m8", "test");
        System.out.println(user);
    }
}