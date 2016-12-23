package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Todo;
import com.example.form.TodoForm;
import com.example.service.TodoService;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	/**
	 * 全件取得
	 * @param offset
	 * @param limit
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public Page<Todo> findJAll(@RequestParam(name="offset") Integer offset, @RequestParam(name="limit") Integer limit) {
		return todoService.findAll(offset, limit);
	}
	
	/**
	 * 登録
	 * @param form
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Todo create(@Valid @RequestBody TodoForm form) {
		Todo todo = new Todo();
		BeanUtils.copyProperties(form, todo);
		return todoService.create(todo);
	}
	
	/**
	 * 削除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		Todo todo = todoService.findById(id);
		todoService.delete(todo);
	}
}
