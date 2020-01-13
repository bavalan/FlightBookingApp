/**
 * 
 */

package user;

import java.io.Serializable;

/**
 * A class to represent a client.
 */
public class Client extends User implements Serializable {

  // Variables that define a client.
  private String firstName;
  private String lastName;
  private String email;
  private Billing billing;

  /**
   * The client is created.
   * 
   * @param firstName The first name of the client.
   * @param lastName The last name of the client.
   * @param email The email of the Client.
   * @param billing The bill that the Client will receive when a flight is booked.
   */
  public Client(String lastName, String firstName, String email, Billing billing) {
    // Just to temp fix error
    super(null, null);
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.billing = billing;
  }

  /**
   * Get the first name of the Client.
   * 
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Set the first name of the Client.
   * 
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Get the last name of the Client.
   * 
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Set the last name of the Client.
   * 
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Get the email of the Client.
   * 
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Get the bill of the Client by calling the Billing class.
   * 
   * @return the billing
   */
  public Billing getBilling() {
    return billing;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return String.format("%s;%s;%s;%s", lastName, firstName, email, billing.toString());
  }
}
