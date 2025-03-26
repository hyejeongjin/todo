package todo.todo.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class TodoRequestDto {

    private String todo;
    private String author;
    private String pw;
    private LocalDate created;
    private LocalDate modified;

}
