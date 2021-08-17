package escola;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

public class Aluno {
    private int    codaluno;
    private String nomaluno;
    private float  medaluno;
    
    public boolean IncluirAluno() {
        String sql  = "insert into aluno ";
               sql += "(nomealuno, medaluno) ";
               sql += " values(?,?);";
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, this.nomaluno);
            stm.setFloat(2, this.medaluno);
            stm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage() +sql);
            return false;
        }
        return true;
    }

    public boolean AlterarAluno() {
        String sql  = "update aluno ";
               sql += "set nomealuno= ?, medaluno= ? ";
               sql += "where codaluno = ?";
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, this.nomaluno);
            stm.setFloat(2, this.medaluno);
            stm.setInt(3, this.codaluno);
            stm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage() +sql);
            return false;
        }
        return true;
    }
    
     public boolean ExcluirAluno() {
        String sql  = "delete from aluno ";
               sql += "where codaluno = ?";
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, this.codaluno);
            stm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage() +sql);
            return false;
        }
        return true;
    }
   
      public List<Aluno> consultaAlunos() {
        List<Aluno> lista = new ArrayList<>();
        Connection con = Conexao.conectar();
        String sql  = "select codaluno, nomealuno, medaluno ";
               sql += " from aluno";
               sql += " order by 1";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Aluno alu = new Aluno();
                alu.setCodaluno(rs.getInt("codaluno"));
                alu.setNomaluno(rs.getString("nomealuno"));
                alu.setMedaluno(rs.getFloat("medaluno"));
                lista.add(alu);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return lista;
    }

     
     
     
     
     
    // area de getters e setters
    public int getCodaluno() {
        return codaluno;
    }

    public void setCodaluno(int codaluno) {
        this.codaluno = codaluno;
    }

    public String getNomaluno() {
        return nomaluno;
    }

    public void setNomaluno(String nomaluno) {
        this.nomaluno = nomaluno;
    }

    public float getMedaluno() {
        return medaluno;
    }

    public void setMedaluno(float medaluno) {
        this.medaluno = medaluno;
    }   
}