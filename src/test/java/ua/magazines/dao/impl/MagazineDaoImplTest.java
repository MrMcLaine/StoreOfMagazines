package ua.magazines.dao.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.magazines.dao.MagazineDao;
import ua.magazines.entity.Magazine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static ua.magazines.TestData.CREATED_MAGAZINE;

public class MagazineDaoImplTest {
    private MagazineDao magazineDao;

    @Before
    public void setUp() throws Exception {
        magazineDao = new MagazineDaoImpl();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
        Magazine mFromDB = magazineDao.create(CREATED_MAGAZINE);
        Double priceForMount = mFromDB.getPriceForMount();
        assertNotNull(mFromDB.getId());
        assertEquals("testName", mFromDB.getName());
        assertEquals("testDescription", mFromDB.getDescription());
        assertEquals(priceForMount, mFromDB.getPriceForMount());
    }

    @Test
    public void read() {
        magazineDao.create(CREATED_MAGAZINE);
        Integer id = CREATED_MAGAZINE.getId();
        Double priceForMount = CREATED_MAGAZINE.getPriceForMount();
        Magazine persistedMagazine = magazineDao.read(id);
        assertNotNull(persistedMagazine);
        assertEquals("testName", CREATED_MAGAZINE.getName());
        assertEquals("testDescription", CREATED_MAGAZINE.getDescription());
        assertEquals(priceForMount, CREATED_MAGAZINE.getPriceForMount());
    }

}