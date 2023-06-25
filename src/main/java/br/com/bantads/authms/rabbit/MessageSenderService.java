package br.com.bantads.authms.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class MessageSenderService {

    private final RabbitTemplate rabbitTemplate;
    private final QueueCreationService queueCreationService;
    private final String exchangeName = ""; // Defina o nome da exchange conforme sua necessidade
    private final String routingKey = "AUTENTICACAO"; // Defina a chave de roteamento conforme sua necessidade
    private final String queueName = "AUTENTICACAO"; // Defina o nome da fila conforme sua necessidade

    @Autowired
    public MessageSenderService(RabbitTemplate rabbitTemplate, QueueCreationService queueCreationService) {
        this.rabbitTemplate = rabbitTemplate;
        this.queueCreationService = queueCreationService;
        //createQueueIfNotExists();
    }

/*    private void createQueueIfNotExists() {
        queueCreationService.createQueue(queueName);
    }*/

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
        System.out.println("Mensagem enviada: " + message);
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public String getQueueName() {
        return queueName;
    }
}

