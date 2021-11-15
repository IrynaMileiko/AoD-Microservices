package com.sirusservice.sirus.service;

import com.sirusservice.sirus.entity.SirusNew;
import com.sirusservice.sirus.repository.SirusRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SirusService {
    SirusRepository repository = new SirusRepository();

    public void update() throws IOException {
        List<SirusNew> newsList = new ArrayList<>();
        String html = getHtml();
        Document document = Jsoup.parse(html);
        Elements news = document.select("div.post__title--cover");
        //System.out.println(news);
        for(int i=0;i<news.size();++i){
            //System.out.println(news.get(i));
            Document curNew = Jsoup.parse(news.get(i).toString());
            Elements spanDate = curNew.select("span");
            //System.out.println(spanDate.get(1).text());
            String date = spanDate.get(1).text() + " 00:00:00";
            Elements links = curNew.select("a[href]");
            //System.out.println(links.text());
            String name = Objects.requireNonNull(links.first()).text();
            //System.out.println(links.attr("href"));
            String href = links.attr("href");
            SirusNew sirusNew = new SirusNew(date,name,href);
            newsList.add(sirusNew);
        }
        repository.update(newsList);
    }

    public String getHtml() throws IOException {
        String sirus = "https://sirus.su/";
        String html = Jsoup.connect(sirus).get().html();
        //System.out.println(html);
        return html;
    }
}
