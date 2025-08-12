package model;

public class ProveedorModel {

    private String nombre;
    private long identificacion;
    private long telefono;
    private String direccion;
    private String correo;
    private String pago;

    public ProveedorModel() {
    }

    public ProveedorModel(String nombre, long identificacion, long telefono, String direccion, String correo, String pago) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.pago = pago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre
                + ", identificacion=" + identificacion
                + ", telefono=" + telefono
                + ", direccion=" + direccion
                + ", correo=" + correo
                + ", pago=" + pago;
    }

}
