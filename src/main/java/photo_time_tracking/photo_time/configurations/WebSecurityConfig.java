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
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import photo_time_tracking.photo_time.constant.SystemConstant;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) // security strict
public class WebSecurityConfig {
    @Autowired
    CustomUserDetailService customUserDetailService;

    private static final String USER = "ROLE_USER";
    private static final String ADMIN = "ROLE_ADMIN";

    private static final String[] permitAllApis = {
            "/api/auth/**",
    };

    private static final String[] apiDoc = {
            SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_PUBLIC + SystemConstant.API_USER + SystemConstant.API_ALL,
            SystemConstant.API + SystemConstant.VERSION_1 + SystemConstant.API_PUBLIC + SystemConstant.API_ALL,
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
        System.out.println("authenticationProvider");
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationsFilter jwtAuthenticationsFilter) throws Exception {

        System.out.println("security filter - Web security Config");

        http.csrf(AbstractHttpConfigurer::disable)
//                .cors(corsConfigurer -> {
//                    CorsConfigurationSource source = request -> {
//                        CorsConfiguration config = new CorsConfiguration();
//                        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
//                        config.setAllowedHeaders(List.of("*"));
//                        return config;
//                    };
//                    corsConfigurer.configurationSource(source);
//                })
                .cors(corsConfigurer -> corsConfigurer.disable())
                .authorizeHttpRequests(req -> req
                        .requestMatchers(permitAllApis).permitAll()
                        .requestMatchers(apiDoc).permitAll()
//                        .requestMatchers(anyAuthorityUserApis).hasAnyAuthority(USER)
//                        .requestMatchers(anyAuthorityAdminApis).hasAnyAuthority(ADMIN)
                        .requestMatchers(anyAuthorityAdminApis).permitAll()
                        .requestMatchers("http://localhost:1001/care-health/api/v1/public/user/login").permitAll()
                        .anyRequest()
                        .permitAll())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationsFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
