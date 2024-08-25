/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.charlieshop.Charlieshop.service.impl;

import com.charlieshop.Charlieshop.dao.UsuarioDao;
import com.charlieshop.Charlieshop.domain.Rol;
import com.charlieshop.Charlieshop.domain.Usuario;
import com.charlieshop.Charlieshop.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tutti
 */
@Service("userDetailsService")

public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Se busca el registro en la tabla de usuario mediante el findByUsername
        Usuario usuario = usuarioDao.findByUsername(username);

        //Se valida si se recupero un usuario de la tabla
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }

        //Aca si se encuentra el usuario
        //Y aqui va la impresion de la foto
        
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());
        
        //Se buscan los roles
        var roles = new ArrayList<GrantedAuthority>();

        for (Rol r : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(r.getNombre()));
        }

        //se devuelve un usuario ya de tipo UserDetails
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
}
