package flight;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * A representation of a flight.
 */
public class Flight {

  private String flightNum; // the flight number of this flight
  private String airline; // the airline of this flight
  private Date departure; // the departure date of this flight
  private Date arrival; // the arrival date of this flight
  private String origin; // the origin of this flight
  private String destination; // the destination of this flight
  private Double cost; // the cost of this flight
  private Duration travelTime;
  private static DateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");

  /**
   * Creates a new flight.
   * 
   * @param flightNum The flight number of this flight.
   * @param airline The airline of this flight.
   * @param departure The departure date of this flight.
   * @param arrival The arrival date of this flight.
   * @param origin The origin of this flight.
   * @param destination The destination of this flight.
   * @param cost The cost of this flight.
   */
  public Flight(String flightNum, Date departure, Date arrival, String airline, String origin,
      String destination, Double cost) {
    this.flightNum = flightNum;
    this.airline = airline;
    this.departure = departure;
    this.arrival = arrival;
    this.origin = origin;
    this.destination = destination;
    this.cost = cost;

    Instant depart = departure.toInstant();
    Instant arrive = arrival.toInstant();
    this.travelTime = Duration.between(depart, arrive);
  }

  /**
   * Returns the travel time.
   * @return the travelTime
   */
  public Duration getTravelTime() {
    return travelTime;
  }

  /**
   * Returns the flight number of this flight.
   * 
   * @return flightNum the flight number
   */
  public String getFlightNum() {
    return flightNum;
  }

  /**
   * Sets the flight number of this flight.
   * 
   * @param flightNum the flight number to set
   */
  public void setFlightNum(String flightNum) {
    this.flightNum = flightNum;
  }

  /**
   * Returns the airline name of this flight.
   * 
   * @return airline the airline name
   */
  public String getAirline() {
    return airline;
  }

  /**
   * Sets the airline name of this flight.
   * 
   * @param airline the airline name
   */
  public void setAirline(String airline) {
    this.airline = airline;
  }

  /**
   * Returns the departure date of this flight.
   * 
   * @return departure the departure date
   */
  public Date getDeparture() {
    return departure;
  }

  /**
   * Formats the date to yyyy-MM-dd.
   * 
   * @return The formated date from yyyy-MM-dd HH:mm to yyyy-MM-dd
   */
  public String getFormatDeparture() {
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    return date.format(getDeparture());

  }

  /**
   * Sets the departure date of this flight.
   * 
   * @param departure the departure date
   */
  public void setDeparture(Date departure) {
    this.departure = departure;
  }

  /**
   * Returns the arrival date of this flight.
   * 
   * @return arrival the arrival date
   */
  public Date getArrival() {
    return arrival;
  }

  /**
   * Sets the arrival date of this flight.
   * 
   * @param arrival the arrival date
   */
  public void setArrival(Date arrival) {
    this.arrival = arrival;
  }

  /**
   * Returns the origin of this flight.
   * 
   * @return origin the origin
   */
  public String getOrigin() {
    return origin;
  }

  /**
   * Sets the origin of this flight.
   * 
   * @param origin the origin
   */
  public void setOrigin(String origin) {
    this.origin = origin;
  }

  /**
   * Returns the destination of this flight.
   * 
   * @return destination the destination
   */
  public String getDestination() {
    return destination;
  }

  /**
   * Sets the destination of this flight.
   * 
   * @param destination the destination
   */
  public void setDestination(String destination) {
    this.destination = destination;
  }

  /**
   * Returns the cost of this flight.
   * 
   * @return cost the cost
   */
  public Double getCost() {
    return cost;
  }

  /**
   * Sets the cost of this flight.
   * 
   * @param cost the cost
   */
  public void setCost(Double cost) {
    this.cost = cost;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((flightNum == null) ? 0 : flightNum.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    // if flight number is equal, flights are equal.
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Flight other = (Flight) obj;
    if (flightNum == null) {
      if (other.flightNum != null) {
        return false;
      }
    } else if (!flightNum.equals(other.flightNum)) {
      return false;
    }
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return String.format("%s;%s;%s;%s;%s;%s;%.2f", flightNum, dateTime.format(departure),
        dateTime.format(arrival), airline, origin, destination, cost);
  }
}
