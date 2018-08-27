package br.edu.ifpb.dac.controllers;

import br.edu.ifpb.dac.model.Album;
import br.edu.ifpb.dac.model.Estilo;
import br.edu.ifpb.dac.services.AlbumService;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class AlbumController {

    @EJB(beanName = "albumservice")
    private AlbumService service;
    private Album album = new Album();

    public void salvar() {
        service.salvar(album);
    }

    public void deletar(Album a) {
        service.deletar(a);
    }

    public List<Estilo> estilos() {
        return Arrays.asList(Estilo.values());
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

}
