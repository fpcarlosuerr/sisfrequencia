/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.evento.controle;

import br.edu.uerr.evento.modelo.Cargo;
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
public class CargoController extends AbstractController {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(Cargo entity) throws Exception {
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

    public void remove(Cargo entity) throws Exception {
        try {
            Cargo aux = entityManager.find(Cargo.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
    
    public Cargo pegaCargoId(Integer id) throws Exception {
        try {
            Cargo aux = entityManager.find(Cargo.class, id);
            return aux;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

    public List<Cargo> findAll() throws Exception {
        try {
            List<Cargo> listaCargo = new ArrayList<>();
            String sql = "select * from cargo";
            listaCargo = executaSqlNativo(sql, Cargo.class, entityManager);
            return listaCargo;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

}
