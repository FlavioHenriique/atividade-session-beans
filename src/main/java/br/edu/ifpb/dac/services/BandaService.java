package br.edu.ifpb.dac.services;

import br.edu.ifpb.dac.db.BandaDAO;
import br.edu.ifpb.dac.model.Banda;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name = "bandaservice")
public class BandaService {
    
    @EJB(beanName = "bandadao")
    private BandaDAO dao;
    
    public BandaService(){
        dao = new BandaDAO();
    }
    
    public void salvar(Banda b){
        this.dao.salvar(b);
    }
    
    public void deletar(Banda b){
        this.dao.deletar(b);
    }
    
    public Banda listarPorIntegrantes(String nome){
        
        return this.dao.listarPorIntegrantes(nome);
    }
    
    public List<Banda> todas(){
        return dao.todas();
    }
}
