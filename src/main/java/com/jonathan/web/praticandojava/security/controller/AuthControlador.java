package com.jonathan.web.praticandojava.security.controller;

import java.util.HashSet;
import java.util.Set;

import com.jonathan.web.praticandojava.security.dto.LoginDTO;
import com.jonathan.web.praticandojava.security.dto.RegistroDTO;
import com.jonathan.web.praticandojava.security.entity.Rol;
import com.jonathan.web.praticandojava.security.entity.Usuario;
import com.jonathan.web.praticandojava.security.jwt.JWTAuthResonseDTO;
import com.jonathan.web.praticandojava.security.jwt.JwtTokenProvider;
import com.jonathan.web.praticandojava.security.repository.RolRepositorio;
import com.jonathan.web.praticandojava.security.repository.UsuarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthControlador {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private RolRepositorio rolRepositorio;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@PostMapping("/login")
	public ResponseEntity<JWTAuthResonseDTO> authenticateUser(@RequestBody LoginDTO loginDTO) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		// obtenemos el token del jwtTokenProvider
		String token = jwtTokenProvider.generarToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		JWTAuthResonseDTO jwtAuthResonseDTO = new JWTAuthResonseDTO(token, userDetails.getUsername(),
				userDetails.getAuthorities());

		return new ResponseEntity<>(jwtAuthResonseDTO, HttpStatus.OK);
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> registrarUsuario(@RequestBody RegistroDTO registroDTO) {
		if (usuarioRepositorio.existsByUsername(registroDTO.getUsername())) {
			return new ResponseEntity<>("Ese nombre de usuario ya existe", HttpStatus.BAD_REQUEST);
		}

		if (usuarioRepositorio.existsByEmail(registroDTO.getEmail())) {
			return new ResponseEntity<>("Ese email de usuario ya existe", HttpStatus.BAD_REQUEST);
		}

		Usuario usuario = new Usuario();
		usuario.setNombre(registroDTO.getNombre());
		usuario.setUsername(registroDTO.getUsername());
		usuario.setEmail(registroDTO.getEmail());
		usuario.setPassword(passwordEncoder.encode(registroDTO.getPassword()));

		Set<Rol> roles = new HashSet<>();
		roles.add(rolRepositorio.findByNombre("ROLE_USER").get());
		if (registroDTO.getRoles().contains("admin")) {
			roles.add(rolRepositorio.findByNombre("ROLE_ADMIN").get());
		}
		usuario.setRoles(roles);
		usuarioRepositorio.save(usuario);
		return new ResponseEntity<>("Usuario registrado exitosamente", HttpStatus.OK);
	}
}
