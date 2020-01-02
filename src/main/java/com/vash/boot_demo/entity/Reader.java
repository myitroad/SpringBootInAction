package com.vash.boot_demo.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Collection;

@Data
@Entity
@Table(name = "user")
public class Reader implements UserDetails {

    @Id
    private Integer id;

    private String username;

    private String password;

    private Integer age;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO: 2020/1/2 授予 READER 权限
        return Arrays.asList(new SimpleGrantedAuthority("READER"));
    }

    // TODO: 2020/1/2 不过期 不加锁 不会被撤销 不禁用↓↓↓↓

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
