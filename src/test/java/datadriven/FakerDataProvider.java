package datadriven;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Iterator;

public class FakerDataProvider {

    public static Iterator<Object[]> getTestData() {
        Faker faker = new Faker();
        ArrayList<Object[]> data = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String entryType = "Family";
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String businessName = faker.company().name();
            String address1 = faker.address().streetAddress();
            String address2 = faker.address().secondaryAddress();
            String address3 = faker.address().secondaryAddress();

            String city = faker.address().city();
            String province = faker.address().state();
            String country = faker.address().country();
            String postalCode = faker.address().zipCode();
            String email1 = faker.internet().emailAddress();
            String email2 = faker.internet().emailAddress();
            String email3 = faker.internet().emailAddress();
            String phone1Type = "Home";
            String phone1Number = faker.phoneNumber().phoneNumber();
            String phone2Type = "Home";
            String phone2Number = faker.phoneNumber().phoneNumber();
            String phone3Type = "Home";
            String phone3Number = faker.phoneNumber().phoneNumber();
            String webSite1 = faker.internet().url();
            String webSite2 = faker.internet().url();
            String webSite3 = faker.internet().url();

            data.add(new Object[] {
                entryType, firstName, lastName, businessName,
                address1, address2, address3, city, province, country, postalCode,
                email1, email2, email3,
                phone1Type, phone1Number, phone2Type, phone2Number, phone3Type, phone3Number,
                webSite1, webSite2, webSite3
            });
        }
        return data.iterator();
    }
}
