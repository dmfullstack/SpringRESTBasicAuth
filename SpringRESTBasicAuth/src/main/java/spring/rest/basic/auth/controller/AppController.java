package spring.rest.basic.auth.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AppController {
    //-------------------Retrieve All Users--------------------------------------------------------
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<String>> listAllUsers() {
        List<String> users = new ArrayList<String>(Arrays.asList("Tamas","John","Kate"));
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
  
  
    //-------------------Retrieve Single User--------------------------------------------------------
      
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        if (id == 1) {
        	return ResponseEntity.status(HttpStatus.OK).body("Tamas");
        }
        else if (id == 2) {
        	return ResponseEntity.status(HttpStatus.OK).body("John");
        }
        else if (id == 3) {
        	return ResponseEntity.status(HttpStatus.OK).body("Kate");
        }
        else  {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        }
    }
  
      
      
    //-------------------Create a User--------------------------------------------------------
      
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser() {
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
  
      
    //------------------- Update a User --------------------------------------------------------
      
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(@PathVariable("id") long id) {
        System.out.println("Updating User " + id);
		return new ResponseEntity<Void>(HttpStatus.OK);
    }
  
    //------------------- Delete a User --------------------------------------------------------
      
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
  
      
    //------------------- Delete All Users --------------------------------------------------------
      
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAllUsers() {
        System.out.println("Deleting All Users");
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
