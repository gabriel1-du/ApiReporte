package com.example.ApiReporte.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.representer.Represent;

import com.example.ApiReporte.Model.EjecucionReporte;
import com.example.ApiReporte.Model.Reporte;
import com.example.ApiReporte.Repository.EjecucionReporteRepository;
import com.example.ApiReporte.Repository.ReporteRepository;

@Service
public class DefinicionReporteService {
    
    //Inyeccion de repositorios

    @Autowired//ReporteRepository 
    private ReporteRepository reporteRepository;

    @Autowired//ejecicionReporteRepository
    private  EjecucionReporteRepository ejecicionReporteRepository;



    //----------------
    //METODOS DE BUSQUEDA/GET
    //---------------

    //Obtener todos los reportes
    public List<EjecucionReporte> getAll(){ 
        return ejecicionReporteRepository.findAll();
    }
   

    //Buscar REPORTE por Id
    public Reporte getbyId(Integer reporteId  ){
        Optional<Reporte> Reporte = reporteRepository.findById(reporteId); //Busca el id
        return Reporte.orElse(null);// Devuelve null en caso de que no encuentre o no haya 
    }

    //Buscar EJECUCION DE REPORTE por Id
     public EjecucionReporte getbyIdEjecucionReporte(Integer ejecucion_id  ){
        Optional<EjecucionReporte> EjecucionReporte= ejecicionReporteRepository.findById(ejecucion_id); //Busca el id
        return EjecucionReporte.orElse(null);// Devuelve null en caso de que no encuentre o no haya 
    }




    //------------------
    //METODOS DE CREACION/POST
    //------------------

    //Crear un nuevo Reporte(Crea  un reporte, Debe ingresarse la ejecucion de reporte )
    public Reporte add(Reporte reporte) {
    return reporteRepository.save(reporte);
    }


    //Crear un nuevo tipo de reporte (El catologo)
    public DefinicionReporte crearTipoReporte(String nombre, String descripcion, String queryBase) {
        DefinicionReporte nuevo = new DefinicionReporte();
        nuevo.setNombre(nombre);
        nuevo.setDescripcion(descripcion);
        nuevo.setQueryBase(queryBase);
        return definicionReporteRepository.save(nuevo);
    }

     //Buscar Tipo reporte por id
    public DefinicionReporte getByIdDefinicionReporte(Integer reporteId) {
        Optional<DefinicionReporte> resultado = definicionReporteRepository.findById(reporteId);
        return resultado.orElse(null);
     }





}
