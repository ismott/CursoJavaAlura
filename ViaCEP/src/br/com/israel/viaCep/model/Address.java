package br.com.israel.viaCep.model;

public class Address {
    String state;
    String city;
    String neighborhood;
    String road;

    public Address(Cep cep) {
        this.state = cep.uf();
        this.city = cep.localidade();
        this.neighborhood = cep.bairro();
        this.road = cep.logradouro();
    }
}
