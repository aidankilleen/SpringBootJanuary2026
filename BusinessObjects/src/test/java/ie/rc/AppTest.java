package ie.rc;


import ie.rc.daos.UserDao;
import org.junit.jupiter.api.Test;

import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public void alwaysFails() {
        assertEquals(1, 2);
    }


}
