package br.edu.uerr.sisfrequencia.controle;

import br.edu.uerr.sisfrequencia.modelo.Setor;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SetorControle extends AbstractControle {
    
    //Ligação com a unidde de persistênca
    @PersistenceContext
    private EntityManager entityManager;

    //Metódo Salvar e Alterar
    public void salvar(Setor entity) throws Exception {
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
    public void remove(Setor entity) throws Exception {
        try {
            Setor aux = entityManager.find(Setor.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    //Método retorna um objeto a partir de um código
    public Setor pegaSetorPeloId(Integer id) throws Exception{
        try {
            Setor aux = entityManager.find(Setor.class, id);
            return aux;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    //Método Lista todos os objetos
    public List<Setor> findAll() throws Exception {
		try {
			List<Setor> lista = new ArrayList<>();
	  		String sql = "select * from setor";
			lista = executaSqlNativo(sql, Setor.class, entityManager);
			return lista;

		} catch (RuntimeException re) {
			throw new Exception(" Erro" + re.getMessage());
		} catch (Exception e) {
			throw new Exception(" Erro" + e.getMessage());
		}

	}
    
    
}
