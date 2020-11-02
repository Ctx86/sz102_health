package com.itheima.health.security;

import com.itheima.health.pojo.Permission;
import com.itheima.health.pojo.Role;
import com.itheima.health.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

/**
 * @Author:Tianxiao
 * @Date: 2020/10/31 20:34
 */
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.itheima.health.pojo.User userInDB = findByUsername(username);

        List<GrantedAuthority> authorities = new ArrayList<>();


        Set<Role> roles = userInDB.getRoles();
        if (null != roles) {
            for (Role role : roles) {

                GrantedAuthority ga = new SimpleGrantedAuthority(role.getName());
                authorities.add(ga);
                for (Permission permission : role.getPermissions()) {
                    ga = new SimpleGrantedAuthority(permission.getName());
                    authorities.add(ga);
                }
            }
        }

        org.springframework.security.core.userdetails.User user =
                new org.springframework.security.core.userdetails.User(username, "{noop}" + userInDB.getPassword(), authorities);
        return user;
    }

    /*模仿从数据库中查询数据*/
    private com.itheima.health.pojo.User findByUsername(String username) {
        if ("admin".equals(username)) {
            com.itheima.health.pojo.User user = new User();
            user.setUsername("admin");
            user.setPassword("admin");

            Role role = new Role();
            role.setName("ROLE_ADMIN");
            Permission permission = new Permission();
            permission.setName("ADD_CHECKITEM");
            role.getPermissions().add(permission);

            Set<Role> roleList = new HashSet<>();
            roleList.add(role);

            user.setRoles(roleList);
            return user;

        }

        return null;
    }
}
