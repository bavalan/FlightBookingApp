package systemdata;

// Import tools to help make the function work.
//import driver.Driver;
//import flight.Flight;
//import flight.Itinerary;
import user.Billing;
import user.Client;

import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.Duration;
//import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The class where all the background applications take place. This class stores all the flights and
 * clients and also creates a map of all flights
 */
public class SystemData implements Serializable {

  private Map<String, Client> clients = new HashMap<String, Client>(); // The clients
  private DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
  private DateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  // Flight Storage
  //private HashMap<String, ArrayList<Flight>> flights = new HashMap<String, ArrayList<Flight>>();


  /**
   * Creates a new SystemData.
   */
  public SystemData() {}

  /**
   * Adds a client to the system.
   * 
   * @param client to be added
   */
  public void addClient(Client client) {
    clients.put(client.getEmail(), client);
  }

  /**
   * Adds a flight to the system. Also updates the flight map.
   * 
   * @param flight to be added
   */
//  public void addFlight(Flight flight) {
//
//    if (!flights.containsKey(flight.getOrigin())) {
//      ArrayList<Flight> list = new ArrayList<Flight>();
//      flights.put(flight.getOrigin(), list);
//      flights.get(flight.getOrigin()).add(flight);
//    } else {
//      flights.get(flight.getOrigin()).add(flight);
//    }
//  }

  /**
   * Adds clients from file.
   * 
   * @param path of file storing client data
   */
//  public void addClientFile(String path) {
//    try {
//      for (String line : Files.readAllLines(Paths.get(path))) {
//        String[] clientInfo = line.split(";");
//        Date expDate = date.parse(clientInfo[5]);
//        Billing bill = new Billing(clientInfo[3], clientInfo[4], expDate);
//        Client client = new Client(clientInfo[0], clientInfo[1], clientInfo[2], bill);
//        this.addClient(client);
//      }
//    } catch (NumberFormatException ex) {
//      // TODO Auto-generated catch block
//      ex.printStackTrace();
//    } catch (IOException ex) {
//      // TODO Auto-generated catch block
//      ex.printStackTrace();
//    } catch (ParseException ex) {
//      // TODO Auto-generated catch block
//      ex.printStackTrace();
//    }
//  }

  /**
   * Adds flights from file.
   * 
   * @param path of file storing flight data
   */
//  public void addFilghtFile(String path) {
//    try {
//      for (String line : Files.readAllLines(Paths.get(path))) {
//        String[] flightInfo = line.split(";");
//        Date departure = dateTime.parse(flightInfo[1]);
//        Date arrival = dateTime.parse(flightInfo[2]);
//        Flight flight = new Flight(flightInfo[0], departure, arrival, flightInfo[3], flightInfo[4],
//            flightInfo[5], Double.valueOf(flightInfo[6]));
//        this.addFlight(flight);
//      }
//    } catch (NumberFormatException ex) {
//      ex.printStackTrace();
//    } catch (IOException ex) {
//      ex.printStackTrace();
//    } catch (ParseException ex) {
//      ex.printStackTrace();
//    }
//  }

  /**
   * Returns all flights that are stored.
   * 
   * @return the list of flights
   */
  //public Map<String, ArrayList<Flight>> getFlights() {
//    return flights;
//  }

  /**
   * Returns all clients that are stored.
   * 
   * @return the list of clients
   */
  public Map<String, Client> getClients() {
    return clients;
  }

  /**
   * Returns all flights that depart from origin and arrive at destination on the given date.
   * 
   * @param departureDate The date the flight will departure.
   * @param origin The origin place the flight will leave.
   * @param destination The destination of the flight
   * @return The possible lists of flights when searching using the departureDate, origin and
   *         Destination
   */
//  public List<Flight> searchFlight(Date departureDate, String origin, String destination) {
//
//    List<Flight> flightList = new ArrayList<Flight>();
//    for (Flight flight : flights.get(origin)) {
//      if (flight.getFormatDeparture().equals(date.format(departureDate))
//          && flight.getDestination().equals(destination)) {
//        // Add the flight found to the List of flights
//        flightList.add(flight);
//      }
//    }
//    // Return the list of flights found.
//    return flightList;
//
//  }
//
//  /**
//   * Returns the given list of itineraries sorted by cost.
//   *
//   * @param intineraryCost The list of itineraries to be sorted.
//   * @return The list of itineraries sorted by cost.
//   */
//  public List<Itinerary> sortCost(List<Itinerary> intineraryCost) {
//
//    // Sorts the order of cost
//    Collections.sort(intineraryCost, new Comparator<Itinerary>() {
//
//      @Override
//      /*
//       * (non-Javadoc)
//       *
//       * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
//       */
//      // Compares the cost of both itineraries by calling the getItinCost() in the Flight method.
//      public int compare(Itinerary intineraryCost1, Itinerary intineraryCost2) {
//        Double cost1 = intineraryCost1.getItinCost();
//        Double cost2 = intineraryCost2.getItinCost();
//
//
//        // Compares it in ascending order
//        return cost1.compareTo(cost2);
//      }
//
//    });
//    return intineraryCost;
//  }
//
//  /**
//   * Returns the given list of itineraries sorted by travel time.
//   *
//   * @param intineraryTime The list of itineraries to be sorted.
//   * @return The list of itineraries sorted by travel time.
//   */
//  public List<Itinerary> sortTime(List<Itinerary> intineraryTime) {
//    // Sorts the order of travel time.
//    Collections.sort(intineraryTime, new Comparator<Itinerary>() {
//
//      @Override
//      /*
//       * (non-Javadoc)
//       *
//       * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
//       */
//      // Compares the travel time of both itineraries by calling the getTravelTime() in the Flight
//      // method.
//      public int compare(Itinerary intineraryTime1, Itinerary intineraryTime2) {
//        Long time1 = intineraryTime1.getTravelTime().toMinutes();
//        Long time2 = intineraryTime2.getTravelTime().toMinutes();
//
//
//        // Compares it in ascending order
//        return time1.compareTo(time2);
//      }
//
//    });
//    return intineraryTime;
//
//  }

