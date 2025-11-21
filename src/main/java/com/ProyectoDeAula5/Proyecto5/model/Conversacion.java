package com.ProyectoDeAula5.Proyecto5.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;

@Data
@Entity
@Table(name = "conversaciones")
public class Conversacion {

    // Mapeamos el id al nombre real en la BD (my_row_id), que es la columna
    // AUTO_INCREMENT actual
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "my_row_id")
    private Long id;

    // nombre real en la BD: usuario_id
    @Column(name = "usuario_id", nullable = false)
    private String usuarioId;

    @Column(name = "titulo", length = 120)
    private String titulo;

    // nombres reales en la BD
    @Column(name = "creada_en", nullable = false)
    private Instant creadaEn;

    @Column(name = "actualizada_en", nullable = false)
    private Instant actualizadaEn;

    @PrePersist
    void alCrear() {
        Instant ahora = Instant.now();
        creadaEn = ahora;
        actualizadaEn = ahora;
    }

    @PreUpdate
    void alActualizar() {
        actualizadaEn = Instant.now();
    }
}
