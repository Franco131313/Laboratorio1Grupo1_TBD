INSERT INTO usuario (ID_USUARIO, email, password, rol) VALUES
    (1, 'Aexandra.Valera@gmail.com', '123abc', 'coordinador'),
    (2, 'Celestino.Maestre@gmail.com', '123abc', 'coordinador'),
    (3, 'Maria.Angustias@gmail.com', '123abc', 'voluntario'),
    (4, 'Clara.Lucas@gmail.com', '123abc', 'voluntario'),
    (5, 'Abdellah.Cuellar@gmail.com', '123abc', 'voluntario'),
    (6, 'Martin.Cruz@gmail.com', '123abc', 'voluntario'),
    (7, 'Wade.Watts@gmail.com', '123abc', 'voluntario'),
    (8, 'Genesis.Felici@gmail.com', '123abc', 'voluntario'),
    (9, 'Raul.Dobbison@gmail.com', '123abc', 'voluntario'),
    (10, 'Bruce.Wearn@gmail.com', '123abc', 'voluntario');

INSERT INTO voluntario (ID_VOLUNTARIO, ID_USUARIO, nombre, latitud, longitud) VALUES 
    (1, 1, 'Aexandra Valera', -70.6483, -33.4372),
    (2, 2, 'Celestino Maestre', -70.6483, -33.4372),
    (3, 3, 'Maria Angustias', -70.6483, -33.4372),
    (4, 4, 'Clara Lucas', -70.6483, -33.4372),
    (5, 5, 'Abdellah Cuellar', -70.6483, -33.4372),
    (6, 6, 'Martin Cruz', -70.6483, -33.4372),
    (7, 7, 'Wade Watts', -70.6483, -33.4372),
    (8, 8, 'Genesis Felici', -70.6483, -33.4372),
    (9, 9, 'Raul Dobbison', -70.6483, -33.4372),
    (10, 10, 'Bruce Wearn', -70.6483, -33.4372);

INSERT INTO habilidad (ID_HABILIDAD, descrip) VALUES
    (1, 'dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam'),
    (2, 'nulla elit ac nulla sed vel enim sit amet nunc viverra dapibus nulla'),
    (3, 'in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla'),
    (4, 'magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient'),
    (5, 'consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis'),
    (6, 'dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut'),
    (7, 'eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus'),
    (8, 'eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula'),
    (9, 'fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer'),
    (10, 'enim blandit mi in porttitor pede justo eu massa donec dapibus duis at');

INSERT INTO vol_habilidad (ID_VOL_HAB, ID_VOLUNTARIO, ID_HABILIDAD) VALUES
    (1, 1, 1),
    (2, 2, 2),
    (3, 3, 3),
    (4, 4, 4),
    (5, 5, 5),
    (6, 6, 6),
    (7, 7, 7),
    (8, 8, 8),
    (9, 9, 9),
    (10, 10, 10);

INSERT INTO institucion (ID_INSTITUCION, nombre, descrip) VALUES
    (1, 'Antidesastres', 'nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam quis turpis'),
    (2, 'Adios desastres', 'sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id'),
    (3, 'Invita voluntarios', 'id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nis'),
    (4, 'Ayuda x desastres', 'phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque'),
    (5, 'AntiInundaciones', 'venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci'),
    (6, 'Contra Terremotos', 'rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis'),
    (7, 'AntiPandemia', 'leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim sit'),
    (8, 'A prueba de desastres', 'lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis'),
    (9, 'Ayuda a todos', 'bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo'),
    (10, 'Voluntarios contra desastres', 'felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non');

