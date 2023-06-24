package br.com.bantads.authms.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {

    @RabbitListener(queues = "auth-queue") // Substitua pelo nome da fila que você criou
    public void receiveMessage(String message) {
        System.out.println("Mensagem consumida: " + message);
        // Faça o processamento necessário da mensagem recebida
    }
}
