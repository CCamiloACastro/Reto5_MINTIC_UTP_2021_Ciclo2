package com.CCamiiloACastro.reto5_ciclo2.controller;

//Librerías para bases de datos
import java.sql.SQLException;
//Estructuras de datos (colecciones)
import java.util.ArrayList;

import com.CCamiiloACastro.reto5_ciclo2.model.dao.Requerimiento_1Dao;
import com.CCamiiloACastro.reto5_ciclo2.model.dao.Requerimiento_2Dao;
import com.CCamiiloACastro.reto5_ciclo2.model.dao.Requerimiento_3Dao;
import com.CCamiiloACastro.reto5_ciclo2.model.vo.Requerimiento1;
import com.CCamiiloACastro.reto5_ciclo2.model.vo.Requerimiento2;
import com.CCamiiloACastro.reto5_ciclo2.model.vo.Requerimiento3;

public class ControladorRequerimientosReto5 {   

    private final Requerimiento_1Dao Requerimiento1Dao; 
    // conocer la información de los asesores ordenado por ciudad de residencia de manera ascendente 
    private final Requerimiento_2Dao Requerimiento2Dao;
    // Listar las compras por proyectos ubicados en la ciudad de salento y que el proveedor sea homecenter
    private final Requerimiento_3Dao Requerimiento3Dao;
    // Conocer cuantos proyectos son de casa campestre y que se van a realizar en las ciudades de Santa Marta, Cartagena
    //y Barranquilla
    
    public ControladorRequerimientosReto5(){
        this.Requerimiento1Dao = new Requerimiento_1Dao();
        this.Requerimiento2Dao = new Requerimiento_2Dao();
        this.Requerimiento3Dao = new Requerimiento_3Dao();

    }

    public ArrayList<Requerimiento1> consultarRequerimiento_1() throws SQLException {
        return this.Requerimiento1Dao.AsesorPorCiudadOrdenado();
    }
    
    public ArrayList<Requerimiento2> consultarRequerimiento_2() throws SQLException {
        return this.Requerimiento2Dao.CompraPorProveedorCiudad();
    }

    public ArrayList<Requerimiento3> consultarRequerimiento_3() throws SQLException {
        return this.Requerimiento3Dao.ProyectosCasaCampestresPorCiudad();
    }

}
