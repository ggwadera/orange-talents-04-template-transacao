package br.com.zupacademy.ggwadera.transacoes.transacao;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class TransacaoListener {

    private final Logger logger = LoggerFactory.getLogger(TransacaoListener.class);
    private final TransacaoRepository transacaoRepository;

    @Autowired
    public TransacaoListener(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @KafkaListener(topics = "transacoes")
    public void listenerTransacoes(@Valid TransacaoMessage message) {
        logger.info("Nova transação {}", message);
        transacaoRepository.save(message.toModel());
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("transacoes").build();
    }
}
