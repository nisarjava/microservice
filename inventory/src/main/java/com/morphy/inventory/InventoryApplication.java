package com.morphy.inventory;

import com.morphy.inventory.domain.Inventory;
import com.morphy.inventory.repository.InventoryRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Product API", version = "2.0", description = "Product Information"))
public class InventoryApplication {

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(InventoryApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadStaticData(InventoryRepository repo){
return args->{

            repo.saveAll(List.of(new Inventory(1,"Iphone 12",100),new Inventory(1,"Iphone13",2)));
        };

    }
}
