package com.comedor.controller;



@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	UsuarioServiceImpl UsuariosServideImpl;
	
	@GetMapping("/usuario")
	public List<Usuario> listarUsuarios(){
		return UsuariosServideImpl.listarUsuarios();
	}
	
	
	
	@PostMapping("/usuario")
	public Usuario salvarUsuarios(@RequestBody Usuario usuarios) {
		
		return UsuariosServideImpl.guardarUsuarios(usuarios);
	}
	
	
	@GetMapping("/usuario/{id}")
	public Usuario reservasXID(@PathVariable(name="id") int id) {
		
		Usuario usuarios_xid= new Usuario();
		
		usuarios_xid=UsuariosServideImpl.UsuariosXID(id);
		
		System.out.println("Usuario XID: "+usuarios_xid);
		
		return usuarios_xid;
	}
	
	@PutMapping("/usuario/{id}")
	public Usuario actualizarUsuarios(@PathVariable(name="id")int id,@RequestBody Usuario usuarios) {
		
		Usuario usuarios_seleccionado= new Usuario();
		Usuario usuarios_actualizado= new  Usuario();
		
		usuarios_seleccionado= UsuariosServideImpl.UsuariosXID(id);
		
		usuarios_seleccionado.setNombreUsuario(usuarios.getNombreUsuario());
		usuarios_seleccionado.setEmail(usuarios.getEmail());
		usuarios_seleccionado.setContraseña(usuarios.getContraseña());
		usuarios_seleccionado.setRoles_id(usuarios.getRoles_id());
		usuarios_actualizado = UsuariosServideImpl.actualizarUsuarios(usuarios_actualizado);
		
		System.out.println("El Usuario actualizado es: "+ usuarios_actualizado);
		
		return usuarios_actualizado;
	}
	
	@DeleteMapping("/usuario/{id}")
	public void eliminarUsuarios(@PathVariable(name="id")int id) {
		UsuariosServideImpl.eliminarUsuarios(id);
	}
	
	
}
