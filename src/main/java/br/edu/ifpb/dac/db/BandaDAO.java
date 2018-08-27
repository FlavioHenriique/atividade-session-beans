package br.edu.ifpb.dac.db;

import br.edu.ifpb.dac.model.Banda;
import br.edu.ifpb.dac.model.CPF;
import br.edu.ifpb.dac.model.Integrante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateless(name = "bandadao")
public class BandaDAO {

    private Connection conn;

    public BandaDAO() {
        try {
            conn = Conexao.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(BandaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BandaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar(Banda b) {
        String sql = "INSERT INTO BANDA (localdeorigem,nomefantasia)"
                + "VALUES (?,?);";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, b.getLocalDeOrigem());
            stmt.setString(2, b.getNomeFantasia());

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public Banda buscar(int id) {
        String sql = "SELECT * FROM BANDA WHERE id = ?;";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Banda banda = new Banda();
                banda.setId(rs.getInt("id"));
                banda.setLocalDeOrigem(rs.getString("localdeorigem"));
                banda.setNomeFantasia(rs.getString("nomefantasia"));
                banda.setIntegrantes(integrantes(banda));
                return banda;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void deletar(Banda b) {
        String sql = "DELETE FROM BANDA WHERE ID = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, b.getId());

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void atualizar(Banda b) {

        String sql = "update banda set localdeorigem = ?, nomefantasia = ? where id = ?;";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, b.getLocalDeOrigem());
            stmt.setString(2, b.getNomeFantasia());
            stmt.setInt(3, b.getId());

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Banda> todas() {
        String sql = "SELECT id from banda";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            List<Banda> bandas = new ArrayList<>();

            while (rs.next()) {
                bandas.add(this.buscar(rs.getInt("id")));
            }
            return bandas;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Banda listarPorIntegrantes(String nome) {
        String sql = "SELECT b.id FROM Banda b, Integrante i"
                + "WHERE b.id = i.banda AND i.nome ilike ?;";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return this.buscar(rs.getInt("id"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Integrante> integrantes(Banda b) {
        String sql = "SELECT * FROM INTEGRANTE WHERE banda = ?;";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, b.getId());

            List<Integrante> lista = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Integrante i = new Integrante();
                i.setCpf(new CPF(rs.getString("cpf")));
                i.setDataDeNascimento(rs.getDate("nascimento").toLocalDate());
                i.setId(rs.getInt("id"));
                i.setNome(rs.getString("nome"));
                lista.add(i);
            }
            return lista;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
