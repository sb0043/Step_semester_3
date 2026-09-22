package week5.assignment_problems;

public class LibraryMemberJavaBean {

    public static class LibraryMember {

        private String membershipId;
        private String name;
        private boolean premiumMember;
        private String securityAnswerHash;

        public LibraryMember() {
        }

        public String getMembershipId() {
            return membershipId;
        }

        public void setMembershipId(String id) {

            if (membershipId == null) {
                membershipId = id;
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isPremiumMember() {
            return premiumMember;
        }

        public void setPremiumMember(boolean premiumMember) {
            this.premiumMember = premiumMember;
        }

        public void setSecurityAnswer(String answer) {
            securityAnswerHash = oneWayTransform(answer);
        }

        private String oneWayTransform(String answer) {

            if (answer == null) {
                return null;
            }

            return Integer.toHexString(answer.hashCode());
        }
    }

    public static void main(String[] args) {

        LibraryMember member = new LibraryMember();

        member.setMembershipId("LIB-8841");
        member.setMembershipId("LIB-9999");

        member.setName("Sathvik");
        member.setPremiumMember(true);
        member.setSecurityAnswer("blue");

        System.out.println(member.getMembershipId());
        System.out.println(member.getName());
        System.out.println(member.isPremiumMember());
        System.out.println("Security answer stored securely");
    }
}