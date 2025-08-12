package interfaces;

import java.io.File;
import java.util.ArrayList;


public interface CrudProductosInterfaces {
    
    final String SEPARADOR = File.separator;
    final String PATCH  = System.getProperty("user.dir") + SEPARADOR + "Productos" + SEPARADOR;
    final String PATHVENTAS  = System.getProperty("user.dir") + SEPARADOR + "Factura" + SEPARADOR;
    final String EXTENCION = ".txt";
    
    abstract void crearArchivo(model.ProductoModel Producto, String nombre_archivo);
    
    abstract void actualizarArchivo(model.ProductoModel Producto, String nombre_archivo);
    
    abstract void actualizarArchivoVenta(model.ProductoModel Producto, String nombre_archivo);
    
    abstract void generarFactura(model.ProductoModel Producto, String nombre_archivo, String cedula, ArrayList<String[]> listaVenta, String precio, String precioTOTAL);
    
    abstract void eliminarArchivo(String nombre_archivo);
}
