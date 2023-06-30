/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AD_T1_C_Xml_Victor_Txt_xml;

public class Pokemon  implements java.io.Serializable {


     private int idPokemon;
     private Tipos tiposByTipoSecundario;
     private Tipos tiposByTipoPrimario;
     private String nombrePokemon;
     private Integer vida;
     private Integer velocidad;
     private Integer ataque;
     private Integer defensa;
     private String rutaSprite;
     private String descripcion;

    public Pokemon() {
    }

	
    public Pokemon(int idPokemon) {
        this.idPokemon = idPokemon;
    }
    public Pokemon(int idPokemon, Tipos tiposByTipoSecundario, Tipos tiposByTipoPrimario, String nombrePokemon, Integer vida, Integer velocidad, Integer ataque, Integer defensa, String rutaSprite, String descripcion) {
       this.idPokemon = idPokemon;
       this.tiposByTipoSecundario = tiposByTipoSecundario;
       this.tiposByTipoPrimario = tiposByTipoPrimario;
       this.nombrePokemon = nombrePokemon;
       this.vida = vida;
       this.velocidad = velocidad;
       this.ataque = ataque;
       this.defensa = defensa;
       this.rutaSprite = rutaSprite;
       this.descripcion = descripcion;
    }
   
    public int getIdPokemon() {
        return this.idPokemon;
    }
    
    public void setIdPokemon(int idPokemon) {
        this.idPokemon = idPokemon;
    }
    public Tipos getTiposByTipoSecundario() {
        return this.tiposByTipoSecundario;
    }
    
    public void setTiposByTipoSecundario(Tipos tiposByTipoSecundario) {
        this.tiposByTipoSecundario = tiposByTipoSecundario;
    }
    public Tipos getTiposByTipoPrimario() {
        return this.tiposByTipoPrimario;
    }
    
    public void setTiposByTipoPrimario(Tipos tiposByTipoPrimario) {
        this.tiposByTipoPrimario = tiposByTipoPrimario;
    }
    public String getNombrePokemon() {
        return this.nombrePokemon;
    }
    
    public void setNombrePokemon(String nombrePokemon) {
        this.nombrePokemon = nombrePokemon;
    }
    public Integer getVida() {
        return this.vida;
    }
    
    public void setVida(Integer vida) {
        this.vida = vida;
    }
    public Integer getVelocidad() {
        return this.velocidad;
    }
    
    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }
    public Integer getAtaque() {
        return this.ataque;
    }
    
    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }
    public Integer getDefensa() {
        return this.defensa;
    }
    
    public void setDefensa(Integer defensa) {
        this.defensa = defensa;
    }
    public String getRutaSprite() {
        return this.rutaSprite;
    }
    
    public void setRutaSprite(String rutaSprite) {
        this.rutaSprite = rutaSprite;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}

