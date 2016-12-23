package com.example.form;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * フォーム
 */
@Data
public class TodoForm {
	/** 内容 */
	@Size(max = 3)
	private String content;
}