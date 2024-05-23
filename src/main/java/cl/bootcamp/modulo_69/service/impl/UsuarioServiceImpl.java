package cl.bootcamp.modulo_69.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import cl.bootcamp.modulo_69.entity.UsuarioEntity;
import cl.bootcamp.modulo_69.model.Usuario;
import cl.bootcamp.modulo_69.repository.UsuarioRepository;
import cl.bootcamp.modulo_69.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.apachecommons.CommonsLog;

@Service
@CommonsLog
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService  {

	private final UsuarioRepository usuarioRepository;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository= usuarioRepository;
	}
	
	
	@Override
	@Transactional
	public int crear(Usuario usuario) {
		try {
			
			
			UsuarioEntity usuarioEntity= new UsuarioEntity();
			usuarioEntity.setPassword(usuario.getPassword());
			usuarioEntity.setUsername(usuario.getUsername());
			
			UsuarioEntity usuarioGuardado=usuarioRepository.save(usuarioEntity);
			
			return usuarioGuardado.getId();
			
		}catch(Exception ex) {
			log.error(ex.getMessage());
			throw ex; 
		}
	}

	@Override
	public int editar(Usuario usuario) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioEntity usuario= usuarioRepository.searchByUsername(username);
		
		if(usuario != null) {
			List<GrantedAuthority> permissions= new ArrayList<>();
			
			GrantedAuthority ga= new SimpleGrantedAuthority("ROLE_"+usuario.getRol().name());
			permissions.add(ga);
			
			ServletRequestAttributes attr= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			
			HttpSession session= attr.getRequest().getSession(true);
			
			session.setAttribute("usuariosession", usuario);
			return new User(usuario.getUsername(),usuario.getPassword(),permissions);
		}
		
		return null;
	}

}
