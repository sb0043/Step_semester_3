package week6.assignment_problems;

class BaseGymMember {
    protected int sessions;

    BaseGymMember() {
        sessions = 0;
    }

    void attendSession() {
        sessions++;
    }

    void displayInfo() {
        System.out.print("Gym Member | Sessions: " + sessions);
    }
}

class BasePremiumMember extends BaseGymMember {

    @Override
    void displayInfo() {
        System.out.print("Premium Member | Sessions: " + sessions);
    }
}

class EliteMember extends BasePremiumMember {

    @Override
    void displayInfo() {
        System.out.print("Elite Member | Sessions: " + sessions);
    }
}

class GroupClassMember extends BaseGymMember {

    @Override
    void displayInfo() {
        System.out.print("Group Class Member | Sessions: " + sessions);
    }
}

public class GymMembershipHierarchy {

    static String classifyGeneration(BaseGymMember member) {

        if (member instanceof EliteMember) {
            return "Elite";
        }

        if (member instanceof BasePremiumMember) {
            return "Premium";
        }

        if (member instanceof GroupClassMember) {
            return "Group";
        }

        return "Base";
    }

    static int getTotalSessions(BaseGymMember[] members) {

        int total = 0;

        for (BaseGymMember member : members) {
            if (member != null) {
                total += member.sessions;
            }
        }

        return total;
    }

    static void batchPrint(BaseGymMember[] members) {

        for (BaseGymMember member : members) {
            if (member != null) {
                System.out.print(
                    classifyGeneration(member) + " | "
                );

                member.displayInfo();
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        BaseGymMember[] members = {
            new BaseGymMember(),
            new BasePremiumMember(),
            new EliteMember(),
            new GroupClassMember()
        };

        for (BaseGymMember member : members) {
            member.attendSession();
        }

        batchPrint(members);

        System.out.println(
            "Total Sessions: " + getTotalSessions(members)
        );
    }
}