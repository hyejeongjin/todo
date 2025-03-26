package todo.todo.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import todo.todo.dto.TodoRequestDto;
import todo.todo.dto.TodoResponseDto;
import todo.todo.entity.Todo;
import todo.todo.repository.TodoRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public TodoResponseDto saveTodo(TodoRequestDto dto) {

        Todo todo = new Todo(dto.getTodo(), dto.getAuthor(), dto.getPw(), LocalDate.now(), LocalDate.now());

        return todoRepository.saveTodo(todo);
    }

    @Override
    public List<TodoResponseDto> findAllTodos(String author, LocalDate modified) {

        return todoRepository.findAllTodos(author, modified);
    }

    @Override
    public TodoResponseDto findTodoById(Long id) {
        Todo todo = todoRepository.findTodoByIdOrElseThrow(id);

        return new TodoResponseDto(todo);
    }

    @Transactional
    @Override
    public TodoResponseDto updateTodo(Long id, String todo, String author, String pw) {
        if(todo == null || author == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title and content are required values.");
        }

        int updatedRow = todoRepository.updateTodo(id, todo, author, pw);

        if(updatedRow == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        Todo todos = todoRepository.findTodoByIdOrElseThrow(id);

        if(!todos.getPw().equals(pw)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Wrong password!!");
        }

        return new TodoResponseDto(todos);
    }

    @Override
    public void deleteTodo(Long id, String pw) {

        Todo todos = todoRepository.findTodoByIdOrElseThrow(id);

        if(!todos.getPw().equals(pw)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Wrong password!!");
        }
        // 먼저 선언해버리면 삭제된 후에 비밀번호 검증을 함.
        int deleteRow = todoRepository.deleteTodo(id, pw);

        if(deleteRow == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

    }
}
