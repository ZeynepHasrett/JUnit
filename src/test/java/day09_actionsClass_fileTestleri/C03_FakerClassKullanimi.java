package day09_actionsClass_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class C03_FakerClassKullanimi {

    @Test
    public void test01() {

        Faker faker = new Faker();

        System.out.println(faker.name().firstName());
        System.out.println(faker.name().nameWithMiddle());
        System.out.println(faker.name().username());

        System.out.println(faker.address().zipCode());
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.address().buildingNumber());

        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.internet().password());
        System.out.println(faker.internet().url());

        System.out.println(faker.harryPotter().character());

        System.out.println(faker.gameOfThrones().character());
        System.out.println(faker.lordOfTheRings().character());

    }

}
