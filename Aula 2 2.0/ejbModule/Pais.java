import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Pais {

	private int id;
	private String nome;
	private long populacao;
	private double area;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Pais() {
	}
	
	public Pais(int id, String nome, long populacao, double area) {
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}
	
	// Obtém conexão com o banco de dados
		public Connection obtemConexao() throws SQLException {
			return DriverManager
					.getConnection("jdbc:mysql://localhost:3306/aula2?useTimezone=true&serverTimezone=America/Sao_Paulo&user=root&password=djow2001");
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
	
	public void criar() {
		String sqlInsert = "INSERT INTO pais(nome, populacao, area) VALUES (?, ?, ?);";
		try(Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			stm.setString(1, getNome());
			stm.setLong(2, getPopulacao());
			stm.setDouble(3, getArea());
			stm.execute();
			String sqlQuery  = "SELECT LAST_INSERT_ID();";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
			ResultSet rs = stm2.executeQuery();) {
				if(rs.next()){
					setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar() {
		String sqlUpdate = "UPDATE pais SET nome = ?, populacao = ?, area = ? WHERE id = ?;";
		try(Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
			stm.setString(1, getNome());
			stm.setLong(2, getPopulacao());
			stm.setDouble(3, getArea());
			stm.setInt(4, getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir() {
		String sqlDelete = "DELETE FROM pais WHERE id = ?;";
		try(Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			stm.setInt(1, getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void carregar() {
		String sqlSelect = "SELECT nome, populacao, area FROM pais WHERE pais.id = ?;";
		try(Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, getId());
			try(ResultSet rs = stm.executeQuery();){
				if (rs.next()) {
					setNome(rs.getString("nome"));
					setPopulacao(rs.getLong("populacao"));
					setArea(rs.getDouble("area"));
				} else {
					setId(-1);
					setNome(null);
					setPopulacao(-1);
					setArea(-1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}
	
	public void maiorHabitante() {
		String sqlpopulacao = "SELECT nome FROM PAIS ORDER BY populacao ASC limit 1;";
		try(Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlpopulacao)){
			try(ResultSet rs = stm.executeQuery();){
				if (rs.next()) {
					setNome(rs.getString("nome"));
					System.out.println("O pais com a maior população é " + getNome());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}
	
	public void menorArea() {
		String sqlarea = "SELECT nome FROM pais ORDER BY area ASC limit 1;";
		try(Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlarea);){
			try(ResultSet rs = stm.executeQuery();){
				if (rs.next()) {
					setNome(rs.getString("nome"));
					System.out.println("O pais com a menor area é " + getNome());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}
	
	public void criaVetor() {
		ArrayList <Pais> pais = new ArrayList<>();
		String sqlvet = "SELECT nome FROM pais limit 3;";
		try(Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlvet);){
			try(ResultSet rs = stm.executeQuery();){
				if (rs.next()) {
					for(Pais p: pais) {
						
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}
}
