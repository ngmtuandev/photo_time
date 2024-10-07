package photo_time_tracking.photo_time.configurations;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import photo_time_tracking.photo_time.entity.UserEntity;
import photo_time_tracking.photo_time.repositories.IUserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final IUserRepo usersRepo;

    public CustomUserDetailService(IUserRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = usersRepo.findByUserName(username);
        System.out.println("find user" + user.getUserName());
        if (user == null) {
            throw new UsernameNotFoundException("User not found !!!");
        }
        return CustomUserDetail.mapUserToDetail(user);
    }
}
