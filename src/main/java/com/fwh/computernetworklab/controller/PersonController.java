package com.fwh.computernetworklab.controller;

import com.fwh.computernetworklab.domain.Person;
import com.fwh.computernetworklab.domain.Role;
import com.fwh.computernetworklab.service.PersonService;
import com.fwh.computernetworklab.util.ReqPerson;
import com.fwh.computernetworklab.util.RespResult;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(HttpServletRequest request) throws UnknownHostException {
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemoteHost());
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        return "";
    }


    /**
     * User register with whose username and password
     * @param reqPerson
     * @return Success message
     * @throws ServletException
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestBody() ReqPerson reqPerson) throws ServletException {
        // Check if username and password is null
        if (reqPerson.getUsername() == "" || reqPerson.getUsername() == null
                || reqPerson.getPassword() == "" || reqPerson.getPassword() == null)
            throw new ServletException("Username or Password invalid!");

        // Check if the username is used
        if(personService.findPersonByUsername(reqPerson.getUsername()) != null)
            throw new ServletException("Username is used!");

        // Give a default role : MEMBER
        List<Role> roles = reqPerson.getRoles();

        // Create a person in ignite
        personService.save(new Person(reqPerson.getUsername(), reqPerson.getPassword(), roles));

        String result = "0";
        return result;
    }

    /**
     * Check user`s login info, then create a jwt token returned to front end
     * @param reqPerson
     * @return jwt token
     * @throws ServletException
     */
    @PostMapping(value = "/login")
    public String login(@RequestBody() ReqPerson reqPerson) throws ServletException {
        // Check if username and password is null
        if (reqPerson.getUsername() == "" || reqPerson.getUsername() == null
                || reqPerson.getPassword() == "" || reqPerson.getPassword() == null)
            throw new ServletException("Please fill in username and password");

        // Check if the username is used
        if(personService.findPersonByUsername(reqPerson.getUsername()) == null
                || !reqPerson.getPassword().equals(personService.findPersonByUsername(reqPerson.getUsername()).getPassword())){
            throw new ServletException("Please fill in username and password");
        }

        Person person = personService.findPersonByUsername(reqPerson.getUsername());

        // Create Twt token
        String jwtToken = Jwts.builder().setSubject(reqPerson.getUsername()).claim("roles", person.getRoles()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
        return jwtToken;
    }

    /**
     * 获取数据库中所有Person对象
     * @return 一个Iterable<Person>变量
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Iterable<Person> getAll(){
        return personService.findAll();
    }
}
