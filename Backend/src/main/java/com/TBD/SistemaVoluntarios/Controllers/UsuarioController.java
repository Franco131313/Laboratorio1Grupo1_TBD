package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.UsuarioEntity;
import com.TBD.SistemaVoluntarios.Repositories.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // CREATE: Crear un nuevo usuario
    /*
    @PostMapping("/agregar-usuario")
    public ResponseEntity<String> nuevoUsuario(@RequestParam("email") String email,
                                               @RequestParam("pass") String pass,
                                               @RequestParam("rol") String rol,
                                               HttpSession session) {
        session.setAttribute("email", email);
        session.setAttribute("rol", rol);
        usuarioRepoImp.guardarUsuario(email, pass, rol);
        return ResponseEntity.ok("Usuario creado exitosamente");
    }

     */
    // READ: Leer todos los usuarios
    @GetMapping("/lista-usuarios")
    public ResponseEntity<List<UsuarioEntity>> listarUsuarios() {

        return ResponseEntity.ok(usuarioRepository.findAll());
    }
    // READ: Leer todos los usuarios según su rol
    @GetMapping("/lista-usuarios-por-rol")
    public ResponseEntity<List<UsuarioEntity>> listaPorRol(@RequestParam("rol") String rol)
    {
        return ResponseEntity.ok(usuarioRepository.findAllByRol(rol));
    }

    //READ: Buscar un usuario por su email
    @GetMapping("/buscar")
    public ResponseEntity<UsuarioEntity> buscarUsuario(@RequestParam("email") String email)
    {
        return ResponseEntity.ok(usuarioRepository.findByEmail(email));
    }
    /*
    //UPDATE: Actualizar email y contraseña del usuario
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAll(@PathVariable Integer id,
                                            @RequestParam("newEmail") String newEmail,
                                            @RequestParam("newPass") String newPass)
    {
        UsuarioEntity usuario = usuarioRepoImp.porID(id);
        usuarioRepoImp.guardarUsuario(newEmail, usuario.getRol(), newPass);
        return ResponseEntity.ok("Datos actualizados con exito");

    }

     */
    //UPDATE: Actualizar email del usuario
    /*
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmail(@PathVariable Integer id,
                                              @RequestParam("newEmail") String newEmail)
    {
        UsuarioEntity usuario = usuarioRepoImp.porID(id);
        usuarioRepoImp.guardarUsuario(newEmail, usuario.getRol(), usuario.getPassword());
        return ResponseEntity.ok("E-mail actualizado exitosamente");
    }
    //UPDATE: Actualizar password del usuario
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePass(@PathVariable Integer id,
                                              @RequestParam("newPass") String newPass)
    {
        UsuarioEntity usuario = usuarioRepoImp.porID(id);
        usuarioRepoImp.guardarUsuario(usuario.getEmail(), usuario.getRol(), newPass);
        return ResponseEntity.ok("Password actualizado exitosamente");
    }

    //DELETE: Eliminar un usuario
    @DeleteMapping("/delete-user")
    public ResponseEntity<String> deleteUser(@RequestParam("email") String email)
    {
        usuarioRepoImp.eliminarUsuarioPorEmail(email);
        return ResponseEntity.ok("Usuario eliminado exitosamente");
    }

     */
}
