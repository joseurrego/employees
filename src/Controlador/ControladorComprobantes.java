/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ProcesarBD;
import Vista.vistaComprobantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class ControladorComprobantes implements ActionListener{
     private vistaComprobantes vista;
     private ProcesarBD base;
    public ControladorComprobantes(vistaComprobantes vista1) {
        this.vista=vista1;
        base = new ProcesarBD();
        vista.ButtonAgregar.addActionListener(this);
        vista.ButtonCerrar.addActionListener(this);
        vista.ButtonLimpiar.addActionListener(this);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.ButtonAgregar) {
            String Comprobante = vista.TexComprobante.getText();
            String Descripcion = vista.TexDescripcion.getText();
            String Tipo = vista.TexTipo.getText();
            String Cuenta = vista.TexCuenta.getText();
            base.ingresarComprobantes(Comprobante, Descripcion, Tipo, Integer.parseInt(Cuenta));
            JOptionPane.showMessageDialog(null, "Se ha Agregado un Comprobante Correctamente");
             vista.TexComprobante.setText("");
            vista.TexCuenta.setText("");
            vista.TexTipo.setText("");
            vista.TexDescripcion.setText("");
        }
        if (e.getSource() == vista.ButtonLimpiar) {
            vista.TexComprobante.setText("");
            vista.TexCuenta.setText("");
            vista.TexTipo.setText("");
            vista.TexDescripcion.setText("");
        }
        if (e.getSource() == vista.ButtonCerrar) {
            vista.dispose();
        }
    }
}
