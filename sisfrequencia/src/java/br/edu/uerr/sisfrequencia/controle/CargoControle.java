package br.edu.uerr.sisfrequencia.controle;

import br.edu.uerr.sisfrequencia.modelo.Cargo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CargoControle extends AbstractControle {
    
    //Ligação com a unidde de persistênca
    @PersistenceContext
    private EntityManager entityManager;

    //Metódo Salvar e Alterar
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

    //Método Remover
    public void remove(Cargo entity) throws Exception {
        try {
            Cargo aux = entityManager.find(Cargo.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    //Método retorna um objeto a partir de um código
    public Cargo pegaCargoPeloId(Integer id) throws Exception{
        try {
            Cargo aux = entityManager.find(Cargo.class, id);
            return aux;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    //Método Lista todos os objetos
    public List<Cargo> findAll() throws Exception {
		try {
			List<Cargo> lista = new ArrayList<>();
	  		String sql = "select * from cargo";
			lista = executaSqlNativo(sql, Cargo.class, entityManager);
			return lista;

		} catch (RuntimeException re) {
			throw new Exception(" Erro" + re.getMessage());
		} catch (Exception e) {
			throw new Exception(" Erro" + e.getMessage());
		}

	}
    
    
}
