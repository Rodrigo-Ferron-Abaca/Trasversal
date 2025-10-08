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
import grupo2universidadv2.accesoadatos.accesoadatos.MateriaData;
import grupo2universidadv2.entidades.entidades.Materia;

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

        /*Alumno a1 = new Alumno(12345678, "Orozco", "Kevin", LocalDate.of(2000, 5, 12), true);
        Alumno a2 = new Alumno(23456789, "Lopez", "Exequiel", LocalDate.of(1999, 8, 20), true);
        AlumnoData alumnoData = new AlumnoData();
        alumnoData.guardarAlumno(a1);
        alumnoData.guardarAlumno(a2);
*/
        
        //Para guardar Materia
        /*Materia m1 = new Materia("IngSoftware", 2023, true);
        MateriaData materiaData = new MateriaData();
        materiaData.guardarMateria(m1);
*/

        //Para modificar Materia
        Materia ingSoftware = new Materia(49,"Ingenieria de Software", 1, false);
        MateriaData materiaData = new MateriaData();
        materiaData.modificarMateria(ingSoftware);

        
        //Para Buscar una materia por ID
        /*MateriaData data= new MateriaData();
        Materia materiaEncontrada=data.buscarMateria(47);
        if(materiaEncontrada!=null){
            System.out.println("Nombre: "+ materiaEncontrada.getNombre());
        }else{
            System.out.println("no se encontro naranja");
        }
        */
        //Falta consulta para dar de baja o alta una materia
        
        ///para eliminado logico de materia por ID
       
        
    }

}
