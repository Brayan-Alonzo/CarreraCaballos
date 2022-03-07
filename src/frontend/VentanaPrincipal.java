package frontend;

import java.io.File;
import javax.swing.JFileChooser;
import backend.logicas.CargaDatos;
import backend.estructuras.listaEnlazada.ListaEnlazada;
import backend.logicas.Resultados;
import backend.logicas.Verificacion;
import backend.pojos.Apuesta;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends javax.swing.JFrame {

    private ListaEnlazada<Apuesta> apuestas = new ListaEnlazada();
    private String rechazados = "";

    public VentanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.btnVerificarApuestas.setEnabled(false);
        this.btnExportarRechazados.setVisible(false);
        this.btnProcesarApuestas.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnExportarRechazados = new javax.swing.JButton();
        btnProcesarApuestas = new javax.swing.JButton();
        lbPrimerLugar = new javax.swing.JLabel();
        lbSegundoLugar = new javax.swing.JLabel();
        lbTercerLugar = new javax.swing.JLabel();
        lbCuartoLugar = new javax.swing.JLabel();
        lbQuintoLugar = new javax.swing.JLabel();
        lbSextoLugar = new javax.swing.JLabel();
        lbSeptimoLugar = new javax.swing.JLabel();
        lbOctavoLugar = new javax.swing.JLabel();
        lbNovenoLugar = new javax.swing.JLabel();
        lbDecimoLugar = new javax.swing.JLabel();
        tfPrimeroLugar = new javax.swing.JTextField();
        tfSegundoLugar = new javax.swing.JTextField();
        tfTercerLugar = new javax.swing.JTextField();
        tfCuartoLugar = new javax.swing.JTextField();
        tfQuintoLugar = new javax.swing.JTextField();
        tfSextoLugar = new javax.swing.JTextField();
        tfSeptimoLugar = new javax.swing.JTextField();
        tfOctavoLugar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfNovenoLugar = new javax.swing.JTextField();
        tfDecimoLugar = new javax.swing.JTextField();
        btnAgregarApuesta = new javax.swing.JButton();
        btnCargarArchivo = new javax.swing.JButton();
        btnVerificarApuestas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExportarRechazados.setText("Exportar rechazados");
        btnExportarRechazados.setMaximumSize(new java.awt.Dimension(165, 30));
        btnExportarRechazados.setMinimumSize(new java.awt.Dimension(165, 30));
        btnExportarRechazados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarRechazadosActionPerformed(evt);
            }
        });
        jPanel1.add(btnExportarRechazados, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 190, 30));

        btnProcesarApuestas.setText("Procesar apuestas");
        btnProcesarApuestas.setMaximumSize(new java.awt.Dimension(150, 30));
        btnProcesarApuestas.setMinimumSize(new java.awt.Dimension(150, 30));
        btnProcesarApuestas.setPreferredSize(new java.awt.Dimension(150, 30));
        btnProcesarApuestas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarApuestasActionPerformed(evt);
            }
        });
        jPanel1.add(btnProcesarApuestas, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, 180, 30));

        lbPrimerLugar.setText("Primero lugar");
        jPanel1.add(lbPrimerLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 105, 110, 30));

        lbSegundoLugar.setText("Segundo lugar");
        jPanel1.add(lbSegundoLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 141, 110, 30));

        lbTercerLugar.setText("Tercer lugar");
        jPanel1.add(lbTercerLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 177, 110, 30));

        lbCuartoLugar.setText("Cuarto lugar");
        jPanel1.add(lbCuartoLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 213, 110, 30));

        lbQuintoLugar.setText("Quinto lugar");
        jPanel1.add(lbQuintoLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 249, 110, 30));

        lbSextoLugar.setText("Sexto lugar");
        jPanel1.add(lbSextoLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 285, 110, 30));

        lbSeptimoLugar.setText("Septimo lugar");
        jPanel1.add(lbSeptimoLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 325, 110, 20));

        lbOctavoLugar.setText("Octavo lugar");
        jPanel1.add(lbOctavoLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 357, 110, 30));

        lbNovenoLugar.setText("Noveno lugar");
        jPanel1.add(lbNovenoLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 393, 110, 30));

        lbDecimoLugar.setText("Decimo lugar");
        jPanel1.add(lbDecimoLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 429, 110, 30));
        jPanel1.add(tfPrimeroLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 105, 40, 30));
        jPanel1.add(tfSegundoLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 141, 40, 30));
        jPanel1.add(tfTercerLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 177, 40, 30));
        jPanel1.add(tfCuartoLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 213, 40, 30));
        jPanel1.add(tfQuintoLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 249, 40, 30));
        jPanel1.add(tfSextoLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 285, 40, 30));
        jPanel1.add(tfSeptimoLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 321, 40, 30));

        tfOctavoLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfOctavoLugarActionPerformed(evt);
            }
        });
        jPanel1.add(tfOctavoLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 357, 40, 30));

        jLabel11.setText("# Caballo");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 76, 110, -1));

        jLabel12.setText("Lugar");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 76, 110, -1));

        tfNovenoLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNovenoLugarActionPerformed(evt);
            }
        });
        jPanel1.add(tfNovenoLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 393, 40, 30));

        tfDecimoLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDecimoLugarActionPerformed(evt);
            }
        });
        jPanel1.add(tfDecimoLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 429, 40, 30));

        btnAgregarApuesta.setText("Agregar apuesta");
        btnAgregarApuesta.setMaximumSize(new java.awt.Dimension(140, 30));
        btnAgregarApuesta.setMinimumSize(new java.awt.Dimension(140, 30));
        btnAgregarApuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarApuestaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarApuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 170, 30));

        btnCargarArchivo.setText("Cargar archivo");
        btnCargarArchivo.setMaximumSize(new java.awt.Dimension(123, 30));
        btnCargarArchivo.setMinimumSize(new java.awt.Dimension(123, 30));
        btnCargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarArchivoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 150, 30));

        btnVerificarApuestas.setText("Verificar apuestas");
        btnVerificarApuestas.setMaximumSize(new java.awt.Dimension(140, 30));
        btnVerificarApuestas.setMinimumSize(new java.awt.Dimension(140, 30));
        btnVerificarApuestas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarApuestasActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerificarApuestas, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 170, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfOctavoLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfOctavoLugarActionPerformed

    }//GEN-LAST:event_tfOctavoLugarActionPerformed

    private void tfNovenoLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNovenoLugarActionPerformed

    }//GEN-LAST:event_tfNovenoLugarActionPerformed

    private void tfDecimoLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDecimoLugarActionPerformed

    }//GEN-LAST:event_tfDecimoLugarActionPerformed

    private void btnAgregarApuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarApuestaActionPerformed
        VtnAgregarApuesta vtnAgregarApuesta = new VtnAgregarApuesta(this, true, this.apuestas);
        vtnAgregarApuesta.setVisible(true);
        btnProcesarApuestas.setEnabled(false);
        if (!this.apuestas.estaVacia()) {
            this.btnVerificarApuestas.setEnabled(true);
        }
    }//GEN-LAST:event_btnAgregarApuestaActionPerformed

    private void btnProcesarApuestasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarApuestasActionPerformed
        try {
            int primerLugar = Integer.valueOf(tfPrimeroLugar.getText());
            int segundoLugar = Integer.valueOf(tfSegundoLugar.getText());
            int tercerLugar = Integer.valueOf(tfTercerLugar.getText());
            int cuartoLugar = Integer.valueOf(tfCuartoLugar.getText());
            int quintoLugar = Integer.valueOf(tfQuintoLugar.getText());
            int sextoLugar = Integer.valueOf(tfSextoLugar.getText());
            int septimoLugar = Integer.valueOf(tfSeptimoLugar.getText());
            int octavoLugar = Integer.valueOf(tfOctavoLugar.getText());
            int novenoLugar = Integer.valueOf(tfNovenoLugar.getText());
            int decimoLugar = Integer.valueOf(tfDecimoLugar.getText());
            int[] resultados = {primerLugar, segundoLugar, tercerLugar, cuartoLugar, quintoLugar, sextoLugar, septimoLugar, octavoLugar, novenoLugar, decimoLugar};
            Resultados calcularResultados = new Resultados(this.apuestas, resultados);
            calcularResultados.procesar();
            VtnProcesarApuestas vtnAgregarApuesta = new VtnProcesarApuestas(this, true, calcularResultados.getApuestasResultados());
            vtnAgregarApuesta.setVisible(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa los resultados", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnProcesarApuestasActionPerformed

    private void btnCargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarArchivoActionPerformed
        btnProcesarApuestas.setEnabled(false);
        JFileChooser fileChosser = new JFileChooser();
        int seleccion = fileChosser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChosser.getSelectedFile();
            CargaDatos cargarDatos = new CargaDatos();
            cargarDatos.cargarDatos(archivo.getAbsolutePath());
            this.apuestas.concatenarLista(cargarDatos.getApuestas());
        }
        if (!this.apuestas.estaVacia()) {
            this.btnVerificarApuestas.setEnabled(true);
        }
    }//GEN-LAST:event_btnCargarArchivoActionPerformed

    private void btnExportarRechazadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarRechazadosActionPerformed
        String encabezado = "APOSTADOR,MONTO,1LUGAR,2LUGAR,3LUGAR,4LUGAR,5LUGAR,"
                + "6LUGAR,7LUGAR,8LUGAR,9LUGAR,10LUGAR\n";
        JFileChooser fileChosser = new JFileChooser();
        int seleccion = fileChosser.showDialog(null, "Guardar como");
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChosser.getSelectedFile();
            boolean guardado = Verificacion.guardarArchivo(archivo, encabezado + this.rechazados);
            if (guardado) {
                JOptionPane.showMessageDialog(null, "Archivo guardado");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el archivo");
            }
        }
    }//GEN-LAST:event_btnExportarRechazadosActionPerformed

    private void btnVerificarApuestasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarApuestasActionPerformed
        Verificacion verificacion = null;
        try {
            verificacion = new Verificacion(apuestas);
            verificacion.verificar();
            this.rechazados = verificacion.getRechazados();
            if (!this.rechazados.equals("")) {
                JOptionPane.showMessageDialog(null, "Se rechazaron algunas apuestas", "Verificado", JOptionPane.INFORMATION_MESSAGE);
                this.btnExportarRechazados.setVisible(true);
                this.btnProcesarApuestas.setEnabled(true);
            } else {
                this.btnExportarRechazados.setVisible(false);
                JOptionPane.showMessageDialog(null, "No se encontraron errores", "Verificado", JOptionPane.INFORMATION_MESSAGE);
            }
            this.btnProcesarApuestas.setEnabled(true);

        } catch (NullPointerException ex) {
            this.btnProcesarApuestas.setEnabled(false);
            this.rechazados = verificacion.getRechazados();
            this.apuestas.vaciar();
            this.btnVerificarApuestas.setEnabled(false);
            this.btnExportarRechazados.setVisible(true);
            JOptionPane.showMessageDialog(this, "Ninguna apuesta es correcta", "Lista vacia", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVerificarApuestasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarApuesta;
    private javax.swing.JButton btnCargarArchivo;
    private javax.swing.JButton btnExportarRechazados;
    private javax.swing.JButton btnProcesarApuestas;
    private javax.swing.JButton btnVerificarApuestas;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCuartoLugar;
    private javax.swing.JLabel lbDecimoLugar;
    private javax.swing.JLabel lbNovenoLugar;
    private javax.swing.JLabel lbOctavoLugar;
    private javax.swing.JLabel lbPrimerLugar;
    private javax.swing.JLabel lbQuintoLugar;
    private javax.swing.JLabel lbSegundoLugar;
    private javax.swing.JLabel lbSeptimoLugar;
    private javax.swing.JLabel lbSextoLugar;
    private javax.swing.JLabel lbTercerLugar;
    private javax.swing.JTextField tfCuartoLugar;
    private javax.swing.JTextField tfDecimoLugar;
    private javax.swing.JTextField tfNovenoLugar;
    private javax.swing.JTextField tfOctavoLugar;
    private javax.swing.JTextField tfPrimeroLugar;
    private javax.swing.JTextField tfQuintoLugar;
    private javax.swing.JTextField tfSegundoLugar;
    private javax.swing.JTextField tfSeptimoLugar;
    private javax.swing.JTextField tfSextoLugar;
    private javax.swing.JTextField tfTercerLugar;
    // End of variables declaration//GEN-END:variables
}
