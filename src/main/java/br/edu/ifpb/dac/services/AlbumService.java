package br.edu.ifpb.dac.services;

import br.edu.ifpb.dac.db.AlbumDAO;
import br.edu.ifpb.dac.model.Album;

public class AlbumService {

    private AlbumDAO dao;

    public AlbumService() {
        this.dao = new AlbumDAO();
    }

    public void salvar(Album a) {
        dao.cadastrar(a);
    }

    public void deletar(Album a) {
        dao.deletar(a.getId());
    }

}
