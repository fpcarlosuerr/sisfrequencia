package br.edu.uerr.sisfrequencia.controle;

import br.edu.uerr.sisfrequencia.modelo.TipoEvento;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TipoEventoControle extends AbstractControle {
    
    //Ligação com a unidde de persistênca
    @PersistenceContext
    private EntityManager entityManager;

    //Metódo Salvar e Alterar
    public void salvar(TipoEvento entity) throws Exception {
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

    //Método Remover
    public void remove(TipoEvento entity) throws Exception {
        try {
            TipoEvento aux = entityManager.find(TipoEvento.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    //Método retorna um objeto a partir de um código
    public TipoEvento pegaTipoEventoPeloId(Integer id) throws Exception{
        try {
            TipoEvento aux = entityManager.find(TipoEvento.class, id);
            return aux;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    //Método Lista todos os objetos
    public List<TipoEvento> findAll() throws Exception {
		try {
			List<TipoEvento> lista = new ArrayList<>();
	  		String sql = "select * from tipo_evento";
			lista = executaSqlNativo(sql, TipoEvento.class, entityManager);
			return lista;

		} catch (RuntimeException re) {
			throw new Exception(" Erro" + re.getMessage());
		} catch (Exception e) {
			throw new Exception(" Erro" + e.getMessage());
		}

	}
    
    
}
