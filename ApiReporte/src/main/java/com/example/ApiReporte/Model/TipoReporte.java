package com.example.ApiReporte.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipo_reporte") //Cambio de nombre a la tabla actual en la bda
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoReporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ejecucion_id")
    private Integer ejecucion_id;//Modificacion a corte a la base de datos

    @ManyToOne
    @JoinColumn(name = "reporte_id", nullable = false)
    private Reporte reporte; //Cracion de la coneccion con la tabla reporte id

    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    @Column(name = "ejecutado_en", nullable = false)
    private LocalDateTime ejecutadoEn = LocalDateTime.now(); //Local date Time para que se ponga la fecha de cuando se cree
}
