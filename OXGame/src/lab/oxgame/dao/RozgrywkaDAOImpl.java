package lab.oxgame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import lab.oxgame.datasource.DataSource;
import lab.oxgame.engine.OXEnum;
import lab.oxgame.model.rozgrywka;

public class RozgrywkaDAOImpl implements RozgrywkaDAO {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(RozgrywkaDAOImpl.class);
	
	public int zapiszRozgrywke(rozgrywka rozgrywka) {
		int liczbaDodanychWierszy = 0;
		String query = "Insert into rozgrywka(zwyciezca, gracz_o, gracz_x, dataczas_rozgrywki) values (?,?,?,?)";
	try(Connection connect = DataSource.getConnection();
			PreparedStatement preparedStmt = connect.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)){
		preparedStmt.setString(1,rozgrywka.getZwyciezca().toString());
		preparedStmt.setString(2,rozgrywka.getGraczO());
		preparedStmt.setString(3,rozgrywka.getGraczX());
		preparedStmt.setObject(4,rozgrywka.getDataczasRozgrywki());
		
		if(((liczbaDodanychWierszy) = preparedStmt.executeUpdate()) > 0){
			try(ResultSet key = preparedStmt.getGeneratedKeys();){
				if(key.next())
					rozgrywka.setRozgrywkaId(key.getInt(1));
			}
		}
	}catch(SQLException e) {
		logger.error("B³¹d podczas zapisywania rozgrywki!", e);
	}
	return liczbaDodanychWierszy;
	}
	public List<rozgrywka> pobierzRozgrywki(Integer odWiersza, Integer liczbaWierszy){
		List<rozgrywka> listaRozgrywek = new ArrayList<>();
		String query = "Select * from rozgrywka order by dataczas_rozgrywki DESC"
				+(odWiersza != null ?" OFFSET ?":"")
				+(liczbaWierszy != null ? " LIMIT ?" : "");
		try(Connection connect = DataSource.getConnection(); PreparedStatement preparedStmt = connect.prepareStatement(query)){
			if(odWiersza !=null) 
				preparedStmt.setInt(1, odWiersza);
			if(liczbaWierszy != null)
				preparedStmt.setInt(odWiersza != null ? 2: 1, liczbaWierszy);
			ResultSet rs = preparedStmt.executeQuery();
			while(rs.next()) {
				rozgrywka rozgrywka = new rozgrywka(
						rs.getInt("rozgrywka_id"),
						rs.getString("gracz_o"),
						rs.getString("gracz_x"),
						OXEnum.fromString(rs.getString("zwyciezca")),
						rs.getTimestamp("dataczas_rozgrywki").toLocalDateTime());
				listaRozgrywek.add(rozgrywka);
			}
		} catch (SQLException e) {
			logger.error("B³¹d podczas pobierania rozgrywki!", e);
		}
		return listaRozgrywek;
		
	}
	@Override
	public int usunRozgrywki() {
		int liczbaUsunietychWierszy = 0;
		String query = "Delete from rozgrywka";
		try(Connection connect = DataSource.getConnection();
				Statement stmt = connect.createStatement()){
			liczbaUsunietychWierszy = stmt.executeUpdate(query);
		}catch (SQLException e){
			logger.error("B³¹d podczas usuwania rozgrywki!", e);
		}
		return liczbaUsunietychWierszy;
	}
}
