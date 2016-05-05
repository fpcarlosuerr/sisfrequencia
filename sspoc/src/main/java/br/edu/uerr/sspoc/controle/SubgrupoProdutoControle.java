/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sspoc.controle;

import br.edu.uerr.sspoc.modelo.SubgrupoProduto;
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
public class SubgrupoProdutoControle extends AbstractControle {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(SubgrupoProduto entity) throws Exception {
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

    public void remover(SubgrupoProduto entity) throws Exception {
        try {
            SubgrupoProduto aux = entityManager.find(SubgrupoProduto.class, entity.getId());
            entityManager.remove(aux);

        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    public List<SubgrupoProduto> findAll() throws Exception {
        try {
            List<SubgrupoProduto> lista = new ArrayList<>();
            String sql = "select * from subgrupo_produto";
            lista = executaSqlNativo(sql, SubgrupoProduto.class, entityManager);
            return lista;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }
    }
    
    public SubgrupoProduto pegarSubgrupoProdutoPeloId(Integer id) throws Exception{
        try {
            SubgrupoProduto aux = entityManager.find(SubgrupoProduto.class, id);
            return aux;
          } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }        
    }
    

}
