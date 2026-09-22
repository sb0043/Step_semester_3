package week4.assignment_problems;

public class ParkingTicket {
    private String vehicleNo;
    private double ratePerMinute;

    public ParkingTicket(String vehicleNo, double ratePerMinute) {
        this.vehicleNo = vehicleNo;
        this.ratePerMinute = ratePerMinute;
    }

    public final double calculateFine(int overstayMinutes) {
        return overstayMinutes * ratePerMinute;
    }

    public final void printReceipt(int overstayMinutes) {
        if (overstayMinutes > 0) {
            double fine = calculateFine(overstayMinutes);
            System.out.println(vehicleNo + " | Overstay: " + overstayMinutes
                    + " minutes | Fine: Rs " + fine);
        } else {
            System.out.println(vehicleNo + " - No fine owed");
        }
    }

    public static void main(String[] args) {
        String[] vehicleNos = {"TN01AB1234", "TN02CD5678", "TN03EF9012", "TN04GH3456"};
        double[] rates = {10, 15, 20, 12};
        int[] overstayMinutes = {30, 0, 15, -5};

        for (int i = 0; i < vehicleNos.length; i++) {
            ParkingTicket ticket = new ParkingTicket(vehicleNos[i], rates[i]);
            ticket.printReceipt(overstayMinutes[i]);
        }
    }
}