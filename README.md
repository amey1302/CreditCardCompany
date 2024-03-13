
# Unusual Spends

#### Description :

You work at a credit card company and as a value-add they want to start providing alerts to users when their spending in any particular category is higher than usual.
 - Compare the total amount paid for the current month, grouped by category with the previous month 
 - Filter down to the categories for which the user spent at least 50% more this month than last month
 - Compose an e-mail message to the user that lists the categories for which spending was unusually high
#### OOMD Design for the Credit Card Company

## class Customer
 - ### States :
    private String name;
    private String email;
- ### Behaviour
    public Customer(String name, String email) 
    public String getName()
    public String getEmail()

## class CreditCardUser
- ### States :
    -private final limit   
## class Transaction
- ### States :
    - private enum Category
    - private Map<Category, Double> amountForEachCategory
- ### Constructor:
    - Transaction(Map<Category, Double> amountForEachCategory)
- ### Behaviour:
    - public double totalAmountSpent
    - public Map<Category, Double> groupByCategory()

## class Transactions
- ### States:
    - private List<Transaction> previousMonthTransactions
    - private List<Transaction> currentMonthTransactions
- ### Constructor:
    - TransactionAnalyzer(List<Transaction> previousMonthTransactions, List<Transaction> currentMonthTransactions)       
- ### Behaviour:
    - public List<Transaction> getPreviousMonthTransactions()
    - public List<Transaction> getCurrentMonthTransactions()
    - public double totalAmountSpent()
    - public double totalAmountSpentInPreviousMonth()
    - private double totalAmount(List<Transaction> transactions)
    - public Map<Category, Double> totalAmountOfUnusualSpentPerCategory()
    -  private double getPreviousMonthAmount
## class UnusualSpendAnalyser
   -  public boolean isUnusualSpending(Transactions transactions)

## interface
  - void send(Notification notification)
      
## class AlertSystem
- EmailAlertMessage : message related all formats
- EmailAlertSystem  : actual implementation of the code to send email
  