INSERT INTO emergencia (ID_EMERGENCIA, nombre, descrip, fecha_inicio, fecha_fin, ID_INSTITUCION, latitud_emer, longitud_emer) VALUES
    (1, 'TERREMOTO', 'Descripcion de TERREMOTO', '2019-9-29', '2022-1-22', 1,  -74.6483, -31.4372),
    (2, 'TSUNAMI', 'Descripcion de TSUNAMI', '2019-12-23', '2022-4-4', 2,  -74.6483, -31.4372),
    (3, 'TERRORISMO', 'Descripcion de TERRORISMO', '2020-11-1', '2022-12-20', 3,  -74.6483, -31.4372),
    (4, 'HAMBRUNA', 'Descripcion de HAMBRUNA', '2020-8-30', '2022-10-13', 4,  -74.6483, -31.4372),
    (5, 'INCENDIO', 'Descripcion de INCENDIO', '2020-6-14', '2022-7-3', 5,  -74.6483, -31.4372),
    (6, 'PANDEMIA', 'Descripcion de PANDEMIA', '2020-2-13', '2022-1-8', 6,  -74.6483, -31.4372),
    (7, 'SAQUEOS', 'Descripcion de SAQUEOS', '2020-5-1', '2022-5-5', 7,  -74.6483, -31.4372),
    (8, 'EVACUACION FORZADA', 'Descripcion de EVACUACION FORZADA', '2021-5-2', '2021-10-29', 8,  -74.6483, -31.4372),
    (9, 'DELINCUENCIA','Descripcion de DELINCUENCIA' , '2020-4-12', '2021-8-28', 9,  -74.6483, -31.4372),
    (10, 'ESTALLIDO', 'Descripcion de ESTALLIDO', '2/5/2021', '2/10/2023', 10,  -74.6483, -31.4372);

INSERT INTO eme_habilidad (ID_EME_HAB, ID_EMERGENCIA, ID_HABILIDAD) VALUES
    (1, 1, 1),
    (2, 2, 2),
    (3, 3, 3),
    (4, 4, 4),
    (5, 5, 5),
    (6, 6, 6),
    (7, 7, 7),
    (8, 8, 8),
    (9, 9, 9),
    (10, 10, 10);

INSERT INTO estado_tarea (ID_ESTADO, descripcion) VALUES
    (1,'Sin Iniciar'),
    (2, 'En proceso'),
    (3, 'Finalizada');
  
INSERT INTO tarea (ID_TAREA, nombre, descrip, fecha_inicio, fecha_fin, cant_vol_requeridos, cant_vol_inscritos, ID_EMERGENCIA, ID_ESTADO) VALUES
    (1, 'RESCATE', 'Descricion de RESCATE', '2021-1-29', '2021-8-11', 15, 9, 1, 1),
    (2, 'ALIMENTAR', 'Descricion de ALIMENTAR', '2020-5-24', '2022-8-13', 11, 7, 2, 2),
    (3, 'ARRESTAR', 'Descricion de ARRESTAR',  '2021-1-24', '2022-12-12', 10, 9, 3, 3),
    (4, 'CURAR', 'Descricion de CURAR', '2020-5-11', '2023-11-1', 14, 2, 4, 1),
    (5, 'APAGAR', 'Descricion de APAGAR',  '2021-5-23', '2022-4-11', 12, 8, 5, 2),
    (6, 'REGALAR', 'Descricion de REGALAR', '2020-9-28', '2021-12-26', 14, 5, 6, 3),
    (7, 'DONAR', 'Descricion de DONAR', '2021-5-20', '2022-3-26', 11, 8, 7, 1),
    (8, 'VENDER', 'Descricion de VENDER', '2020-7-10', '2021-12-11', 13, 6, 8, 2),
    (9, 'ARREGLAR', 'Descricion de ARREGLAR', '2020-6-27', '2023-1-31', 10, 9, 9, 3),
    (10, 'EDUCAR', 'Descricion de EDUCAR', '2020-2-9', '2022-7-12',10, 5, 10, 1);

INSERT INTO ranking (ID_RANKING, ID_VOLUNTARIO, ID_TAREA, puntaje, flg_invitado, flg_participa) VALUES
    (1, 1, 1, 4.00, 0, 1),
    (2, 2, 2, 4.90, 7, 2),
    (3, 3, 3, 7.00, 1, 2),
    (4, 4, 4, 3.00, 0, 1),
    (5, 5, 5, 4.00, 2, 6),
    (6, 6, 6, 3.50, 4, 7),
    (7, 7, 7, 4.50, 8, 3),
    (8, 8, 8, 5.00, 4, 5),
    (9, 9, 9, 6.60, 2, 1),
    (10, 10, 10, 4.00, 9, 5);

INSERT INTO tarea_habilidad (ID_TARHAB, ID_EME_HAB, ID_TAREA) VALUES
    (1, 1, 1),
    (2, 2, 2),
    (3, 3, 3),
    (4, 4, 4),
    (5, 5, 5),
    (6, 6, 6),
    (7, 7, 7),
    (8, 8, 8),
    (9, 9, 9),
    (10, 10, 10);




  
