package no.engevik.fish.integration;

import no.engevik.fish.core.Fish;
import no.engevik.fish.core.FishRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class H2FishRepository implements FishRepository {

    private static final FishRowMapper fishRowMapper = new FishRowMapper();
    private final JdbcTemplate jdbc;

    public H2FishRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public String save(Fish fish) {
        final String sql = "insert into fish (id, name, species, lengthInCm, weightInKg) values (?, ?, ?, ?, ?)";
        jdbc.update(sql, fish.getId(), fish.getName(), fish.getSpecies(), fish.getLengthInCm(), fish.getWeightInKg());
        return fish.getId();
    }

    @Override
    public void update(Fish fish) {
        final String sql = "update fish set (name = ?, species = ?, lengthInCm = ?, weightInKg = ?) where id = ?";
        jdbc.update(sql, fish.getName(), fish.getSpecies(), fish.getLengthInCm(), fish.getWeightInKg(), fish.getId());
    }

    @Override
    public List<Fish> list() {
        final String sql = "select * from fish";
        return jdbc.query(sql, fishRowMapper);
    }

    @Override
    public Fish getById(String id) {
        final String sql = "select * from fish where id = ?";
        return jdbc.query(sql, fishRowMapper, id).getFirst();
    }

    @Override
    public void delete(String id) {
        final String sql = "delete from fish where id = ?";
        jdbc.update(sql, id);
    }

    private static class FishRowMapper implements RowMapper<Fish> {
        @Override
        public Fish mapRow(ResultSet rs, int rowNum) throws SQLException {
            try {
                return new Fish(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("species"),
                        rs.getDouble("lengthInCm"),
                        rs.getDouble("weightInKg")
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
