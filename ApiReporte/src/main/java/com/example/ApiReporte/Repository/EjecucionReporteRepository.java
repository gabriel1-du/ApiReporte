package com.example.ApiReporte.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ApiReporte.Model.TipoReporte;

public interface EjecucionReporteRepository extends JpaRepository<TipoReporte, Integer>{

}
