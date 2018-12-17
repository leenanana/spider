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
//				影片别名
			    Element info=e.select(".other").first();
//			    影片评分
			    Element rating=e.select(".rating_num").first();
				String num=e.select(".star span").last().text();
//				影片海报
				String pic=e.select(".pic").text();
//				影片语录
				String quote=e.select(".quote span").first().text();
//				影片导演信息
				String bd=e.select(".bd p").first().text();
				System.out.println(t.text());
				System.out.println(t.text()+","+num);
                System.out.println("别名  "+info.text());
                System.out.println("评分"+rating.text());
                System.out.println(t.text()+","+pic);
                System.out.println(t.text()+","+"语录"+quote);
                System.out.println(t.text()+","+bd);
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
