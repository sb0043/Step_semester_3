package oop.assignment_problems;

public class ParkingTicket {
    String vehicleNo;
    double baseFine;

    public ParkingTicket(String vehicleNo, double baseFine) {
        this.vehicleNo = vehicleNo;
        this.baseFine = baseFine;
    }

    final double calculateFine(int hoursOverstayed) {
        return baseFine + (hoursOverstayed * 50);
    }

    final void printSummary(int hoursOverstayed) {
        double fine = calculateFine(hoursOverstayed);

        System.out.println(vehicleNo + " | Base Fine: Rs "
                + baseFine + " | Total Fine: Rs " + fine);
    }

    public static void main(String[] args) {
        String[] vehicleNos = {"TN01AB1234", "TN02CD5678",
                               "TN03EF9012", "TN04GH3456"};

        double[] baseFines = {100, 150, 200, 250};

        int[] hoursOverstayed = {2, 0, 3, 5};

        for (int i = 0; i < vehicleNos.length; i++) {
            ParkingTicket ticket =
                    new ParkingTicket(vehicleNos[i], baseFines[i]);

            ticket.printSummary(hoursOverstayed[i]);
        }
    }
}