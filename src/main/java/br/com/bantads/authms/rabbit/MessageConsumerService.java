package br.com.bantads.authms.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import br.com.bantads.authms.dto.AuthDTO;
import br.com.bantads.authms.models.Auth;
import br.com.bantads.authms.repositories.AuthRepository;

@Service
public class MessageConsumerService {
	
	@Autowired
    private AuthRepository authRepository;

    @RabbitListener(queues = "AUTENTICACAO") // Substitua pelo nome da fila que você criou
    public void receiveMessage(@Payload AuthDTO authdto) {
        // Extrair os dados necessários do AuthDTO
        String email = authdto.getEmail();
        String senha = authdto.getSenha();
        String cargo = authdto.getCargo();

        // Criar a entidade conta com os dados extraídos
        Auth auth = new Auth();
        auth.setEmail(email);
        auth.setSenha(senha);
        auth.setCargo(cargo);

        // Salvar a conta no banco utilizando o JpaRepository
        authRepository.save(auth);

    }
}
