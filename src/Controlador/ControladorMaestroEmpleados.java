/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ProcesarBD;
import Vista.vistaMaestroEmpleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Labing
 */
public class ControladorMaestroEmpleados implements ActionListener{
    private vistaMaestroEmpleados vista;
    private ProcesarBD base;
    public ControladorMaestroEmpleados(vistaMaestroEmpleados vista1) {
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
            String Nit = vista.TexNit.getText();
            String Nombre = vista.TexNombre.getText();
            String Direccion = vista.TexDireccion.getText();
            String Telefono = vista.TexTelefono.getText();
            String Ciudad = vista.TexCiudad.getText();
            String CCosto = vista.TexCCosto.getText();
            String ECivil = vista.TexECivil.getText();
            String Fecha = vista.TexFIngreso.getText();
            String Cuenta = vista.TexCuenta.getText();
            base.ingresarEmpleado(Integer.parseInt(Nit), Nombre, Direccion, Telefono, Ciudad, Integer.parseInt(CCosto), ECivil, Fecha, Integer.parseInt(Cuenta));
            JOptionPane.showMessageDialog(null, "Se ha Agregado un Empleado Correctamente");
            vista.TexCCosto.setText("");
            vista.TexCiudad.setText("");
            vista.TexDireccion.setText("");
            vista.TexECivil.setText("");
            vista.TexNit.setText("");
            vista.TexNombre.setText("");
            vista.TexTelefono.setText("");
        }
        if (e.getSource() == vista.ButtonLimpiar) {
            vista.TexCCosto.setText("");
            vista.TexCiudad.setText("");
            vista.TexDireccion.setText("");
            vista.TexECivil.setText("");
            vista.TexNit.setText("");
            vista.TexNombre.setText("");
            vista.TexTelefono.setText("");
        }
        if (e.getSource() == vista.ButtonCerrar) {
            vista.dispose();
        }
    }
    
}
