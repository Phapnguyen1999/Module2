package bai2;

public class AcountExampleTest {
    private static AccountExample accountExample;

    public static final String[] valiAcccount = new String[] {"123abc__", "_abc123", "____", "1234", "abcdegh"};
    public static final String[] invalidAccount = new String[] {".@", " 12345", "1235_", "abcdvf"};

    public static void main(String[] args) {
        accountExample = new AccountExample();
        for (String account : valiAcccount) {
            boolean isvalid = accountExample.validate(account);
            System.out.println("account is " + account + " is valid " + isvalid);
        }
        for (String account : invalidAccount) {
            boolean isvalid = accountExample.validate(account);
            System.out.println("Account is " + account + " is valid " + isvalid);
        }
    }
}
