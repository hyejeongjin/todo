package todo.todo.repository;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;
import todo.todo.dto.TodoResponseDto;
import todo.todo.entity.Todo;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Repository
public class JdbcTemplateTodoRepository implements TodoRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateTodoRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public TodoResponseDto saveTodo(Todo todo) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("todo").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("todo", todo.getTodo());
        parameters.put("author", todo.getAuthor());
        parameters.put("pw", todo.getPw());
        parameters.put("created", todo.getCreated());
        parameters.put("modified", todo.getModified());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

        return new TodoResponseDto(key.longValue(), todo.getTodo(), todo.getAuthor(), todo.getCreated(), todo.getModified());
    }

    /*@Override
    public List<TodoResponseDto> findAllTodos() {

        String sql = "select * from todo order by modified desc";


        return jdbcTemplate.query(sql, todoRowMapper());
    }*/

    @Override
    public List<TodoResponseDto> findAllTodos(String author, LocalDate modified) {

        StringBuilder sql = new StringBuilder("select id, todo, author, created, modified from todo where 1=1");
        List<Object> list = new ArrayList<>();

        // 둘 다 충족하는 경우
        if(author != null && !author.isEmpty() && modified != null){
            sql.append(" and author = ? and modified = ? ");
            list.add(author);
            list.add(modified);

        // 둘 중에 하나 충족하는 경우
        }else if(author != null && !author.isEmpty() || modified != null){
            if(author != null && !author.isEmpty()){
                sql.append(" and author = ?");
                list.add(author);
            }else if(modified != null){
                sql.append(" and modified = ?");
                list.add(modified);
            }
        }
        sql.append(" order by modified desc");

        return jdbcTemplate.query(sql.toString(), list.toArray(), todoRowMapper());
    }

    @Override
    public Optional<Todo> findTodoById(Long id) {
        List<Todo> result = jdbcTemplate.query("select * from todo where id = ?", todoRowMapperV2(), id);
        return result.stream().findAny();
    }


    @Override
    public Todo findTodoByIdOrElseThrow(Long id) {
        List<Todo> result = jdbcTemplate.query("select * from todo where id = ?", todoRowMapperV2(), id);

        // Optional<Todo> 대신 exception 던지는 용으로 사용. 그래서 Optional<Todo>로 할 필요가 없음.
        return result.stream().findAny().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exists id = " + id));
    }


    @Override
    public int updateTodo(Long id, String todo, String author, String pw) {

        return jdbcTemplate.update("update todo set todo = ?, author = ?, modified = CURRENT_TIMESTAMP where id = ?", todo, author, id);
    }

    @Override
    public int deleteTodo(Long id, String pw) {
        return jdbcTemplate.update("delete from todo where id = ?", id);
    }


    private RowMapper<TodoResponseDto> todoRowMapper(){

        return new RowMapper<TodoResponseDto>(){

            @Override
            public TodoResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new TodoResponseDto(
                        rs.getLong("id"),
                        rs.getString("todo"),
                        rs.getString("author"),
                        rs.getTimestamp("created").toLocalDateTime(),
                        rs.getTimestamp("modified").toLocalDateTime()
                );
            }
        };
    }

    private RowMapper<Todo> todoRowMapperV2(){
        return new RowMapper<Todo>() {
            @Override
            public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Todo(
                        rs.getLong("id"),
                        rs.getString("todo"),
                        rs.getString("author"),
                        rs.getString("pw"),
                        rs.getTimestamp("created").toLocalDateTime(),
                        rs.getTimestamp("modified").toLocalDateTime()
                );
            }
        };
    }


}
