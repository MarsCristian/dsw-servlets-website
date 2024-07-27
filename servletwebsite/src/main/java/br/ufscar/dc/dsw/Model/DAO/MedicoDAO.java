package br.ufscar.dc.dsw.Model.DAO;

import br.ufscar.dc.dsw.Model.Entities.Medico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO extends GenericDAO{

    public void Insert(Medico medico) {

        String sql = "insert into medico (medico_id,email,senha,crm,nome,especialidade) values(?,?,?,?,?,?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps = conn.prepareStatement(sql);
            ps.setString(1,medico.getId());
            ps.setString(2,medico.getEmail());
            ps.setString(3,medico.getSenha());
            ps.setString(4,medico.getCrm());
            ps.setString(5,medico.getNome());
            ps.setString(6,medico.getEspecialidade());
            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public void Delete(Medico medico) {
        String sql = "delete from medico where medico_id=?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,medico.getId());
            ps.executeUpdate();
            conn.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void Update(Medico medico) {
        String sql = "UPDATE medico SET email=?,senha=?,crm=?,nome=?,especialidade=?, WHERE medico_id=?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,medico.getEmail());
            ps.setString(2,medico.getSenha());
            ps.setString(3,medico.getCrm());
            ps.setString(4,medico.getNome());
            ps.setString(5,medico.getEspecialidade());
            ps.setString(6,medico.getId());
            ps.executeUpdate();

            //ps.close();
            conn.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Medico> GetAll() {
        List<Medico> listaMedicos = new ArrayList<>();
        String sql = "select * from medico m order by medico_id";

        try {
            Connection con = this.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String medico_id = rs.getString("medico_id");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                String crm = rs.getString("crm");
                String nome = rs.getString("nome");
                String especialidade = rs.getString("especialidade");

                Medico medico = new Medico(medico_id,email,crm,nome,especialidade);
                listaMedicos.add(medico);
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaMedicos;
    }

}
