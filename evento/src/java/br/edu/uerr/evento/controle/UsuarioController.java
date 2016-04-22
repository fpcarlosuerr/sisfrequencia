/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.evento.controle;

import br.edu.uerr.evento.modelo.Usuario;
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
public class UsuarioController extends AbstractController {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(Usuario entity) throws Exception {
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

    public void remove(Usuario entity) throws Exception {
        try {
            Usuario aux = entityManager.find(Usuario.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public Usuario pegaUsuarioId(Integer id) throws Exception {
        try {
            Usuario aux = entityManager.find(Usuario.class, id);
            return aux;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

    public List<Usuario> findAll() throws Exception {
        try {
            List<Usuario> listaUsuario = new ArrayList<>();
            String sql = "select * from usuario";
            listaUsuario = executaSqlNativo(sql, Usuario.class, entityManager);
            return listaUsuario;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

}
