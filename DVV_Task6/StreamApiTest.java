package demo.streamapi;

import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.slf4j.Slf4j;
import demo.streamapi.models.Product;
import demo.streamapi.models.Order;
import demo.streamapi.repos.CustomerRepo;
import demo.streamapi.repos.OrderRepo;
import demo.streamapi.repos.ProductRepo;

@Slf4j
@DataJpaTest
public class StreamApiTest {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private ProductRepo productRepo;

	@Test
	@DisplayName("Obtain a list of product with category = \"Books\" and price > 100")
	public void exercise0() {
		long startTime = System.currentTimeMillis();
		List<Product> result = productRepo.findAll()
		.stream()
		.filter(p -> p.getCategory().equalsIgnoreCase("Books"))
		.filter(p -> p.getPrice() > 100)
		.collect(Collectors.toList());
		long endTime = System.currentTimeMillis();

		log.info(String.format("exercise 1 - execution time: %1$d ms", (endTime - startTime)));
		result.forEach(p -> log.info(p.toString()));
	}

	@Test
	@DisplayName("Obtain a list of orders with category = \"Baby\"")
	public void exercise1() {
		long startTime = System.currentTimeMillis();
		List<Order> result = orderRepo.findAll()
				.stream()
				.filter(p -> p.getProducts().stream().anyMatch(x -> x.getCategory().equalsIgnoreCase("Baby")))
				.collect(Collectors.toList());
		long endTime = System.currentTimeMillis();

		log.info(String.format("exercise 1 - execution time: %1$d ms", (endTime - startTime)));
		result.forEach(p -> log.info(p.toString()));
	}

	@Test
	@DisplayName("Obtain a list of product with category = \"Toys\" and use to it discount 10%")
	public void exercise2() {
		long startTime = System.currentTimeMillis();
		List<Product> result = productRepo.findAll()
				.stream()
				.filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
				.map(p -> new Product(p.getId(), p.getName(), p.getCategory(), p.getPrice() * 0.9, p.getOrders()))
				.collect(Collectors.toList());
		long endTime = System.currentTimeMillis();

		log.info(String.format("exercise 2 - execution time: %1$d ms", (endTime - startTime)));
		result.forEach(p -> log.info(p.toString()));
	}

	@Test
	@DisplayName("Task 3")
	public void exercise3() {
		long startTime = System.currentTimeMillis();
		Set<Product> result = orderRepo.findAll()
				.stream()
				.filter(o -> o.getCustomer().getTier().equals(2))
				.filter(o -> o.getOrderDate().getDayOfYear() <= 91)
				.map(Order::getProducts)
				.flatMap(Collection::stream)
				.collect(Collectors.toSet());
		long endTime = System.currentTimeMillis();

		log.info(String.format("exercise 3 - execution time: %1$d ms", (endTime - startTime)));
		result.forEach(p -> log.info(p.toString()));
	}

	@Test
	@DisplayName("Obtain a collection of static numbers for all products with \"Books\" category")
	public void exercise4() {
		long startTime = System.currentTimeMillis();

        DoubleSummaryStatistics statistics = productRepo.findAll()
				.stream()
				.filter(p -> p.getCategory().equalsIgnoreCase("Books"))
				.mapToDouble(p -> p.getPrice())
				.summaryStatistics();

		long endTime = System.currentTimeMillis();

		log.info(String.format("exercise 4 - execution time: %1$d ms", (endTime - startTime)));
		log.info(statistics.toString());
	}

}
