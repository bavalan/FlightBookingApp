package flight;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * A representation of an itinerary.
 */
public class Itinerary {

  private List<Flight> flights; // flights of this itinerary.
  private Double cost; // the cost of this itinerary.
  private Duration travelTime; // the travel time of this itinerary.

  /**
   * Creates a new itinerary. Has base cost of 0.00.
   */
  public Itinerary() {
    this.flights = new ArrayList<Flight>();
    this.cost = 0.00;
    this.travelTime = Duration.ZERO;
  }

  /**
   * Creates a new itinerary with input list of flights.
   * 
   * @param flights the list of flights
   */
  public Itinerary(List<Flight> flights) {
    this.flights = new ArrayList<Flight>(flights);
    if (flights != null && !flights.isEmpty()) {
      Instant departure = flights.get(0).getDeparture().toInstant();
      Instant arrival = flights.get(flights.size() - 1).getArrival().toInstant();
      this.travelTime = Duration.between(departure, arrival);
      this.cost = 0.00;
      for (Flight flight : flights) {
        this.cost += flight.getCost();
      }
    } else {
      this.travelTime = Duration.ZERO;
      this.cost = 0.00;
    }
  }

  /**
   * Returns true iff Itinerary contains the origin.
   * 
   * @param origin The origin to be searched
   */
  public boolean containsOrigin(String origin) {
    for (Flight flight : flights) {
      if (flight.getOrigin().equals(origin)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Adds a flight to the itinerary and adds the cost.
   * 
   * @param flight the flight that is added
   */
  public void addflight(Flight flight) {
    cost = cost + flight.getCost();
    flights.add(flight);
    if (flights != null && !flights.isEmpty()) {
      Instant departure = flights.get(0).getDeparture().toInstant();
      Instant arrival = flights.get(flights.size() - 1).getArrival().toInstant();
      this.travelTime = Duration.between(departure, arrival);
    } else {
      this.travelTime = Duration.ZERO;
    }
  }

  /**
   * Returns the total travel time of the itinerary.
   * 
   * @return travel time of itinerary
   */
  public Duration getTravelTime() {
    return this.travelTime;
  }

  /**
   * Returns the flights of this itinerary.
   * 
   * @return the flights
   */
  public List<Flight> getFlights() {
    return flights;
  }

  /**
   * Returns the total cost of this itinerary.
   * 
   * @return cost the total cost
   */
  public double getItinCost() {
    return cost;
  }

  /**
   * Returns the final destination of this itinerary.
   * 
   * @return the final destination of this itinerary
   */
  public String getDestination() {
    return flights.get(flights.size() - 1).getDestination();
  }

  @Override
  public String toString() {
    String ret = "";
    DateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    for (Flight flight : flights) {
      ret = ret + String.format("%s;%s;%s;%s;%s;%s", flight.getFlightNum(),
          dateTime.format(flight.getDeparture()), dateTime.format(flight.getArrival()),
          flight.getAirline(), flight.getOrigin(), flight.getDestination()) + "\n";
    }
    return ret + this.cost + "\n" + (this.travelTime.toMinutes() / 60.0);
  }
}
