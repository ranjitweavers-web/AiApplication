package com.example.aiapplication.service;

import com.example.aiapplication.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    public final List<Product> products = List.of(
            new Product(1L, "Dell Inspiron 15", "laptop", 650, 8),
            new Product(2L, "Dell Inspiron 16", "laptop", 780, 16),
            new Product(3L, "Dell XPS 13", "laptop", 999, 16),
            new Product(4L, "Dell XPS 15", "laptop", 1399, 32),
            new Product(5L, "Dell Latitude 5440", "laptop", 920, 16),
            new Product(6L, "Dell Latitude 7440", "laptop", 1250, 16),
            new Product(7L, "Dell G15 Gaming", "laptop", 1100, 16),
            new Product(8L, "Dell G16 Gaming", "laptop", 1450, 32),
            new Product(9L, "Dell Vostro 3520", "laptop", 600, 8),
            new Product(10L, "Dell Vostro 5620", "laptop", 850, 16),

            new Product(11L, "Lenovo IdeaPad 3", "laptop", 550, 8),
            new Product(12L, "Lenovo IdeaPad 5", "laptop", 700, 16),
            new Product(13L, "Lenovo IdeaPad Slim 5", "laptop", 780, 16),
            new Product(14L, "Lenovo ThinkPad E14", "laptop", 820, 16),
            new Product(15L, "Lenovo ThinkPad E16", "laptop", 900, 16),
            new Product(16L, "Lenovo ThinkPad T14", "laptop", 1200, 16),
            new Product(17L, "Lenovo ThinkPad T16", "laptop", 1400, 32),
            new Product(18L, "Lenovo Legion 5", "laptop", 1150, 16),
            new Product(19L, "Lenovo Legion 7", "laptop", 1600, 32),
            new Product(20L, "Lenovo Yoga 7", "laptop", 950, 16),

            new Product(21L, "HP Pavilion 14", "laptop", 650, 8),
            new Product(22L, "HP Pavilion 15", "laptop", 720, 16),
            new Product(23L, "HP Pavilion Plus", "laptop", 850, 16),
            new Product(24L, "HP Envy 13", "laptop", 900, 16),
            new Product(25L, "HP Envy 16", "laptop", 1250, 32),
            new Product(26L, "HP Spectre x360", "laptop", 1350, 16),
            new Product(27L, "HP EliteBook 640", "laptop", 950, 16),
            new Product(28L, "HP EliteBook 840", "laptop", 1200, 16),
            new Product(29L, "HP Omen 16", "laptop", 1300, 32),
            new Product(30L, "HP Victus 15", "laptop", 850, 16),

            new Product(31L, "Apple MacBook Air M2", "laptop", 999, 8),
            new Product(32L, "Apple MacBook Air M2 16GB", "laptop", 1199, 16),
            new Product(33L, "Apple MacBook Air M3", "laptop", 1099, 8),
            new Product(34L, "Apple MacBook Air M3 16GB", "laptop", 1299, 16),
            new Product(35L, "Apple MacBook Air M4", "laptop", 999, 16),
            new Product(36L, "Apple MacBook Pro M3", "laptop", 1599, 16),
            new Product(37L, "Apple MacBook Pro M3 Pro", "laptop", 1999, 18),
            new Product(38L, "Apple MacBook Pro M4", "laptop", 1699, 24),
            new Product(39L, "Apple MacBook Pro M4 Pro", "laptop", 2199, 24),
            new Product(40L, "Apple MacBook Pro 16", "laptop", 2499, 36),

            new Product(41L, "Acer Aspire 3", "laptop", 500, 8),
            new Product(42L, "Acer Aspire 5", "laptop", 650, 16),
            new Product(43L, "Acer Aspire 7", "laptop", 800, 16),
            new Product(44L, "Acer Swift 3", "laptop", 750, 16),
            new Product(45L, "Acer Swift Go 14", "laptop", 850, 16),
            new Product(46L, "Acer Swift X", "laptop", 1000, 16),
            new Product(47L, "Acer Nitro 5", "laptop", 900, 16),
            new Product(48L, "Acer Nitro V", "laptop", 950, 16),
            new Product(49L, "Acer Predator Helios", "laptop", 1400, 32),
            new Product(50L, "Acer Predator Triton", "laptop", 1700, 32),

            new Product(51L, "Asus VivoBook 15", "laptop", 600, 8),
            new Product(52L, "Asus VivoBook 16", "laptop", 700, 16),
            new Product(53L, "Asus VivoBook S15", "laptop", 850, 16),
            new Product(54L, "Asus ZenBook 14", "laptop", 950, 16),
            new Product(55L, "Asus ZenBook 15", "laptop", 1100, 16),
            new Product(56L, "Asus ROG Strix G16", "laptop", 1400, 32),
            new Product(57L, "Asus ROG Zephyrus G14", "laptop", 1500, 32),
            new Product(58L, "Asus TUF Gaming A15", "laptop", 1000, 16),
            new Product(59L, "Asus TUF Gaming F15", "laptop", 900, 16),
            new Product(60L, "Asus ExpertBook B1", "laptop", 750, 16),

            new Product(61L, "MSI Modern 14", "laptop", 650, 8),
            new Product(62L, "MSI Modern 15", "laptop", 750, 16),
            new Product(63L, "MSI Prestige 14", "laptop", 1000, 16),
            new Product(64L, "MSI Prestige 16", "laptop", 1300, 32),
            new Product(65L, "MSI Katana 15", "laptop", 1050, 16),
            new Product(66L, "MSI Katana 17", "laptop", 1200, 16),
            new Product(67L, "MSI Cyborg 15", "laptop", 950, 16),
            new Product(68L, "MSI Raider GE68", "laptop", 1800, 32),
            new Product(69L, "MSI Stealth 16", "laptop", 1700, 32),
            new Product(70L, "MSI Creator Z16", "laptop", 1600, 32),

            new Product(71L, "Microsoft Surface Laptop 5", "laptop", 900, 8),
            new Product(72L, "Microsoft Surface Laptop 5 16GB", "laptop", 1100, 16),
            new Product(73L, "Microsoft Surface Laptop 6", "laptop", 1200, 16),
            new Product(74L, "Microsoft Surface Laptop Studio", "laptop", 1500, 32),
            new Product(75L, "Microsoft Surface Pro 9", "laptop", 1000, 16),

            new Product(76L, "Razer Blade 14", "laptop", 1800, 32),
            new Product(77L, "Razer Blade 15", "laptop", 2000, 32),
            new Product(78L, "Razer Blade 16", "laptop", 2400, 32),
            new Product(79L, "Razer Book 13", "laptop", 1100, 16),
            new Product(80L, "Razer Blade Stealth", "laptop", 1300, 16),

            new Product(81L, "LG Gram 14", "laptop", 1000, 16),
            new Product(82L, "LG Gram 15", "laptop", 1100, 16),
            new Product(83L, "LG Gram 16", "laptop", 1250, 16),
            new Product(84L, "LG Gram Pro 16", "laptop", 1500, 32),
            new Product(85L, "LG UltraPC", "laptop", 850, 16),

            new Product(86L, "Samsung Galaxy Book 3", "laptop", 800, 8),
            new Product(87L, "Samsung Galaxy Book 4", "laptop", 950, 16),
            new Product(88L, "Samsung Galaxy Book 4 Pro", "laptop", 1300, 16),
            new Product(89L, "Samsung Galaxy Book 4 Ultra", "laptop", 1800, 32),
            new Product(90L, "Samsung Galaxy Book Go", "laptop", 500, 8),

            new Product(91L, "Framework Laptop 13", "laptop", 900, 16),
            new Product(92L, "Framework Laptop 16", "laptop", 1400, 32),
            new Product(93L, "Framework Laptop 13 AMD", "laptop", 950, 16),
            new Product(94L, "Framework Laptop 16 Gaming", "laptop", 1600, 32),
            new Product(95L, "Framework Laptop 13 Intel", "laptop", 1000, 16),

            new Product(96L, "Huawei MateBook D15", "laptop", 650, 8),
            new Product(97L, "Huawei MateBook 14", "laptop", 850, 16),
            new Product(98L, "Huawei MateBook X Pro", "laptop", 1300, 16),
            new Product(99L, "Huawei MateBook GT", "laptop", 1500, 32),
            new Product(100L, "Huawei MateBook 16", "laptop", 1100, 16)
    );

    public List<Product> findLaptopsUnderPrice(double maxPrice) {
        return products.stream()
                .filter(product -> product.category().equalsIgnoreCase("laptop") && product.price() <= maxPrice)
                .toList();
    }

    public List<Product> findProductsByName(String name){
        return products.stream()
                .filter(product -> product.name().toLowerCase().startsWith(name.toLowerCase()))
                .toList();
    }

    public List<Product> findProductsByCategory(String category){
        return products.stream()
                .filter(product -> product.category().equalsIgnoreCase(category))
                .toList();
    }

    public List<Product> findAllAppleLaptops(){
        return products.stream()
                .filter(product -> product.name().toLowerCase().contains("apple"))
                .toList();
    }


}