  /**
   * Returns the client with given email.
   * 
   * @param email the email of a client
   * @return Returns the clients.
   */
  public Client searchClient(String email) {
    return clients.get(email);
  }

  /**
   * Helper method for search itineraries.
   * 
   * @param flightList The itinerary of flights that it traversed through
   * @param currOrigin Current location of the traversal
   * @param destination Destination of the itinerary
   * @param arrival of the time it arrived at the current location
   * @return The list of itineraries
   */
//  private List<Itinerary> searchItinHelper(Itinerary flightList, String currOrigin,
//      String destination, Date arrival) {
//    List<Itinerary> itinList = new ArrayList<Itinerary>(); // The list to return
//    Instant arrivalTime = arrival.toInstant();
//    if (flights.containsKey(currOrigin)) { // Checks if the origin has flights
//
//      for (Flight flight : flights.get(currOrigin)) { // Loops through all flights from origin
//        Itinerary newItin = new Itinerary(flightList.getFlights()); // new itin with multiple paths
//        String flightDestination = flight.getDestination(); // Final destination
//        Duration layOver = Duration.between(arrivalTime, flight.getDeparture().toInstant());
//        if (layOver.toMinutes() >= Driver.MIN_LAYOVER.toMinutes()
//            && layOver.toMinutes() <= Driver.MAX_LAYOVER.toMinutes()) {
//          if (flightDestination.equals(destination)) { // If the destination is reached
//            flightList.addflight(flight); // add the flight to itin and return the itinerary to be
//            itinList.add(flightList); // added to the main list
//          } else {
//            if (flightList.containsOrigin(flightDestination)
//                || flightList.getFlights().contains(null)) {
//              itinList.add(null);
//              return itinList; // return null meaning false path
//            }
//            newItin.addflight(flight);
//            String nextFlight = flight.getDestination();
//            List<Itinerary> newList = new ArrayList<Itinerary>(
//                this.searchItinHelper(newItin, nextFlight, destination, flight.getArrival()));
//            if ((!(newList.contains(null))) && (newList != null)) { // ??? Confused currently if a
//              // list can have null element
//              itinList.addAll(newList); // add the itinerary to the list
//            }
//          }
//        }
//      }
//      return itinList;
//    }
//    itinList.add(null);
//    return itinList; // flight was not found
//  }
//
//  /**
//   * Returns all possible itineraries with the given date origin and destination.
//   *
//   * @param departureDate the date of wanted departure
//   * @param origin the origin of wanted departure
//   * @param destination the wanted destination
//   * @return The list of the searched itineraries.
//   */
//  public List<Itinerary> searchItinerary(Date departureDate, String origin, String destination) {
//    List<Itinerary> itinList = new ArrayList<Itinerary>(); // The list to return
//
//    if (flights.containsKey(origin)) { // Checks if the origin has flights
//      for (Flight flight : flights.get(origin)) { // Loops through all flights
//        // from origin
//        Itinerary itin = new Itinerary(); // The itinerary to add
//        String flightDestination = flight.getDestination(); // Destination of the current flight in
//        // the graph
//        if (flight.getFormatDeparture().equals(date.format(departureDate))) {
//          if (flightDestination.equals(destination)) { // If the flight goes to the destination
//            // directly (NO recursion)
//            itin.addflight(flight);
//            itinList.add(itin); // Add the itinerary
//          } else { // Multiple paths required
//            // traverse through the graph till destination or null (Recursion)
//            itin.addflight(flight);
//            String nextFlight = flight.getDestination();
//            List<Itinerary> newList = new ArrayList<Itinerary>(
//                this.searchItinHelper(itin, nextFlight, destination, flight.getArrival()));
//            if ((!(newList.contains(null))) && (newList != null)) { // ??? Confused currently if a
//              // list can have null element
//              itinList.addAll(newList); // add the itinerary to the list
//            }
//          }
//        }
//
//      }
//    }
//    return itinList;
//  }
}
