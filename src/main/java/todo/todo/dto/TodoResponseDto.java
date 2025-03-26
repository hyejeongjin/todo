package todo.todo.dto;

import lombok.Getter;
import todo.todo.entity.Todo;

import java.time.LocalDate;

@Getter
public class TodoResponseDto {

    private final Long id;
    private final String todo;
    private final String author;
    private String pw;
    private final LocalDate created;
    private LocalDate modified;

    public TodoResponseDto(Todo todo){
        this.id = todo.getId();
        this.todo = todo.getTodo();
        this.author = todo.getAuthor();
        this.pw = todo.getPw();
        this.created = todo.getCreated();
        this.modified = todo.getModified();
    }

    public TodoResponseDto(Long id, String todo, String author, LocalDate created, LocalDate modified) {
        this.id = id;
        this.todo = todo;
        this.author = author;
        this.created = created;
        this.modified = modified;
    }

}
