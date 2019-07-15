import java.util.*;

public class Theater {
    private final String theaterName;
    private List<Seat> seats = new ArrayList<>();

    public Theater(String theaterName, int numRows, int seatsPerRow) {
        this.theaterName = theaterName;
        //creating the rows (letter) and seats (number)
        int lastRow = 'A' + (numRows-1);
        for (char row = 'A'; row<=lastRow; row++){ // creating rows
            for (int seatNum=1; seatNum<=seatsPerRow; seatNum++) {// seats number
                Seat seat= new Seat (row +String.format("%02d",seatNum)); //creating seat in format A01
                seats.add(seat); //add the seat to the List seats
            }
        }
    }
    public String getTheaterName() {
        return theaterName;
    }
    public boolean reserveSeat (String seatNumber){//if the seat exists, reserve() it
        //using source code from binary search
        int low = 0;
        int high = seats.size()-1;

        while (low <= high) {
            System.out.print(".");//print dot to track how many times the loop is run/check performance of the algorithm
            int mid = (low + high) >>> 1; // same as (low + high) /2
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSeatNumber().compareTo(seatNumber);//seatNumber is the key to find
            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return seats.get(mid).reserve(); // key found, get the seat and reserve it
        }
        System.out.println("There is no seat at "+seatNumber);
            return false; // key not found


//        //binary search, alternative to brute force search below
//        Seat requestedSeat=new Seat(seatNumber);
//        int foundSeat = Collections.binarySearch(seats, requestedSeat,null);//search on a sorted array/list
//        if (foundSeat>=0){
//            return seats.get(foundSeat).reserve();
//        }else{
//            System.out.println("There is no seat at "+seatNumber);
//            return false;
//        }
//        //brute force search - code to use without the binary search
//        Seat requestedSeat=null;
//        for (Seat seat: seats){
//            System.out.print(".");// printing a dot to count how many seats it has to check
//            if (seat.getSeatNumber().equals(seatNumber)){//check if the seat is in the List of seats
//                requestedSeat=seat; //seat found
//                break;
//            }
//        }
//        if (requestedSeat==null){//invalid seat
//            System.out.println("There is no seat at "+seatNumber);
//            return false;
//        }
//        return requestedSeat.reserve();
    }
    //for testing
    public void getSeat(){
        for(Seat seat:seats){
            System.out.println(seat.getSeatNumber());
        }
    }
    private class Seat implements Comparable<Seat>{//comparable added to use binarySearch
        private final String seatNumber;
        private boolean reserved = false;//all seats are no reserved initially

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {//from Comparable interface
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());// returns 0, neg or pos nr
        }

        public boolean reserve(){
            if (!this.reserved){
                this.reserved=true;
                System.out.println("Seat "+ seatNumber + " reserved");
                return true;
            }else {
                return false;
            }
        }
        public boolean cancel(){
            if(this.reserved){ // undo reserve
                this.reserved=false;
                System.out.println("Reservation of seat "+ seatNumber+ " cancelled");
                return true;
            }else{
                return false;//unable to cancel
            }
        }
        public String getSeatNumber() {
            return seatNumber;
        }
    }
}
