package br.com.zupacademy.ggwadera.transacoes.cartao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class CartaoMessage {

    @NotNull
    private UUID id;

    @NotBlank
    private String email;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CartaoRequest{" +
            "id=" + id +
            ", email='" + email + '\'' +
            '}';
    }
}
