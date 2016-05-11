/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sspoc.visao;

import br.edu.uerr.sspoc.modelo.IndiceMarkup;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author fpcarlos
 */
@Named
@SessionScoped
public class PainelABean extends AbstractBean implements Serializable{
   
    private IndiceMarkup indiceMarkup;

    public PainelABean() {
    }
    
    
    
    
    public String abreForm(){
        try {
            indiceMarkup = new IndiceMarkup();
            
            return redirect("/sistema/markup/formPainel1.xhtml");
        } catch (Exception e) {
            return null;
        }
    }

    public IndiceMarkup getIndiceMarkup() {
        return indiceMarkup;
    }

    public void setIndiceMarkup(IndiceMarkup indiceMarkup) {
        this.indiceMarkup = indiceMarkup;
    }
    
    
    
    
}
