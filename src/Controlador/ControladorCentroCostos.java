/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ProcesarBD;
import Vista.vistaCentroCostos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Labing
 */
public class ControladorCentroCostos implements ActionListener{
    private vistaCentroCostos vista;
    private ProcesarBD base;
    public ControladorCentroCostos(vistaCentroCostos vista1) {
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
            String Codigo = vista.TexCodigo.getText();
            String Descripcion = vista.TexDescripcion.getText();
            base.ingresarCentroCostos(Integer.parseInt(Codigo), Descripcion);
            JOptionPane.showMessageDialog(null, "Se ha Agregado un Centro de Costos Correctamente");
            vista.TexCodigo.setText("");
            vista.TexDescripcion.setText("");
        }
        if (e.getSource() == vista.ButtonLimpiar) {
            vista.TexCodigo.setText("");
            vista.TexDescripcion.setText("");
        }
        if (e.getSource() == vista.ButtonCerrar) {
            vista.dispose();
        }
    }
}
