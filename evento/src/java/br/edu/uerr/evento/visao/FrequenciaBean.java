/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.evento.visao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author fpcarlos
 */
@Named
@SessionScoped
public class FrequenciaBean extends AbstractBean implements Serializable {

    private Integer diasDoMes;
    private String fimDeSemana;
    private List<Integer> listaDiasDoMes = new ArrayList<>();

    public String abrirFrequencia() {
        try {
            //Date data = new Date();
            //diasDoMes = data.
            Calendar calendario = Calendar.getInstance();
            diasDoMes = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
            listaDiasDoMes = new ArrayList<>();
            for (int i = 1; i <= diasDoMes; i++) {
                listaDiasDoMes.add(i);
            }

            return redirect("/sistema/relatorios/frequencia.xhtml");
        } catch (Exception e) {
            return null;
        }
    }

    public String pegaFimDeSemana(Integer id) {
        try {
            Date d = new Date();
            TimeZone tz = TimeZone.getTimeZone("America/Boa_Vista");
            TimeZone.setDefault(tz);
            Calendar calendario = Calendar.getInstance(tz);
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
  
            calendario.setTime(d);
            
            String nomeDia = "";
            Integer dia = id;
            Integer mes = calendario.get(Calendar.MONTH) + 1;
            Integer ano = calendario.get(Calendar.YEAR);
            String nData= dia.toString()+"/"+mes.toString()+"/"+ano.toString();
            Date dt1 = df.parse (nData);

            calendario.setTime(dt1);

            if (calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                nomeDia = "Domingo";
            } else if (calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                nomeDia = "Sábado";
            } else {
                nomeDia = "";//id.toString();
            }
            return nomeDia;

        } catch (Exception e) {
            return null;
        }

    }

    public Integer getDiasDoMes() {
        return diasDoMes;
    }

    public void setDiasDoMes(Integer diasDoMes) {
        this.diasDoMes = diasDoMes;
    }

    public List<Integer> getListaDiasDoMes() {
        return listaDiasDoMes;
    }

    public void setListaDiasDoMes(List<Integer> listaDiasDoMes) {
        this.listaDiasDoMes = listaDiasDoMes;
    }

    public String getFimDeSemana() {
        return fimDeSemana;
    }

    public void setFimDeSemana(String fimDeSemana) {
        this.fimDeSemana = fimDeSemana;
    }

}
