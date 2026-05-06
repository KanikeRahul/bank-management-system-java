import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();

        while (true) {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");

            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    bank.createAccount(
                        new Account(accNo, name, balance)
                    );

                    break;

                case 2:

                    System.out.print("Enter Account Number: ");
                    int depAcc = sc.nextInt();

                    System.out.print("Enter Amount: ");
                    double depAmount = sc.nextDouble();

                    bank.depositMoney(depAcc, depAmount);

                    break;

                case 3:

                    System.out.print("Enter Account Number: ");
                    int withAcc = sc.nextInt();

                    System.out.print("Enter Amount: ");
                    double withAmount = sc.nextDouble();

                    bank.withdrawMoney(withAcc, withAmount);

                    break;

                case 4:

                    System.out.print("Enter Account Number: ");
                    int balAcc = sc.nextInt();

                    bank.checkBalance(balAcc);

                    break;

                case 5:

                    bank.viewAccounts();

                    break;

                case 6:

                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}