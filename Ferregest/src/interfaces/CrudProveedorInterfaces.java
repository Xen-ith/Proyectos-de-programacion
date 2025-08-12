package interfaces;

import java.io.File;
import model.ProveedorModel;

public interface CrudProveedorInterfaces {
    
    final String SEPARADOR = File.separator;
    final String PATCH  = System.getProperty("user.dir") + SEPARADOR + "Proveedor" + SEPARADOR;
    final String EXTENCION = ".txt";
    
    abstract void crearArchivoProveedor(ProveedorModel Proveedor, String nombre_archivo);
    
    abstract void actualizarArchivoProveedor(ProveedorModel Proveedor, String nombre_archivo);
    
    abstract void eliminarArchivoProveedor(String nombre_archivo);
}
