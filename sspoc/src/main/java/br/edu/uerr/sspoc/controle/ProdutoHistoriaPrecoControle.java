/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sspoc.controle;

import br.edu.uerr.sspoc.modelo.ProdutoHistoriaPreco;
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
public class ProdutoHistoriaPrecoControle extends AbstractControle {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(ProdutoHistoriaPreco entity) throws Exception {
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

    public void remover(ProdutoHistoriaPreco entity) throws Exception {
        try {
            ProdutoHistoriaPreco aux = entityManager.find(ProdutoHistoriaPreco.class, entity.getId());
            entityManager.remove(aux);

        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    public List<ProdutoHistoriaPreco> findAll() throws Exception {
        try {
            List<ProdutoHistoriaPreco> lista = new ArrayList<>();
            String sql = "select * from produto_historia_preco";
            lista = executaSqlNativo(sql, ProdutoHistoriaPreco.class, entityManager);
            return lista;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }
    }
    
    public ProdutoHistoriaPreco pegarProdutoHistoriaPrecoPeloId(Integer id) throws Exception{
        try {
            ProdutoHistoriaPreco aux = entityManager.find(ProdutoHistoriaPreco.class, id);
            return aux;
          } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }        
    }
    

}
