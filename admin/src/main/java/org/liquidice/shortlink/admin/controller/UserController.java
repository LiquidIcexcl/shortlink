package org.liquidice.shortlink.admin.controller;


import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.liquidice.shortlink.admin.common.convention.result.Result;
import org.liquidice.shortlink.admin.common.convention.result.Results;
import org.liquidice.shortlink.admin.dto.req.UserLoginReqDTO;
import org.liquidice.shortlink.admin.dto.req.UserRegisterReqDTO;
import org.liquidice.shortlink.admin.dto.req.UserUpdateReqDTO;
import org.liquidice.shortlink.admin.dto.resp.UserActualRespDTO;
import org.liquidice.shortlink.admin.dto.resp.UserLoginRespDTO;
import org.liquidice.shortlink.admin.dto.resp.UserRespDTO;
import org.liquidice.shortlink.admin.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理-控制层
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 根据用户名获取用户信息
     */
    @GetMapping("/api/shortlink/admin/v1/user/{username}")
    public Result<UserRespDTO> getUserByUsername
        (@PathVariable("username") String username) {
        return Results.success
                (userService.getUserByUsername
                        (username));
    }

    /**
     * 根据用户名获取用户信息（无脱敏）
     */
    @GetMapping("/api/shortlink/admin/v1/actual/user/{username}")
    public Result<UserActualRespDTO> getActualUserByUsername
    (@PathVariable("username") String username) {
        return Results.success
                (
                        BeanUtil.toBean(userService.getUserByUsername
                        (username), UserActualRespDTO.class)
                );
    }


    /**
     * 检查用户名是否存在
     * @param username
     * @return 存在返回true，不存在返回false
     */
    @GetMapping("/api/shortlink/admin/v1/user/has-username")
    public Result<Boolean> hasUsername
            (@RequestParam("username") String username) {
            return Results.success(userService.hasUsername(username));
    }


    /**
     * 用户注册
     */
    @PostMapping("/api/shortlink/admin/v1/user")
    public Result<Void> register
            (@RequestBody UserRegisterReqDTO requestParam) {
        userService.register(requestParam);
        return Results.success();
    }

    /**
     * 修改用户
     */
    @PutMapping("/api/shortlink/admin/v1/user")
    public Result<Void> updateUser
            (@RequestBody UserUpdateReqDTO requestParam) {
        userService.update(requestParam);
        return Results.success();
    }

    /**
     * 用户登入
     */
    @PostMapping("/api/shortlink/admin/v1/user/login")
    public Result<UserLoginRespDTO> login
            (@RequestBody UserLoginReqDTO requestParam) {
        return Results.success(userService.login(requestParam));
    }

    /**
     * 验证用户是否登入
     */
    @GetMapping("/api/shortlink/admin/v1/user/check-login")
    public Result<Boolean> checkLogin
            (@RequestParam("username") String username, @RequestParam("token") String token) {
        return Results.success(userService.checkLogin(username, token));
    }


    /**
     * 用户登出
     */
    @DeleteMapping("/api/shortlink/admin/v1/user/logout")
    public Result<Void> logout
            (@RequestParam("username") String username, @RequestParam("token") String token) {
        userService.logout(username, token);
        return Results.success();
    }
}
