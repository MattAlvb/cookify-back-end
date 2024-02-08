package io.github.mattalvb.cookify.domain.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import io.github.mattalvb.cookify.domain.entity.Assinante;

@Repository
public class Assinantes {
    private static String INSERT = "insert into assinante (nome) values (?) ";
    private static String SELECT_ALL = "SELECT * FROM ASSINANTE";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("null")
    public Assinante salvar (Assinante assinante){
        jdbcTemplate.update(INSERT, assinante.getNome());
        return assinante;
    }

    public java.util.List<Assinante> obterTodos(){
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Assinante>(){
            @Override
            public Assinante mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                return new Assinante(id, nome);
            }
        });
    }
}
