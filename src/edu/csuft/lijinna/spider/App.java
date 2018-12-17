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
   //		Ŀ��URL
		String url="https://movie.douban.com/top250";
     //		ʹ��JSOUPץȡ�ĵ�
		try {
			Document doc= Jsoup.connect(url).get();
			
			Elements es =doc.select(".grid_view .item");
			System.out.println(es.size());
			
//			����һ��ӰƬ���б�
			ArrayList<film> list=new ArrayList<>();
			
			for(Element e :es) {
//				.�������class
//				  ÿһ��ӰƬ
				film f=new film();
				
				Element t =e.select(".title").first();
//				ӰƬ����
			    Element info=e.select(".other").first();
//			    ӰƬ����
			    Element rating=e.select(".rating_num").first();
				String num=e.select(".star span").last().text();
//				ӰƬ����
				String pic=e.select(".pic").text();
//				ӰƬ��¼
				String quote=e.select(".quote span").first().text();
//				ӰƬ������Ϣ
				String bd=e.select(".bd p").first().text();
				System.out.println(t.text());
				System.out.println(t.text()+","+num);
                System.out.println("����  "+info.text());
                System.out.println("����"+rating.text());
                System.out.println(t.text()+","+pic);
                System.out.println(t.text()+","+"��¼"+quote);
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
