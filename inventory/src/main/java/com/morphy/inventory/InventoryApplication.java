package com.morphy.inventory;

import com.morphy.inventory.domain.Inventory;
import com.morphy.inventory.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadStaticData(InventoryRepository repo){
return args->{

            repo.saveAll(List.of(new Inventory(1,"Iphone 12",100),new Inventory(1,"Iphone13",2)));
        };

    }
}
