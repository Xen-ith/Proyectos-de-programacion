package controller;

import interfaces.CrudProveedorInterfaces;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Properties;
import javax.swing.JOptionPane;
import model.ProveedorModel;

public class ProveedorController implements CrudProveedorInterfaces {

    public ProveedorController() {
        File path = new File(CrudProveedorInterfaces.PATCH);
        path.mkdirs();
        if (!path.exists()) {
            System.out.println("No se pudo crear la carpeta: " + path.getAbsolutePath());
        }

    }

    public ProveedorModel proveedor_model = new ProveedorModel();
    private ArrayList<String[]> filas;

    public boolean validarFormulario(String nombre, long identificacion, long telefono, String direccion, String correo, String pago) {
        return !(nombre.equals("") || identificacion == 0 || telefono == 0 || direccion.equals("") || correo.equals("") || pago.equals(""));
    }

    public boolean validarIdProveedor(String nombre) {
        return nombre !="" ;
    }

    public boolean existeProveedor(String nombre_archivo) {
        File archivo = new File(CrudProveedorInterfaces.PATCH
                + nombre_archivo + CrudProveedorInterfaces.EXTENCION);
        return archivo.exists();
    }

    public ArrayList<String[]> mostrarProveedorTabla() {
        filas = new ArrayList<>();
        File ubicacion_Proveedor = new File(CrudProveedorInterfaces.PATCH);
        File[] listar_Proveedor = ubicacion_Proveedor.listFiles();

        try {
            for (File listar_archivoProveedor : listar_Proveedor) {
                try (FileInputStream AI = new FileInputStream(listar_archivoProveedor)) {
                    Properties detalles_Archivo = new Properties();
                    detalles_Archivo.load(AI);

                    filas.add(new String[]{
//                       listar_archivoProveedor.getName().replace(".txt", ""),
                        detalles_Archivo.getProperty("nombre"),
                        detalles_Archivo.getProperty("identificacion"),
                        detalles_Archivo.getProperty("telefono"),
                        detalles_Archivo.getProperty("direccion"),
                        detalles_Archivo.getProperty("correo"),
                        detalles_Archivo.getProperty("pago")

                    });
                }
            }            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return filas;
    }

    @Override
    public void crearArchivoProveedor(ProveedorModel proveedor, String nombre_archivo) {
        proveedor_model = proveedor;

        File ubicacion_archivo = new File(CrudProveedorInterfaces.PATCH);

        if (!ubicacion_archivo.exists()) {
            ubicacion_archivo.mkdirs();
        }
        File nuevoUbicacion = new File(CrudProveedorInterfaces.PATCH + nombre_archivo + CrudProveedorInterfaces.EXTENCION);

        if (!nuevoUbicacion.exists()) {
            try {
                ubicacion_archivo.mkdir();
                try (Formatter formateador = new Formatter(nuevoUbicacion.getAbsolutePath())) {
                    formateador.format(
                            "%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n",
                            "nombre: " + proveedor_model.getNombre(),
                            "identificacion: " + proveedor_model.getIdentificacion(),
                            "telefono: " + proveedor_model.getTelefono(),
                            "direccion: " + proveedor_model.getDireccion(),
                            "correo: " + proveedor_model.getCorreo(),
                            "pago: " + proveedor_model.getPago()
                    );
                    formateador.close();
                    JOptionPane.showMessageDialog(null, "Archivo " + nombre_archivo + " creado");
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("El archivo " + nombre_archivo + "Ya existe");
        }
    }

    @Override
    public void actualizarArchivoProveedor(ProveedorModel Proveedor, String nombre_archivo) {
        proveedor_model = Proveedor;
        File nuevoUbicacion = new File(CrudProveedorInterfaces.PATCH + nombre_archivo + CrudProveedorInterfaces.EXTENCION);

        if (nuevoUbicacion.exists()) {
            try {
                FileWriter escribir_archivoProveedor = new FileWriter(nuevoUbicacion);

                try (PrintWriter imprimir_archivoProveedor = new PrintWriter(escribir_archivoProveedor)) {
                    imprimir_archivoProveedor.format(
                            "%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n",
                            "nombre: " + proveedor_model.getNombre(),
                            "identificacion: " + proveedor_model.getIdentificacion(),
                            "telefono: " + proveedor_model.getTelefono(),
                            "direccion: " + proveedor_model.getDireccion(),
                            "correo: " + proveedor_model.getCorreo(),
                            "pago: " + proveedor_model.getPago());
                    imprimir_archivoProveedor.close();
                    JOptionPane.showMessageDialog(null, "Archivo " + nombre_archivo + "Se Actualizado");

                }
            } catch (IOException e) {
                System.out.println(e.getMessage());

            }
        } else {
            System.out.println("El archivo " + nombre_archivo + "No existe");
        }
    }

    @Override
    public void eliminarArchivoProveedor(String nombre_archivo
    ) {
        File nuevoUbicacion = new File(CrudProveedorInterfaces.PATCH + nombre_archivo + CrudProveedorInterfaces.EXTENCION);
        if (nuevoUbicacion.exists()) {
            try {
                if (nuevoUbicacion.delete()) {
                    JOptionPane.showMessageDialog(null, "Archivo eliminado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el archivo" + nuevoUbicacion.getAbsolutePath());
                    JOptionPane.showMessageDialog(null, "El archivo esta en uso");

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "El archivo no existe");
        }

    }
}
