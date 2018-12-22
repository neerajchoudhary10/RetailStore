Code Explanation:
1) I have created UserTypeEnum to maintain the discount percemtage and  Employee, Customer and Affiliate deyails.
2) I have created ItemTypeEnum to maintain Item types(Grocery.Cosmetic,medicine) and its price.
3) I have created Bill details class to calculate the discount amount for users (Employee, Customer and Affiliate)
4) In billdetails class in method "discountOnAmount" calculating discount on user basis type.
  a) If item type is grocery than discount is not calculated on that item (for all types of users)
  b) If user is registered 2 years back than applying 5% discount and registred within 2 years no discount
  c) If user is Employee and Affiliate than applying respectivly 30% and 10% discount
  d) Finally if bill sum is greater than $100 than applying $5 on each $100 amount
5) In CalculateDiscount class there is main method to test the program and its discount.

Test case:
3 different test case class created for all user types.
and checked the calculation are calculated correct or not.\
And also checked date is 2 years back from current date.
