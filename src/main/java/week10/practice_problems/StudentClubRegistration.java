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
        if (this == obj) {
            return true;
        }

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

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");

            if (parts[0].equalsIgnoreCase("ADD") && parts.length == 3) {
                ClubMember member = new ClubMember(parts[1], parts[2]);

                if (members.contains(member)) {
                    System.out.println("duplicate rejected");
                } else {
                    members.add(member);
                    System.out.println("Added");
                }
            } else if (parts[0].equalsIgnoreCase("CONTAINS")
                    && parts.length == 3) {
                ClubMember member = new ClubMember(parts[1], parts[2]);
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