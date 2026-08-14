package com.example.aiapplication.util;

import com.example.aiapplication.model.Product;
import com.example.aiapplication.service.ProductService;
import dev.langchain4j.agent.tool.Tool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ProductTool {

	private final ProductService productService;

	public ProductTool(ProductService productService) {
		this.productService = productService;
	}


	@Tool(
			name = "findLaptopsUnderPrice",
			value = "Find laptops that cost less than or equal to the given price"
	)
	public List<Product> findLaptopsUnderPrice(double maxPrice) {
		System.out.println("TOOL CALLED: findLaptopsUnderPrice(" + maxPrice + ")");
		List<Product> result = productService.findLaptopsUnderPrice(maxPrice);
		System.out.println("PRODUCTS RETURNED: " + result.size());
		return result;
	}

	@Tool(
			name = "findProductsByName",
			value = "Find products by name"
	)
	public List<Product> findProductsByName(String name) {
		System.out.println("TOOL CALLED: findProductsByName(" + name + ")");
		List<Product> result = productService.findProductsByName(name);
		System.out.println("PRODUCTS RETURNED: " + result.size());
		return result;
	}

	@Tool(
			name = "findProductsByCategory",
			value = "Find products by category"
	)
	public List<Product> findProductsByCategory(String category) {

		if (category == null) {
			return null;
		}

		String normalizedCategory = switch (category.toLowerCase().trim()) {
			case "laptops", "laptop" -> "laptop";
			case "phones", "phone" -> "phone";
			case "tablets", "tablet" -> "tablet";
			default -> category.toLowerCase().trim();
		};

		System.out.println("TOOL CALLED: findProductsByCategory(" + normalizedCategory + ")");
		List<Product> result = productService.findProductsByCategory(normalizedCategory);
		System.out.println("PRODUCTS RETURNED: " + result.size());
		return result;
	}

	@Tool(
			name = "getAllProducts",
			value = "Get all apple products"
	)
	public List<Product> getAllProducts() {
		log.info("TOOL CALLED: get all Apple Products()");
		System.out.println("TOOL CALLED: get all Apple Products()");
		List<Product> result = productService.findAllAppleLaptops();
		System.out.println("PRODUCTS : " + result.size());
		return result;
	}


}
