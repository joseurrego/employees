package Modelo;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcesarBD {

    private Conexion con;

    public ProcesarBD() {
        System.out.println("entro");
        this.con = new Conexion();
    }

    public void ingresarEmpleado(int Nit, String nombre, String direccion, String Telefono, String Ciudad, int CCosto, String E_Civil, String F_ingreso, int Cuenta) {
        String datos[] = {String.valueOf(Nit), nombre, direccion, Telefono, Ciudad, String.valueOf(CCosto), E_Civil, F_ingreso, String.valueOf(Cuenta)};
        insertar(datos, "INSERT INTO MaestroEmpleados(Nit, Nombre, Direccion, Telefono, Ciudad, CCosto, E_Civil, F_ingreso, Cuenta) VALUES(?,?,?,?,?,?,?,?,?)");
    }
    public void ingresarCentroCostos(int Codigo, String Descripcion) {
        String datos[] = {String.valueOf(Codigo), Descripcion};
        insertar(datos, "INSERT INTO CentroCostos(Codigo, Descripcion) VALUES(?,?)");
    }
    public void ingresarConceptosPago(int Codigo, String Descripcion, String Tipo, int Valor) {
        String datos[] = {String.valueOf(Codigo), Descripcion, Tipo, String.valueOf(Valor)};
        insertar(datos, "INSERT INTO ConceptosPago(Codigo, Descripcion, Tipo, Valor) VALUES(?,?,?,?)");
    }
    public void ingresarConceptosDescuento(int Codigo, String Descripcion, String Tipo, int Valor) {
        String datos[] = {String.valueOf(Codigo), Descripcion, Tipo, String.valueOf(Valor)};
        insertar(datos, "INSERT INTO ConceptosDescuento(Codigo, Descripcion, Tipo, Valor) VALUES(?,?,?,?)");
    }
    public void ingresarComprobantes(String Comprobante, String Descripcion, String Tipo, int Cuenta) {
        String datos[] = {Comprobante, Descripcion, Tipo, String.valueOf(Cuenta)};
        insertar(datos, "INSERT INTO ConceptosDescuento(Comprobante, Descripcion, Tipo, Cuenta) VALUES(?,?,?,?)");
    }
    public boolean insertar(String datos[], String insert) {
        boolean estado = false;

        try {
            //Connection dbC= (Connection) con.conectado();
            //PreparedStatement ps = dbC.prepareStatement(insert);	
            PreparedStatement ps = con.conectado().prepareStatement(insert);

            for (int i = 0; i <= datos.length - 1; i++) {
                ps.setString(i + 1, datos[i]);
            }
            ps.execute();
            ps.close();
            estado = true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return estado;
    }

    public void listar() {
        String strConsulta = "SELECT *FROM articulo";
        try {
            PreparedStatement ps = con.conectado().prepareStatement(strConsulta);
            ResultSet res = ps.executeQuery();

            String codigo = "";
            String nombre = "";
            int precio = 0;
            while (res.next()) {
                codigo = res.getString("id_arti");
                nombre = res.getString("nom_art");
                precio = res.getInt("precio_art");
                System.out.println(codigo + "\t" + nombre + "\t" + precio);
            }
            res.close();

        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
