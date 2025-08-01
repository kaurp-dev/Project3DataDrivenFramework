package datadriven;

import com.github.javafaker.Faker;
import java.io.FileWriter;
import java.io.IOException;

public class DataToCSV {
    public static void main(String[] args) {
        Faker faker = new Faker();

        try {
            FileWriter writer = new FileWriter("puneet-1302027-addressbook-data.csv");

            writer.append("EntryType,FirstName,LastName,BusinessName,Address1,Address2,Address3,City,Province,Country,PostalCode,Email1,Email2,Email3,PhoneType1,Phone1,PhoneType2,Phone2,PhoneType3,Phone3,Website1,Website2,Website3\n");

            for (int i = 0; i < 10; i++) {
                writer.append("\"Family\"").append(",");
                writer.append("\"" + faker.name().firstName() + "\"").append(",");
                writer.append("\"" + faker.name().lastName() + "\"").append(",");
                writer.append("\"" + faker.company().name() + "\"").append(",");
                writer.append("\"" + faker.address().streetAddress() + "\"").append(",");
                writer.append("\"" + faker.address().secondaryAddress() + "\"").append(",");
                writer.append("\"" + faker.address().secondaryAddress() + "\"").append(",");

                writer.append("\"" + faker.address().city() + "\"").append(",");
                writer.append("\"" + faker.address().state() + "\"").append(",");
                writer.append("\"Canada\"").append(",");
                writer.append("\"" + faker.address().zipCode() + "\"").append(",");
                writer.append("\"" + faker.internet().emailAddress() + "\"").append(",");
                writer.append("\"" + faker.internet().emailAddress() + "\"").append(",");
                writer.append("\"" + faker.internet().emailAddress() + "\"").append(",");
                writer.append("\"Home\"").append(",").append("\"" + faker.phoneNumber().cellPhone() + "\"").append(",");
                writer.append("\"Mobile\"").append(",").append("\"" + faker.phoneNumber().cellPhone() + "\"").append(",");
                writer.append("\"Work\"").append(",").append("\"" + faker.phoneNumber().phoneNumber() + "\"").append(",");
                writer.append("\"" + faker.internet().url() + "\"").append(",");
                writer.append("\"" + faker.internet().url() + "\"").append(",");
                writer.append("\"" + faker.internet().url() + "\"").append("\n");
            }

            writer.flush();
            writer.close();
            System.out.println("✅ CSV file created successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
