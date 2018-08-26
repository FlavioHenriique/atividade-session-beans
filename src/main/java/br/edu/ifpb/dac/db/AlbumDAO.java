package br.edu.ifpb.dac.db;

import br.edu.ifpb.dac.model.Album;
import br.edu.ifpb.dac.model.Banda;
import br.edu.ifpb.dac.model.Estilo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class AlbumDAO {

    private Connection conn;

    public AlbumDAO() {
        try {
            conn = Conexao.getConnection();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean cadastrar(Album album) {

        String sql = "INSERT INTO album (estilo, banda, lancamento) VALUES (?,?,?);";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, album.getEstilo().name());
            stmt.setInt(2, album.getBanda().getId());
            stmt.setDate(3, Date.valueOf(album.getAnoDeLancamento()));
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean atualizar(Album album) {
        String sql = "UPDATE album set estilo = ?, banda = ?,"
                + " lancamento  = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, album.getEstilo().name());
            stmt.setInt(2, album.getBanda().getId());
            stmt.setDate(3,Date.valueOf(album.getAnoDeLancamento()));
            stmt.setInt(4,album.getId());

            stmt.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }

    public boolean deletar(int id) {
        String sql = "DELETE FROM Album WHERE id  = ?;";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<Album> buscar() {

        String sql = "SELECT * FROM Album;";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Album> lista = new ArrayList<>();
            BandaDAO dao = new BandaDAO();
            while (rs.next()) {
                Album a = new Album();
                a.setBanda(dao.buscar(rs.getInt("banda")));
                a.setEstilo(Estilo.valueOf(rs.getString("estilo")));
                a.setAnoDeLancamento(rs.getDate("lancamento").toLocalDate());
                a.setId(rs.getInt("id"));
                lista.add(a);
            }
            return lista;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }



}
