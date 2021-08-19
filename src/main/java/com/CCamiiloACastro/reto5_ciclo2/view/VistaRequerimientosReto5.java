package com.CCamiiloACastro.reto5_ciclo2.view;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import com.CCamiiloACastro.reto5_ciclo2.controller.ControladorRequerimientosReto5;
import com.CCamiiloACastro.reto5_ciclo2.model.vo.Requerimiento1;
import com.CCamiiloACastro.reto5_ciclo2.model.vo.Requerimiento2;
import com.CCamiiloACastro.reto5_ciclo2.model.vo.Requerimiento3;

public class VistaRequerimientosReto5 {

	public static final ControladorRequerimientosReto5 controlador = new ControladorRequerimientosReto5();

	static JFrame f1 = new JFrame();
	static JFrame f2 = new JFrame();
	static JFrame f3 = new JFrame();
//	final static JFrame f2 = marcos(450, f_acciones, "Compras por Proveedor");
//	final static JFrame f3 = marcos(900, f_acciones, "Proyectos Casa Campestre");

	public static void requerimiento1() {

		System.out.println("Asesor Ordenado Por Ciudad");
		String mensaje = ""; 
		
		try {
			ArrayList<Requerimiento1> asesorOrdenadoPorCiudad = controlador.consultarRequerimiento_1();
			for (Requerimiento1 asesorPorCiudad : asesorOrdenadoPorCiudad) {
				/*System.out.printf("El asesor con Id %d se llama %s %s y reside en %s %n", asesorPorCiudad.getIdLider(),
						asesorPorCiudad.getNombre(), asesorPorCiudad.getPrimerApellido(),
						asesorPorCiudad.getCiudadResidencia());*/
				mensaje += "El asesor con Id " + 
						asesorPorCiudad.getIdLider() + 
						" se llama: " +
						asesorPorCiudad.getNombre() + " " + asesorPorCiudad.getPrimerApellido() + 
						" y reside en " + 
						asesorPorCiudad.getCiudadResidencia() + "\n";
					
			}
		} catch (SQLException e) {
			System.err.println("No se puede optener los datos <<requerimiento 1>>" + e.getMessage());
			JOptionPane.showMessageDialog(null,"No se puede optener los datos <<requerimiento 1>>" + e.getMessage(),
				    "Error SQLException",JOptionPane.ERROR_MESSAGE);
		}
		
		f1 = marcos(0, "Asesores ordenados por ciudad",mensaje,420);
 
	}

	public static void requerimiento2() {
		
		System.out.println("Lista de Compras por Proveedor y Ciudad");
		String mensaje = "";
		try {
			ArrayList<Requerimiento2> compraProveedorCiudad = controlador.consultarRequerimiento_2();
			for (Requerimiento2 compraPorProveedor : compraProveedorCiudad) {
				/*System.out.printf("La compra %d del proveedor %s para la construtora %s del banco %s ubicado en %s %n",
						compraPorProveedor.getID_Compra(), compraPorProveedor.getProveedor(),
						compraPorProveedor.getConstructora(), compraPorProveedor.getBanco_Vinculado(),
						compraPorProveedor.getCiudad());*/
				mensaje += "La compra " + compraPorProveedor.getID_Compra() + 
						" del proveedor " + compraPorProveedor.getProveedor() + 
						" para la construtora " + compraPorProveedor.getConstructora() +
						" del banco " + compraPorProveedor.getBanco_Vinculado() +
						" ubicado en ->" + compraPorProveedor.getCiudad() + "\n";
			}

		} catch (SQLException e) {
			System.err.println("No se puede optener los datos <<requerimiento 2>>" + e.getMessage());
			JOptionPane.showMessageDialog(null,"No se puede optener los datos <<requerimiento 2>>" + e.getMessage(),
				    "Error SQLException",JOptionPane.ERROR_MESSAGE);
		}
		f2 = marcos(380, "Asesores ordenados por ciudad",mensaje,800);
	}

	public static void requerimiento3() {
		String mensaje = "";
		System.out.println("Proyectos Casa Campestre");
		try {
			ArrayList<Requerimiento3> casaCampestreCiudad = controlador.consultarRequerimiento_3();
			for (Requerimiento3 proyectosCasaCampestre : casaCampestreCiudad) {
				/*System.out.printf(
						"El proyecto con ID %d de la constructora: %s tiene %.0f habitaciones y esta ubicado en %s %n",
						proyectosCasaCampestre.getID_Proyecto(), proyectosCasaCampestre.getConstructora(),
						proyectosCasaCampestre.getNumero_Habitaciones(), proyectosCasaCampestre.getCiudad());*/
				mensaje += "El proyecto con ID " + proyectosCasaCampestre.getID_Proyecto() +
						" de la constructora: " + proyectosCasaCampestre.getConstructora() +
						" tiene " + proyectosCasaCampestre.getNumero_Habitaciones() + 
						" habitaciones y esta ubicado en - > " + proyectosCasaCampestre.getCiudad() + "\n";
			}

		} catch (SQLException e) {
			System.err.println("No se puede optener los datos <<requerimiento 3>>" + e.getMessage());
			JOptionPane.showMessageDialog(null,"No se puede optener los datos <<requerimiento 3>>" + e.getMessage(),
				    "Error SQLException",JOptionPane.ERROR_MESSAGE);
		}
		f3 = marcos(700, "Asesores ordenados por ciudad",mensaje,700);
	}

	public static JFrame marcos(int distancia, String titulo, String mensaje, int width) {
		JFrame frame = new JFrame();
	
		frame.setTitle(titulo);
		frame.setLocation(distancia + 10, 300);
		
                
        JTextArea ta = new JTextArea();
        ta.setText(mensaje);
        ta.setEditable(false);

        // Agregar componentes al marco.
        frame.getContentPane().add(BorderLayout.CENTER, ta);

        frame.setSize(width, 480);// 400 width and 500 height
		//frame.setLayout(null);// using no layout managers
		frame.setVisible(true);
		return frame;
	}
}
