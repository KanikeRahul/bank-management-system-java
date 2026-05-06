import java.io.*;
import java.util.ArrayList;

public class Bank {

    ArrayList<Account> accounts = new ArrayList<>();

    private final String FILE_NAME = "accounts.txt";

    public Bank() {
        loadAccounts();
    }

    public void createAccount(Account account) {
        accounts.add(account);
        saveAccounts();
        System.out.println("Account Created Successfully!");
    }

    public void depositMoney(int accNo, double amount) {

        for (Account acc : accounts) {

            if (acc.getAccountNumber() == accNo) {
                acc.deposit(amount);
                saveAccounts();
                System.out.println("Money Deposited Successfully!");
                return;
            }
        }

        System.out.println("Account Not Found!");
    }

    public void withdrawMoney(int accNo, double amount) {

        for (Account acc : accounts) {

            if (acc.getAccountNumber() == accNo) {

                if (acc.withdraw(amount)) {
                    saveAccounts();
                    System.out.println("Withdrawal Successful!");
                } else {
                    System.out.println("Insufficient Balance!");
                }

                return;
            }
        }

        System.out.println("Account Not Found!");
    }

    public void checkBalance(int accNo) {

        for (Account acc : accounts) {

            if (acc.getAccountNumber() == accNo) {
                acc.display();
                return;
            }
        }

        System.out.println("Account Not Found!");
    }

    public void viewAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No Accounts Available.");
            return;
        }

        for (Account acc : accounts) {
            acc.display();
        }
    }

    private void saveAccounts() {

        try (BufferedWriter bw =
                 new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Account acc : accounts) {
                bw.write(acc.toString());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error Saving Accounts!");
        }
    }

    private void loadAccounts() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader br =
                 new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int accNo = Integer.parseInt(data[0]);
                String name = data[1];
                double balance = Double.parseDouble(data[2]);

                accounts.add(new Account(accNo, name, balance));
            }

        } catch (IOException e) {
            System.out.println("Error Loading Accounts!");
        }
    }
}