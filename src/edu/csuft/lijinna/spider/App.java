package edu.csuft.lijinna.spider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App {
   
	//	alt+/
	
    //ctrl+s
	public static void main(String[] args) {
   //		目标URL
		String url="https://movie.douban.com/top250";
     //		使用JSOUP抓取文档
		try {
			Document doc= Jsoup.connect(url).get();
			
			Elements es =doc.select(".grid_view .item");
			System.out.println(es.size());
			
//			创建一个影片的列表
			ArrayList<film> list=new ArrayList<>();
			
			for(Element e :es) {
//				.代表的是class
//				  每一部影片
				film f=new film();
				
				Element t =e.select(".title").first();
				String num=e.select(".star span").last().text();
				System.out.println(t.text()+","+num);
				System.out.println(t.text());

//				f.id
//				f.title
				list.add(f);
				
			}
			
//			String title=doc.title();
//			String data=doc.data();
//			
//			System.out.println(title);
//			System.out.println(data);
		    	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
