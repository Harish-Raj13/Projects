import java.util.*;

public class Main {

    static int id = 0;
    int flightId;
    int tickets;
    int price;
    ArrayList<String> passengerDetails;
    ArrayList<Integer> passengerIds;
    ArrayList<Integer> bookedTicketsPerPassenger;
    ArrayList<Integer> passengerCost;

    Main() {
        tickets = 50;
        price = 5000;
        id = id + 1;
        flightId = id;
        passengerDetails = new ArrayList<>();
        passengerIds = new ArrayList<>();
        bookedTicketsPerPassenger = new ArrayList<>();
        passengerCost = new ArrayList<>();
    }

    public static void main(String[] args) {
        ArrayList<Main> flight = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            flight.add(new Main());
        }

        int passengerId = 1;
        while (true) {
            System.out.println("1-- Book, 2-- Cancel, 3-- Print");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the flight id: ");
                    int fid = sc.nextInt();
                    if (fid > flight.size()) {
                        System.out.println("Invalid flight Id");
                        break;
                    }
                    Main currentFlight = null;
                    for (Main f : flight) {
                        if (f.flightId == fid) {
                            currentFlight = f;
                            f.flightSummary();
                            break;
                        }
                    }
                    if (currentFlight == null) {
                        System.out.println("Flight not found");
                        break;
                    }
                    System.out.println("Enter the number of tickets");
                    int t = sc.nextInt();

                    if (t > currentFlight.tickets) {
                        System.out.println("Not enough tickets");
                        break;
                    }

                    book(currentFlight, t, passengerId);
                    passengerId += 1;
                    break;
                case 2:
                    System.out.println("Enter flightId and passenger Id to cancel the flight");
                    int fid1 = sc.nextInt();
                    if (fid1 > flight.size()) {
                        System.out.println("Invalid flight Id");
                        break;
                    }
                    Main currentFlight1 = null;
                    for (Main f : flight) {
                        if (f.flightId == fid1) {
                            currentFlight1 = f;
                            break;
                        }
                    }
                    if (currentFlight1 == null) {
                        System.out.println("Flight not found");
                        break;
                    }
                    int id = sc.nextInt();

                    cancel(currentFlight1, id);
                    break;
                case 3:
                    for (Main f : flight) {
                        if (f.passengerDetails.size() == 0) {
                            System.out.println("No passenger Details for the flight: " + f.flightId);
                        } else {
                            print(f);
                        }
                    }
                    break;
            }
        }
    }

    public void flightSummary() {
        System.out.println("Flight ID " + flightId + "... " + "Remaining Tickets " + tickets + "..." +
                "Current Ticket Price " + price);
    }

    public static void book(Main currentFlight, int tickets, int passengerId) {
        String passengerDetail = "";
        passengerDetail = "Passenger ID " + passengerId + "...." + "No.of tickets booked " +
                tickets + "..." + "Total cost " + currentFlight.price * tickets;

        currentFlight.addPassengerDetails(passengerDetail, tickets, passengerId);
    }

    public void addPassengerDetails(String passengerDetail, int nooftickets, int passengerId) {
        passengerDetails.add(passengerDetail);
        passengerIds.add(passengerId);
        passengerCost.add(price * nooftickets);

        price += 200 * nooftickets;
        tickets -= nooftickets;
        bookedTicketsPerPassenger.add(nooftickets);
        System.out.println("Booked Successfully");
    }

    public static void cancel(Main currentFlight, int passengerId) {
        int index = currentFlight.passengerIds.indexOf(passengerId);
        if (index < 0) {
            System.out.println("Passenger ID not found");
            return;
        }
        int ticketCancel = currentFlight.bookedTicketsPerPassenger.get(index);
        currentFlight.tickets += ticketCancel;
        currentFlight.price -= 200 * ticketCancel;

        System.out.println("Refund amount after cancel: " + currentFlight.passengerCost.get(index));

        currentFlight.bookedTicketsPerPassenger.remove(index);
        currentFlight.passengerIds.remove(Integer.valueOf(passengerId));
        currentFlight.passengerDetails.remove(index);
        currentFlight.passengerCost.remove(index);

        System.out.println("Cancelled successfully!!!");
    }

    public static void print(Main f) {
        System.out.println("FlightId " + f.flightId);
        for (String detail : f.passengerDetails) {
            System.out.println(detail);
        }
    }
}