/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AD_T1_C_Xml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Objects;

/**
 *
 * @author Vespertino
 */
public class Departamento implements Serializable{

    
    private int dept_no;
    private String nombre;
    private String loc;
    private ArrayList
            <Empleado> empleados;
    
    public Departamento() {
        empleados=new ArrayList<>();
        dept_no=0;
        nombre=loc="";
    }

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado empleados) {
        this.empleados.add(empleados);
    }

    @Override
    public String toString() {
        return  dept_no + "," + nombre + "," + loc + ", empleados=" + empleados ;
    }

    

    @Override
    public boolean equals(Object obj) {
        Departamento dep =(Departamento) obj;
        return this.getNombre().equals(dep.getNombre());
        
       
         
    }
    
    
}
