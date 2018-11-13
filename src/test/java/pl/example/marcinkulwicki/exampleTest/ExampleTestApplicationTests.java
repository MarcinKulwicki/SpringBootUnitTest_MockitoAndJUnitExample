package pl.example.marcinkulwicki.exampleTest;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.example.marcinkulwicki.exampleTest.repository.DataService;
import pl.example.marcinkulwicki.exampleTest.service.BusinessService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleTestApplicationTests {

	@MockBean
	DataService dataServiceMock;
	@Autowired
	BusinessService businessImpl;

	@Test
	public void testFindTheGreatestFromAllData() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24, 15, 5});
		assertEquals(24, businessImpl.findTheGreatestFromAllData());
	}
	@Test
	public void testFindTheGreatestFromAllData_ForOneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 15 });
		assertEquals(15, businessImpl.findTheGreatestFromAllData());
	}

	@Test
	public void testFindTheGreatestFromAllData_NoValues() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
	}

}
