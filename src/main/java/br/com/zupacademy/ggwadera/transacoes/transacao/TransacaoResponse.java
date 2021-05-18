package br.com.zupacademy.ggwadera.transacoes.transacao;

import br.com.zupacademy.ggwadera.transacoes.estabelecimento.EstabelecimentoResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransacaoResponse {

    private final UUID id;
    private final BigDecimal valor;
    private final LocalDateTime efetivadaEm;
    private final EstabelecimentoResponse estabelecimento;

    public TransacaoResponse(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.efetivadaEm = transacao.getEfetivadaEm();
        this.estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento());
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }
}
