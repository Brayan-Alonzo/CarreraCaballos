package frontend;

import backend.estructuras.listaEnlazada.ListaEnlazada;
import backend.estructuras.listaEnlazada.Nodo;
import backend.logicas.Ordenamiento;
import backend.logicas.Verificacion;
import backend.pojos.Apuesta;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VtnProcesarApuestas extends javax.swing.JDialog {

    private final ListaEnlazada<Apuesta> apuestas;
    private DefaultTableModel resultadosModel = new DefaultTableModel();
    private final Ordenamiento ordenamiento;
    private String resultados = "";

    public VtnProcesarApuestas(java.awt.Frame parent, boolean modal, ListaEnlazada<Apuesta> apuestas) {
        super(parent, modal);
        this.apuestas = apuestas;
        this.ordenamiento = new Ordenamiento(apuestas);
        initComponents();
        this.setLocationRelativeTo(parent);
        this.ordenamiento.ordenarPorPuntos();
        this.cargarModeloTabla();
        this.imprimirResultados();
    }

    private void cargarModeloTabla() {
        resultadosModel.addColumn("Apostador");
        resultadosModel.addColumn("Puntos");
    }

    private void imprimirResultados() {
        Nodo nodo = this.apuestas.getInicio();
        this.resultados = "";
        do {
            Apuesta apuesta = (Apuesta) nodo.getValor();
            resultadosModel.addRow(apuesta.getResultado());
            this.resultados += apuesta.getResultado()[0] + "," + apuesta.getResultado()[1] + "\n";
            nodo = nodo.getSiguiente();
        } while (nodo != null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnOrdenarAZ = new javax.swing.JButton();
        btnOrdenarPorPuntos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPosiciones = new javax.swing.JTable();
        btnExportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnOrdenarAZ.setText("Ordenar A-Z");
        btnOrdenarAZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarAZActionPerformed(evt);
            }
        });

        btnOrdenarPorPuntos.setText("Ordenar por puntos");
        btnOrdenarPorPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarPorPuntosActionPerformed(evt);
            }
        });

        tbPosiciones.setModel(resultadosModel);
        jScrollPane1.setViewportView(tbPosiciones);

        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnOrdenarAZ)
                        .addGap(18, 18, 18)
                        .addComponent(btnOrdenarPorPuntos)
                        .addGap(103, 103, 103)
                        .addComponent(btnExportar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOrdenarAZ)
                    .addComponent(btnOrdenarPorPuntos)
                    .addComponent(btnExportar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrdenarAZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarAZActionPerformed
        this.ordenamiento.ordenarAlfabeticamente();
        this.resultadosModel = new DefaultTableModel();
        this.cargarModeloTabla();
        this.imprimirResultados();
        this.tbPosiciones.setModel(resultadosModel);
    }//GEN-LAST:event_btnOrdenarAZActionPerformed

    private void btnOrdenarPorPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarPorPuntosActionPerformed
        this.ordenamiento.ordenarPorPuntos();
        this.resultadosModel = new DefaultTableModel();
        this.cargarModeloTabla();
        this.imprimirResultados();
        this.tbPosiciones.setModel(resultadosModel);
    }//GEN-LAST:event_btnOrdenarPorPuntosActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        String encabezado = "NOMBRE APOSTADOR,PUNTOS\n";
        JFileChooser fileChosser = new JFileChooser();
        int seleccion = fileChosser.showDialog(null, "Guardar como");
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChosser.getSelectedFile();
            boolean guardado = Verificacion.guardarArchivo(archivo, encabezado + this.resultados);
            if (guardado) {
                JOptionPane.showMessageDialog(null, "Archivo guardado");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el archivo");
            }
        }

    }//GEN-LAST:event_btnExportarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnOrdenarAZ;
    private javax.swing.JButton btnOrdenarPorPuntos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPosiciones;
    // End of variables declaration//GEN-END:variables
}
