object BankApp extends App {
  class BankAccount(val accountNumber: String, var balance: Double) {
    def deposit(amount: Double): Unit = {
      balance += amount
    }

    def withdraw(amount: Double): Unit = {
      balance -= amount
    }

    override def toString: String = f"Account($accountNumber, Balance: $$${balance}%.2f)"
  }

  class Bank(val accounts: List[BankAccount]) {
    def accountsWithNegativeBalances: List[BankAccount] = {
      accounts.filter(_.balance < 0)
    }

    def totalBalance: Double = {
      accounts.map(_.balance).sum
    }

    def applyInterest(): Unit = {
      accounts.foreach { account =>
        if (account.balance > 0) {
          account.deposit(account.balance * 0.05)
        } else if (account.balance < 0) {
          account.withdraw(math.abs(account.balance) * 0.1)
        }
      }
    }
  }

  object Bank {
    def apply(accounts: BankAccount*): Bank = new Bank(accounts.toList)
  }


  val account1 = new BankAccount("1234567890", 1000.0)
  val account2 = new BankAccount("9876543210", -500.0)
  val account3 = new BankAccount("1111111111", 2000.0)
  val account4 = new BankAccount("2222222222", -100.0)


  val bank = Bank(account1, account2, account3, account4)


  println("Accounts with negative balances:")
  bank.accountsWithNegativeBalances.foreach { account =>
    println(f"Account: ${account.accountNumber}, Balance: $$${account.balance}%.2f")
  }


  println(f"\nTotal balance of all accounts: $$${bank.totalBalance}%.2f")

  bank.applyInterest()

  println("\nFinal balances after applying interest:")
  bank.accounts.foreach { account =>
    println(f"Account: ${account.accountNumber}, Balance: $$${account.balance}%.2f")
  }
}
