package com.ClinicService;

import com.ClinicService.model.Visit;
import com.ClinicService.repository.VisitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ClinicServiceApplicationTests {

	@Autowired
	private VisitRepository visitRepository;


	@Test
	public void shouldFindVisitByDateAndDoctor_ID() {
		//given
		List<Visit> visitList = visitRepository.findVisitByDoctor_IdAndDateBetween(1,LocalDateTime.parse("2021-02-15T00:00:00"),LocalDateTime.parse("2021-02-16T00:00:00"));

		assertThat(visitList).hasSize(2);
	}

}
