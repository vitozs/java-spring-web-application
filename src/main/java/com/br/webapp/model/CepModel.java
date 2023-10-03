package com.br.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CepModel {
    public String localidade;
    public String cep;
    public String bairro;
    public String uf;
    public String ddd;
    public CepModel(@JsonProperty("cep") String cep, @JsonProperty("localidade") String localidade, @JsonProperty("bairro") String bairro, @JsonProperty("uf") String uf, @JsonProperty("ddd") String ddd ){
        this.localidade = localidade;
        this.cep = cep;
        this.bairro = bairro;
        this.ddd = ddd;
        this.uf = uf;
    }
}
