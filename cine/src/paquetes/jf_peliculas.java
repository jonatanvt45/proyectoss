/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetes;

/**
 *
 * @author JonatanVT
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class jf_peliculas extends javax.swing.JFrame {
     jf_Principal JF_Principal;
     private Connection conexion;
    private Statement st;
    private ResultSet rs;
  

    
    
    public void Conectar(){
     try{ 
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/cine","root","utec");                     
            st=conexion.createStatement(); 
            
            rs = st.executeQuery("Select * from peliculas");
            rs.next();
            this.jtf_pelicula.setText(rs.getString("IDPELICULA"));
            this.jtf_nombre.setText(rs.getString("NOMBRE"));
            this.jtf_genero.setText(rs.getString("GENERO"));
            this.jtf_formato.setText(rs.getString("FORMATO"));
            this.jtf_duracion.setText(rs.getString("DURACION"));
        } catch (SQLException err) {
        JOptionPane.showMessageDialog(null, "Error" + err.getMessage());
        }
    }
    public jf_peliculas() {
        initComponents();
        Conectar();
    }
     
    
     public jf_peliculas(jf_Principal JF_Principal) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.JF_Principal = JF_Principal;
    }
    private void primerRegistro(){    
        try{ 
        if(rs.isFirst()==false) {                 
            rs.first();                 
            this.jtf_pelicula.setText(rs.getString("IDPELICULA"));
            this.jtf_nombre.setText(rs.getString("NOMBRE"));
            this.jtf_genero.setText(rs.getString("GENERO"));
            this.jtf_formato.setText(rs.getString("FORMATO"));
            this.jtf_duracion.setText(rs.getString("DURACION"));
        }         
    }catch(Exception err) {             
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
    }     
} 
       private void anteriorRegistro(){    
        try{ 
        if(rs.isFirst()==false) {                 
            rs.previous();                 
            this.jtf_pelicula.setText(rs.getString("IDPELICULA"));
            this.jtf_nombre.setText(rs.getString("NOMBRE"));
            this.jtf_genero.setText(rs.getString("GENERO"));
            this.jtf_formato.setText(rs.getString("FORMATO"));
            this.jtf_duracion.setText(rs.getString("DURACION")); 
        }         
    }catch(Exception err) {             
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
    }     
} 
    private void siguienteRegistro(){    
    try{ 
        if(rs.isLast()==false) {                 
            rs.next();        
            this.jtf_pelicula.setText(rs.getString("IDPELICULA"));
            this.jtf_nombre.setText(rs.getString("NOMBRE"));
            this.jtf_genero.setText(rs.getString("GENERO"));
            this.jtf_formato.setText(rs.getString("FORMATO"));
            this.jtf_duracion.setText(rs.getString("DURACION"));
           
        }     
    }catch(Exception err) {             
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
    }     
}   
    
    private void ultimoRegistro(){    
        try{ 
        if(rs.isLast()==false) {                 
            rs.last();                 
            this.jtf_pelicula.setText(rs.getString("IDPELICULA"));
            this.jtf_nombre.setText(rs.getString("NOMBRE"));
            this.jtf_genero.setText(rs.getString("GENERO"));
            this.jtf_formato.setText(rs.getString("FORMATO"));
            this.jtf_duracion.setText(rs.getString("DURACION"));
        }         
    }catch(Exception err) {             
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
    }     
} 
    private void guardarRegistro() {        
       try{ 
            
            String nombre = this.jtf_nombre.getText();
            String genero = this.jtf_genero.getText();
            String formato = this.jtf_formato.getText();
            String duracion = this.jtf_duracion.getText();

            st.executeUpdate("Insert into PELICULAS(NOMBRE,GENERO,FORMATO,DURACION)"+" values ('"+nombre+"','"+ genero +"','"+ formato +"','"+ duracion +"');"); 
            this.Conectar();
            this.primerRegistro();
         } catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        } 

    }
    private void borrarRegistro() {        
       try{
            String nombre = this.jtf_nombre.getText();

            st.executeUpdate("delete from PELICULAS where NOMBRE='"+nombre+"';");
            this.Conectar();
            this.primerRegistro();

        } catch(SQLException err)         { 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        } 

    }
    private void modificarRegistro() {        
       try{
            String idpelicula = this.jtf_pelicula.getText();
            String nombre = this.jtf_nombre.getText(); 
            String genero = this.jtf_genero.getText();
            String formato = this.jtf_formato.getText();
            String duracion = this.jtf_duracion.getText();
                  
                st.executeUpdate("update PELICULAS set IDPELICULA= '"+idpelicula+"', NOMBRE='"+nombre+"', GENERO='"+genero+"',FORMATO='"+formato+"',DURACION='"+duracion+"' where IDPELICULA='"+idpelicula+"';");
                this.Conectar();
                this.primerRegistro();
              }
              catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }  

    }
    public void vbotones(){
         jb_primero.setEnabled(true);
         jb_siguiente.setEnabled(true);
         jb_anterior.setEnabled(true);
         jb_ultimo.setEnabled(true);
         jb_nuevo.setEnabled(true);
         jb_modificar.setEnabled(true);
         jb_borrar.setEnabled(true);
         jb_guardar.setEnabled(false);
         jb_regresar.setEnabled(true);
     }
     
     public void vbo(){
         jb_primero.setEnabled(false);
         jb_siguiente.setEnabled(false);
         jb_anterior.setEnabled(false);
         jb_ultimo.setEnabled(false);
         jb_nuevo.setEnabled(false);
         jb_modificar.setEnabled(false);
         jb_borrar.setEnabled(false);
         jb_guardar.setEnabled(true);
         jb_regresar.setEnabled(true);
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jb_primero = new javax.swing.JButton();
        jb_anterior = new javax.swing.JButton();
        jb_siguiente = new javax.swing.JButton();
        jb_ultimo = new javax.swing.JButton();
        jb_nuevo = new javax.swing.JButton();
        jb_guardar = new javax.swing.JButton();
        jb_borrar = new javax.swing.JButton();
        jl_nombre = new javax.swing.JLabel();
        jl_genero = new javax.swing.JLabel();
        jl_formato = new javax.swing.JLabel();
        jl_duracion = new javax.swing.JLabel();
        jtf_nombre = new javax.swing.JTextField();
        jtf_genero = new javax.swing.JTextField();
        jtf_formato = new javax.swing.JTextField();
        jb_modificar = new javax.swing.JButton();
        jtf_duracion = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jb_regresar = new javax.swing.JButton();
        jl_pelicula = new javax.swing.JLabel();
        jtf_pelicula = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jb_primero.setText("|<");
        jb_primero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_primeroMouseClicked(evt);
            }
        });

        jb_anterior.setText("<<");
        jb_anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_anteriorMouseClicked(evt);
            }
        });
        jb_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_anteriorActionPerformed(evt);
            }
        });

        jb_siguiente.setText(">>");
        jb_siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_siguienteMouseClicked(evt);
            }
        });

        jb_ultimo.setText(">|");
        jb_ultimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_ultimoMouseClicked(evt);
            }
        });

        jb_nuevo.setText("Nuevo");
        jb_nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_nuevoMouseClicked(evt);
            }
        });

        jb_guardar.setText("Guardar");
        jb_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_guardarMouseClicked(evt);
            }
        });

        jb_borrar.setText("Borrar");
        jb_borrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_borrarMouseClicked(evt);
            }
        });
        jb_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_borrarActionPerformed(evt);
            }
        });

        jl_nombre.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jl_nombre.setText("nombre");

        jl_genero.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jl_genero.setText("genero");

        jl_formato.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jl_formato.setText("formato");

        jl_duracion.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jl_duracion.setText("duracion");

        jb_modificar.setText("modificar");
        jb_modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_modificarMouseClicked(evt);
            }
        });
        jb_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_modificarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel1.setFont(new java.awt.Font("Bauhaus 93", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PELICULAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jb_regresar.setText("Regresar");
        jb_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_regresarActionPerformed(evt);
            }
        });

        jl_pelicula.setText("Clave Pelicula");
        jl_pelicula.setEnabled(false);

        jtf_pelicula.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jb_primero)
                        .addGap(18, 18, 18)
                        .addComponent(jb_anterior)
                        .addGap(18, 18, 18)
                        .addComponent(jb_siguiente)
                        .addGap(18, 18, 18)
                        .addComponent(jb_ultimo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_genero)
                            .addComponent(jl_formato)
                            .addComponent(jl_duracion)
                            .addComponent(jl_nombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtf_genero)
                            .addComponent(jtf_duracion)
                            .addComponent(jtf_formato, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(jtf_nombre, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jb_nuevo)
                        .addGap(18, 18, 18)
                        .addComponent(jb_guardar)
                        .addGap(26, 26, 26)
                        .addComponent(jb_borrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jb_modificar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jb_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jl_pelicula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_pelicula)
                    .addComponent(jtf_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_nombre)
                    .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_genero)
                    .addComponent(jtf_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_formato)
                    .addComponent(jtf_formato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_duracion)
                    .addComponent(jtf_duracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_primero)
                    .addComponent(jb_anterior)
                    .addComponent(jb_siguiente)
                    .addComponent(jb_ultimo))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_nuevo)
                    .addComponent(jb_guardar)
                    .addComponent(jb_borrar)
                    .addComponent(jb_modificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jb_regresar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_primeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_primeroMouseClicked
  try {
         if (rs.isFirst() == false){
             rs.first();
            this.jtf_nombre.setText(rs.getString("nombre"));
            this.jtf_genero.setText(rs.getString("genero"));
            this.jtf_formato.setText(rs.getString("formato"));
            this.jtf_duracion.setText(rs.getString("duracion"));
         }   
         } catch (SQLException err) {
        JOptionPane.showMessageDialog(null, "Error" + err.getMessage());
         }
                
             
    }//GEN-LAST:event_jb_primeroMouseClicked

    private void jb_anteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_anteriorMouseClicked
        // TODO add your handling code here:
     try {
         if (rs.isFirst() == false){
             rs.previous();
            this.jtf_nombre.setText(rs.getString("nombre"));
            this.jtf_genero.setText(rs.getString("genero"));
            this.jtf_formato.setText(rs.getString("formato"));
            this.jtf_duracion.setText(rs.getString("duracion"));
         }   
         } catch (SQLException err) {
        JOptionPane.showMessageDialog(null, "Error" + err.getMessage());
         }
                
    }//GEN-LAST:event_jb_anteriorMouseClicked

    private void jb_siguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_siguienteMouseClicked
        // TODO add your handling code here:
        siguienteRegistro();
    }//GEN-LAST:event_jb_siguienteMouseClicked

    private void jb_ultimoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_ultimoMouseClicked
        // TODO add your handling code here:
        ultimoRegistro();
    }//GEN-LAST:event_jb_ultimoMouseClicked

    private void jb_nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_nuevoMouseClicked
        // TODO add your handling code here:
        try{
            jtf_nombre.setText("");
            jtf_genero.setText("");
            jtf_formato.setText("");
            jtf_duracion.setText("");
        } catch(Exception err)
        {
            JOptionPane.showMessageDialog(null, "Error" + err.getMessage());
        }
    }//GEN-LAST:event_jb_nuevoMouseClicked

    private void jb_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_guardarMouseClicked
        // TODO add your handling code here:
      try{
            String nombre=this.jtf_nombre.getText();
            String genero=this.jtf_genero.getText();
            String formato=this.jtf_formato.getText();
            String duracion=this.jtf_duracion.getText();
            
            st.executeUpdate("Insert into peliculas(nombre,genero,formato,duracion)"+" values ('"+ nombre +"','"+ genero+"','"+ formato +"','"+ duracion +"');"); 
            
            rs = st.executeQuery("Select * from peliculas");
            rs.first();
            this.jtf_nombre.setText(rs.getString("nombre"));
            this.jtf_genero.setText(rs.getString("genero"));
            this.jtf_formato.setText(rs.getString("formato"));
            this.jtf_duracion.setText(rs.getString("duracion"));
            
         } catch (SQLException err) {
        JOptionPane.showMessageDialog(null, "Error" + err.getMessage());
           } 
    }//GEN-LAST:event_jb_guardarMouseClicked

    private void jb_borrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_borrarMouseClicked
        // TODO add your handling code here
    }//GEN-LAST:event_jb_borrarMouseClicked

    private void jb_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_borrarActionPerformed
        borrarRegistro();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_borrarActionPerformed

    private void jb_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_modificarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_modificarMouseClicked

    private void jb_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_modificarActionPerformed
        modificarRegistro();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_modificarActionPerformed

    private void jb_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_regresarActionPerformed
        JF_Principal.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_regresarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        Conectar();// TODO add your handling code here:
    }//GEN-LAST:event_formComponentShown

    private void jb_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_anteriorActionPerformed
        anteriorRegistro();// TODO add your handling code here:
    }//GEN-LAST:event_jb_anteriorActionPerformed

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
            java.util.logging.Logger.getLogger(jf_peliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jf_peliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jf_peliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jf_peliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jf_peliculas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jb_anterior;
    private javax.swing.JButton jb_borrar;
    private javax.swing.JButton jb_guardar;
    private javax.swing.JButton jb_modificar;
    private javax.swing.JButton jb_nuevo;
    private javax.swing.JButton jb_primero;
    private javax.swing.JButton jb_regresar;
    private javax.swing.JButton jb_siguiente;
    private javax.swing.JButton jb_ultimo;
    private javax.swing.JLabel jl_duracion;
    private javax.swing.JLabel jl_formato;
    private javax.swing.JLabel jl_genero;
    private javax.swing.JLabel jl_nombre;
    private javax.swing.JLabel jl_pelicula;
    private javax.swing.JTextField jtf_duracion;
    private javax.swing.JTextField jtf_formato;
    private javax.swing.JTextField jtf_genero;
    private javax.swing.JTextField jtf_nombre;
    private javax.swing.JTextField jtf_pelicula;
    // End of variables declaration//GEN-END:variables
}
