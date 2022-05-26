package com.comedor.controller;

@RestController
@RequestMapping("/api")
public class RolController {
	
	@Autowired
	 RolServiceImpl  RolServideImpl;
	
	@GetMapping("/rol")
	public List< Rol> listarRol(){
		return  RolServideImpl.listarRol();
	}
	
	
	
	@PostMapping("/rol")
	public  Rol salvarRol(@RequestBody  Rol rol) {
		
		return  RolServideImpl.guardarRol(rol);
	}
	
	
	@GetMapping("/rol/{id}")
	public  Rol RolXID(@PathVariable(name="id") int id) {
		
		Rol equipos_xid= new  Rol();
		
		 equipos_xid=RolServideImpl.RolXID(id);
		
		System.out.println(" Rol XID: "+equipos_xid);
		
		return equipos_xid;
	}
	
	@PutMapping("/rol/{id}")
	public Rol actualizarRol(@PathVariable(name="id")int id,@RequestBody Rol rol) {
		
		Rol rol_seleccionado= new  Rol();
		Rol rol_actualizado= new   Rol();
		
		rol_seleccionado= RolServideImpl.RolXID(id);
		
		rol_seleccionado.setNombreRol(rol.getNombreRol());
		rol_seleccionado = RolServideImpl.actualizarRol(rol_actualizado);
		
		System.out.println("El rol actualizado es: "+ rol_actualizado);
		
		return rol_actualizado;
	}
	
	@DeleteMapping("/rol/{id}")
	public void eliminarRol(@PathVariable(name="id")int id) {
		RolServideImpl.eliminarRol(id);
	}
	
}