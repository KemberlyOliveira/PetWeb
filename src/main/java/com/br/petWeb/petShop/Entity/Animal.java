package com.br.petWeb.petShop.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "animal")
@Data
public class Animal {
    

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_animal", unique = true, nullable = false)
    private long id_animal;

    @Column (name = "nome_animal", nullable = false, length = 100)
    private String nome_animal;

    @Column (name = "idade", nullable = false)
    private int idade;

    @Column (name = "raca", nullable = false, length = 100)
    private String raca;

    @ManyToOne
    @JoinColumn(name = "tutor_codigo", nullable = false)
    private Tutor tutor;


}
