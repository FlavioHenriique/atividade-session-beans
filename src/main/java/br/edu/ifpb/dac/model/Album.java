package br.edu.ifpb.dac.model;

import java.time.LocalDate;
import java.util.Objects;

public class Album {

    private Estilo estilo; //Rock, Pop, Sertanejo
    private Banda banda;
    private LocalDate anoDeLancamento;

    public Album(Estilo estilo, Banda banda, LocalDate anoDeLancamento) {
        this.estilo = estilo;
        this.banda = banda;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Album() {

    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public LocalDate getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(LocalDate anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.estilo);
        hash = 79 * hash + Objects.hashCode(this.banda);
        hash = 79 * hash + Objects.hashCode(this.anoDeLancamento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Album other = (Album) obj;
        if (this.estilo != other.estilo) {
            return false;
        }
        if (!Objects.equals(this.banda, other.banda)) {
            return false;
        }
        if (!Objects.equals(this.anoDeLancamento, other.anoDeLancamento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Album{" + "estilo=" + estilo + ", banda=" + banda + 
                ", anoDeLancamento=" + anoDeLancamento + '}';
    }

}
