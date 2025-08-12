package view;

import controller.ProductoController;
import interfaces.CrudProductosInterfaces;
import interfaces.CrudProveedorInterfaces;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class MenuPrincipal extends javax.swing.JFrame {

    private final ProductoController PRODUCTO_CONTROLLER = new ProductoController();
    private final String[] Columnas = {"Producto".toUpperCase(), "Id Producto".toUpperCase(), "Descripcion".toUpperCase(), "Proveedor".toUpperCase(), "Categoria".toUpperCase(), "Cantidad".toUpperCase(),
        "Precio de compra".toUpperCase(), "Precio de venta".toUpperCase()};
    private final DefaultTableModel TABLA_DEFECTO = new DefaultTableModel(null, Columnas);

    private MenuVenta ventanaVenta;

    public void setVentana(MenuVenta ventanaVenta) {
        this.ventanaVenta = ventanaVenta;
    }

    private MenuProveedor ventana;

    public void setVentana(MenuProveedor ventana) {
        this.ventana = ventana;
    }

    private MenuCotizacion ventanaCotizacion;

    public void setVentana(MenuCotizacion Cotizacion) {
        this.ventanaCotizacion = ventanaCotizacion;
    }

    private MenuPrincipal menu_principal;

    public void setVentana(MenuPrincipal principal) {
        this.menu_principal = menu_principal;
    }

    public MenuPrincipal() {
        initComponents();
        this.setResizable(false);
        this.setTitle("Sistema de inventario La Ermita".toUpperCase());
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Ico.png")).getImage());
        this.setLocationRelativeTo(null);
        generarTabla();
        cargarProveedores();
    }

    private void reiniciarFormulario() {
        jTextFieldNombre.setText("");
        jTextFieldIDProducto.setText("");
        jTextFieldDescripcion.setText("");
        jTextFieldCategoria.setText("");
        jComboBoxProveedor1.setSelectedIndex(0);
        jTextFieldCategoria.setText("");
        jSpinnerCantidad1p.setValue(0);
        jSpinnerCompras.setValue(0);
        jSpinnerVenta.setValue(0);

    }

    public TableRowSorter filtroS;
    String filtro;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jLabelNombre = new javax.swing.JLabel();
        jLabelDescripcion = new javax.swing.JLabel();
        jLabelProveedor = new javax.swing.JLabel();
        jLabelCategoria = new javax.swing.JLabel();
        jLabelIDPro = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelComprar = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldCategoria = new javax.swing.JTextField();
        jSpinnerVenta = new javax.swing.JSpinner();
        jSpinnerCompras = new javax.swing.JSpinner();
        jButtonRegistroProveedor = new javax.swing.JButton();
        jLabelCantidad1 = new javax.swing.JLabel();
        jSpinnerCantidad1p = new javax.swing.JSpinner();
        jButtonBuscar = new javax.swing.JButton();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jButtonEliminar = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jComboBoxProveedor1 = new javax.swing.JComboBox<>();
        jButtonRegistrar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonReset = new javax.swing.JButton();
        jTextFieldIDProducto = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItemVentas = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuSoporte = new javax.swing.JMenu();
        jMenuItemAcercadeNosostros = new javax.swing.JMenuItem();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 900, 30));

        jTableProductos.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jTableProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProductos);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 900, 170));

        jLabelNombre.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabelNombre.setText("NOMBRE:");
        jLabelNombre.setPreferredSize(new java.awt.Dimension(76, 20));
        jPanel3.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, -1));

        jLabelDescripcion.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabelDescripcion.setText("DESCRIPCION:");
        jLabelDescripcion.setPreferredSize(new java.awt.Dimension(76, 20));
        jPanel3.add(jLabelDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 120, -1));

        jLabelProveedor.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabelProveedor.setText("PROVEEDOR:");
        jLabelProveedor.setPreferredSize(new java.awt.Dimension(76, 20));
        jPanel3.add(jLabelProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 110, -1));

        jLabelCategoria.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabelCategoria.setText("CATEGORIA:");
        jLabelCategoria.setPreferredSize(new java.awt.Dimension(76, 20));
        jPanel3.add(jLabelCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 100, -1));

        jLabelIDPro.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabelIDPro.setText("ID PRODUCTO:");
        jLabelIDPro.setPreferredSize(new java.awt.Dimension(76, 20));
        jPanel3.add(jLabelIDPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 120, 20));

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel10.setText("PRECIO DE VENTA:");
        jLabel10.setPreferredSize(new java.awt.Dimension(76, 20));
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 150, -1));

        jLabelComprar.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabelComprar.setText("PRECIO DE COMPRA:");
        jLabelComprar.setPreferredSize(new java.awt.Dimension(76, 20));
        jPanel3.add(jLabelComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 170, -1));

        jSeparator2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSeparator2MouseClicked(evt);
            }
        });
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 900, 20));

        jTextFieldNombre.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jTextFieldNombre.setPreferredSize(new java.awt.Dimension(0, 25));
        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });
        jTextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombreKeyTyped(evt);
            }
        });
        jPanel3.add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 400, -1));

        jTextFieldCategoria.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jTextFieldCategoria.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel3.add(jTextFieldCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 370, -1));

        jSpinnerVenta.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000000, 1));
        jSpinnerVenta.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel3.add(jSpinnerVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, 230, -1));

        jSpinnerCompras.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000000, 1));
        jSpinnerCompras.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel3.add(jSpinnerCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, 220, -1));

        jButtonRegistroProveedor.setText("?");
        jButtonRegistroProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroProveedorActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonRegistroProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 40, -1));

        jLabelCantidad1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabelCantidad1.setText("CANTIDAD:");
        jLabelCantidad1.setPreferredSize(new java.awt.Dimension(76, 20));
        jPanel3.add(jLabelCantidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 90, 20));

        jSpinnerCantidad1p.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000, 1));
        jSpinnerCantidad1p.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel3.add(jSpinnerCantidad1p, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 290, -1));

        jButtonBuscar.setText("BUSCAR");
        jButtonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBuscarMouseClicked(evt);
            }
        });
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 160, -1));

        jTextFieldDescripcion.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jTextFieldDescripcion.setPreferredSize(new java.awt.Dimension(0, 25));
        jPanel3.add(jTextFieldDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 360, -1));

        jButtonEliminar.setText("ELIMINAR");
        jButtonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEliminarMouseClicked(evt);
            }
        });
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 160, -1));

        jButtonActualizar.setText("ACTUALIZAR");
        jButtonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonActualizarMouseClicked(evt);
            }
        });
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 170, -1));

        jComboBoxProveedor1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Selecione una opcion" }));
        jComboBoxProveedor1.setPreferredSize(new java.awt.Dimension(0, 25));
        jComboBoxProveedor1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxProveedor1MouseClicked(evt);
            }
        });
        jComboBoxProveedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProveedor1ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBoxProveedor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 310, -1));

        jButtonRegistrar1.setText("REGISTRAR");
        jButtonRegistrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRegistrar1MouseClicked(evt);
            }
        });
        jButtonRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrar1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonRegistrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 140, -1));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SISTEMA DE INVENTARIO LA ERMITA");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 40));

        jButtonReset.setText("LIMPIAR");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 220, 150, -1));

        jTextFieldIDProducto.setEditable(false);
        jTextFieldIDProducto.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jTextFieldIDProducto.setFocusable(false);
        jTextFieldIDProducto.setPreferredSize(new java.awt.Dimension(0, 25));
        jTextFieldIDProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldIDProductoKeyTyped(evt);
            }
        });
        jPanel3.add(jTextFieldIDProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 260, -1));

        jMenu1.setText("Sistema");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setText("Cerrar Sistema");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu6.setText("Ventas / Cotizacion ");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem4.setText("Menu Principal");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem4);

        jMenuItemVentas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemVentas.setText("Ventas");
        jMenuItemVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVentasActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItemVentas);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Cotizacion");
        jMenuItem2.setToolTipText("");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem2);
        jMenu6.add(jSeparator3);

        jMenuBar1.add(jMenu6);

        jMenu5.setText("Proveedor ");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Abrir Menu");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuBar1.add(jMenu5);

        jMenuSoporte.setText("Soporte");

        jMenuItemAcercadeNosostros.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemAcercadeNosostros.setText("Acerca de nosostros");
        jMenuItemAcercadeNosostros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAcercadeNosostrosActionPerformed(evt);
            }
        });
        jMenuSoporte.add(jMenuItemAcercadeNosostros);

        jMenuBar1.add(jMenuSoporte);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVentasActionPerformed
        MenuVenta venta = new MenuVenta();
        venta.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jMenuItemVentasActionPerformed

    private void jMenuItemAcercadeNosostrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAcercadeNosostrosActionPerformed
        JOptionPane.showMessageDialog(null, """
                                            """);
    }//GEN-LAST:event_jMenuItemAcercadeNosostrosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        MenuProveedor Proveedor = new MenuProveedor();
        Proveedor.setVentana(Proveedor);
        Proveedor.setVisible(true);
        this.setVisible(false);
        this.dispose();

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButtonRegistroProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroProveedorActionPerformed
        JOptionPane.showMessageDialog(null, "Crea nuevo proveedor");
        MenuProveedor Proveedor = new MenuProveedor();
        Proveedor.setVentana(Proveedor);
        Proveedor.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButtonRegistroProveedorActionPerformed

    private void jButtonBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBuscarMouseClicked

    }//GEN-LAST:event_jButtonBuscarMouseClicked

    private void jTableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductosMouseClicked
        try {
            int indice = jTableProductos.rowAtPoint(evt.getPoint());
            if (indice >= 0 && indice < jTableProductos.getRowCount()) {

                jTextFieldNombre.setText(String.valueOf(jTableProductos.getValueAt(indice, 0)));
                jTextFieldIDProducto.setText(String.valueOf(jTableProductos.getValueAt(indice, 1)));
                jTextFieldDescripcion.setText(String.valueOf(jTableProductos.getValueAt(indice, 2)));
                jComboBoxProveedor1.setSelectedItem(String.valueOf(jTableProductos.getValueAt(indice, 3)));
                jTextFieldCategoria.setText(String.valueOf(jTableProductos.getValueAt(indice, 4)));
                jSpinnerCompras.setValue(Integer.valueOf(jTableProductos.getValueAt(indice, 6).toString()));
                jSpinnerVenta.setValue(Integer.valueOf(jTableProductos.getValueAt(indice, 7).toString()));
                jSpinnerCantidad1p.setValue(Integer.valueOf(jTableProductos.getValueAt(indice, 5).toString()));

            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al selecionar el valor " + e.getMessage());
        }

    }//GEN-LAST:event_jTableProductosMouseClicked

    private void jButtonEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminarMouseClicked
