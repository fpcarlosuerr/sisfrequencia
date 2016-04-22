/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.evento.visao;

import br.edu.uerr.evento.controle.CargoController;
import br.edu.uerr.evento.modelo.Cargo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author fpcarlos
 */
@Named
@SessionScoped
public class CargoBean extends AbstractBean implements Serializable{
    
    @EJB
    private CargoController cargoController;
    
    private List<Cargo> listCargo = new ArrayList<>();
    
    private Cargo cargo;

    public CargoBean() {
    }
    

    public String prepararCadastroCargo() {
        try {
            cargo = new Cargo();
            return redirect("/sistema/cargo/formCargo.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public String abrirListaCargos(){
        try {
            listCargo = new ArrayList<>();
            listCargo = cargoController.findAll();
            return redirect("/sistema/cargo/listaCargos.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public String prepararEditaCargo(Cargo aux) {
        try {
            cargo = cargoController.pegaCargoId(aux.getId());
            return redirect("/sistema/cargo/formCargo.xhtml");

        } catch (Exception e) {
            return null;
        }
    }
    
    public String removeCargo(Cargo aux) {
        try {            
            cargoController.remove(aux);
            showFacesMessage("Cargo deletado com sucesso!!!", 2);
            cargo = new Cargo();
            listCargo = new ArrayList<>();
            listCargo = cargoController.findAll();
            return redirect("/sistema/cargo/listaCargos.xhtml");

        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
            return null;
        }
    }
    
    public void salvarCargo(){
        try {
            cargoController.salvar(cargo);
            showFacesMessage("salvo com sucesso!!!", 2);
            listCargo = new ArrayList<>();
            listCargo = cargoController.findAll();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/evento/sistema/cargo/listaCargos.xhtml");
            
        } catch (Exception e) {
            showFacesMessage(e.getMessage(), 4);
        }
    }

    public List<Cargo> getListCargo() {
        return listCargo;
    }

    public void setListCargo(List<Cargo> listCargo) {
        this.listCargo = listCargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    
    
}
