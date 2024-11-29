package com.ecalazaes.ErickEmissorMicroservico.rabbitMQ;

import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

        @Autowired
        private AmqpAdmin amqpAdmin;

        // Definindo a fila como um bean
        @Bean
        public Queue queue() {
            return new Queue("Fila", true, false, false); // Fila durável, não exclusiva, não auto-deletável
        }

        // Definindo o Exchange como um bean
        @Bean
        public DirectExchange directExchange() {
            return new DirectExchange("erick"); // Nome do Exchange
        }

        // Definindo o conversor de mensagens como um bean
        @Bean
        public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
            return new Jackson2JsonMessageConverter();
        }

        // Criando o Binding entre a fila e o exchange
        @Bean
        public Binding binding(Queue queue, DirectExchange directExchange) {
            return new Binding(
                    queue.getName(),
                    Binding.DestinationType.QUEUE,
                    directExchange.getName(),
                    queue.getName(),
                    null
            );
        }

        // Declarando a fila, exchange e binding no AmqpAdmin
        @PostConstruct
        public void setupRabbitMQ() {
            amqpAdmin.declareQueue(queue()); // Declara a fila
            amqpAdmin.declareExchange(directExchange()); // Declara o exchange
            amqpAdmin.declareBinding(binding(queue(), directExchange())); // Declara o binding
        }
    }
