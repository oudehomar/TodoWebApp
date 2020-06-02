package todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import todo.model.Todo;
import todo.repositories.TodoRepository;

@RestController
@RequestMapping("/todo")
public class TodoController {
	
	
	@Autowired
	TodoRepository todoRepository;
	
	
	@GetMapping("/findall")
	public List<Todo> fetchAll(){
		
		
		return this.todoRepository.findAll();
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addTodo(@RequestBody Todo todo ){
		
		return new ResponseEntity<>(this.todoRepository.save(todo),HttpStatus.CREATED);
		
	}
	
	
	
	

}
