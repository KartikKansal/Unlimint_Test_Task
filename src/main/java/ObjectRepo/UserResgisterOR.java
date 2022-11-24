    package ObjectRepo;

    public interface UserResgisterOR extends BaseOR {
     String CustfirstName = "input[id='customer\\.firstName']";
     String CustlastName = "input[id='customer\\.lastName']";
     String CustAddress = "input[id='customer\\.address\\.street']";
     String CustCity = "input[id='customer\\.address\\.city']";
     String CustState = "input[id='customer\\.address\\.state']";
     String CustZipCode = "input[id='customer\\.address\\.zipCode']";
     String CustSSN = "input[id='customer\\.ssn']";
     String CustuserName = "input[id='customer\\.username']";
     String CustPassword = "input[id='customer\\.password']";
     String CustConfirmPassword = "#repeatedPassword";
     String RegisterBtn = "//input[@value='Register']";
     String userExistErr = "#customer\\.username\\.errors";
    }