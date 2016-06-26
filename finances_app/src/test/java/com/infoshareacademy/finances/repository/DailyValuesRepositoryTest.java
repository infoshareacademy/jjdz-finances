package com.infoshareacademy.finances.repository;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.infoshareacademy.finances.entity.DailyValue;
import com.infoshareacademy.finances.entity.DailyValueEntity;

@Ignore
//need to have DB for integration tests
@RunWith(Arquillian.class)
public class DailyValuesRepositoryTest {

	@Deployment
	public static WebArchive deployment() {
		WebArchive archive = ShrinkWrap.create(WebArchive.class).addAsResource("META-INF/persistence.xml ")
				.addClasses(LocalDate.class, DailyValuesRepository.class).addClasses(DailyValueEntity.class);
		return archive;
	}

	@EJB
	DailyValuesRepository dailyValuesRepository;

	@Test
	public void testFindDailyValuesByRange_check_if_select_one_month_works() throws Exception {
		LocalDate dateFrom = LocalDate.now().withMonth(5).withYear(2014).withDayOfMonth(1);
		int interval = dateFrom.lengthOfMonth();
		LocalDate dateTo = dateFrom.withDayOfMonth(interval);
		String code = "SEB001";
		List<DailyValue> dailyValuesByRange = dailyValuesRepository
				.findDailyValuesByRange(code, dateFrom, dateTo);

		dailyValuesByRange.forEach(f -> System.out.println(f));
	}
}