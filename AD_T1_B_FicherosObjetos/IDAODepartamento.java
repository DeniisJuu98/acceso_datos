/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AD_T1_B_FicherosObjetos;

/**
 *
 * @author Vespertino
 */
public interface IDAODepartamento {
    public abstract boolean Alta (Departamento d);
    public abstract boolean Baja (Departamento d);
    public abstract void verTodos ();
}
