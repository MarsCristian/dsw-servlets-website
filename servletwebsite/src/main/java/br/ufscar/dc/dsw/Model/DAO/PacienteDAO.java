package br.ufscar.dc.dsw.Model.DAO;

import br.ufscar.dc.dsw.Model.Entities.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO extends GenericDAO {

    public void Insert(Paciente paciente) {
        String sql = "insert into paciente (paciente_id,email,senha,cpf,nome,telefone,sexo,dataNascimento) values(?,?,?,?,?,?,?,?)";

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps = con.prepareStatement(sql);
            ps.setString(1, paciente.getId());
            ps.setString(2, paciente.getEmail());
            ps.setString(3, paciente.getSenha());
            ps.setString(4, paciente.getCpf());
            ps.setString(5, paciente.getNome());
            ps.setString(6, paciente.getTelefone());
            ps.setString(7, paciente.getSexo());
            ps.setString(8, paciente.getDataNascimento());
            ps.executeUpdate();
            con.close();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void Delete(Paciente paciente) {
        String sql = "delete from paciente where paciente_id=?";

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, paciente.getId());
            ps.executeUpdate();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Update(Paciente paciente) {
        String sql = "update paciente set email=?,senha=?,cpf=?,telefone=?,sexo=?,dataNascimento=? where paciente_id=?";

        try{
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, paciente.getEmail());
            ps.setString(2, paciente.getSenha());
            ps.setString(3, paciente.getCpf());
            ps.setString(4, paciente.getTelefone());
            ps.setString(5, paciente.getSexo());
            ps.setString(6, paciente.getDataNascimento());
            ps.setString(7, paciente.getId());
            ps.executeUpdate();

            //ps.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Paciente> GetAll() {
        List<Paciente> listaPacientes = new ArrayList<>();
        String sql = "select * from paciente p order by paciente_id";

        try {
            Connection con = this.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String paciente_id = rs.getString("paciente_id");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String sexo = rs.getString("sexo");
                String dataNascimento = rs.getString("dataNascimento");

                Paciente paciente = new Paciente(senha,email,cpf,nome,telefone,sexo,dataNascimento);
                listaPacientes.add(paciente);
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPacientes;
    }

    public Paciente GetById(String id) {
        Paciente paciente = null;

        String sql = "SELECT * from paciente where paciente_id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String sexo = rs.getString("sexo");
                String dataNascimento = rs.getString("dataNascimento");

                paciente = new Paciente(senha,email,cpf,nome,telefone,sexo,dataNascimento);
            }

            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return paciente;
    }

}
