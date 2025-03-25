package todo.todo.service;

import org.springframework.stereotype.Service;
import todo.todo.dto.TodoRequestDto;
import todo.todo.dto.TodoResponseDto;
import todo.todo.entity.Todo;
import todo.todo.repository.TodoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public TodoResponseDto saveTodo(TodoRequestDto dto) {

        Todo todo = new Todo(dto.getTodo(), dto.getAuthor(), dto.getPw(), LocalDateTime.now(), LocalDateTime.now());

        return todoRepository.saveTodo(todo);
    }

    @Override
    public List<TodoResponseDto> findAllTodos() {
        return todoRepository.findAllTodos();
    }

    @Override
    public TodoResponseDto findTodoById(Long id) {
        Todo todo = todoRepository.findTodoByIdOrElseThrow(id);

        return new TodoResponseDto(todo);
    }

    @Override
    public int updateTodo(Long id, String todo, String author) {
        return 0;
    }

    @Override
    public int deleteTodo(Long id) {
        return 0;
    }
}
