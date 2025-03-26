package todo.todo.dto;

import lombok.Getter;
import todo.todo.entity.Todo;

import java.time.LocalDateTime;

@Getter
public class TodoResponseDto {

    private final Long id;
    private final String todo;
    private final String author;
    private String pw;
    private final LocalDateTime created;
    private LocalDateTime modified;

    public TodoResponseDto(Todo todo){
        this.id = todo.getId();
        this.todo = todo.getTodo();
        this.author = todo.getAuthor();
        this.pw = todo.getPw();
        this.created = todo.getCreated();
        this.modified = todo.getModified();
    }

    public TodoResponseDto(Long id, String todo, String author, LocalDateTime created, LocalDateTime modified) {
        this.id = id;
        this.todo = todo;
        this.author = author;
        this.created = created;
        this.modified = modified;
    }

}
