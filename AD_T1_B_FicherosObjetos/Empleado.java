/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AD_T1_B_FicherosObjetos;

import java.io.Serializable;

/**
 *
 * @author Vespertino
 */
public class Empleado implements Serializable{
    private int emp_no;
    private String nombre;
    private String oficio;

    public Empleado(int emp_no, String nombre, String oficio) {
        this.emp_no = emp_no;
        this.nombre = nombre;
        this.oficio = oficio;
    }

    @Override
    public String toString() {
        return "#" + emp_no + "#" + nombre + "#" + oficio + "\n";
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }




    
    
}
