package br.com.zupacademy.ggwadera.transacoes.transacao;

import br.com.zupacademy.ggwadera.transacoes.estabelecimento.Estabelecimento;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Transacao {

    @Id
    private UUID id;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDateTime efetivadaEm;

    @Embedded
    private Estabelecimento estabelecimento;

    @Column(nullable = false)
    private UUID cartaoId;

    @Deprecated
    public Transacao() {
    }

    public Transacao(UUID id, BigDecimal valor, LocalDateTime efetivadaEm,
        Estabelecimento estabelecimento, UUID cartaoId) {
        this.id = id;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.estabelecimento = estabelecimento;
        this.cartaoId = cartaoId;
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

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public UUID getCartaoId() {
        return cartaoId;
    }
}