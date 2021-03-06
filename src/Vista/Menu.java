package Vista;

import Conexion.Conexiones;
//import com.apple.eawt.Application;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;




public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    Conexiones con;
    
    public Menu() {
        con = new Conexiones();
        con.crearConexion();
        setIconImage(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());
        
        initComponents();
        login();
    }
    public void login(){
        if(this.desktopPane.getComponentCount()!=0){
                JInternalFrame[] f = desktopPane.getAllFrames();
                f[0].dispose();
                this.desktopPane.removeAll();
        }
        V_Login l = new V_Login(con);
        l.setVisible(true);
        l.setSize(250, 160);
        l.setClosable(true);
        this.desktopPane.add(l);
        l.moveToFront();
        l.setLocation((this.desktopPane.getWidth()/2)-125, (this.desktopPane.getHeight()/2)-80);
        menu(false);
    }
    public void menu(boolean r){
        if(r){
            jMenu3.setEnabled(r);
            Catalogos.setEnabled(r);
        }else{
            jMenu3.setEnabled(false);
            Catalogos.setEnabled(false);
            jMenuItem7.setText("Iniciar Sesión");
            jMenuItem7.setEnabled(true);
            jMenuItem8.setEnabled(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        Catalogos = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        MenuSesion = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        Ayuda = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pizzeria v1.3");
        setMinimumSize(new java.awt.Dimension(1200, 700));

        desktopPane.setLayout(null);
        getContentPane().add(desktopPane, java.awt.BorderLayout.CENTER);

        Catalogos.setText("Catalogos");

        jMenuItem2.setText("Usuarios");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Catalogos.add(jMenuItem2);

        jMenuItem3.setText("Productos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        Catalogos.add(jMenuItem3);

        jMenuItem4.setText("Clientes");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        Catalogos.add(jMenuItem4);

        jMenuItem6.setText("Pedidos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        Catalogos.add(jMenuItem6);

        menuBar.add(Catalogos);

        jMenu3.setText("Venta");

        jMenuItem5.setText("Orden");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        menuBar.add(jMenu3);

        MenuSesion.setText("Sesión");

        jMenuItem7.setText("Iniciar Sesión");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        MenuSesion.add(jMenuItem7);

        jMenuItem8.setText("Cerrar Sesión");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        MenuSesion.add(jMenuItem8);

        menuBar.add(MenuSesion);

        Ayuda.setText("Ayuda");

        jMenuItem1.setText("Acerca de");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Ayuda.add(jMenuItem1);

        menuBar.add(Ayuda);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            V_AltaUsuario users = new V_AltaUsuario(con);
            users.setSize(this.desktopPane.getSize());
            if(this.desktopPane.getComponentCount()!=0){
                JInternalFrame[] f = desktopPane.getAllFrames();
                f[0].dispose();
                this.desktopPane.removeAll();
            }
            users.setVisible(true);
            this.desktopPane.add(users);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al abrir la ventana\n"+ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            V_AltaProducto prod = new V_AltaProducto(con);
            prod.setSize(this.desktopPane.getSize());
            if(this.desktopPane.getComponentCount()!=0){
                JInternalFrame[] f = desktopPane.getAllFrames();
                f[0].dispose();
                this.desktopPane.removeAll();
            }
            prod.setVisible(true);
            this.desktopPane.add(prod);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al abrir la ventana\n"+ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try {
            V_AltaCliente Client = new V_AltaCliente(con);
            Client.setSize(this.desktopPane.getSize());
            if(this.desktopPane.getComponentCount()!=0){
                JInternalFrame[] f = desktopPane.getAllFrames();
                f[0].dispose();
                this.desktopPane.removeAll();
            }
            Client.setVisible(true);
            this.desktopPane.add(Client);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al abrir la ventana\n"+ex, "Error", JOptionPane.ERROR_MESSAGE);
        
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        V_AltaPedido p = new V_AltaPedido(con);
        p.setSize(this.desktopPane.getSize());
        if(this.desktopPane.getComponentCount()!=0){
            JInternalFrame[] f = desktopPane.getAllFrames();
            f[0].dispose();
            this.desktopPane.removeAll();
        }
        p.setVisible(true);
        this.desktopPane.add(p);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        V_Acerca a = new V_Acerca();
        a.setVisible(true);
        this.desktopPane.add(a);
        a.moveToFront();
        a.setLocation((this.desktopPane.getWidth()/2)-237, (this.desktopPane.getHeight()/2)-193);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        try {
            V_BuscarPedido p = new V_BuscarPedido(con);
            p.setSize(this.desktopPane.getSize());
            if(this.desktopPane.getComponentCount()!=0){
                JInternalFrame[] f = desktopPane.getAllFrames();
                f[0].dispose();
                this.desktopPane.removeAll();
            }
            p.setVisible(true);
            this.desktopPane.add(p);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al abrir la ventana\n"+ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        
        login();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        login();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Ayuda;
    public static javax.swing.JMenu Catalogos;
    private javax.swing.JMenu MenuSesion;
    public javax.swing.JDesktopPane desktopPane;
    public static javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    public static javax.swing.JMenuItem jMenuItem7;
    public static javax.swing.JMenuItem jMenuItem8;
    public javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
