package todo.todo.repository;

import todo.todo.dto.TodoResponseDto;
import todo.todo.entity.Todo;

import java.util.List;
import java.util.Optional;


public interface TodoRepository {

    TodoResponseDto saveTodo(Todo todo);

    List<TodoResponseDto> findAllTodos();

    Optional<Todo> findTodoById(Long id);

    Todo findTodoByIdOrElseThrow(Long id);

    int updateTodo(Long id, String todo, String author, String pw);

    int deleteTodo(Long id, String pw);
}
