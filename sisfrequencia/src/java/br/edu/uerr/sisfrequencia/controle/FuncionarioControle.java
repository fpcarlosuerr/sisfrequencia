package br.edu.uerr.sisfrequencia.controle;

import br.edu.uerr.sisfrequencia.modelo.Funcionario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FuncionarioControle extends AbstractControle {
    
    //Ligação com a unidde de persistênca
    @PersistenceContext
    private EntityManager entityManager;

    //Metódo Salvar e Alterar
    public void salvar(Funcionario entity) throws Exception {
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
    public void remove(Funcionario entity) throws Exception {
        try {
            Funcionario aux = entityManager.find(Funcionario.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    //Método retorna um objeto a partir de um código
    public Funcionario pegaFuncionarioPeloId(Integer id) throws Exception{
        try {
            Funcionario aux = entityManager.find(Funcionario.class, id);
            return aux;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    //Método Lista todos os objetos
    public List<Funcionario> findAll() throws Exception {
		try {
			List<Funcionario> lista = new ArrayList<>();
	  		String sql = "select * from funcionario";
			lista = executaSqlNativo(sql, Funcionario.class, entityManager);
			return lista;

		} catch (RuntimeException re) {
			throw new Exception(" Erro" + re.getMessage());
		} catch (Exception e) {
			throw new Exception(" Erro" + e.getMessage());
		}

	}
    
    
}
