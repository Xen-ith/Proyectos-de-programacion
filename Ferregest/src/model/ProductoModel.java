package model;

public class ProductoModel extends ProveedorModel {
    
    private String nombre_producto;
    private int IdProducto;
    private String descripcion;
    private String proveedor;
    private String categoria;
    private int cantidad;
    private int precio_compra;
    private int precio_venta;

    public ProductoModel() {
        
    }
    
    

    public ProductoModel(String nombre_producto, int IdProducto, String descripcion, String proveedor, String categoria, int cantidad, int precio_compra, int precio_venta) {
        this.nombre_producto = nombre_producto;
        this.IdProducto = IdProducto;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
    }

    public ProductoModel(String nombre_producto, int IdProducto, String descripcion, String proveedor, String categoria, int cantidad, int precio_compra, int precio_venta, String nombre, long identificacion, long telefono, String direccion, String correo, String pago) {
        super(nombre, identificacion, telefono, direccion, correo, pago);
        this.nombre_producto = nombre_producto;
        this.IdProducto = IdProducto;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
    }

    
    

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    
        
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(int precio_compra) {
        this.precio_compra = precio_compra;
    }

    public int getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(int precio_venta) {
        this.precio_venta = precio_venta;
    }

    @Override
    public String toString() {
        return "nombre_producto=" + nombre_producto + 
                ", IdProducto=" + IdProducto + 
                ", descripcion=" + descripcion + 
                ", proveedor=" + proveedor + 
                ", categoria=" + categoria + 
                ", cantidad=" + cantidad + 
                ", precio_compra=" + precio_compra + 
                ", precio_venta=" + precio_venta;
    }

     
    
    
    
}
