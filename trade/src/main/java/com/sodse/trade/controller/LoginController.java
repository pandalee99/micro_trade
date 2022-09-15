package com.sodse.trade.controller;

import cn.hutool.core.map.MapUtil;
import com.sodse.trade.common.dot.LoginDto;
import com.sodse.trade.common.lang.Result;
import com.sodse.trade.domain.User;
import com.sodse.trade.service.UserService;
import io.jsonwebtoken.lang.Assert;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController extends BaseController {

    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response) {

//        User user = userService.getOne(new QueryWrapper<User>().eq("username", loginDto.getUsername()));
//        Assert.notNull("user","用户不存在");//返回一个异常,在全局异常处理中
//        if(!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))){
//            return  Result.fail("密码不正确");
//        }
//        String jwt = jwtUtils.generateToken(user.getId());
//
//        response.setHeader("Authorization",jwt);//放置响应头中
//        response.setHeader("Access-control-Expose-Headers","Authorization");
//
//        return Result.succ(MapUtil.builder()
//                .put("id", user.getId())
//                .put("username", user.getUsername())
//                .put("avatar", user.getAvatar())
//                .put("email", user.getEmail())
//                .map()
//        );
        System.out.println();
        System.out.println("don`t to say");
        BCryptPasswordEncoder code=new BCryptPasswordEncoder();

        User user= userService.selectOneByUsername(loginDto.getUsername());
        if (user==null){
            return Result.succ("错误");
        }
        boolean flag = code.matches(
                loginDto.getPassword(),
                user.getPassword());
        if (!flag){
            return Result.succ("错误");
        }
        String jwt= authService.login( loginDto.getUsername(), loginDto.getPassword() );
        response.setHeader("Authorization",jwt);//放置响应头中
        response.setHeader("Access-control-Expose-Headers","Authorization");

        return Result.succ(user);

    }

//    @RequiresAuthentication//logout需要权限
//    @GetMapping("/logout")
//    @ResponseBody
//    @RequestMapping
//    public Result logout() {
//        System.out.println("注销");
////        SecurityUtils.getSubject().logout();
//        return Result.succ(null);
//    }

    @GetMapping("/qq")
    public Result test1() {
        System.out.println("11111111");
//        SecurityUtils.getSubject().logout();
        return Result.succ(null);
    }

    // 登录
    @RequestMapping(value = "/login2", method = RequestMethod.POST)
    public String createToken( String username,String password ) throws AuthenticationException {
        System.out.println("进入");
        return authService.login( username, password ); // 登录成功会返回JWT Token给用户
    }

//    @PostMapping(value = "/register")
//    public Integer register( @RequestBody User addedUser ) throws AuthenticationException {
//        return authService.register(addedUser);//返回1表示注册成功
//    }
    @PostMapping(value = "/register")
    public Result register(@Validated @RequestBody User register_user , HttpServletResponse response ) throws AuthenticationException {
        authService.register(register_user);


        String jwt= authService.login( register_user.getUsername(), register_user.getPassword() );

        User user= userService.selectOneByUsername(register_user.getUsername());

        response.setHeader("Authorization",jwt);//放置响应头中
        response.setHeader("Access-control-Expose-Headers","Authorization");

        return Result.succ(user);
    }

}
