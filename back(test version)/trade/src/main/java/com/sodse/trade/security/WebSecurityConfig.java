package com.sodse.trade.security;


import com.sodse.trade.filter.JwtTokenFilter;
import com.sodse.trade.service.UserService;
import com.sodse.trade.service.impl.MyUserDetailsService;
import com.sodse.trade.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsService myUserDetailsService;

//    @Autowired
//    AuthenticationSuccessHandler authenticationSuccessHandler;

    @Bean
    public JwtTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JwtTokenFilter();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception {
        auth.userDetailsService( myUserDetailsService ).passwordEncoder( new BCryptPasswordEncoder() );
    }

    @Override
    protected void configure( HttpSecurity httpSecurity ) throws Exception {

        httpSecurity
                .csrf()
                .disable()
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()

                //关闭防护

                .antMatchers("/").permitAll()//允许/、/login的访问

                .antMatchers("/user").hasRole("USER")//用户USER角色的用户访问有关/user下面的所有
                .antMatchers("/admin").hasRole("ADMIN")//同上
//                .anyRequest().authenticated()//其它所有访问都拦截
//                .and()
//                .formLogin()//添加登陆
//                .loginPage("/login").permitAll()//登陆页面“/login"允许访问
//                .defaultSuccessUrl("/")//成功默认跳转 url
//                .usernameParameter("userName")
//                .passwordParameter("passWord")
//                .permitAll()
                //设置注销操作
                //所有用户都可以访问（可以使用注销）
//                .and()
//                .exceptionHandling().accessDeniedPage("/error")
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers(HttpMethod.POST, "/register").permitAll()


//                .antMatchers(HttpMethod.GET, "/**").permitAll()
//                .antMatchers(HttpMethod.POST).authenticated()
//                .antMatchers(HttpMethod.PUT).authenticated()
//                .antMatchers(HttpMethod.DELETE).authenticated()
//                .antMatchers(HttpMethod.GET).authenticated()
//                .and()
//                .formLogin().loginPage("/login")
//                //开始设置登录操作
//                //设置登录页面的访问地址
//
//                .successHandler(authenticationSuccessHandler)
                //设置了一个认证处理，登录成功后不同用户需要跳转到不同的页面
                //以此认证，视为通行证// 开启跨域
                .and()
                .cors()
                .and()
//                .exceptionHandling().accessDeniedPage("/accessDenied")
        ;


        ;

        httpSecurity
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
        httpSecurity.headers().cacheControl();

//        http
//                // CSRF Token
//                .csrf()
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

//        httpSecurity.logout().logoutUrl("/logout").logoutSuccessUrl("/");
    }

}




//**/
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true) //开启权限注解,默认是关闭的
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    /**
//     * 自定义登录成功处理器
//     */
//    @Autowired
//    private UserLoginSuccessHandler userLoginSuccessHandler;
//    /**
//     * 自定义登录失败处理器
//     */
//    @Autowired
//    private UserLoginFailureHandler userLoginFailureHandler;
//    /**
//     * 自定义注销成功处理器
//     */
//    @Autowired
//    private UserLogoutSuccessHandler userLogoutSuccessHandler;
//    /**
//     * 自定义暂无权限处理器
//     */
//    @Autowired
//    private UserAuthAccessDeniedHandler userAuthAccessDeniedHandler;
//    /**
//     * 自定义未登录的处理器
//     */
//    @Autowired
//    private UserAuthenticationEntryPointHandler userAuthenticationEntryPointHandler;
//    /**
//     * 自定义登录逻辑验证器
//     */
//    @Autowired
//    private UserAuthenticationProvider userAuthenticationProvider;
//
//    /**
//     * 加密方式
//     * @Author Sans
//     * @CreateTime 2019/10/1 14:00
//     */
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    /**
//     * 注入自定义PermissionEvaluator
//     */
//    @Bean
//    public DefaultWebSecurityExpressionHandler userSecurityExpressionHandler(){
//        DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
//        handler.setPermissionEvaluator(new UserPermissionEvaluator());
//        return handler;
//    }
//
//    /**
//     * 配置登录验证逻辑
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth){
//        //这里可启用我们自己的登陆验证逻辑
//        auth.authenticationProvider(userAuthenticationProvider);
//    }
//
//    /**
//     * 配置security的控制逻辑
//     * @author zwq
//     * @date 2020/4/4
//     * @param http
//     * @return
//     **/
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                // 不进行权限验证的请求或资源(从配置文件中读取)
//               .antMatchers(JWTConfig.antMatchers.split(",")).permitAll()
//                // 其他的需要登陆后才能访问  其他url都需要验证
//                .anyRequest().authenticated()
//                .and()
//                // 配置未登录自定义处理类
//                .httpBasic().authenticationEntryPoint(userAuthenticationEntryPointHandler)
//                .and()
//                // 配置登录地址
//                .formLogin()
//                //配置security表单登录页面地址 默认是login
//                .loginPage("/login")
//                //配置security提交form表单请求的接口地址 默认是/login/userLogin
//                .loginProcessingUrl("/myLoginForm")
//                //设置security提交的用户名属性值是那个 默认是username
//                .usernameParameter("userName")
//                //设置security提交的密码属性名是那个 默认是password
//                .passwordParameter("passWord")
//                //.successForwardUrl("/success")  登录成功跳转的请求 集成thymeleaf已经测试过了
//                //配置登录失败页
//                //.failureForwardUrl("/error")
//                // 配置登录成功自定义处理类
//                .successHandler(userLoginSuccessHandler)
//                // 配置登录失败自定义处理类
//                .failureHandler(userLoginFailureHandler)
//                .and()
//                // 配置登出地址
//                .logout()
//                .logoutUrl("/login/userLogout")
//                // 配置用户登出自定义处理类
//                .logoutSuccessHandler(userLogoutSuccessHandler)
//                .and()
//                // 配置没有权限自定义处理类
//                .exceptionHandling().accessDeniedHandler(userAuthAccessDeniedHandler)
//                .and()
//                // 开启跨域
//                .cors()
//                .and()
//                // 取消跨站请求伪造防护
//                .csrf().disable();
//        // 基于Token不需要session
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        // 禁用缓存
//        http.headers().cacheControl();
//        // 添加JWT过滤器
//        http.addFilter(new JWTAuthenticationTokenFilter(authenticationManager()));
//    }
