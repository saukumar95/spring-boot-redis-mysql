package com.saurabh.springbootrediscachedb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saurabh.springbootrediscachedb.domain.Student;
import com.saurabh.springbootrediscachedb.service.RedisService;
import com.saurabh.springbootrediscachedb.vo.ResponseVO;

@RestController
public class RedisController {

	@Autowired
	private RedisService redisService;

	private ResponseVO responseVO = new ResponseVO();

	@PostMapping("/student")
	public ResponseVO save(@Valid @RequestBody Student student) {
		try {
			boolean status = redisService.save(student);
			if (status) {
				responseVO.setStatus(String.valueOf(status));
				responseVO.setStatusCode(HttpStatus.CREATED.value());
				responseVO.setMessage("SAVED_SUCCESSFULLY");
			} else {
				responseVO.setStatus(String.valueOf(status));
				responseVO.setStatusCode(HttpStatus.BAD_REQUEST.value());
				responseVO.setMessage("FAILED_TO_SAVE");
			}
		} catch (Exception ex) {
			responseVO.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseVO.setMessage("Due to some technical error.");
			ex.printStackTrace();
		}
		return responseVO;
	}

	@GetMapping("/student/{id}")
	public ResponseVO getStudentById(@PathVariable Integer id) {
		try {
			System.out.println("Searching by ID  : " + id);
			Student student = redisService.getStudentById(id);
			if (null != student) {
				responseVO.setResponseData(student);
				responseVO.setStatus(HttpStatus.OK.name());
				responseVO.setStatusCode(HttpStatus.OK.value());
				responseVO.setMessage("Record fetched successfully.");
			} else {

				responseVO.setStatus(HttpStatus.BAD_REQUEST.name());
				responseVO.setStatusCode(HttpStatus.BAD_REQUEST.value());
				responseVO.setMessage("Error while fetching record.");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			responseVO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
			responseVO.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseVO.setMessage("Due to some techincal error.");
		}

		return responseVO;
	}

}
