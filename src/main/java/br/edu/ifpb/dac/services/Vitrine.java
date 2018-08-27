package br.edu.ifpb.dac.services;

import br.edu.ifpb.dac.model.Banda;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import br.edu.ifpb.dac.db.BandaDAO;
import java.util.Collections;
import java.util.List;

@Singleton
public class Vitrine implements Serializable {

    private List<Banda> vitrine;
    @EJB(beanName = "bandadao")
    private BandaDAO dao;

    @PostConstruct
    public void init() {

        vitrine = dao.todas();
    }

    public void atualizar() {
        List<Banda> lista = dao.todas();
        Collections.shuffle(lista);
        vitrine = lista;
    }

    public List<Banda> getVitrine() {
        return vitrine.subList(0, 3);
    }

    public void setVitrine(List<Banda> vitrine) {
        this.vitrine = vitrine;
    }

}
