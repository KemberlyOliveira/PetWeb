package com.br.petWeb.petShop.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tutor")
@Data
public class Tutor {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_tutor", unique = true, nullable = false)
    private long id_tutor;

    @Column (name = "nome_tutor", nullable = false, length = 100)
    private String nome_tutor;

    @Column (name = "telefone", nullable = false)
    private int telefone;

    @Column (name = "endereco", nullable = false, length = 200)
    private String endereco;
}
