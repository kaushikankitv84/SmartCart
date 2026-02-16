package SmartCart.Registration.Registration.Service;

import SmartCart.Registration.Registration.Entity.MasterEntity;
import SmartCart.Registration.Registration.Entity.UserPrincipal;
import SmartCart.Registration.Registration.Repository.MasterRepository;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.NullMarked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@NullMarked
public class UserDetailServiceImpl implements UserDetailsService {


    @Autowired
    private MasterRepository masterRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MasterEntity user = masterRepository.findByUsername(username);
        if (user!=null){
            List<SimpleGrantedAuthority> authorities = Arrays.stream(user.getRoles().split(","))
                    .map(SimpleGrantedAuthority::new)
                    .toList();

            return new UserPrincipal(
                    user.getUsername(),
                    user.getPassword(),
                    authorities,
                    user.getSmartCartId()
            );
        }
        throw new UsernameNotFoundException("User not available " + username);
    }
}
