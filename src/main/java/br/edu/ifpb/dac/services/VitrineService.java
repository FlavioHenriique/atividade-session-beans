package br.edu.ifpb.dac.services;

import br.edu.ifpb.dac.model.Banda;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class VitrineService{
    
    @EJB
    private Vitrine vitrine;
    
    public List<Banda> getVitrine(){
        return vitrine.getVitrine();
    }
    
    public void atualizar(){
        vitrine.atualizar();
    }
}
