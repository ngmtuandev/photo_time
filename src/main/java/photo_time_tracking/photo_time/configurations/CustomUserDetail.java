package photo_time_tracking.photo_time.configurations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import photo_time_tracking.photo_time.entity.UserEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomUserDetail implements UserDetails {
    private String userName;

    @JsonIgnore
    private String password;

    private boolean status;

    public CustomUserDetail(String userName, String password, boolean status, List<GrantedAuthority> authorities) {
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.authorities = authorities;
    }

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities; // get role of this user
    }


    // from info user transfer info custom user detail of security
    public static CustomUserDetail mapUserToDetail(UserEntity user) {

        System.out.println("CustomUserDetail");

        // get all role of user
        List<GrantedAuthority> listAuthoritys = new ArrayList<>();
        listAuthoritys.add(new SimpleGrantedAuthority(user.getRole().getRoleName().name()));
        // return a customer user detail
        return new CustomUserDetail(
                user.getUserName(),
                user.getPassword(),
                user.getStatus(),
                listAuthoritys
        );
    }


    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
