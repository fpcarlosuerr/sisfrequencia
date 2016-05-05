/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sspoc.controle;

import br.edu.uerr.sspoc.modelo.Cliente;
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
public class ClienteControle extends AbstractControle {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(Cliente entity) throws Exception {
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

    public void remover(Cliente entity) throws Exception {
        try {
            Cliente aux = entityManager.find(Cliente.class, entity.getId());
            entityManager.remove(aux);

        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    public List<Cliente> findAll() throws Exception {
        try {
            List<Cliente> lista = new ArrayList<>();
            String sql = "select * from cliente";
            lista = executaSqlNativo(sql, Cliente.class, entityManager);
            return lista;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }
    }
    
    public Cliente pegarClientePeloId(Integer id) throws Exception{
        try {
            Cliente aux = entityManager.find(Cliente.class, id);
            return aux;
          } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }        
    }
    

}
