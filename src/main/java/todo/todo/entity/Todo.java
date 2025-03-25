package todo.todo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import todo.todo.dto.TodoRequestDto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Todo {

    private Long id;
    private String todo;
    private String author;
    private String pw;
    private LocalDateTime created;
    private LocalDateTime modified;

    public Todo(String todo, String author, String pw, LocalDateTime created, LocalDateTime modified){
        this.todo = todo;
        this.author = author;
        //this.pw = pw;
        this.created = created;
        //this.modified = modified;

    }


    public void update(String todo, String author){
        this.todo = todo;
        this.author = author;
    }

}

