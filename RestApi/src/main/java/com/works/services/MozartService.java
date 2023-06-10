package com.works.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class MozartService {


    public void result() {
        String baseUrl = "http://yiboyoung.com/music/mozart/mozart_complete/1EARLIERSYMPHONIES/";
        try {
            String url = baseUrl+"EARLYSYMPHONIES.htm";
            Document doc = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get();
            Elements fonts = doc.getElementsByAttributeValue("size", "+2");
            for(Element item : fonts) {

                String objTitle = item.toString();
                if ( !objTitle.contains("a href=") ) {
                    String title = item.text().toString();
                    if ( !title.isEmpty() ) {
                        System.out.println("Title : " + title);
                    }
                }else {
                    String subTitle = item.text().toString();
                    if ( !subTitle.isEmpty() ) {
                        String href = baseUrl + item.getAllElements().attr("href");
                        System.out.println("-- subTitle : " + subTitle + " url : " + href);
                    }
                }


            }
        }catch (Exception ex) {
            System.err.println("Mozart Error : " + ex);
        }
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