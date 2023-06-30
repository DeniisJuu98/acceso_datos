/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AD_T1_B_FicherosObjetos;

import java.io.Serializable;
import java.util.LinkedHashSet;

/**
 *
 * @author Vespertino
 */
public class Departamento implements Serializable{
    private int dept_no;
    private String dnombre;
    private String loc;
    private LinkedHashSet<Empleado> empleados;

    public Departamento(int dept_no, String dnombre, String loc, LinkedHashSet<Empleado> empleados) {
        this.dept_no = dept_no;
        this.dnombre = dnombre;
        this.loc = loc;
        this.empleados = empleados;
    }

    public Departamento(int dept_no) {
        this.dept_no = dept_no;
    }

    public Departamento() {
    }

    @Override
    public String toString() {
        return "Departamento con :" + " dept_no :" + dept_no + ", dnombre: " + ", loc: " +loc + ", Con empleados :\n" + empleados.toString()+ "\n";
    }

    
    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public LinkedHashSet<Empleado> getEmpleados() {
        return empleados;
    }


    public void setEmpleados(LinkedHashSet<Empleado> empleados) {
        this.empleados = empleados;
    }

   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Departamento other = (Departamento) obj;
        if (this.dept_no != other.dept_no) {
            return false;
        }
        return true;
    }

    
    
    
}
