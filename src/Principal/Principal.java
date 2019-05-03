/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Controlador.ControladorPrincipal;
import Vista.vistaPrincipal;

/**
 *
 * @author jose urrego
 * @author juan Balsero
 */
public class Principal {
    public static void main(String[] args) {
        vistaPrincipal vista = new vistaPrincipal();
        ControladorPrincipal controller = new ControladorPrincipal(vista);
    }
}
