package photo_time_tracking.photo_time.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import photo_time_tracking.photo_time.constant.SystemConstant;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    @Autowired
    CustomUserDetailService customUserDetailService;

    private static final String USER = "USER";
    private static final String ADMIN = "ADMIN";

    private static final String[] permitAllApis = {
            "/api/auth/**",
    };

    private static final String[] apiDoc = {
            SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_PUBLIC + SystemConstant.API_USER + SystemConstant.API_ALL,
            SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_PUBLIC + SystemConstant.API_ALL,
            // TEMPO
            SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_ADMIN + SystemConstant.API_ALL,
            "/swagger-ui/**",
            "/swagger-ui.html"
    };

    private static final String[] anyAuthorityAdminApis = {
            SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_ADMIN + SystemConstant.API_ALL,
            SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_PUBLIC + SystemConstant.API_ALL,
            SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_ADMIN + SystemConstant.API_USER + SystemConstant.API_ALL,
    };

    @Bean
    JwtAuthenticationsFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationsFilter();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(permitAllApis).permitAll()
                        .requestMatchers(apiDoc).permitAll()
                        .requestMatchers(anyAuthorityAdminApis).hasRole(ADMIN)
                        .requestMatchers("/api/v1/user/**").hasAnyRole(USER, ADMIN)
                        .anyRequest().authenticated()
                )
                // no save token ==> stateless
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
