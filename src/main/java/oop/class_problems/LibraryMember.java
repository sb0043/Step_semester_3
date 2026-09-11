package oop.class_problems;

public class LibraryMember {

    private String membershipPin;
    String branchCode;
    protected String finesOwed;
    public String displayName;

    public LibraryMember(String membershipPin, String branchCode,
                         String finesOwed, String displayName) {

        this.membershipPin = membershipPin;
        this.branchCode = branchCode;
        this.finesOwed = finesOwed;
        this.displayName = displayName;
    }
}