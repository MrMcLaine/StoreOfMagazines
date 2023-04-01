package ua.magazines;

import ua.magazines.entity.Magazine;
import ua.magazines.entity.Role;
import ua.magazines.entity.User;

public class TestData {

    public static final User CREATED_USER = new User("testFirstName", "testLastName",
            "test@example.com", "password", Role.USER);
    public static final Magazine CREATED_MAGAZINE = new Magazine("testName",
            "testDescription", 22.33);
}
