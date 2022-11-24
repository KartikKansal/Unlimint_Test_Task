package JPathRepo;

public interface JsonPaths {
    String userName = "results[0].login.username";
    String streetName = "results[0].location.street.name";
    String streetNumber = "results[0].location.street.number";
    String City = "results[0].location.city";
    String State = "results[0].location.state";
    String PostCode = "results[0].location.postcode";
    String Cell = "results[0].cell";
    String AccNo = "12345";
    String Amount = "789";
    String firstName = "results[0].name.first";
    String lastName = "results[0].name.last";
    String SSN = "results[0].id.value";
    String Password = "results[0].login.password";
}
