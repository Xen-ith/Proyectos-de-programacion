package controller;

import interfaces.CrudProductosInterfaces;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Properties;
import javax.swing.JOptionPane;
import model.ProductoModel;


public class ProductoController implements CrudProductosInterfaces {

    public ProductoController() {
        File path = new File(CrudProductosInterfaces.PATCH);

        path.mkdir();

    }

    public ProductoModel producto_model = new ProductoModel();
    private ArrayList<String[]> filas;

    public boolean validarFormulario(String nombre_producto, int IdProducto, String descripcion, String proveedor, String categoria, int cantidad, int precio_compra, int precio_venta) {
        return !(nombre_producto.isEmpty() || IdProducto == 0 || descripcion.isEmpty()
                || proveedor.isEmpty() || categoria.isEmpty() || cantidad == 0
                || precio_compra == 0 || precio_venta == 0);
    }

    public boolean validarIdProducto(int identificacion) {
        return identificacion != 0;
    }

    public boolean existeProducto(String nombre_archivo) {
        File archivo = new File(CrudProductosInterfaces.PATCH + nombre_archivo + CrudProductosInterfaces.EXTENCION);
        return archivo.exists();
    }

    public ArrayList<String[]> mostarProductoTabla() {
        filas = new ArrayList<>();
        File ubicacion_archivo = new File(CrudProductosInterfaces.PATCH);
        File[] listar_archivos = ubicacion_archivo.listFiles();

        try {
            for (File listar_archivo : listar_archivos) {
                try (FileInputStream i = new FileInputStream(listar_archivo)) {
                    Properties detalles_Archivo = new Properties();
                    detalles_Archivo.load(i);

                    filas.add(new String[]{
                        //                        listar_archivo.getName().replace(".txt", ""),
                        detalles_Archivo.getProperty("nombre"),
                        detalles_Archivo.getProperty("idProducto"),
                        detalles_Archivo.getProperty("descripcion"),
                        detalles_Archivo.getProperty("proveedor"),
                        detalles_Archivo.getProperty("categoria"),
                        detalles_Archivo.getProperty("cantidad"),
                        detalles_Archivo.getProperty("precio_compra"),
                        detalles_Archivo.getProperty("precio_venta")
                    });
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return filas;
    }
    
    public String obtenerNombreArchivo(int codigo){
        String codigoProducto = String.valueOf(codigo);
        File carpeta = new File(CrudProductosInterfaces.PATCH);
        File[] arrayArchivos = carpeta.listFiles();
        
        for(File archivo: arrayArchivos){
            try (FileInputStream i = new FileInputStream(archivo)) {
                Properties detalleArchivo = new Properties();
                detalleArchivo.load(i);
                
                String codigoArchivo = detalleArchivo.getProperty("idProducto");
                if(codigoArchivo.equals(codigoProducto)){
                    System.out.println("UWU:  " + archivo.getName());
                    return archivo.getName();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            }
        return "";
        }
    
    

    @Override
    public void crearArchivo(ProductoModel Producto, String nombre_archivo) {
        producto_model = Producto;

        File ubicacion_archivo = new File(CrudProductosInterfaces.PATCH);
        File nuevo_archivo = new File(CrudProductosInterfaces.PATCH + nombre_archivo + CrudProductosInterfaces.EXTENCION);

        if (!nuevo_archivo.exists()) {
            try {
                ubicacion_archivo.mkdir();
                try (Formatter formateo = new Formatter(CrudProductosInterfaces.PATCH + nombre_archivo + CrudProductosInterfaces.EXTENCION)) {
                    formateo.format("%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n",
                            "nombre: " + producto_model.getNombre_producto(),
                            "idProducto: " + producto_model.getIdProducto(),
                            "descripcion: " + producto_model.getDescripcion(),
                            "proveedor: " + producto_model.getProveedor(),
                            "categoria: " + producto_model.getCategoria(),
                            "cantidad: " + producto_model.getCantidad(),
                            "precio_compra: " + producto_model.getPrecio_compra(),
                            "precio_venta: " + producto_model.getPrecio_venta());
                    formateo.close();
                    JOptionPane.showMessageDialog(null, "Archivo " + nombre_archivo + " creado exitosamente");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al crear el archivo: " + e.getMessage());
                }

            } catch (Exception e) {
            }

        }

    }

    @Override
    public void actualizarArchivo(ProductoModel Producto, String nombre_archivo) {
        producto_model = Producto;

        File ubicacionArchivo = new File(CrudProductosInterfaces.PATCH + nombre_archivo + CrudProductosInterfaces.EXTENCION);
        if (ubicacionArchivo.exists()) {
            try (FileWriter escribirArchivo = new FileWriter(ubicacionArchivo);
                    PrintWriter imprimirArchivo = new PrintWriter(escribirArchivo)) {
                imprimirArchivo.format("%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n",
                        "nombre: " + producto_model.getNombre_producto(),
                        "idProducto: " + producto_model.getIdProducto(),
                        "descripcion: " + producto_model.getDescripcion(),
                        "proveedor: " + producto_model.getProveedor(),
                        "categoria: " + producto_model.getCategoria(),
                        "cantidad: " + producto_model.getCantidad(),
                        "precio_compra: " + producto_model.getPrecio_compra(),
                        "precio_venta: " + producto_model.getPrecio_venta());

                JOptionPane.showMessageDialog(null, "Archivo " + nombre_archivo + " se ha actualizado.");
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar el archivo " + nombre_archivo);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El archivo " + nombre_archivo + " no existe.");
        }
    }

    @Override
    public void eliminarArchivo(String nombre_archivo) {
        File ubicacionArchivo = new File(CrudProductosInterfaces.PATCH + nombre_archivo + CrudProductosInterfaces.EXTENCION);

        if (ubicacionArchivo.exists()) {
            try {
                if (ubicacionArchivo.delete()) {
                    JOptionPane.showMessageDialog(null, "Archivo eliminado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Archivo eliminado correctamente" + ubicacionArchivo.getAbsolutePath());
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Se depecto un error inesperado " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "El archivo no existe");
        }

    }
    
    @Override
    public void generarFactura(ProductoModel Producto, String nombre_archivo, String cedula, ArrayList<String[]> listaVenta, String precio, String precioTOTAL){
        ArrayList<String> listaFactura = new ArrayList();
        File ubicacion_archivo = new File(CrudProductosInterfaces.PATHVENTAS);

        
        producto_model = Producto;
        for(String[] productico : listaVenta){
            producto_model.setNombre_producto(String.valueOf(productico[0]));
            producto_model.setCantidad(Integer.parseInt(productico[2]));
            producto_model.setPrecio_venta(Integer.parseInt(productico[1]));
            listaFactura.add("PRODUCTO: " + producto_model.getNombre_producto() + "| PRECIO: " + producto_model.getPrecio_venta() +
                    "| CANTIDAD: " + producto_model.getCantidad()+ "\n");
        }

            try {
                ubicacion_archivo.mkdir();
                try (Formatter formateo = new Formatter(CrudProductosInterfaces.PATHVENTAS + nombre_archivo + CrudProductosInterfaces.EXTENCION)) {
                    formateo.format("%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n",
                            "COMPRADOR: " + nombre_archivo + "  ||  CEDULA: "  + cedula,
                            "\n-------------------------------------------------------------------------\n",
                            String.join("\r\n", listaFactura),
                            "-------------------------------------------------------------------------\n",
                            "PRECIO DE VENTA: " + precio,
                            "IVA: 15%",
                            "PRECIO TOTAL:" + precioTOTAL);
                    formateo.close();
                    JOptionPane.showMessageDialog(null, "Factura creada");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al crear el archivo: " + e.getMessage());
                }

            } catch (Exception e) {
                System.out.println(e);
            }
    }
    
    @Override
    public void actualizarArchivoVenta(ProductoModel Producto, String nombre_archivo) {
        producto_model = Producto;

        File ubicacionArchivo = new File(CrudProductosInterfaces.PATCH + nombre_archivo + CrudProductosInterfaces.EXTENCION);
        if (ubicacionArchivo.exists()) {
            try (FileWriter escribirArchivo = new FileWriter(ubicacionArchivo); PrintWriter imprimirArchivo = new PrintWriter(escribirArchivo)) {

                imprimirArchivo.format("%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n",
                        "nombre: " + producto_model.getNombre_producto(),
                        "idProducto: " + producto_model.getIdProducto(),
                        "descripcion: " + producto_model.getDescripcion(),
                        "proveedor: " + producto_model.getProveedor(),
                        "categoria: " + producto_model.getCategoria(),
                        "cantidad: " + producto_model.getCantidad(),
                        "precio_compra: " + producto_model.getPrecio_compra(),
                        "precio_venta: " + producto_model.getPrecio_venta());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cambiar cantidad de: " + nombre_archivo);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El archivo " + nombre_archivo + " no existe.");
        }
    }

}
