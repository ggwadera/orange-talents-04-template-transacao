package br.com.zupacademy.ggwadera.transacoes.transacao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {
    List<Transacao> findFirst10ByCartaoIdOrderByEfetivadaEmDesc(UUID cartaoId);
}