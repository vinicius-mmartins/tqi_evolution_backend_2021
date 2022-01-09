package com.github.viniciusmmartins.tqi_evolution_v2.cliente;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "Usuário com e-mail %s não foi encontrado.";
    private final ClienteRepository clienteRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return clienteRepository.findClienteByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG)));
    }

    public String cadastrarCliente(Cliente cliente){

        boolean clienteJaCadastrado = clienteRepository.findClienteByEmail(cliente.getEmail()).isPresent();

        if(clienteJaCadastrado){
            throw new IllegalStateException("Este e-mail já foi cadastrado.");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(cliente.getPassword());

        cliente.setSenha(encodedPassword);

        clienteRepository.save(cliente);

        return "Cadastro efetuado!";
    }
}
