package br.edu.ifpb.dac.controllers;

import br.edu.ifpb.dac.model.Banda;
import br.edu.ifpb.dac.services.VitrineService;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named
@RequestScoped
public class VitrineController {

    @EJB
    private VitrineService service;

    private void atualizar() {
        service.atualizar();
        System.out.println("atualizou");
    }

    public List<Banda> vitrine() {
        return service.getVitrine();
    }
}
