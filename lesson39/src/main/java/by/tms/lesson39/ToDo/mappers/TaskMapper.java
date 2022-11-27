package by.tms.lesson39.ToDo.mappers;

import by.tms.lesson39.ToDo.entities.Status;
import by.tms.lesson39.ToDo.entities.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Task.builder()
                .description(rs.getString("description"))
                .status(Status.valueOf(rs.getString("status")))
                .build();
    }
}
