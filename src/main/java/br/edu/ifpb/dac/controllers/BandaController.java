package br.edu.ifpb.dac.controllers;

import br.edu.ifpb.dac.model.Banda;
import br.edu.ifpb.dac.model.Estilo;
import br.edu.ifpb.dac.services.BandaService;
import br.edu.ifpb.dac.services.VitrineService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@RequestScoped
@Stateful
public class BandaController implements Serializable {

    @EJB(beanName = "bandaservice")
    private BandaService service;
    @EJB
    private VitrineService vService;
    private Banda banda = new Banda();
    private Banda buscada = new Banda();
    private List<Banda> vitrine = new ArrayList<>();

    @PostConstruct
    public void init() {
        vitrine = service.todas().subList(0, 3);
    }

    public void salvar() {
        service.salvar(banda);
        vService.atualizar();
    }

    public void deletar(Banda b) {
        service.deletar(b);
    }

    public void listarPorIntegrantes(String nome) {
        this.buscada = service.listarPorIntegrantes(nome);
    }

    public List<Banda> todas() {
        return service.todas();
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public Banda getBuscada() {
        return buscada;
    }

    public void setBuscada(Banda buscada) {
        this.buscada = buscada;
    }

}
