package com.springk.apidemos.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.RestController;
import com.springk.apidemos.Dao.User;
import com.springk.apidemos.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DemoAPi {


    @Autowired
    private UserService userService;



    @GetMapping("/api/getuser/{userid}")
    public ResponseEntity<?> getUserByVariable(@PathVariable int userid)
    {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(userid));
    }

    @GetMapping("/api/getuser")
    public ResponseEntity<?> getUserByQuery(@RequestParam int userid)
    {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(userid));
    }


    @GetMapping("/getcsrfToken")
    public ResponseEntity<?> getUserByQuery(HttpServletRequest request)
    {
        CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        return ResponseEntity.status(HttpStatus.OK).body(csrf);
    }
    
    @PostMapping("/api/addUser")
    public ResponseEntity<?> addUser(@ModelAttribute User user )
    {
        System.out.println(user);

        String status=userService.addUserDetails(user);

        if (status.equals("saved")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ReponseMessage("The user details successfully saved into database","success",HttpStatus.CREATED.value()));
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("The users details not saved");
    }

    @PostMapping("/api/addUserJ")
    public ResponseEntity<?> addUser1(@RequestBody User user)
    {
        System.out.println(user);

        String status=userService.addUserDetails(user);

        if (status.equals("saved")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ReponseMessage("The user details successfully saved into database","success",HttpStatus.CREATED.value()));
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("The users details not saved");
    }


    
    public static class ReponseMessage
    {
        private String message;
        private int statusCode;
        private String status;

        public ReponseMessage(String message,String status,int statusCode)
        {
            this.message=message;
            this.status=status;
            this.statusCode=statusCode;
        }

        public String getMessage()
        {
            return message;
        }

        public int getStatusCode()
        {
            return statusCode;
        }

        public String getStatus()
        {
            return status;
        }


        public void setMessage(String message)
        {
            this.message=message;
        }

        public void setStatusCode(int statusCode)
        {
            this.statusCode=statusCode;
        }


        public void setStatus(String status)
        {
            this.status=status;
        }



    }

    
}
