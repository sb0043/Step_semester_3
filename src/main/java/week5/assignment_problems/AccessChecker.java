package week5.assignment_problems;

public class AccessChecker {

    static String classifyAccess(
            String fieldModifier,
            String accessorContext) {

        switch (fieldModifier) {

            case "private":
                return accessorContext.equals("SAME_CLASS")
                        ? "ALLOWED"
                        : "DENIED";

            case "default":
                return accessorContext.equals("SAME_CLASS")
                        || accessorContext.equals("SAME_PACKAGE")
                        ? "ALLOWED"
                        : "DENIED";

            case "protected":
                return accessorContext.equals("SAME_CLASS")
                        || accessorContext.equals("SAME_PACKAGE")
                        ? "ALLOWED"
                        : "DENIED";

            case "public":
                return "ALLOWED";

            default:
                return "DENIED";
        }
    }

    static String summarizeByModifier(String[][] attempts) {

        int privateAllowed = 0;
        int privateDenied = 0;

        int defaultAllowed = 0;
        int defaultDenied = 0;

        int protectedAllowed = 0;
        int protectedDenied = 0;

        int publicAllowed = 0;
        int publicDenied = 0;

        for (String[] attempt : attempts) {

            String modifier = attempt[0];
            String context = attempt[1];

            boolean allowed =
                    classifyAccess(modifier, context)
                            .equals("ALLOWED");

            switch (modifier) {

                case "private":
                    if (allowed) {
                        privateAllowed++;
                    } else {
                        privateDenied++;
                    }
                    break;

                case "default":
                    if (allowed) {
                        defaultAllowed++;
                    } else {
                        defaultDenied++;
                    }
                    break;

                case "protected":
                    if (allowed) {
                        protectedAllowed++;
                    } else {
                        protectedDenied++;
                    }
                    break;

                case "public":
                    if (allowed) {
                        publicAllowed++;
                    } else {
                        publicDenied++;
                    }
                    break;
            }
        }

        return "private: " + privateAllowed
                + " allowed / " + privateDenied + " denied\n"
                + "default: " + defaultAllowed
                + " allowed / " + defaultDenied + " denied\n"
                + "protected: " + protectedAllowed
                + " allowed / " + protectedDenied + " denied\n"
                + "public: " + publicAllowed
                + " allowed / " + publicDenied + " denied";
    }

    public static void main(String[] args) {

        String[][] attempts = {
                {"private", "SAME_CLASS"},
                {"private", "SAME_PACKAGE"},
                {"default", "SAME_PACKAGE"},
                {"default", "DIFFERENT_PACKAGE"},
                {"protected", "SAME_PACKAGE"},
                {"protected", "SAME_CLASS"},
                {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(
                classifyAccess("private", "SAME_CLASS")
        );

        System.out.println(
                classifyAccess("protected", "DIFFERENT_PACKAGE")
        );

        System.out.println(
                summarizeByModifier(attempts)
        );
    }
}

class LibraryMember {

    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;
}