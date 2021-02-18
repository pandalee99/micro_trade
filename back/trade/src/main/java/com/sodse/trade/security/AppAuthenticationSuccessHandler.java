//package com.sodse.trade.security;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.DefaultRedirectStrategy;
//import org.springframework.security.web.RedirectStrategy;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Component
//public class AppAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//
//    //spring security 通过RedirectStrategy 对象负责所有重定向事务
//    private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
//
//    /*
//    重写 handle 方法，方法中通过 RedirectStrategy 对象重定向到指定的url
//     */
//
//    @Override
//    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        //通过determineTargetURL方法返回需要跳转的URL
//        String targetUrl=determineTargetUrl(authentication);
//        //重定向请求指定的URL
//        redirectStrategy.sendRedirect(request,response,targetUrl);
//    }
//    /*
//    从Authentication 对象中提取当前登录用户的角色，并根据其角色返回适当的URL
//     */
//
//    protected String determineTargetUrl(Authentication authentication) {
//        String url="";
//
//        // 重点理解 ：获取当前登录用户的角色权限到集合 authentication
//        Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
//        //Collection是最基本的集合接口，
//        // 一个Collection代表一组Object，即Collection的元素（Elements）。
//        // 一些Collection允许相同的元素而另一些不行。一些能排序而另一些不行。
//        // Java SDK不提供直接继承自Collection的类，
//        // Java SDK提供的类都是继承自Collection的“子接口”如List和Set。
//
//        List<String> roles=new ArrayList<String>();
//
//        //将角色名称添加到List集合
//        for (GrantedAuthority a:authorities)
//        {
//           roles.add(a.getAuthority());
//        }
//        //判断不同角色跳转到不同的URL
//        if(isAdmin(roles))
//        {
//            url="/admin";
//        }else if (isUser(roles)){
//            url="/shop";
//        }else {url="/accessDenied";
//        }
//        System.out.println("url="+url);
//        return url;
//    }
//
//    private boolean isUser(List<String> roles) {
//        if (roles.contains("ROLE_USER")){
//            return true;
//        }
//        return false;
//    }
//
//    private boolean isAdmin(List<String> roles) {
//        if (roles.contains("ROLE_ADMIN")){
//            return true;
//        }
//        return false;
//    }
//    //set 和  get
//
//    @Override
//    public RedirectStrategy getRedirectStrategy() {
//        return redirectStrategy;
//    }
//
//    @Override
//    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
//        this.redirectStrategy = redirectStrategy;
//    }
//}
