/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AD_T2_C_UnionT1yT2;

import java.io.Serializable;

/**
 *
 * @author Vespertino
 */
public class Empleado implements Serializable{
    private int mep_no;
    private String nombre;
    private String apellido;
    private String oficio;

    public Empleado() {
        mep_no=0;
        nombre="";
        apellido="";
        oficio="";
    }

    public int getMep_no() {
        return mep_no;
    }

    public void setMep_no(int mep_no) {
        this.mep_no = mep_no;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    @Override
    public String toString() {
        return mep_no + "," + nombre + "," + apellido + "," + oficio + "!";
    }
    
    
}
