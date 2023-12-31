package com.example.demo.controller;

import java.util.List;

import javax.naming.directory.InvalidAttributesException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.user_dto;
import com.example.demo.service.user_service;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.mail.MessagingException;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping(value = "/api/user")
public class user_controller {
	@Autowired
	private user_service user_service;
	
	@GetMapping
	public ResponseEntity<Object> getAllUser(){
		List<user_dto> users = user_service.getAllUser();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	@GetMapping("/{iduser}")
	public ResponseEntity<Object> getUserById(@PathVariable("iduser") int iduser){
		user_dto find_user = user_service.getUserById(iduser);
		return new ResponseEntity<Object>(find_user, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Object> createUser(@RequestBody user_dto user){
		user_dto save_user = user_service.createUser(user);
		return new ResponseEntity<Object>(save_user, HttpStatus.CREATED);	
	}
	@PutMapping("/{iduser}")
	public ResponseEntity<Object> updateUser(@PathVariable("iduser") int iduser, @RequestBody user_dto user){
		user.setIduser(iduser);
		user_dto updated_user = user_service.updateUser(user);
		return new ResponseEntity<Object>(updated_user, HttpStatus.OK);	
	}
	@DeleteMapping("/{iduser}")
	public ResponseEntity<String> deleteUser(@PathVariable("iduser") int iduser){
		user_service.deleteUser(iduser);
		return new ResponseEntity<String>("User successfully deleted", HttpStatus.OK);
	}
	@PutMapping(value = "/login")
	public ResponseEntity<Object> login(@RequestBody List<String> list){
		try {
	        user_dto foundUser = user_service.login(list);

	        if (foundUser != null) {
	            // Trả về dữ liệu người dùng khi xác thực thành công
	            return new ResponseEntity<Object>(foundUser, HttpStatus.OK);
	        } else {
	            // Trả về một JSON với giá trị null khi xác thực không thành công
	            return new ResponseEntity<Object>("Sai tài khoản hoặc mật khẩu", HttpStatus.ALREADY_REPORTED);
	        }
	    } catch(SecurityException e) {
	    	return new ResponseEntity<>("Tài khoản đăng nhập ở 1 nơi khác", HttpStatus.ACCEPTED);
	    } 
		catch (Exception e) {
	        // Xử lý các trường hợp lỗi và trả về một JSON với giá trị null
	        return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	@PutMapping(value = "/logout")
	public ResponseEntity<String> logout(@RequestBody user_dto dto){
		user_service.updateUser(dto);
		return new ResponseEntity<String>("User successfully logged out", HttpStatus.OK);
	}
	@PutMapping(value = "/rank")
	public ResponseEntity<Object> getTop10(){
		List<user_dto> list = user_service.getTopTen();
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}
	@PutMapping(value = "/reset_password")
    public ResponseEntity<Integer> reset_password(@RequestBody String gmail) {
        return ResponseEntity.ok(user_service.reset_password(gmail));
    }
	@PutMapping(value = "/cofirm_gmail")
    public ResponseEntity<Object> cofirm_gmail(@RequestBody List<String> list) {
        try {
        	int token = user_service.cofirm_gmail(list);
        	return new ResponseEntity<Object>(token, HttpStatus.OK);
        }
        catch (InvalidAttributesException e) {
			// TODO: handle exception
        	return new ResponseEntity<Object>("Gmail đã tồn tại", HttpStatus.ALREADY_REPORTED);
        	
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Object>("Tên đã tồn tại", HttpStatus.ALREADY_REPORTED);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Object>("Gmail không tồn tại", HttpStatus.ALREADY_REPORTED);
		}
    }
	@PutMapping(value = "/update_password")
	public void update_password(@RequestBody List<String> list ) {
		System.out.println("Vô");
	    user_service.update_password(list);
	    // Không cần trả về gì từ controller nếu không muốn
	}
}
