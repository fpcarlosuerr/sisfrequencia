package br.edu.uerr.sisfrequencia.visao;

import br.edu.uerr.sisfrequencia.controle.EmpresaControle;
import br.edu.uerr.sisfrequencia.modelo.Empresa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class EmpresaVisao extends AbstractVisao implements Serializable {

    //importar a classe e criar um objeto da empresa, pois essa visão é da empresa
    private Empresa empresa;

    //importar as regras de negócio da empresa, mais marca-la para não ser visiel
    @EJB
    private EmpresaControle empresaControle;

    //criar uma lista de empresas cadastradas
    private List<Empresa> listEmpresa = new ArrayList<>();

    //criar um construtor
    public EmpresaVisao() {

    }

    //criar o método que ira abrir o formCad para incluir novo
    public String abrirFormCad() {
        try {
            //Criar uma instancia do objeto
            empresa = new Empresa();
            //criar uma lista vazia
            listEmpresa = new ArrayList<>();
            //preencher a lista com todas as empresas usando uma regra
            listEmpresa = empresaControle.findAll();
            //abrir o forumlário
            //showFacesMessage("Pronto para Cadastrar", 2);
            return redirect("/sistema/empresa/formCadEmpresa.xhtml");

        } catch (Exception e) {
            e.printStackTrace();
            //showFacesMessage(e.getMessage(), 4);
            return null;
        }
    }
    
    //criar o método que irar abriar o formCad para alteração
    public String abrirFormAlt(Empresa aux){
        try {
            empresa = new Empresa(); 
            
            empresa = empresaControle.pegaEmpresaPeloId(aux.getId());
            
            System.out.println(empresa.getNome());
            
            return redirect("/sistema/empresa/formCadEmpresa.xhtml");
        } catch (Exception e) {           
            e.printStackTrace();
            return null;
        }

    }

    //criar o méto que irar utilizar a regra salvar
    public void salvar() {
        try {
            empresaControle.salvar(empresa);
            showFacesMessage("Salvo com sucesso!!!", 2);
            //limpar a lista
            empresa = new Empresa();
            listEmpresa = new ArrayList<>();
            //preencher a lista com todas as empresas usando uma regra
            listEmpresa = empresaControle.findAll();            
        } catch (Exception e) {
            e.printStackTrace();
            showFacesMessage(e.getMessage(), 4);
        }
    }
    
    //criar o método que irar utilizar a regra remover
    //temos que receber a empresa que será removida
    public void remover(Empresa aux){
        try {
            empresaControle.remove(aux);
             showFacesMessage("Removido com sucesso!!!", 2);
            //limpar a lista
            listEmpresa = new ArrayList<>();
            //preencher a lista com todas as empresas usando uma regra
            listEmpresa = empresaControle.findAll();
            
        } catch (Exception e) {
            e.printStackTrace();
            showFacesMessage(e.getMessage(), 2);
        }
    }

    //adicionar os Gets e Set, exceto para as regras
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Empresa> getListEmpresa() {
        return listEmpresa;
    }

    public void setListEmpresa(List<Empresa> listEmpresa) {
        this.listEmpresa = listEmpresa;
    }

}
