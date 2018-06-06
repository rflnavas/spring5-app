package guru.springframework.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

	Category category;
	
	@Before
	public void setUp() {
		category = new Category();
	}
	
	@Test
	public void testGetId() {
		Long idValue = 4L;
		category.setId(idValue);
		assertEquals(idValue, category.getId());
	}

	@Test
	public void testGetCategoryName() {
	}

	@Test
	public void testGetRecipes() {
	}

}
