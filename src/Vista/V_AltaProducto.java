package Vista;

import Conexion.Conexiones;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class V_AltaProducto extends javax.swing.JInternalFrame implements Runnable {

    Conexiones cn;
    boolean editar = false;
    int id_producto = 0;
    String hora,minutos,segundos,ampm;
    Calendar calendario;    
    Thread h1;
    public V_AltaProducto(Conexiones con) throws SQLException {
        initComponents();
        cn = con;
        CargarTabla();
        h1 = new Thread(this);
        h1.start();
    }

    public void CargarTabla() throws SQLException{
        ResultSet rs;
        rs = cn.ejecutarSQLSelect("Select * from producto");
        ResultSetMetaData metadata = rs.getMetaData();
        
        //Agregamos los datos de la cabecera de la tabla
        
        Object[] col = new Object[metadata.getColumnCount()];
        int columnas = metadata.getColumnCount();
        for (int i = 1; i <= columnas; i++) {
            col[i-1]=metadata.getColumnName(i);
        }
        
        DefaultTableModel modTable = new DefaultTableModel(null,col);
        Object[] filas = new Object[columnas];
        while (rs.next()) {
            //agregamos una de las filas de la tabla
            for (int j = 1; j <= columnas; j++) {
                filas[j-1]=(rs.getString(j));
            }
            modTable.addRow(filas);
        }
        cn.cerrarConexion();
        this.Table.setModel(modTable);
    }
    public void calcula () {        
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();


        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";

        if(ampm.equals("PM")){
         int h = calendario.get(Calendar.HOUR_OF_DAY)-12;
         hora = h>9?""+h:"0"+h;
        }else{
         hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);            
        }
        minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND); 
    }
    public void Limpiar(){
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelNorte = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        PanelCentro = new javax.swing.JPanel();
        Datos = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(34, 0), new java.awt.Dimension(34, 0), new java.awt.Dimension(34, 32767));
        txtNombre = new javax.swing.JTextField();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(13, 0), new java.awt.Dimension(13, 0), new java.awt.Dimension(13, 32767));
        txtDescripcion = new javax.swing.JTextField();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(44, 0), new java.awt.Dimension(44, 0), new java.awt.Dimension(44, 32767));
        txtPrecio = new javax.swing.JTextField();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 32767));
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 80), new java.awt.Dimension(0, 80), new java.awt.Dimension(32767, 80));
        Tabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        PanelSur = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Alta Producto");
        setPreferredSize(new java.awt.Dimension(130, 55));

        PanelNorte.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ufgkjh.jpg"))); // NOI18N
        jPanel4.add(jLabel1);

        PanelNorte.add(jPanel4);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.Y_AXIS));

        lblUser.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblUser.setText("Usuario:");
        jPanel5.add(lblUser);

        lblFecha.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblFecha.setText("Fecha:");
        jPanel5.add(lblFecha);

        PanelNorte.add(jPanel5);

        getContentPane().add(PanelNorte, java.awt.BorderLayout.PAGE_START);

        PanelCentro.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PanelCentro.setLayout(new javax.swing.BoxLayout(PanelCentro, javax.swing.BoxLayout.Y_AXIS));

        Datos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Producto"));
        Datos.setLayout(new javax.swing.BoxLayout(Datos, javax.swing.BoxLayout.Y_AXIS));

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.X_AXIS));

        jLabel2.setText("Nombre:");
        jPanel6.add(jLabel2);
        jPanel6.add(filler5);

        txtNombre.setMaximumSize(new java.awt.Dimension(2147483647, 26));
        jPanel6.add(txtNombre);
        jPanel6.add(filler2);

        Datos.add(jPanel6);

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setText("Descripcion:");
        jPanel7.add(jLabel3);
        jPanel7.add(filler6);

        txtDescripcion.setMaximumSize(new java.awt.Dimension(2147483647, 26));
        jPanel7.add(txtDescripcion);
        jPanel7.add(filler3);

        Datos.add(jPanel7);

        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        jLabel4.setText("Precio:");
        jPanel8.add(jLabel4);
        jPanel8.add(filler8);

        txtPrecio.setMaximumSize(new java.awt.Dimension(2147483647, 26));
        jPanel8.add(txtPrecio);
        jPanel8.add(filler7);

        Datos.add(jPanel8);
        Datos.add(filler1);

        PanelCentro.add(Datos);

        Tabla.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(454, 250));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Table);

        Tabla.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        PanelCentro.add(Tabla);

        getContentPane().add(PanelCentro, java.awt.BorderLayout.CENTER);

        PanelSur.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setPreferredSize(new java.awt.Dimension(130, 55));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        PanelSur.add(btnGuardar);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pencil_medium.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setPreferredSize(new java.awt.Dimension(130, 55));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        PanelSur.add(btnEditar);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setPreferredSize(new java.awt.Dimension(130, 55));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        PanelSur.add(btnEliminar);

        getContentPane().add(PanelSur, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nombre = txtNombre.getText(), descripcion=txtDescripcion.getText(),
                precio = txtPrecio.getText();
        PreparedStatement consulta;
        if(editar && id_producto!=0){
            if(cn.ejecutarSQL("UPDATE producto\n" +
            "  SET Nombre='"+nombre+"', Descripcion='"+descripcion+"', Precio="+precio+"\n" +
            "  WHERE id_Producto = "+ id_producto)){
                JOptionPane.showMessageDialog(null, "Guardado con Exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                editar=false;
                this.Table.setEnabled(true);
                this.btnEditar.setEnabled(true);
                this.btnEliminar.setEnabled(true);
                id_producto =0;
                cn.cerrarConexion();
            }  
        }else{
            try {
                consulta = cn.getConexion().prepareStatement("INSERT INTO producto" + "(Nombre, Descripcion, Precio) VALUES(?, ?, ?)");
                consulta.setString(1, nombre);
                consulta.setString(2, descripcion);
                consulta.setString(3, precio);
                consulta.executeUpdate();
                JOptionPane.showMessageDialog(null, "Guardado con Exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                cn.cerrarConexion();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error:"+ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        try {
            CargarTabla();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex, "Error al cargar la Tabla", JOptionPane.ERROR_MESSAGE);
        }
        Limpiar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int s = this.Table.getSelectedRow();
        id_producto = Integer.parseInt(this.Table.getValueAt(s,0).toString());
        txtNombre.setText(this.Table.getValueAt(s, 1).toString());
        txtDescripcion.setText(this.Table.getValueAt(s,2 ).toString());
        txtPrecio.setText(this.Table.getValueAt(s, 3).toString());
        this.Table.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        editar =true;
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int s = this.Table.getSelectedRow();
        id_producto = Integer.parseInt(this.Table.getValueAt(s,0).toString());
        this.Table.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnGuardar.setEnabled(false);
        int dialogResult = JOptionPane.showConfirmDialog (null, "Desea eliminar el registro seleccionado?","Advertencia",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            if(cn.ejecutarSQL("DELETE FROM producto WHERE id_producto =" +id_producto )){
                JOptionPane.showMessageDialog(null, "Eliminado con Exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                this.Table.setEnabled(true);
                this.btnEditar.setEnabled(true);
                this.btnEliminar.setEnabled(true);
                this.btnGuardar.setEnabled(true);
                id_producto =0;
                cn.cerrarConexion();
            }else{
                JOptionPane.showMessageDialog(null, "No se logro eliminar el elemento seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
            }
            try {
                CargarTabla();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error:" + ex, "Error al cargar la Tabla", JOptionPane.ERROR_MESSAGE);
            }
        }
        this.Table.setEnabled(true);
        this.btnEditar.setEnabled(true);
        this.btnEliminar.setEnabled(true);
        this.btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Datos;
    private javax.swing.JPanel PanelCentro;
    private javax.swing.JPanel PanelNorte;
    private javax.swing.JPanel PanelSur;
    private javax.swing.JPanel Tabla;
    private javax.swing.JTable Table;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while(ct == h1) {   
            calcula();
            this.lblFecha.setText(hora + ":" + minutos + ":" + segundos + " "+ampm);
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e) {}
        }
    }
}
