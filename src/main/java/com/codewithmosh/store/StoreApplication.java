package com.codewithmosh.store;

import com.codewithmosh.store.entities.Address;
import com.codewithmosh.store.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {

        SpringApplication.run(StoreApplication.class, args);

//    var user = User.builder()
//            .name("Mosh").email("poah@mail.com").password("123456")
//            .build();
//
//    var address = Address.builder()
//            .street("123 Main St")
//            .city("New York")
//            .state("NY")
//            .zip("10001")
//            .build();
//
//    user.getAddresses().add(address);
//        System.out.println(user);
    }
}
