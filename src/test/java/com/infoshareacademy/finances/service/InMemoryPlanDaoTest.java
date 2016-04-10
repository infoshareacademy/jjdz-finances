package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.Asset;
import com.infoshareacademy.finances.model.PlanCreationDto;
import com.infoshareacademy.finances.model.PlanViewDto;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class InMemoryPlanDaoTest {

   private InMemoryPlanDao sut;

    private Matcher<PlanViewDto> equivalentToCreation(final PlanCreationDto creation) {
        return new BaseMatcher<PlanViewDto>() {
            @Override
            public boolean matches(final Object item) {
                final PlanViewDto view = (PlanViewDto) item;
                return view.getAsset().equals(creation.getAsset())
                        && view.getSellTime().equals(creation.getSellTime())
                        && view.getBuyTime().equals(creation.getBuyTime());
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
        sut.create(new PlanCreationDto(ZonedDateTime.now(), ZonedDateTime.now().minusDays(6), mock(Asset.class)));
        sut.create(new PlanCreationDto(ZonedDateTime.now().minusHours(8), ZonedDateTime.now().plusDays(4), mock(Asset.class)));
        //sut.create(new PlanCreationDto(ZonedDateTime.of(2015, 4, 23, 0, 0, 0, 0, ZoneId.systemDefault()),
    }

    @Test


    public void testCreate() throws Exception {
        //given
        PlanCreationDto creation = new PlanCreationDto(ZonedDateTime.now().plusMonths(5), ZonedDateTime.now().minusDays(6), mock(Asset.class));
        int idTest = sut.create(creation);
        //when
        PlanViewDto readed = sut.read(idTest);
        //then
        assertThat(readed, equivalentToCreation(creation));
    }
@Ignore
    @Test
    public void testRead() throws Exception {

    }
@Ignore
    @Test
    public void testUpdate() throws Exception {

    }
@Ignore
    @Test
    public void testDelete() throws Exception {

    }



}