package br.edu.ifpb.dac.services;

import br.edu.ifpb.dac.model.Banda;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class PlaylistService {

    @EJB
    private Playlists playlist;

    public void adicionarBanda(Banda b) {
        playlist.adicionarBanda(b);
    }

    public void removerBanda(Banda b) {
        playlist.removerBanda(b);
    }

    public List<Banda> getPlaylist() {
        return playlist.getPlaylist();
    }

}
