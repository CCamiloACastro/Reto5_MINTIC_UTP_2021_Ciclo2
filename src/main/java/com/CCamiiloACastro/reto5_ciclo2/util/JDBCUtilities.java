package com.CCamiiloACastro.reto5_ciclo2.util;

import java.io.File;//Para verificación de longitud de base de datos

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilities {

    //Atributos de clase para gestión de conexión con la base de datos    
    private static final String UBICACION_BD = "ProyectosConstruccion.db";    
//	  private static final String UBICACION_BD = "D:/Documentos/1. Programas y Proyectos/Java/Mintic2022/Retos/reto4_ciclo2/ProyectosConstruccion.db";
//    private static final String UBICACION_BD = "D/Documentos:1. Programas y Proyectos:Java:Mintic2022:Retos:reto4_ciclo2:ProyectosConstruccion.db";
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + UBICACION_BD;
        //Class.forName("org.sqlite.JDBC");
        return DriverManager.getConnection(url);
    }

    public static boolean estaVacia(){
        File archivo = new File(JDBCUtilities.UBICACION_BD);
        return archivo.length() == 0;
    }
}
