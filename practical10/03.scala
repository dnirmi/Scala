object BankAccountApp extends App {
  class BankAccount(val accountNumber: String, var balance: Double) {
    def deposit(amount: Double): Unit = {
      balance += amount
      println(s"Deposited $amount into account $accountNumber. New balance: $balance")
    }

    def withdraw(amount: Double): Unit = {
      if (amount > balance) {
        println(s"Insufficient balance in account $accountNumber. Cannot withdraw $amount")
      } else {
        balance -= amount
        println(s"Withdrew $amount from account $accountNumber. New balance: $balance")
      }
    }

    def transfer(toAccount: BankAccount, amount: Double): Unit = {
      if (amount > balance) {
        println(s"Insufficient balance in account $accountNumber. Cannot transfer $amount to account ${toAccount.accountNumber}")
      } else {
        balance -= amount
        toAccount.deposit(amount)
        println(s"Transferred $amount from account $accountNumber to account ${toAccount.accountNumber}")
      }
    }
  }

  object BankAccount {
    def apply(accountNumber: String, initialBalance: Double): BankAccount = new BankAccount(accountNumber, initialBalance)
  }

  val account1 = BankAccount("200140058959", 1000.0)
  val account2 = BankAccount("200160018969", 500.0)

  account1.deposit(500.0)
  account1.withdraw(200.0)

  account1.transfer(account2, 300.0)

  println(s"Account 1 balance: ${account1.balance}")
  println(s"Account 2 balance: ${account2.balance}")
}