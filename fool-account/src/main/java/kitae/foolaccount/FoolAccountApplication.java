package kitae.foolaccount;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;

@SpringBootApplication
public class FoolAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoolAccountApplication.class, args);
		final String naverUrl = "https://finance.naver.com/sise/";
		Connection conn = Jsoup.connect(naverUrl);

		try {
			Document document = conn.get();
			Elements corporation = document.select("#popularItemList li a");
			Elements price = document.select("#popularItemList span");

			ArrayList<String> corporation1 = new ArrayList<>();
			ArrayList<String> price1 = new ArrayList<>();

			for(Element corporation_name : corporation){
				corporation1.add(corporation_name.text());
			}

			for(Element priceInfo : price){
				price1.add(priceInfo.text());
			}

			System.out.println("-----오늘의 인기 주식-----");

			for(int i=0;i<corporation1.size();i++){
				System.out.print(corporation1.get(i));
				System.out.print(" : ");
				System.out.println(price1.get(2*i) + " " + price1.get(2*i+1));
			}

		} catch (
				IOException e){
			e.printStackTrace();
		}
	}

}
