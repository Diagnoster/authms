package br.com.bantads.authms.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueCreationService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public QueueCreationService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

 /*   public void createQueue(String queueName) {
        rabbitTemplate.execute(channel -> {
            channel.queueDeclare(queueName, true, false, false, null);
            return null;
        });
        System.out.println("Fila criada: " + queueName);
    }*/
}
