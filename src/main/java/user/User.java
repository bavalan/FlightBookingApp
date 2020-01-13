/**
 * 
 */

package user;

import java.io.Serializable;

/**
 * A class to represent a user.
 */

// Used for checkstyle, fixes the unused items in class
@SuppressWarnings("unused")
public class User implements Serializable{

  // Variables to be initiated in Phase 3
  private String username;
  private String password;

  /**
   * Creating a user for the app either an admin or client.
   * 
   * @param username The username used for the account.
   * @param password The password for the account.
   */
  public User(String username, String password) {
    this.username = username;
    this.password = password;

  }


}
