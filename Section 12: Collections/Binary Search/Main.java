public class Main {

    public static void main(String[] args) {
        Theater theater = new Theater("Apollo", 11, 20);
//        theater.getSeat();
        if (theater.reserveSeat("B12")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is already taken");
        }
        if (theater.reserveSeat("B12")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is already taken");
        }
        theater.reserveSeat("A01");
        if (theater.reserveSeat("a01")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is already taken");
        }
    }
}
