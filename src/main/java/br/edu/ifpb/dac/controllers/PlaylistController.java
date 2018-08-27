package br.edu.ifpb.dac.controllers;

import br.edu.ifpb.dac.model.Banda;
import br.edu.ifpb.dac.services.PlaylistService;
import br.edu.ifpb.dac.services.Playlists;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named
@RequestScoped
public class PlaylistController implements Serializable {

    @EJB
    private PlaylistService service;

    public void addBanda(Banda b) {
        service.adicionarBanda(b);
    }

    public void removerBanda(Banda b) {
        service.removerBanda(b);
    }

    public List<Banda> listar() {
        return service.getPlaylist();
    }

}
