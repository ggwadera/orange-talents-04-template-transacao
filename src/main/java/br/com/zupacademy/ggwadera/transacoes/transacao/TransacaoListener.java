package br.com.zupacademy.ggwadera.transacoes.transacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
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

    @KafkaListener(topics = "${kafka.topics.transactions}")
    public void listenerTransacoes(@Valid TransacaoMessage message) {
        logger.info(
            "Nova transação id={} valor={} estabelecimento={}",
            message.getId(),
            message.getValor(),
            message.getEstabelecimento().getNome()
        );
        transacaoRepository.save(message.toModel());
    }

}
