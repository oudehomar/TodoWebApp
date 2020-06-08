package todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	
	
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteTodo(@PathVariable Integer id){
		
		if(this.todoRepository.findById(id).isPresent()) {
			this.todoRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<?> updateTodo(@PathVariable Integer id, @RequestBody Todo todo ){
		
		if(this.todoRepository.findById(id).isPresent()) {
			
			todo.setId(id);
			return new ResponseEntity<>(this.todoRepository.save(todo),HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		
		if(this.todoRepository.findById(id).isPresent()) {
			
			return new ResponseEntity<>(this.todoRepository.findById(id),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}
	
	
	

}
