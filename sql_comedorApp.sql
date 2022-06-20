
use heroku_fbbeb505cb0db46;
SET @@auto_increment_increment=1;

drop table if exists categorias;
CREATE TABLE categorias
(idCategoria INT PRIMARY KEY AUTO_INCREMENT,
nombreCategoria VARCHAR(60));

INSERT INTO categorias (nombreCategoria)
VALUES 
('entrants'),
('primers'),
('segons'),
('postres');

drop table if exists franjas;
CREATE TABLE franjas
(idFranja INT PRIMARY KEY AUTO_INCREMENT,
ocupacionMaxima int,
inicioFranja TIME,
finFranja TIME);

INSERT INTO franjas (ocupacionMaxima, inicioFranja, finFranja)
VALUES 
(15, '12:00:00', '12:15:00'),
(15, '12:15:00', '12:30:00'),
(15, '12:30:00', '12:45:00'),
(15, '12:45:00', '13:00:00');

drop table if exists roles;
CREATE TABLE roles
(idRol INT PRIMARY KEY AUTO_INCREMENT,
nombreRol VARCHAR(60));

INSERT INTO roles (nombreRol)
VALUES 
('invitado'),
('autorizado'),
('administrador');

drop table if exists platos;
CREATE TABLE platos
(idPlato INT PRIMARY KEY AUTO_INCREMENT,
nombrePlato VARCHAR(60),
descripcionPlato VARCHAR(250),
imagenPlato VARCHAR(250),
precioPlato FLOAT,
idCategoria INT,
FOREIGN KEY (idCategoria) REFERENCES Categorias (idCategoria)
ON DELETE CASCADE
ON UPDATE CASCADE);

INSERT INTO  platos (nombrePlato, descripcionPlato, imagenPlato, precioPlato, idCategoria)
VALUES
('spagetti', 'pasta con salsa bolognesa', 'imagen', 5.99, 2),
('macarrones', 'pasta con salsa al pesto', 'imagen1', 5.99,  2),
('helado de chocolate', 'virtuas de chocolate con nata', 'imagen2', 2.50, 4),
('entrecot de buey', 'entrecot curado 60 dias con salsa ximenez', 'imagen3', 6.99, 3);


drop table if exists Usuarios;
CREATE TABLE usuarios
(idUsuario INT PRIMARY KEY AUTO_INCREMENT,
nombreUsuario VARCHAR(60),
email VARCHAR(60),
contrasenya VARCHAR(60),
idRol INT,
FOREIGN KEY (idRol) REFERENCES Roles (idRol)
ON DELETE CASCADE
ON UPDATE CASCADE);

INSERT INTO usuarios (nombreUsuario, email, contrasenya, idRol)
VALUES 
('Marc', 'newgate3211@gmail.com', 'A12345',2),
('Veronika', 'veronika@gmail.com', 'B12345',3),
('Isidre', 'isidre_@gmail.com', 'C12345',3),
('Borja', 'borja_@gmail.com', 'D12345',1);


drop table if exists pedirPlato;
CREATE TABLE pedirPlato
(idPedirPlato INT PRIMARY KEY AUTO_INCREMENT,
idUsuario INT,
idPlato INT,
idFranja INT,
FOREIGN KEY (idUsuario) REFERENCES Usuarios (idUsuario)
ON DELETE CASCADE
ON UPDATE CASCADE,
FOREIGN KEY (idPlato) REFERENCES Platos (idPlato)
ON DELETE CASCADE
ON UPDATE CASCADE,
FOREIGN KEY (idFranja) REFERENCES Franjas (idFranja)
ON DELETE CASCADE
ON UPDATE CASCADE);

INSERT INTO pedirplato (idUsuario, idPlato, idFranja)
VALUES 
(2, 2, 1),
(1, 1, 2),
(3, 4, 3),
(2, 4, 4),
(1, 3, 2);

drop table if exists reservas;
CREATE TABLE reservas
(idReserva INT PRIMARY KEY AUTO_INCREMENT,
idPedirPlato INT,
fechaReservada DATE,
precioTotal FLOAT,
FOREIGN KEY (idPedirPlato) REFERENCES pedirPlato (idPedirPlato)
ON DELETE CASCADE
ON UPDATE CASCADE);

INSERT INTO reservas (idPedirPlato, fechaReservada, precioTotal)
VALUES 
(1, '2022-07-03', 23.12),
(2, '2022-09-22', 23.12),
(3, '2022-10-10', 12.33),
(4, '2022-12-15', 45.65);












