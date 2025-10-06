/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo2universidadv2;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import grupo2universidadv2.accesoadatos.accesoadatos.AlumnoData;
import grupo2universidadv2.entidades.entidades.Alumno;
import grupo2universidadv2.accesoadatos.accesoadatos.Conexion;

/**
 *
 * @author rodrigo
 */
public class Universidadv2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection con = Conexion.getConexion();

        Alumno a1 = new Alumno(12345678, "Orozco", "Kevin", LocalDate.of(2000, 5, 12), true);
        Alumno a2 = new Alumno(23456789, "Lopez", "Exequiel", LocalDate.of(1999, 8, 20), true);
        AlumnoData alumnoData = new AlumnoData();
        alumnoData.guardarAlumno(a1);
        alumnoData.guardarAlumno(a2);
    }

}
