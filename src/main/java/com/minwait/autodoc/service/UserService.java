package com.minwait.autodoc.service;

import com.minwait.autodoc.entity.User;
import com.minwait.autodoc.page.Page;
import com.minwait.autodoc.page.PageParam;
import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @author by xunmi
 * 2020/4/10 9:57
 * @version 1.0
 */
@Service
public class UserService {

    public Page<User> page(User user, PageParam pageParam) {
        return new Page<>();
    }

    public User get(Long id) {
        User user = new User();
        user.setId(1L);
        user.setName("demo");
        user.setUsername("admin");
        user.setPassword("1");
        return user;
    }

    public User save(User user) {
        return new User();
    }

    public void delete(Long id) {

    }
}
