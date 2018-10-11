package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.ConnectionFactory;
import utils.Pessoa;

public class PessoaDAO implements InterfacePessoaDAO {

	@Override
	public void adicionar(Pessoa p) {
		PreparedStatement ps = null;
		String sql = "insert into pessoas(cpf,nome, idade, rg) values (?,?,?,?);";
		System.out.println(sql);
		try (Connection conn = new ConnectionFactory().getConnection()) {
			ps = conn.prepareStatement(sql); // preparar a clausula sql do banco
			ps.setLong(1, p.getCpf());
			ps.setString(2, p.getNome());
			ps.setInt(3, p.getIdade());
			ps.setLong(4, p.getRg());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Error ao inserir uma pessoa no banco!");
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void remover(Pessoa p) {
		try (Connection conn = new ConnectionFactory().getConnection()) {
			PreparedStatement ps = conn.prepareStatement("delete from nomeTabela where cpf = ?");
			ps.setLong(1, p.getCpf());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error ao deletar uma pessoa do banco");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public ArrayList<Pessoa> listar() {
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		String sql = "select * from pessoas";
		PreparedStatement ps;
		try (Connection conn = new ConnectionFactory().getConnection()) {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pessoa p = new Pessoa();
				p.setCpf(rs.getLong("cpf"));
				p.setNome(rs.getString("nome"));
				p.setIdade(rs.getInt("idade"));
				p.setRg(rs.getInt("rg"));
				pessoas.add(p);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error ao listar pessoas do banco!");
		}
		return pessoas;

	}

	@Override
	public void alterar(Pessoa p) {
		String sql = "update nomeTabela set nome=?, cpf= ? where cpf = ?";
		try (Connection conn = new ConnectionFactory().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(2, p.getNome());
			ps.setLong(1, p.getCpf());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error ao atualizar uma pessoa do banco");
			System.out.println(e.getMessage());
		}

	}

	public ArrayList<Pessoa> buscarPorNome(String nome) {
		String sql = "select * from pessoas where nome like ?";
		PreparedStatement ps;
		ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();
		try (Connection conn = new ConnectionFactory().getConnection()) {
			ps = conn.prepareStatement(sql);
			ps.setString(1,nome+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pessoa p1 = new Pessoa();
				p1.setCpf(rs.getLong("cpf"));
				p1.setNome(rs.getString("nome"));
				p1.setIdade(rs.getInt("idade"));
				p1.setRg(rs.getLong("rg"));
				pessoa.add(p1);
				System.out.println(p1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error ao listar pessoas do banco!");
		}
		return pessoa;
	}
	
	public ArrayList<Pessoa> buscarPorRg(long rg) {
		String sql = "select * from pessoas where rg = ?";
		PreparedStatement ps;
		ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();
		try (Connection conn = new ConnectionFactory().getConnection()) {
			ps = conn.prepareStatement(sql);
			ps.setLong(1,rg);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pessoa p1 = new Pessoa();
				p1.setCpf(rs.getLong("cpf"));
				p1.setNome(rs.getString("nome"));
				p1.setIdade(rs.getInt("idade"));
				p1.setRg(rs.getLong("rg"));
				pessoa.add(p1);
				System.out.println(p1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error ao listar pessoas do banco!");
		}
		return pessoa;
	}

}
