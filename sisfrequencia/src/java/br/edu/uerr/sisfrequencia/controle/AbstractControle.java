/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sisfrequencia.controle;

import java.lang.annotation.Annotation;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
 *
 * @author fpcarlos
 */
public class AbstractControle {
    
        private <T> String nomeTabela(Class<T> clazz) {

        try {

            for (Annotation fA : clazz.getAnnotations()) {
                if (fA.annotationType().getName().toString()
                        .equals("javax.persistence.Table")) {
                    javax.persistence.Table myAnnotation = (javax.persistence.Table) fA;
                    return myAnnotation.schema() + "." + myAnnotation.name();
                }
            }
            return null;
        } catch (RuntimeException e) {
            throw e;

        } catch (Exception e) {
            throw e;

        }

    }

    public <T> List<T> buscarComSqlNativo(Class<T> clazz, EntityManager entityManager) throws Exception {

        try {

            String sql = "select * from " + nomeTabela(clazz) + ";";
            return executaSqlNativo(sql, clazz, entityManager);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    public <T> List<T> executaSqlNativo(String sql, Class<T> clazz, EntityManager entityManager)
            throws Exception {
        try {
            //printErro(sql);
            Query sqlQuery = entityManager.createNativeQuery(sql, clazz);
            System.out.println(sql);
            return sqlQuery.getResultList();

        } catch (RuntimeException re) {
            throw new Exception("SQl:" + sql + ": Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception("SQl:" + sql + ": Erro" + e.getMessage());
        }

    }

    public <T> List<T> buscarComSqlNativoOrdenado(String ordem, Class<T> clazz, EntityManager entityManager)
            throws Exception {
        try {

            String sql = "select * from " + nomeTabela(clazz) + " order by "
                    + ordem + ";";

            return executaSqlNativo(sql, clazz, entityManager);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

}
