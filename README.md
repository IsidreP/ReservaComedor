# ReservaComedor
Proyecto final bootcamp Java&amp;Angular 2022


MODELO ENTIDAD-RELACIÓN
![image](https://user-images.githubusercontent.com/89861246/168420985-0c7aa132-c957-4266-b756-ab42bc027d7a.png)


MODELO RELACIONAL

![image](https://user-images.githubusercontent.com/103040138/168540844-b8392eff-fac5-4b5f-8762-77952e1265d3.png)


BASE DE DATOS RELACIONAL

![image](https://user-images.githubusercontent.com/89861246/169401042-e244b971-0dd7-4509-88c3-c76e8a1272f5.png)

1. Listar según la entidad:

@GetMapping("/categirías")<br>
@GetMapping("/platos")<br>
@GetMapping("/usuarios")<br>
@GetMapping("/roles")<br>
@GetMapping("/franjas")<br>
@GetMapping("/pedirPlato")<br>
@GetMapping("/reservas")<br>

2. Listar solo un registro:

@GetMapping("/categorias/{id}")<br>
@GetMapping("/platos/{id}")<br>
@GetMapping("/usuarios/{id}")<br>
@GetMapping("/roles/{idRol}")<br>
@GetMapping("/franjas/{id}")<br>
@GetMapping("/pedirPlato/{id}")<br>
@GetMapping("/reservas/{id}")<br>

3. Crear nuevo registro:

@PostMapping("/categorias")<br>
@PostMapping("/platos")<br>
@PostMapping("/usuarios")<br>
@PostMapping("/roles")<br>
@PostMapping("/franjas")<br>
@PostMapping("/pedirPlato")<br>
@PostMapping("/reservas")<br>

4. Acualizar registro:

@PutMapping("/categorias/{id}")<br>
@PutMapping("/platos/{id}")<br>
@PutMapping("/usuarios/{id}")<br>
@PutMapping("/roles/{idRol}")<br>
@PutMapping("/franjas/{id}")<br>
@PutMapping("/pedirPlato/{id}")<br>
@PutMapping("/reservas/{id}")<br>

5. Eliminar registro:

@DeleteMapping("/categorias/{id}")<br>
@DeleteMapping("/platos/{id}")<br>
@DeleteMapping("/usuarios/{id}")<br>
@DeleteMapping("/roles/{idRol}")<br>
@DeleteMapping("/franjas/{id}")<br>
@DeleteMapping("/pedirPlato/{id}")<br>
@DeleteMapping("/reservas/{id}")<br>
