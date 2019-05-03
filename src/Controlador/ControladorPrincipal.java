/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.vistaCentroCostos;
import Vista.vistaComprobantes;
import Vista.vistaConceptosDescuento;
import Vista.vistaConceptosPago;
import Vista.vistaMaestroEmpleados;
import Vista.vistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Labing
 */
public class ControladorPrincipal implements ActionListener {
    private vistaPrincipal Principal;
    private vistaCentroCostos vistaCentroCostos;
    private vistaComprobantes vistaComprobantes;
    private vistaConceptosDescuento vistaConceptosDescuento;
    private vistaConceptosPago vistaConceptosPago;
    private vistaMaestroEmpleados vistaMaestroEmpleados;
    
    public ControladorPrincipal(vistaPrincipal principal) {
        this.Principal=principal;
        
        this.vistaCentroCostos= new vistaCentroCostos();
        this.vistaComprobantes= new vistaComprobantes();
        this.vistaConceptosDescuento= new vistaConceptosDescuento();
        this.vistaConceptosPago= new vistaConceptosPago();
        this.vistaMaestroEmpleados= new vistaMaestroEmpleados();
        
        this.Principal.MenuCentroCostos.addActionListener(this);
        this.Principal.MenuComprobantes.addActionListener(this);
        this.Principal.MenuConceptosDescuento.addActionListener(this);
        this.Principal.MenuConceptosPago.addActionListener(this);
        this.Principal.MenuMaestroEmpleados.addActionListener(this);
        this.Principal.MenuSalir.addActionListener(this);
        this.Principal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== this.Principal.MenuMaestroEmpleados) {            
            ControladorMaestroEmpleados controladorME = new ControladorMaestroEmpleados(vistaMaestroEmpleados);
        }
        if (e.getSource()== this.Principal.MenuCentroCostos) {            
            ControladorCentroCostos controladorCC = new ControladorCentroCostos(vistaCentroCostos);
        }
        if (e.getSource()== this.Principal.MenuConceptosDescuento) {            
            ControladorConceptosDescuento controladorCD = new ControladorConceptosDescuento(vistaConceptosDescuento);
        }
        if (e.getSource()== this.Principal.MenuConceptosPago) {            
            ControladorConceptosPago controladorCP = new ControladorConceptosPago(vistaConceptosPago);
        }
        if (e.getSource()== this.Principal.MenuComprobantes) {            
            ControladorComprobantes controladorCO = new ControladorComprobantes(vistaComprobantes);
        }
        if (e.getSource()== this.Principal.MenuSalir) {            
            Principal.dispose();
            System.exit(0);
        }
    }

}
