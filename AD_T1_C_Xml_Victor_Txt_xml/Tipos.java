/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AD_T1_C_Xml_Victor_Txt_xml;

/**
 *
 * @author denis
 */
import java.util.HashSet;
import java.util.Set;

/**
 * Tipos generated by hbm2java
 */
public class Tipos  implements java.io.Serializable {


     private int idTipo;
     private String nombreTipo;
     private Set pokemonsForTipoSecundario = new HashSet(0);
     private Set pokemonsForTipoPrimario = new HashSet(0);

    public Tipos() {
    }

	
    public Tipos(int idTipo) {
        this.idTipo = idTipo;
    }
    public Tipos(int idTipo, String nombreTipo, Set pokemonsForTipoSecundario, Set pokemonsForTipoPrimario) {
       this.idTipo = idTipo;
       this.nombreTipo = nombreTipo;
       this.pokemonsForTipoSecundario = pokemonsForTipoSecundario;
       this.pokemonsForTipoPrimario = pokemonsForTipoPrimario;
    }
   
    public int getIdTipo() {
        return this.idTipo;
    }
    
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
    public String getNombreTipo() {
        return this.nombreTipo;
    }
    
    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
    public Set getPokemonsForTipoSecundario() {
        return this.pokemonsForTipoSecundario;
    }
    
    public void setPokemonsForTipoSecundario(Set pokemonsForTipoSecundario) {
        this.pokemonsForTipoSecundario = pokemonsForTipoSecundario;
    }
    public Set getPokemonsForTipoPrimario() {
        return this.pokemonsForTipoPrimario;
    }
    
    public void setPokemonsForTipoPrimario(Set pokemonsForTipoPrimario) {
        this.pokemonsForTipoPrimario = pokemonsForTipoPrimario;
    }




}
