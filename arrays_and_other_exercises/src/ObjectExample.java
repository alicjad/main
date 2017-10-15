import java.util.Scanner;
public class ObjectExample {
    public static void main(String[] args) {
        account bobsAccount = new account("Bobs account");
        account PetersAccount = new account("Peters account");
        PetersAccount.setBallance(10502.121);
        bobsAccount.setBallance(5000.45);
//bobsAccount.setAccountName("Luis account");
        System.out.println(bobsAccount.getAccountName());
        System.out.println(bobsAccount.getBallance());
    }
}
class account {
    private String accountName;
    private double ballance;
    account(String name) {
        this.accountName = name;
    }
    public void setBallance(double ballance) {
        this.ballance = ballance;
    }
    public double getBallance() {
        return this.ballance;
    }
    public void setAccountName(String accountName) {
        System.out.println("Are you sure?");
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        if(answer.equals("yes")) {
            this.accountName = accountName;
        } else {
            System.out.println("You choose not to change the name of the account holder");
        }
    }
    public String getAccountName() {
        return this.accountName;
    }
}
