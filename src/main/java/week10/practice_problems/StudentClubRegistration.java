package week10.practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ClubMember {
    String rollNumber;
    String name;

    ClubMember(String rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ClubMember)) {
            return false;
        }
        ClubMember other = (ClubMember) obj;
        return rollNumber.equals(other.rollNumber);
    }

    @Override
    public int hashCode() {
        return rollNumber.hashCode();
    }
}

public class StudentClubRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<ClubMember> members = new ArrayList<>();
        List<String> containsResults = new ArrayList<>();

        for (int command = 0; command < 5; command++) {
            String operation = sc.next();

            if (operation.equalsIgnoreCase("ADD")) {
                String rollNumber = sc.next();
                String name = sc.next();

                ClubMember member = new ClubMember(rollNumber, name);

                if (members.contains(member)) {
                    System.out.println("duplicate rejected");
                } else {
                    members.add(member);
                    System.out.println("Added");
                }
            } else if (operation.equalsIgnoreCase("CONTAINS")) {
                String rollNumber = sc.next();
                String name = sc.next();

                ClubMember member = new ClubMember(rollNumber, name);
                containsResults.add("contains: " + members.contains(member));
            }
        }

        System.out.println("member count " + members.size());

        for (String result : containsResults) {
            System.out.println(result);
        }

        sc.close();
    }
}