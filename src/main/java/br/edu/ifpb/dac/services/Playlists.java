package br.edu.ifpb.dac.services;

import br.edu.ifpb.dac.model.Banda;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.NamedArg;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Singleton
public class Playlists implements Serializable {

    private List<Banda> playlist;

    @PostConstruct
    public void iniciar() {
        playlist = new ArrayList<>();
    }

    public void adicionarBanda(Banda banda) {
        playlist.add(banda);
        System.out.println(playlist.size());
    }

    public void removerBanda(Banda b) {
        playlist.remove(b);
    }

    public List<Banda> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Banda> playlist) {
        this.playlist = playlist;
    }

    public void finalizar() {
        playlist.clear();
    }

}
