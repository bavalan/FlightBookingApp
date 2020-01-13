package user;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A class to store the billing information.
 */
public class Billing implements Serializable {

  private String address;
  private String cardNum;
  private Date expDate;
  private static DateFormat date = new SimpleDateFormat("yyyy-MM-dd");

  /**
   * Initialize the billing information when a flight is booked.
   * 
   * @param address The address of the Client.
   * @param cardNum The credit card number of the Client.
   * @param expDate The expire date of the credit card.
   */
  public Billing(String address, String cardNum, Date expDate) {
    this.address = address;
    this.cardNum = cardNum;
    this.expDate = expDate;
  }


  /**
   * Get the address of the Client.
   * 
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Set the address of the Client.
   * 
   * @param address the address to set
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Get the credit card number of the Client.
   * 
   * @return the cardNum
   */
  public String getCardNum() {
    return cardNum;
  }

  /**
   * Set the credit card number of the Client.
   * 
   * @param cardNum the cardNum to set
   */
  public void setCardNum(String cardNum) {
    this.cardNum = cardNum;
  }

  /**
   * Get the expire date of the credit card.
   * 
   * @return the expDate
   */

  public Date getExpDate() {
    return expDate;
  }

  /**
   * Set the expire date of the credit card.
   * 
   * @param expDate the expDate to set
   */
  public void setExpDate(Date expDate) {
    this.expDate = expDate;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return String.format("%s;%s;%s", address, cardNum, date.format(expDate));
  }
}
