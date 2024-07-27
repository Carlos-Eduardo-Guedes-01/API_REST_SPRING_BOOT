package com.carlos.demo_park_api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carlos.demo_park_api.entity.Usuario;
import com.carlos.demo_park_api.repository.UsuarioRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        // TODO Auto-generated method stub
        // Retorna apenas o nome 'null' caso não tenha usuário com o id requisitado.
        return usuarioRepository.findById(id).orElse(null);
        // return usuarioRepository.findById(id).orElseThrow(() -> new
        // RuntimeException("Usuário não encontrado."));
    }

    @Transactional
    public Usuario editarSenha(Long id, String password) {

        Usuario user = buscarPorId(id);
        user.setPassword(password);
        return user;
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }
}
