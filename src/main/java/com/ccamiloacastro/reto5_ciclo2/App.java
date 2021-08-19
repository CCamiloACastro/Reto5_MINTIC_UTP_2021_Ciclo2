package com.ccamiloacastro.reto5_ciclo2;

import com.CCamiiloACastro.reto5_ciclo2.view.VistaRequerimientosReto5;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class App {

	static JFrame f = new JFrame("Estructurando Company");// creating instance of JFrame

	static JButton b1 = new JButton("Consultar Asesores");// creating instance of JButton
	static JButton b2 = new JButton("Listar Compras");
	static JButton b3 = new JButton("Colsultar C. Campestre");
	static JButton b4 = new JButton("Abrir PDF");
	
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				inicio(); //Crea Inicio Saludo
				panel(f); // Crea el panel principal donde se van añadir los botones
				
				// Acciones para los botones
				b1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						System.out.println("Boton 1");
						VistaRequerimientosReto5.requerimiento1();
					}
				});
				b2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						System.out.println("Boton 2");
						VistaRequerimientosReto5.requerimiento2();
					}
				});
				b3.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						System.out.println("Boton 3");
						VistaRequerimientosReto5.requerimiento3();
					}
				});
				b4.addActionListener(new ActionListener() { //Abrir PDF
					@Override
					public void actionPerformed(ActionEvent arg0) {
						System.out.println("Boton 4");
						try {
						     File path = new File ("D:\\Documentos\\1. Programas y Proyectos\\Java\\Mintic2022\\Retos\\reto5_ciclo2\\reto5_ciclo2\\MisionTIC_C2R5_P70.pdf");
						     Desktop.getDesktop().open(path);
						}catch (IOException ex) {
						     ex.printStackTrace();
						}
					}
				});
			}
		});
	}

	public static void inicio() {
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File(
					"D:\\Documentos\\1. Programas y Proyectos\\Java\\Mintic2022\\Retos\\reto5_ciclo2\\reto5_ciclo2\\estructurando.png"));
			ImageIcon icon = new ImageIcon(myPicture);
			JLabel picLabel = new JLabel(icon);

			JOptionPane.showMessageDialog(null, picLabel);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void panel(JFrame f) {

		f.setLocation(400, 150);
//		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//		f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra todas las ventanas cuando se da X
		f.getContentPane().setBackground(new Color(10, 10, 10));
   
		b1.setBounds(10, 10, 200, 40);// x axis, y axis, width, height
		b1.setBackground(new Color(255, 255, 255));
//    	b1.setBorderPainted(true);

		b2.setBounds(180, 10, 200, 40);
		b2.setBackground(new Color(255, 255, 255));

		b3.setBounds(360, 10, 200, 40);
		b3.setBackground(new Color(255, 255, 255));
		
		b4.setBounds(180, 65, 180, 35);
		b4.setBackground(new Color(220, 220, 220));

		f.add(b1);// adding button in JFrame
		f.add(b2);
		f.add(b3);
		f.add(b4);
		// frame.getContentPane().add(button1);

		f.setSize(600, 150);// 400 width and 500 height
		f.setLayout(null);// using no layout managers
		f.setVisible(true);// making the frame visible
	}
	

	  
}
