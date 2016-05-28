package br.edu.uerr.sisfrequencia.controle;

import br.edu.uerr.sisfrequencia.modelo.Evento;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EventoControle extends AbstractControle {
    
    //Ligação com a unidde de persistênca
    @PersistenceContext
    private EntityManager entityManager;

    //Metódo Salvar e Alterar
    public void salvar(Evento entity) throws Exception {
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
    public void remove(Evento entity) throws Exception {
        try {
            Evento aux = entityManager.find(Evento.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    //Método retorna um objeto a partir de um código
    public Evento pegaEventoPeloId(Integer id) throws Exception{
        try {
            Evento aux = entityManager.find(Evento.class, id);
            return aux;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    //Método Lista todos os objetos
    public List<Evento> findAll() throws Exception {
		try {
			List<Evento> lista = new ArrayList<>();
	  		String sql = "select * from evento";
			lista = executaSqlNativo(sql, Evento.class, entityManager);
			return lista;

		} catch (RuntimeException re) {
			throw new Exception(" Erro" + re.getMessage());
		} catch (Exception e) {
			throw new Exception(" Erro" + e.getMessage());
		}

	}
    
    
}
