package todo.todo.dto;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class TodoRequestDto {

    private String todo;
    private String author;
    private String pw;
    private Timestamp created;
    private Timestamp modified;

}
