package br.com.bantads.authms.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyComponent implements CommandLineRunner {

    private final MessageSenderService messageSenderService;
    
    @Autowired
    public MyComponent(MessageSenderService messageSenderService) {
        this.messageSenderService = messageSenderService;
    }
    
    @Override
    public void run(String... args) throws Exception {
        // Exemplo de uso do serviço de envio de mensagens
       /* String message = "Hello, RabbitMQ!";
        messageSenderService.sendMessage(message);*/
    }
}
