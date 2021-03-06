package taskmanagement.dto;

import java.util.List;

/**
 * DTO used to store a single user information for
 * client side operations.
 * @author David Ramirez
 * @version 0.01
 * Version History
 * [07/26/2015] 0.01 � David Ramirez � Initial codes.
 * [07/27/2015] 0.02 - Jacquelyn Amaya - Added data members id and telephone with getters and setters
 */

public class UserDto {
        private long id;
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private List<String> errorList;
        
        public List<String> getErrorList() {
            return errorList;
        }
        public void setErrorList(List<String> errorList) {
            this.errorList = errorList;
        }
        
        public String getUsername(){
            return username;
        }
        
        public String getPassword(){
            return password;
        }
        
        public String getFirstName(){
            return firstName;
        }
        
        public String getLastName(){
            return lastName;
        }
        
        public void setUsername(String username){
            this.username = username;
        }
        
        public void setPassword(String password){
            this.password = password;
        }
        
        public void setFirstName(String firstName){
            this.firstName = firstName;
        }
        
        public void setLastName(String lastName){
            this.lastName = lastName;
        }
        
        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
}
