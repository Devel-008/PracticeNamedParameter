package com.student;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import java.io.ByteArrayInputStream;
import java.sql.Types;

public class StudentJDBCTemplate implements StudentDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public void updateDescription(Integer id, String description) {
        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("id", id);
        in.addValue("description",  new SqlLobValue(description, new DefaultLobHandler()), Types.CLOB);

        String SQL = "update Student set description = :description where id = :id";
        NamedParameterJdbcTemplate jdbcTemplateObject = new NamedParameterJdbcTemplate(dataSource);

        jdbcTemplateObject.update(SQL, in);
        System.out.println("Updated Record with ID = " + id );
    }
}
