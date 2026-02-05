package com.example.demo;

import org.springframework.stereotype.Repository;

import com.example.demo.types.ReviewerNameAndScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcDAO {
	
	@Autowired
	private NamedParameterJdbcTemplate npjdbct;
	
	/*
	private static final String CREATE_APPLICANTS_TABLE = """
			CREATE TABLE Applicants_t (
			  Applicant_ID INTEGER PRIMARY KEY,
			  First_Name TEXT NOT NULL,
			  Last_Name TEXT NOT NULL
			);
			""";
	
	private static final String INSERT_APPLICANTS = """
			INSERT INTO Applicants_t VALUES (1, 'Harvey', 'Sun');
			INSERT INTO Applicants_t VALUES (2, 'Yi', 'Zhang');
			INSERT INTO Applicants_t VALUES (3, 'Dana', 'Zhang');
			""";
	
	private static final String CREATE_REVIEWERS_TABLE = """
			CREATE TABLE Reviewers_t (
			  Reviewer_ID INTEGER PRIMARY KEY,
			  First_Name TEXT NOT NULL,
			  Last_Name TEXT NOT NULL
			);
			""";
	
	private static final String INSERT_REVIEWERS = """
			INSERT INTO Reviewers_t VALUES (1, 'John', 'Smith');
			INSERT INTO Reviewers_t VALUES (2, 'Jane', 'Doe');
			""";
	
	private static final String CREATE_APPLICATIONS_TABLE = """
			CREATE TABLE Applications_t (
			  Application_ID INTEGER PRIMARY KEY,
			  Applicant_ID INTEGER NOT NULL,
			  FOREIGN KEY (Applicant_ID) REFERENCES Applicants_t(Applicant_ID)
			);
			""";
	
	private static final String INSERT_APPLICATIONS = """
			INSERT INTO Applications_t VALUES (1, 1);
			INSERT INTO Applications_t VALUES (2, 2);
			""";
	
	private static final String CREATE_SCORES_TABLE = """
			CREATE TABLE Scores_t (
			  Score_ID INTEGER PRIMARY KEY,
			  Application_ID TEXT NOT NULL,
			  Reviewer_ID TEXT NOT NULL,
			  Score INTEGER NOT NULL,
			  FOREIGN KEY (Application_ID) REFERENCES Applications_t(Application_ID),
			  FOREIGN KEY (Reviewer_ID) REFERENCES Reviewers_t(Reviewer_ID)
			);
			""";
	
	private static final String INSERT_SCORES = """
			INSERT INTO Scores_t VALUES (1, 1, 1, 10);
			INSERT INTO Scores_t VALUES (2, 1, 2, 20);
			INSERT INTO Scores_t VALUES (3, 1, 2, 30);
			INSERT INTO Scores_t VALUES (4, 2, 1, 40);
			""";
	
	private static final String INITIALIZE_DB = CREATE_APPLICANTS_TABLE 
			+ INSERT_APPLICANTS 
			+ CREATE_REVIEWERS_TABLE 
			+ INSERT_REVIEWERS
			+ CREATE_APPLICATIONS_TABLE
			+ INSERT_APPLICATIONS
			+ CREATE_SCORES_TABLE
			+ INSERT_SCORES;
	*/
	
	private static final String GET_SCORES_AND_REVIEWERS_FOR_APPLICANT = """
			SELECT Reviewers_t.First_Name AS reviewerFirstName, Reviewers_t.Last_Name AS reviewerLastName, Scores_t.Score
			FROM Scores_t
			INNER JOIN Reviewers_t ON Scores_t.Reviewer_ID = Reviewers_t.Reviewer_ID
			INNER JOIN Applications_t ON Scores_t.Application_ID = Applications_t.Application_ID
            INNER JOIN Applicants_t ON Applications_t.Applicant_ID = Applicants_t.Applicant_ID
			WHERE Applicants_t.First_Name = :firstName AND Applicants_t.Last_Name = :lastName;
			""";
	
	/*
	private void setupDB() throws DataAccessException {
		try {
			npjdbct.getJdbcOperations().execute(INITIALIZE_DB);
			System.out.println("[DEBUG] Created DB Tables correctly!");
		} catch (DataAccessException e) {
			System.out.println("[DEBUG] Failed to create DB Tables!");
			throw e;
		}
	}
	*/
	
	public List<ReviewerNameAndScore> getScoresByStudentName(String studentName) throws DataAccessException{
		
		String[] fullName = studentName.split(" ");
		String firstName = fullName[0];
		String lastName = fullName[1];
		
		System.out.println("[DEBUG] firstName = " + firstName + ", lastName = " + lastName);
		
		// Should Exceptions be caught in the DAO or above, in the Service - consider Exception handling further
		try {
			MapSqlParameterSource mp = new MapSqlParameterSource()
					.addValue("firstName", firstName)
					.addValue("lastName", lastName);
			
			return npjdbct.query(GET_SCORES_AND_REVIEWERS_FOR_APPLICANT, mp, new ScoreExtractor());
		} catch (Exception e) {
			System.out.println("Exception in CollegeApplicationsDAO: " + e.getMessage());
			throw e;
		}
	}
	
	private class ScoreExtractor implements ResultSetExtractor<List<ReviewerNameAndScore>> {
		@Override
		public List<ReviewerNameAndScore> extractData(ResultSet rs) throws SQLException {
			BeanPropertyRowMapper<ReviewerNameAndScore> scoreMapper = new BeanPropertyRowMapper<ReviewerNameAndScore>(ReviewerNameAndScore.class);
			List<ReviewerNameAndScore> scores = new ArrayList<ReviewerNameAndScore>();
			
			while (rs.next()) {
				scores.add(scoreMapper.mapRow(rs, rs.getRow()));
			}
			
			return scores;
		}
	}
	
}
