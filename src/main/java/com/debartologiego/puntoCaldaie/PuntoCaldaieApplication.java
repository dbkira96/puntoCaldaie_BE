package com.debartologiego.puntoCaldaie;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;

@SpringBootApplication
@EnableScheduling
public class PuntoCaldaieApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(PuntoCaldaieApplication.class,args);
	}
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

	@Scheduled(cron = "0 0 11 * * MON")
	public void backup(){
		try {
			URL url=new URL("http://localhost:8080/puntocaldaie/clienti/getAll");
			FileWriter f = new FileWriter("C:\\Users\\dbkir\\OneDrive\\Backups\\backup"+ LocalDate.now().toString()+".js");

			URLConnection con= url.openConnection();
			InputStream is =con.getInputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			String line = null;


			while ((line = br.readLine()) != null) {

				f.write(line);
			}
			f.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
