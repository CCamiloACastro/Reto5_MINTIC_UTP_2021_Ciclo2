package com.CCamiiloACastro.reto5_ciclo2.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//Librerías para SQL y Base de Datos
import java.sql.SQLException;
//Estructura de datos
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.CCamiiloACastro.reto5_ciclo2.model.vo.Requerimiento2;
import com.CCamiiloACastro.reto5_ciclo2.util.JDBCUtilities;

public class Requerimiento_2Dao {
   
    public ArrayList<Requerimiento2> CompraPorProveedorCiudad() throws SQLException {
        
        ArrayList<Requerimiento2> respuesta = new ArrayList<Requerimiento2>();
        Connection conexion = JDBCUtilities.getConnection();
        try{

            String consulta = "SELECT ID_Compra, Proveedor, Constructora, Banco_Vinculado, Ciudad " +
                                "FROM Compra c INNER JOIN Proyecto p " +
                                "ON c.ID_Proyecto = p.ID_Proyecto " +
                                "WHERE Ciudad = 'Salento' AND Proveedor = 'Homecenter'";


            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            //Recorrer los registros en los VO específicos
            while(resultSet.next()){
                Requerimiento2 asesorPorCiudad = new Requerimiento2();
                asesorPorCiudad.setID_Compra(resultSet.getInt("ID_Compra"));
                asesorPorCiudad.setProveedor(resultSet.getString("Proveedor"));
                asesorPorCiudad.setConstructora(resultSet.getString("Constructora"));
                asesorPorCiudad.setBanco_Vinculado(resultSet.getString("Banco_Vinculado"));
                asesorPorCiudad.setCiudad(resultSet.getString("Ciudad"));

                //Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(asesorPorCiudad);
            }
            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando las compras por proveedor y Ciudad: " + e);
            JOptionPane.showMessageDialog(null, "Error consultando las compras por proveedor y Ciudad: " + e,
            	    "Error en la lectura de datos", JOptionPane.ERROR_MESSAGE);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }
        return respuesta;
    }
        
}
