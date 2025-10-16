/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package grupo2universidadv2.vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import grupo2universidadv2.accesoadatos.accesoadatos.InscripcionData;
import grupo2universidadv2.accesoadatos.accesoadatos.MateriaData;
import grupo2universidadv2.entidades.entidades.Alumno;
import grupo2universidadv2.entidades.entidades.Inscripcion;
import grupo2universidadv2.entidades.entidades.Materia;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Gonza
 */
public class AlumnosPorMateriaView extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    private MateriaData matData;
    private InscripcionData inscData;

    /**
     * Creates new form AlumnosPorMateriaView
     */
    public AlumnosPorMateriaView() {
        initComponents();
        modelo = new DefaultTableModel();
        matData = new MateriaData();
        inscData = new InscripcionData();
        armarCabeceraTabla();
        cargarMateriasCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcMateria = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAlumnosXmateria = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jbSalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(208, 208, 250));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setText("Listado de Alumnos por Materia");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel2.setText("Seleccione una Materia");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jcMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcMateriaActionPerformed(evt);
            }
        });
        jPanel1.add(jcMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 210, -1));

        jtAlumnosXmateria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtAlumnosXmateria);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 390, 250));

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 390, 10));

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });
        jPanel1.add(jbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 362, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jcMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcMateriaActionPerformed
        cargarAlumnosTabla();
    }//GEN-LAST:event_jcMateriaActionPerformed

    private void cargarMateriasCombo() {
        jcMateria.removeAllItems();
        List<Materia> materias = matData.listarMaterias();
        DefaultComboBoxModel<Materia> comboModel = new DefaultComboBoxModel<>();
        for (Materia m : materias) {
            comboModel.addElement(m);
        }
        jcMateria.setModel(comboModel);
    }

    private void cargarAlumnosTabla() {
        borrarFilaTabla();
        Materia m = (Materia) jcMateria.getSelectedItem();
        if (m != null) {
            List<Alumno> alumnos = inscData.obtenerAlumnosXMateria(m.getIdMateria());
            for (Alumno a : alumnos) {
                modelo.addRow(new Object[]{
                    a.getIdAlumno(),
                    a.getDni(),
                    a.getApellido(),
                    a.getNombre()
                });
            }
        }
    }

    private void armarCabeceraTabla() {
        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        jtAlumnosXmateria.setModel(modelo);
    }

    private void borrarFilaTabla() {
        int filas = modelo.getRowCount();
        for (int i = filas - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox jcMateria;
    private javax.swing.JTable jtAlumnosXmateria;
    // End of variables declaration//GEN-END:variables
}
