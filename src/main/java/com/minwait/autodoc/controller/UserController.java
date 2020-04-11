package com.minwait.autodoc.controller;


import com.minwait.autodoc.entity.User;
import com.minwait.autodoc.page.PageParam;
import com.minwait.autodoc.result.Result;
import com.minwait.autodoc.result.ResultBuilder;
import com.minwait.autodoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * UserController
 *
 * @author by xunmi
 * @version 1.0
 * 2020/3/9 15:49
 */
@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 分页查询
     *
     * @param user      查询条件
     * @param pageParam 分页参数
     * @return
     */
    @GetMapping
    public Result page(User user, PageParam pageParam) {
        return ResultBuilder.create().success().data(userService.page(user, pageParam)).build();
    }

    /**
     * 获取单个用户
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("{id:\\d+}")
    public Result get(@PathVariable Long id) {
        return ResultBuilder.create().success().data(userService.get(id)).build();
    }

    /**
     * 保存用户
     *
     * @param user 用户
     * @return 保存结果
     */
    @PostMapping
    public Result save(@Valid @RequestBody User user) {
        return ResultBuilder.create().success(userService.save(user)).build();
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 删除结果
     */
    @DeleteMapping("{id:\\d+}")
    public Result delete(@PathVariable Long id) {
        userService.delete(id);
        return ResultBuilder.create().success().build();
    }
}
