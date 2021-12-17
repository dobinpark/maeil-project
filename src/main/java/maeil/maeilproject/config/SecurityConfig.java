package maeil.maeilproject.config;

import maeil.maeilproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MemberService memberService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage("/members/login") //로그인 페이지 URL
                .defaultSuccessUrl("/")      //로그인 성공 시, 이동할 URL
                .usernameParameter("email")  //로그인 시, 사용할 파라미터 이름(email로 지정)
                .defaultSuccessUrl("/members/login/error") //로그인 실패 시, 이동할 URL
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout")) //로그아웃 성공 시, 이동할 URL
                .logoutSuccessUrl("/");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(memberService)
                .passwordEncoder(passwordEncoder());
    }
}
