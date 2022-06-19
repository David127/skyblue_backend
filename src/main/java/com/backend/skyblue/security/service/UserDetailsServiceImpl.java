package com.backend.skyblue.security.service;

import com.backend.skyblue.security.entity.Usuario;
import com.backend.skyblue.security.entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsuarioSevice usuarioSevice;
    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioSevice.getByNombreUsuario(nombreUsuario).get();

        return UsuarioPrincipal.build(usuario);
    }
    
}
