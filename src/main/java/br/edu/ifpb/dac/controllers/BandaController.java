package br.edu.ifpb.dac.controllers;

import br.edu.ifpb.dac.model.Banda;
import br.edu.ifpb.dac.services.BandaService;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class BandaController {

    private BandaService service = new BandaService();
    private Banda banda = new Banda();

    public void salvar() {
        service.salvar(banda);
    }

    public void deletar(Banda b) {
        service.deletar(b);
    }

    public Banda listarPorIntegrantes(String nome) {
        return service.listarPorIntegrantes(nome);
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

}
