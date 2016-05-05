/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sspoc.controle;

import br.edu.uerr.sspoc.modelo.GrupoProduto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fpcarlos
 */
@Stateless
public class GrupoProdutoControle extends AbstractControle {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(GrupoProduto entity) throws Exception {
        try {
            if (entity.getId() != null && entity.getId() > 0) {
                entityManager.merge(entity);
            } else {
                entityManager.persist(entity);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public void remover(GrupoProduto entity) throws Exception {
        try {
            GrupoProduto aux = entityManager.find(GrupoProduto.class, entity.getId());
            entityManager.remove(aux);

        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    public List<GrupoProduto> findAll() throws Exception {
        try {
            List<GrupoProduto> lista = new ArrayList<>();
            String sql = "select * from grupo_produto";
            lista = executaSqlNativo(sql, GrupoProduto.class, entityManager);
            return lista;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }
    }
    
    public GrupoProduto pegarGrupoProdutoPeloId(Integer id) throws Exception{
        try {
            GrupoProduto aux = entityManager.find(GrupoProduto.class, id);
            return aux;
          } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }        
    }
    

}
