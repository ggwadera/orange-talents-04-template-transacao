package br.com.zupacademy.ggwadera.transacoes.estabelecimento;

import javax.validation.constraints.NotBlank;

public class EstabelecimentoMessage {

    @NotBlank
    private String nome;

    @NotBlank
    private String cidade;

    @NotBlank
    private String endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Estabelecimento toModel() {
        return new Estabelecimento(nome, cidade, endereco);
    }

    @Override
    public String toString() {
        return "EstabelecimentoRequest{" +
            "nome='" + nome + '\'' +
            ", cidade='" + cidade + '\'' +
            ", endereco='" + endereco + '\'' +
            '}';
    }
}
