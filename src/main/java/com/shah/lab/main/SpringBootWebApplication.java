/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.shah.lab.main;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import com.shah.lab.dao.PatientRepository;
import com.shah.lab.model.User;
import static java.lang.System.exit;

@SpringBootApplication
@ComponentScan("com.shah.lab")
@EntityScan("com.shah.lab.model")
@EnableJpaRepositories("com.shah.lab.dao")
public class SpringBootWebApplication extends SpringBootServletInitializer implements CommandLineRunner{
	@Autowired
    DataSource dataSource;
	@Autowired
	private PatientRepository repository;
  public static void main(String[] args) throws Exception {
    SpringApplication.run(SpringBootWebApplication.class, args);
  }

  @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootWebApplication.class);
	}
  @Transactional(readOnly = true)
  @Override
  public void run(String... args) throws Exception {
	  System.out.println("DATASOURCE = " + dataSource);

      System.out.println("\n1.findAll()...");
      for (User customer : repository.findAll()) {
          System.out.println(customer);
      }
     
  }
 }
