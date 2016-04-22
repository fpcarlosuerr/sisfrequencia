/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.evento.controle;

import br.edu.uerr.evento.modelo.TipoUsuario;
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
public class TipoUsuarioController extends AbstractController {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(TipoUsuario entity) throws Exception {
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

    public void remove(TipoUsuario entity) throws Exception {
        try {
            TipoUsuario aux = entityManager.find(TipoUsuario.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
    
    public List<TipoUsuario> findAll() throws Exception {
		try {
			List<TipoUsuario> listaTipoUsuario = new ArrayList<>();
			String sql = "select * from tipo_usuario";
			listaTipoUsuario = executaSqlNativo(sql, TipoUsuario.class, entityManager);
			return listaTipoUsuario;

		} catch (RuntimeException re) {
			throw new Exception(" Erro" + re.getMessage());
		} catch (Exception e) {
			throw new Exception(" Erro" + e.getMessage());
		}

	}
}
