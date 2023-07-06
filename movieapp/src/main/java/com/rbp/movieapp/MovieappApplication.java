package com.rbp.movieapp;

import com.rbp.movieapp.models.ERole;
import com.rbp.movieapp.models.Movie;
import com.rbp.movieapp.models.Role;
import com.rbp.movieapp.repository.MovieRepository;
import com.rbp.movieapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.math.BigInteger;
import java.util.List;

@SpringBootApplication
public class MovieappApplication implements CommandLineRunner {

   @Autowired
   private MovieRepository movieRepository;
   @Autowired
   private RoleRepository roleRepository;

   @Autowired
   private MongoTemplate mongoTemplate;


   public static void main(String[] args) {
      SpringApplication.run(MovieappApplication.class, args);
   }

   @Override
   public void run(String... args) throws Exception {

      mongoTemplate.dropCollection("roles");
//    mongoTemplate.dropCollection("ticket");
//    mongoTemplate.dropCollection("users");
      mongoTemplate.dropCollection("movie");

      Movie movie1 = new Movie(BigInteger.valueOf(111L),"Leo","inox",126,"Book ASAP");
      Movie movie2 = new Movie(BigInteger.valueOf(222L),"T68","inox",122,"Book ASAP");
      Movie movie3 = new Movie(BigInteger.valueOf(333L),"Indian2","inox",2,"Book ASAP");
      Movie movie4 = new Movie(BigInteger.valueOf(444L),"Spider man","inox",1,"Book ASAP");

      movieRepository.saveAll(List.of(movie1,movie2,movie3,movie4));

      Role admin = new Role(ERole.ROLE_ADMIN);
      Role user = new Role(ERole.ROLE_USER);

      roleRepository.saveAll(List.of(admin,user));
   }
}

 

