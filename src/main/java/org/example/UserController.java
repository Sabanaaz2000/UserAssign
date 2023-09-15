//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    List<org.saba.UserManagementSystem.User> myUser;

    public UserController() {
    }

    @PostMapping({"user"})
    public String addUser(@RequestBody org.saba.UserManagementSystem.User newUser) {
        this.myUser.add(newUser);
        return "New User added successfully";
    }

    @GetMapping({"user/{id}"})
    public ResponseEntity<org.saba.UserManagementSystem.User> getUserById(@PathVariable Integer id) {
        Iterator var2 = this.myUser.iterator();

        org.saba.UserManagementSystem.User user;
        do {
            if (!var2.hasNext()) {
                return ResponseEntity.notFound().build();
            }

            user = (org.saba.UserManagementSystem.User)var2.next();
        } while(!user.getUserId().equals(id));

        return ResponseEntity.ok(user);
    }

    @GetMapping({"user"})
    public List<org.saba.UserManagementSystem.User> getAllUser() {
        return this.myUser;
    }

    @PutMapping({"user/{userId}"})
    public String setUserUpdate(@PathVariable Integer userId, @RequestBody org.saba.UserManagementSystem.User updatedUser) {
        Iterator var3 = this.myUser.iterator();

        org.saba.UserManagementSystem.User user;
        do {
            if (!var3.hasNext()) {
                return "Invalid id";
            }

            user = (org.saba.UserManagementSystem.User)var3.next();
        } while(!user.getUserId().equals(userId));

        user.setName(updatedUser.getName());
        user.setUserName(updatedUser.getUserName());
        user.setAddress(updatedUser.getAddress());
        user.setPhoneNumber(updatedUser.getPhoneNumber());
        return "User with ID " + userId + " updated successfully";
    }

    @DeleteMapping({"user/{id}"})
    public String removeUser(@PathVariable Integer id) {
        Iterator var2 = this.myUser.iterator();

        org.saba.UserManagementSystem.User user;
        do {
            if (!var2.hasNext()) {
                return "Invalid id";
            }

            user = (org.saba.UserManagementSystem.User)var2.next();
        } while(!user.getUserId().equals(id));

        this.myUser.remove(user);
        return "User with ID " + id + " removed successfully";
    }
}
