package bdd.bank;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankTest {


    @DisplayName("Given there is an economy credit offer")
    @Nested
    class EconomyCreditOfferTest {

        private CreditOffer economyCreditOffer;
        private Customer mike;
        private Customer john;

        @BeforeEach
        void setUp() {
            economyCreditOffer = new EconomyCreditOffer("1");
            mike = new Customer("Mike", false);
            john = new Customer("John", true);
        }

        @Nested
        @DisplayName("When we have a usual customer")
        class UsualCustomer {
            @Test
            @DisplayName("Then you can add and remove him from an economy credit offer")
            public void testEconomyCreditOfferUsualCustomer() {
                assertAll("Verify all conditions for a usual customer and an economy credit offer",
                        () -> assertEquals("1", economyCreditOffer.getId()),
                        () -> assertEquals(true, economyCreditOffer.addCustomer(mike)),
                        () -> assertEquals(1, economyCreditOffer.getCustomersSet().size()),
                        () -> assertTrue(economyCreditOffer.getCustomersSet().contains(mike)),
                        () -> assertEquals("Mike", new ArrayList<Customer>(economyCreditOffer.getCustomersSet()).get(0).getName()),
                        () -> assertEquals(true, economyCreditOffer.removeCustomer(mike)),
                        () -> assertEquals(0, economyCreditOffer.getCustomersSet().size())
                );
            }

        }

        @Nested
        @DisplayName("When we have a VIP customer")
        class VipCustomer {
            @Test
            @DisplayName("Then you can add him but cannot remove him from an economy credit offer")
            public void testEconomyCreditOfferVipCustomer() {
                assertAll("Verify all conditions for a VIP customer and an economy credit offer",
                        () -> assertEquals("1", economyCreditOffer.getId()),
                        () -> assertEquals(true, economyCreditOffer.addCustomer(john)),
                        () -> assertEquals(1, economyCreditOffer.getCustomersSet().size()),
                        () -> assertTrue(economyCreditOffer.getCustomersSet().contains(john)),
                        () -> assertEquals("John", new ArrayList<Customer>(economyCreditOffer.getCustomersSet()).get(0).getName()),
                        () -> assertEquals(false, economyCreditOffer.removeCustomer(john)),
                        () -> assertEquals(1, economyCreditOffer.getCustomersSet().size())
                );
            }
        }
    }


    @DisplayName("Given there is a business credit offer")
    @Nested
    class BusinessCreditOfferTest {
        private CreditOffer businessCreditOffer;
        private Customer mike;
        private Customer john;

        @BeforeEach
        void setUp() {
            businessCreditOffer = new BusinessCreditOffer("2");
            mike = new Customer("Mike", false);
            john = new Customer("John", true);
        }

        @Nested
        @DisplayName("When we have a usual customer")
        class UsualCustomer {

            @Test
            @DisplayName("Then you cannot add or remove him from a business credit offer")
            public void testBusinessCreditOfferUsualCustomer() {
                assertAll("Verify all conditions for a usual customer and a business credit offer",
                        () -> assertEquals(false, businessCreditOffer.addCustomer(mike)),
                        () -> assertEquals(0, businessCreditOffer.getCustomersSet().size()),
                        () -> assertEquals(false, businessCreditOffer.removeCustomer(mike)),
                        () -> assertEquals(0, businessCreditOffer.getCustomersSet().size())
                );

            }
        }

        @Nested
        @DisplayName("When we have a VIP customer")
        class VipCustomer {
            @Test
            @DisplayName("Then you can add him but cannot remove him from a business credit offer")
            public void testBusinessCreditOfferVipCustomer() {
                assertAll("Verify all conditions for a VIP customer and a business credit offer",
                        () -> assertEquals(true, businessCreditOffer.addCustomer(john)),
                        () -> assertEquals(1, businessCreditOffer.getCustomersSet().size()),
                        () -> assertEquals(false, businessCreditOffer.removeCustomer(john)),
                        () -> assertEquals("John", new ArrayList<Customer>(businessCreditOffer.getCustomersSet()).get(0).getName()),
                        () -> assertEquals(1, businessCreditOffer.getCustomersSet().size())
                );

            }

        }

    }

}
