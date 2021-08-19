package com.CCamiiloACastro.reto5_ciclo2.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//Librerías para SQL y Base de Datos
import java.sql.SQLException;
//Estructura de datos
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.CCamiiloACastro.reto5_ciclo2.model.vo.Requerimiento3;
import com.CCamiiloACastro.reto5_ciclo2.util.JDBCUtilities;

public class Requerimiento_3Dao {
    //Obtener los proyectos por Tipo en la ciudad de Montería
    public ArrayList<Requerimiento3> ProyectosCasaCampestresPorCiudad() throws SQLException {
        
        ArrayList<Requerimiento3> respuesta = new ArrayList<Requerimiento3>();
        Connection conexion = JDBCUtilities.getConnection();
        try{

            String consulta =   "SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad " + 
                                "FROM Proyecto " +
                                "WHERE Ciudad IN ('Santa Marta', 'Cartagena', 'Barranquilla') " +
                                "AND Clasificacion = 'Casa Campestre'";


            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Requerimiento3 proyectoCasaCampestre = new Requerimiento3();
                proyectoCasaCampestre.setID_Proyecto(resultSet.getInt("ID_Proyecto"));
                proyectoCasaCampestre.setConstructora(resultSet.getString("Constructora"));
                proyectoCasaCampestre.setNumero_Habitaciones(resultSet.getDouble("Numero_Habitaciones"));
                proyectoCasaCampestre.setCiudad(resultSet.getString("Ciudad"));

                //Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(proyectoCasaCampestre);
            }
                
            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando los proyectos: " + e);
            JOptionPane.showMessageDialog(null, "Error consultando los proyectos: " + e,
            	    "Error en la lectura de datos", JOptionPane.ERROR_MESSAGE);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }
        return respuesta;
    }     
}
