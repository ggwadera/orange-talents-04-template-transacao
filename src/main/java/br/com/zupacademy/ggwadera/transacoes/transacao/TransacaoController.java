package br.com.zupacademy.ggwadera.transacoes.transacao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class TransacaoController {

    private final TransacaoRepository repository;

    public TransacaoController(TransacaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/transacoes/{cartaoId}")
    public ResponseEntity<List<TransacaoResponse>> ultimasTransacoes(@PathVariable UUID cartaoId) {
        List<Transacao> transacoes = repository.findFirst10ByCartaoIdOrderByEfetivadaEmDesc(cartaoId);
        if (transacoes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<TransacaoResponse> responses = transacoes.stream()
            .map(TransacaoResponse::new)
            .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }
}