//        try {
//            String archivoEliminar = jTextFieldNombre.getText();
//            if (archivoEliminar.equals("")) {
//                JOptionPane.showMessageDialog(this, "ingrese un codigo de producto");
//            } else {
//                PRODUCTO_CONTROLLER.eliminarArchivo(archivoEliminar);
//                reiniciarFormulario();
//                generarTabla();
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

try {
            int archivoEliminar = Integer.parseInt(jTextFieldIDProducto.getText());
            String productoEliminar = PRODUCTO_CONTROLLER.obtenerNombreArchivo(archivoEliminar).replace(".txt", "");
            if(productoEliminar.equals("")){
                JOptionPane.showMessageDialog(this, "Ingrese un codigo de producto valido");
            } else{
                System.out.println(productoEliminar);
                PRODUCTO_CONTROLLER.eliminarArchivo(productoEliminar);
                reiniciarFormulario();
                generarTabla();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButtonEliminarMouseClicked

    private void jButtonActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonActualizarMouseClicked
        try {
            String nombre = jTextFieldNombre.getText();
            String IdProducto = jTextFieldIDProducto.getText();
            String descripcion = jTextFieldDescripcion.getText();
            String proveedor = (String) jComboBoxProveedor1.getSelectedItem();
            String categoria = jTextFieldCategoria.getText();
            int cantidad = (int) jSpinnerCantidad1p.getValue();
            int precioCompra = (int) jSpinnerCompras.getValue();
            int precioVenta = (int) jSpinnerVenta.getValue();

            if (PRODUCTO_CONTROLLER.validarFormulario(nombre, Integer.parseInt(IdProducto), descripcion, proveedor, categoria, cantidad, precioCompra, precioVenta)) {
                PRODUCTO_CONTROLLER.producto_model.setNombre_producto(nombre);
                PRODUCTO_CONTROLLER.producto_model.setIdProducto(Integer.parseInt(IdProducto));
                PRODUCTO_CONTROLLER.producto_model.setDescripcion(descripcion);
                PRODUCTO_CONTROLLER.producto_model.setProveedor(proveedor);
                PRODUCTO_CONTROLLER.producto_model.setCategoria(categoria);
                PRODUCTO_CONTROLLER.producto_model.setCantidad(cantidad);
                PRODUCTO_CONTROLLER.producto_model.setPrecio_compra(precioCompra);
                PRODUCTO_CONTROLLER.producto_model.setPrecio_venta(precioVenta);
                String nombreActualizar = PRODUCTO_CONTROLLER.obtenerNombreArchivo(Integer.parseInt(IdProducto));
                
                PRODUCTO_CONTROLLER.actualizarArchivo(PRODUCTO_CONTROLLER.producto_model, nombreActualizar);

                reiniciarFormulario();
                generarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "todos los campos son obligatorios");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButtonActualizarMouseClicked

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        try {
            jTextFieldNombre.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    try {
                        String cadena = jTextFieldNombre.getText();
                        jTextFieldNombre.setText(cadena);
                        repaint();
                        filtro();
                    } catch (Exception x) {
                        System.out.println(x.getMessage());
                    }
                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    public void filtro() {
        filtro = jTextFieldNombre.getText();
        filtroS.setRowFilter(RowFilter.regexFilter(jTextFieldNombre.getText(), 0));
    }

    private void jComboBoxProveedor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProveedor1ActionPerformed


    }//GEN-LAST:event_jComboBoxProveedor1ActionPerformed

    private void jComboBoxProveedor1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxProveedor1MouseClicked
        
    }//GEN-LAST:event_jComboBoxProveedor1MouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JOptionPane.showMessageDialog(null, "CERRAR SESSION");
        LauncherSystem login = new LauncherSystem();
        login.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButtonRegistrar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegistrar1MouseClicked
        try {
            String nombre = jTextFieldNombre.getText();
            int IdProducto = generarCodigo();
            String descripcion = jTextFieldDescripcion.getText();
            String proveedor = (String) jComboBoxProveedor1.getSelectedItem();
            String categoria = jTextFieldCategoria.getText();
            int cantidad = (int) jSpinnerCantidad1p.getValue();
            int precioCompra = (int) jSpinnerCompras.getValue();
            int precioVenta = (int) jSpinnerVenta.getValue();

            if (PRODUCTO_CONTROLLER.validarFormulario(nombre, IdProducto, descripcion, proveedor, categoria, cantidad, precioCompra, precioVenta)) {
                if (PRODUCTO_CONTROLLER.existeProducto(nombre)) {
                    JOptionPane.showMessageDialog(this, "Producto: " + nombre + " ya existe");
                } else {
                    PRODUCTO_CONTROLLER.producto_model.setNombre_producto(nombre);
                    PRODUCTO_CONTROLLER.producto_model.setIdProducto(IdProducto);
                    PRODUCTO_CONTROLLER.producto_model.setDescripcion(descripcion);
                    PRODUCTO_CONTROLLER.producto_model.setProveedor(proveedor);
                    PRODUCTO_CONTROLLER.producto_model.setCategoria(categoria);
                    PRODUCTO_CONTROLLER.producto_model.setCantidad(cantidad);
                    PRODUCTO_CONTROLLER.producto_model.setPrecio_compra(precioCompra);
                    PRODUCTO_CONTROLLER.producto_model.setPrecio_venta(precioVenta);
                    PRODUCTO_CONTROLLER.crearArchivo(PRODUCTO_CONTROLLER.producto_model, nombre);

                    reiniciarFormulario();
                    generarTabla();
                }
            } else {
                JOptionPane.showMessageDialog(this, "todos los campos son obligatorios");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButtonRegistrar1MouseClicked

    private void jButtonRegistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegistrar1ActionPerformed

    private void jTextFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreKeyTyped
        filtroS = new TableRowSorter(jTableProductos.getModel());
        jTableProductos.setRowSorter(filtroS);
    }//GEN-LAST:event_jTextFieldNombreKeyTyped

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jSeparator2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSeparator2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jSeparator2MouseClicked

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        JOptionPane.showMessageDialog(null, "Se limpiara los datos digitados");
        reiniciarFormulario();
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        MenuCotizacion Cotizacion = new MenuCotizacion();
        Cotizacion.setVentana(Cotizacion);
        Cotizacion.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       MenuPrincipal menu_principal = new MenuPrincipal();
       menu_principal.setVentana(menu_principal);
       menu_principal.setVisible(true);
       this.setVisible(false);
       this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jTextFieldIDProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIDProductoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDProductoKeyTyped

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonRegistrar1;
    private javax.swing.JButton jButtonRegistroProveedor;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JComboBox<String> jComboBoxProveedor1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabelCantidad1;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelComprar;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelIDPro;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelProveedor;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItemAcercadeNosostros;
    private javax.swing.JMenuItem jMenuItemVentas;
    private javax.swing.JMenu jMenuSoporte;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JSpinner jSpinnerCantidad1p;
    private javax.swing.JSpinner jSpinnerCompras;
    private javax.swing.JSpinner jSpinnerVenta;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTextField jTextFieldCategoria;
    private javax.swing.JTextField jTextFieldDescripcion;
    private javax.swing.JTextField jTextFieldIDProducto;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables

    private void generarTabla() {
        TABLA_DEFECTO.setRowCount(0);
        for (String[] datos : PRODUCTO_CONTROLLER.mostarProductoTabla()) {
            TABLA_DEFECTO.addRow(datos);
        }
        jTableProductos.setModel(TABLA_DEFECTO);
        System.out.println(Arrays.deepToString(PRODUCTO_CONTROLLER.mostarProductoTabla().toArray()));
    }

//    private String leerPrimerIndice(File archivo) {
//        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
//            return reader.readLine(); // Leer la primera línea
//        } catch (IOException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + archivo.getAbsolutePath() + " (" + e.getMessage() + ")", "Error", JOptionPane.ERROR_MESSAGE);
//            return null;
//        }
//    }

    private int generarCodigo() {
        Random numero = new Random();
        ArrayList<String> codigos = new ArrayList();
        File carpeta = new File(CrudProductosInterfaces.PATCH);
        File[] arrayArchivos = carpeta.listFiles();

        for (File archivo : arrayArchivos) {
            try (FileInputStream i = new FileInputStream(archivo)) {
                Properties detalleArchivo = new Properties();
                detalleArchivo.load(i);
                String codigoArchivo = detalleArchivo.getProperty("idProducto");
                codigos.add(codigoArchivo);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            boolean duplicado = true;

            while (duplicado) {
                int codigoProducto = numero.nextInt(2147483647);
                String valorString = String.valueOf(codigoProducto);
                if (codigos.contains(valorString)) {
                } else {
                    duplicado = false;
                    return codigoProducto;
                }

            }

        }
        return numero.nextInt(2147483647);
    }

    private void cargarProveedores() {
        try {
            File ubicacionArchivo = new File(CrudProveedorInterfaces.PATCH);

            if (ubicacionArchivo.exists() && ubicacionArchivo.isDirectory()) {
                File[] archivos = ubicacionArchivo.listFiles();
                if (archivos != null) {
                    for (File archivo : archivos) {
                        String nombreArchivo = archivo.getName();
                        String nombreArreglado = nombreArchivo.replace(".txt", "");
                        jComboBoxProveedor1.addItem(nombreArreglado);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se encuentran proveedores creados", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al procesar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
