package com.works.services;

import com.works.models.Item;
import com.works.models.MusicCategory;
import com.works.models.MusicCategoryList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MozartService {


    public MusicCategoryList result() {

        String baseUrl = "http://yiboyoung.com/music/mozart/mozart_complete/1EARLIERSYMPHONIES/";
        Map<Integer, String> hmTitle = new HashMap<>();
        List<Item> items = new ArrayList<>();
        try {
            String url = baseUrl+"EARLYSYMPHONIES.htm";
            Document doc = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get();
            Elements fonts = doc.getElementsByAttributeValue("size", "+2");
            int countTitle = 0;
            for(Element item : fonts) {
                String objTitle = item.toString();
                if ( !objTitle.contains("a href=") ) {
                    String title = item.text().toString();
                    if ( !title.isEmpty() ) {
                        System.out.println("Title : " + title);
                        hmTitle.put(countTitle, title);
                        countTitle++;
                    }
                }else {
                    String subTitle = item.text().toString();
                    if ( !subTitle.isEmpty() ) {
                        String href = baseUrl + item.getAllElements().attr("href");
                        Item item1 = new Item();
                        item1.setBaseCat(countTitle);
                        item1.setTitle(subTitle);
                        item1.setUrl(href);
                        items.add(item1);
                    }
                }

            }
        }catch (Exception ex) {
            System.err.println("Mozart Error : " + ex);
        }
        MusicCategoryList musicCategoryList = new MusicCategoryList();
        musicCategoryList.setMusicCategories( parseData( hmTitle, items ) );
        System.out.println(hmTitle);
        System.out.println(items);
        return musicCategoryList;
    }

    private List<MusicCategory> parseData(Map<Integer, String> hmTitle, List<Item> items) {

        return null;
    }

}


/*
[

{
    baseTitle: Symphony No.1 in E flat, KV 16
    musics: [
       { title: "Allegro molto", url: "http://yiboyoung.com/music/mozart/mozart_complete/1EARLIERSYMPHONIES/EARLYSYMPHONIES_files/01a01.mp3" },
       { title: "Andante", url: "http://yiboyoung.com/music/mozart/mozart_complete/1EARLIERSYMPHONIES/EARLYSYMPHONIES_files/01a01.mp3" },
       { title: "Presto", url: "http://yiboyoung.com/music/mozart/mozart_complete/1EARLIERSYMPHONIES/EARLYSYMPHONIES_files/01a01.mp3" },
    ]
},

{
    baseTitle: Symphony No.1 in E flat, KV 16
    musics: [
       { title: "Allegro molto", url: "http://yiboyoung.com/music/mozart/mozart_complete/1EARLIERSYMPHONIES/EARLYSYMPHONIES_files/01a01.mp3" },
       { title: "Andante", url: "http://yiboyoung.com/music/mozart/mozart_complete/1EARLIERSYMPHONIES/EARLYSYMPHONIES_files/01a01.mp3" },
       { title: "Presto", url: "http://yiboyoung.com/music/mozart/mozart_complete/1EARLIERSYMPHONIES/EARLYSYMPHONIES_files/01a01.mp3" },
    ]
}

]


 */