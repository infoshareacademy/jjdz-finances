package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.Asset;
import com.infoshareacademy.finances.model.PlanCreationDto;
import com.infoshareacademy.finances.model.PlanViewDto;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class InMemoryPlanDaoTest {

   private InMemoryPlanDao sut;

    private Matcher<PlanViewDto> equivalentToCreation(final PlanCreationDto creation) {
        return new BaseMatcher<PlanViewDto>() {
            @Override
            public boolean matches(final Object item) {
                final PlanViewDto view = (PlanViewDto) item;
                return view.getSellTime().equals(creation.getSellTime())
                        && view.getBuyTime().equals(creation.getBuyTime())
                        && view.getAsset().equals(creation.getAsset());
            }
            @Override
            public void describeTo(final Description description) {
                description.appendText("getNumber should return ").appendValue(creation);
            }
        };
    }
    @Before
    public void initialize() {
        sut = new InMemoryPlanDao();
        sut.create(new PlanCreationDto(ZonedDateTime.now(), ZonedDateTime.now().minusDays(6), mock(Asset.class), 20));
        sut.create(new PlanCreationDto(ZonedDateTime.now().minusHours(8), ZonedDateTime.now().plusDays(4), mock(Asset.class), 30));
        sut.create(new PlanCreationDto(ZonedDateTime.of(2015, 4, 23, 0, 0, 0, 0, ZoneId.systemDefault()),
                ZonedDateTime.of(2015, 5, 23, 0, 0, 0, 0, ZoneId.systemDefault()),
                mock(Asset.class), 23));
    }

    @Test
    public void testCreate() throws Exception {
        //given
        PlanCreationDto creation = new PlanCreationDto(ZonedDateTime.now().plusMonths(5), ZonedDateTime.now().minusDays(6), mock(Asset.class), 3);
        int idTest = sut.create(creation);
        //when
        PlanViewDto read = sut.read(idTest);
        //then
        assertEquals(equivalentToCreation(creation).matches(read), true);
        assertEquals(read.getBuyTime(), creation.getBuyTime());
        assertEquals("Check id number", 4, read.getId());
    }


    @Test
    public void testRead() throws Exception {
        //given
        int idTest = 3;
        //when
        PlanViewDto read = sut.read(idTest);
        //then
        assertEquals("Check read buy time", ZonedDateTime.of(2015, 4, 23, 0, 0, 0, 0, ZoneId.systemDefault()), read.getSellTime());
    }

    @Test
    public void testUpdate() throws Exception {
        //given
        int idTest = 2;
        PlanCreationDto planCreationDtoTest = new PlanCreationDto(ZonedDateTime.of(2016, 4, 1, 0, 0, 0, 0, ZoneId.systemDefault()),
            ZonedDateTime.of(2016, 1, 1, 0, 0, 0, 0, ZoneId.systemDefault()), mock(Asset.class), 3);
        //when
        sut.update(idTest, planCreationDtoTest);
        //then
        assertEquals(planCreationDtoTest.getBuyTime(), sut.read(idTest).getBuyTime());
    }

    @Test
    public void testDelete() throws Exception {
        //given
        int idTest = 1;
        //when
        sut.delete(idTest);
        //then
        assertEquals(sut.read(1), null);
    }



}