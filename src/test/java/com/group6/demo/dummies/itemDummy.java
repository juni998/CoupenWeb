package com.group6.demo.dummies;

import com.group6.demo.entity.item.ItemDTO;
import com.group6.demo.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class itemDummy {

    @Autowired
    ItemService itemService;

    @Test
    public void itemDummies() throws Exception{

        for (int i=0; i<30; i++){
            for (int j=1; j<7; j++){
                ItemDTO itemDTO = ItemDTO.builder()
                        .stock((int) (Math.random() *15+1))
                        .price((int) ((Math.random() *20+1)*100))
                        .thumbImg("https://coupenweb.s3.ap-northeast-2.amazonaws.com/grain0"+j+".jpg")
                        .writer("grain"+i)
                        .content("<p>매일매일 신선하게<p>" +
                                "<p>즐길수 있는 곡물>"+i)
                        .title("신선한 곡물"+i)
                        .type("grain")
                        .build();

                itemService.register(itemDTO);
            }

        }
        for (int i=0; i<30; i++){
            for (int j=1; j<7; j++){
                ItemDTO itemDTO = ItemDTO.builder()
                        .stock((int) (Math.random() *15+1))
                        .price((int) ((Math.random() *20+1)*100))
                        .thumbImg("https://coupenweb.s3.ap-northeast-2.amazonaws.com/milk0"+j+".jpg")
                        .writer("milk"+i)
                        .content("<p>매일매일 신선하게<p>" +
                                "<p>즐길수 있는 유제품>"+i)
                        .title("신선한 유제품"+i)
                        .type("milk")
                        .build();

                itemService.register(itemDTO);
            }

        }
        for (int i=0; i<30; i++){
            for (int j=1; j<7; j++){
                ItemDTO itemDTO = ItemDTO.builder()
                        .stock((int) (Math.random() *15+1))
                        .price((int) ((Math.random() *20+1)*100))
                        .thumbImg("https://coupenweb.s3.ap-northeast-2.amazonaws.com/meat0"+j+".jpg")
                        .writer("meat"+i)
                        .content("<p>매일매일 신선하게<p>" +
                                "<p>즐길수 있는 육류>"+i)
                        .title("신선한 육류"+i)
                        .type("meat")
                        .build();

                itemService.register(itemDTO);
            }

        }
        for (int i=0; i<30; i++){
            for (int j=1; j<7; j++){
                ItemDTO itemDTO = ItemDTO.builder()
                        .stock((int) (Math.random() *15+1))
                        .price((int) ((Math.random() *20+1)*100))
                        .thumbImg("https://coupenweb.s3.ap-northeast-2.amazonaws.com/fruit0"+j+".jfif")
                        .writer("fruit"+i)
                        .content("<p>매일매일 싱싱하게<p>" +
                                "<p>즐길수 있는 과일>"+i)
                        .title("유기농 과일 "+i)
                        .type("fruit")
                        .build();

                itemService.register(itemDTO);
            }

        }
        for (int i=0; i<30; i++){
            for (int j=1; j<7; j++){
                ItemDTO itemDTO = ItemDTO.builder()
                        .stock((int) (Math.random() *15+1))
                        .price((int) ((Math.random() *20+1)*100))
                        .thumbImg("https://coupenweb.s3.ap-northeast-2.amazonaws.com/vegetable0"+j+".jpg")
                        .writer("vegetable"+i)
                        .content("<p>매일매일 싱싱하게<p>" +
                                "<p>즐길수 있는 채소>"+i)
                        .title("유기농 채소 "+i)
                        .type("vegetable")
                        .build();

                itemService.register(itemDTO);
            }

        }

    }
    @Test
    public void itemDetailDummies() throws  Exception{
        ItemDTO itemDTO = ItemDTO.builder()
                .stock((int) (Math.random() *15+1))
                .price((int) ((Math.random() *20+1)*100))
                .thumbImg("https://coupenweb.s3.ap-northeast-2.amazonaws.com/milk01.jpg")
                .writer("milk")
                .content("<div class=\"type-TEXT\" style=\"margin: 0px 0px 40px; padding: 0px; box-sizing: border-box; font-family: 'apple sd gothic neo', '맑은 고딕', 'malgun gothic', 나눔고딕, nanumgothic, 돋움, dotum, sans-serif; font-size: 16px; background-color: #ffffff;\">\n" +
                        "<div class=\"subType-TEXT\" style=\"margin: 0px; padding: 0px; box-sizing: border-box;\">\n" +
                        "<div id=\"container-core\" style=\"margin: 20px auto; padding: 0px; box-sizing: border-box; max-width: 780px; width: auto; border: 0px solid #bcbcbc;\">\n" +
                        "<div style=\"margin: 15px 0px 20px; padding: 0px; box-sizing: border-box; border-top: 1px solid #777777;\"><span style=\"box-sizing: border-box; font-size: 2em; line-height: 0.6em; font-weight: bold; letter-spacing: -0.05em; padding: 10px 10px 0px 0px;\">핵심 포인트</span></div>\n" +
                        "<div id=\"content-left\" style=\"margin: 0px 0px 8px; padding: 0px; box-sizing: border-box; width: 390px; float: left;\">\n" +
                        "<table style=\"font-family: 돋움, Dotum, sans-serif; border-spacing: 0px; max-width: 100%; background-color: transparent; border: 0px; width: 390px;\">\n" +
                        "<tbody style=\"box-sizing: border-box;\">\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 46.7917px;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box; max-width: 100px; width: 46.7917px;\" src=\"http://img2a.coupangcdn.com/image/retail/images/6908548076884-591c071e-65b5-4a14-8218-2af66916fcf1.png\" /></td>\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 343.208px; height: 54px; vertical-align: middle;\">\n" +
                        "<p style=\"margin: 10.2917px 0px 10px 6.85417px; padding: 0px; box-sizing: border-box; font-size: 1.2em; font-weight: bold; letter-spacing: -0.03em;\">브랜드&amp;생산지</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box;\" colspan=\"2\">\n" +
                        "<p style=\"margin: 0px 0px 10px; padding: 0px; box-sizing: border-box; font-size: 1.2em; letter-spacing: -0.03em; line-height: 1.4;\">- 우유 외길을 걸어온 조합, 서울우유<br style=\"box-sizing: border-box;\" />- 낙농산업 발전에 기여하는 브랜드</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</tbody>\n" +
                        "</table>\n" +
                        "</div>\n" +
                        "<div id=\"content-right\" style=\"margin: 0px 0px 8px; padding: 0px; box-sizing: border-box; width: 390px; float: right;\">\n" +
                        "<table style=\"font-family: 돋움, Dotum, sans-serif; border-spacing: 0px; max-width: 100%; background-color: transparent; border: 0px; width: 390px;\">\n" +
                        "<tbody style=\"box-sizing: border-box;\">\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 46.7917px;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box; max-width: 100px; width: 46.7917px;\" src=\"http://img2a.coupangcdn.com/image/retail/images/45582454356573-39e83443-639f-477b-9499-9ad5c5a8e0f3.png\" /></td>\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 343.208px; height: 54px; vertical-align: middle;\">\n" +
                        "<p style=\"margin: 10.2917px 0px 10px 6.85417px; padding: 0px; box-sizing: border-box; font-size: 1.2em; font-weight: bold; letter-spacing: -0.03em;\">상품 특징</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box;\" colspan=\"2\">\n" +
                        "<p style=\"margin: 0px 0px 10px; padding: 0px; box-sizing: border-box; font-size: 1.2em; letter-spacing: -0.03em; line-height: 1.4;\">- 신선한 국내산 원유로 제조한 우유<br style=\"box-sizing: border-box;\" />- 본연의 고소하고 깔끔한 맛이 일품</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</tbody>\n" +
                        "</table>\n" +
                        "</div>\n" +
                        "<div id=\"content-left\" style=\"margin: 0px 0px 8px; padding: 0px; box-sizing: border-box; width: 390px; float: left;\">\n" +
                        "<table style=\"font-family: 돋움, Dotum, sans-serif; border-spacing: 0px; max-width: 100%; background-color: transparent; border: 0px; width: 390px;\">\n" +
                        "<tbody style=\"box-sizing: border-box;\">\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 46.7917px;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box; max-width: 100px; width: 46.7917px;\" src=\"http://img2a.coupangcdn.com/image/retail/images/6804456357169-5fbe96be-d61b-469b-8ff3-7ef47235658f.png\" /></td>\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 343.208px; height: 54px; vertical-align: middle;\">\n" +
                        "<p style=\"margin: 10.2917px 0px 10px 6.85417px; padding: 0px; box-sizing: border-box; font-size: 1.2em; font-weight: bold; letter-spacing: -0.03em;\">보관 방법</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box;\" colspan=\"2\">\n" +
                        "<p style=\"margin: 0px 0px 10px; padding: 0px; box-sizing: border-box; font-size: 1.2em; letter-spacing: -0.03em; line-height: 1.4;\">- 냉장 보관(0~10℃)<br style=\"box-sizing: border-box;\" />- 개봉 후 빠른 섭취 권장</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</tbody>\n" +
                        "</table>\n" +
                        "</div>\n" +
                        "<div id=\"content-right\" style=\"margin: 0px 0px 8px; padding: 0px; box-sizing: border-box; width: 390px; float: right;\">\n" +
                        "<table style=\"font-family: 돋움, Dotum, sans-serif; border-spacing: 0px; max-width: 100%; background-color: transparent; border: 0px; width: 390px;\">\n" +
                        "<tbody style=\"box-sizing: border-box;\">\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 46.7917px;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box; max-width: 100px; width: 46.7917px;\" src=\"http://img2a.coupangcdn.com/image/retail/images/6986705065517-d992a00b-8808-4f02-8580-c48f3dc39ba6.png\" /></td>\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 343.208px; height: 54px; vertical-align: middle;\">\n" +
                        "<p style=\"margin: 10.2917px 0px 10px 6.85417px; padding: 0px; box-sizing: border-box; font-size: 1.2em; font-weight: bold; letter-spacing: -0.03em;\">인증과 수상</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box;\" colspan=\"2\">\n" +
                        "<p style=\"margin: 0px 0px 10px; padding: 0px; box-sizing: border-box; font-size: 1.2em; letter-spacing: -0.03em; line-height: 1.4;\">- 안심할 수 있는 HACCP 인증</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</tbody>\n" +
                        "</table>\n" +
                        "</div>\n" +
                        "<div id=\"footer\" style=\"margin: 0px; padding: 10px; box-sizing: border-box; position: relative; clear: both; border-bottom: 0px solid #000000;\">\n" +
                        "<p style=\"margin: 0px 0px 10px; padding: 0px; box-sizing: border-box;\">&nbsp;</p>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<div class=\"type-IMAGE_NO_SPACE\" style=\"margin: 0px; padding: 0px; box-sizing: border-box; font-family: 'apple sd gothic neo', '맑은 고딕', 'malgun gothic', 나눔고딕, nanumgothic, 돋움, dotum, sans-serif; font-size: 16px; background-color: #ffffff;\">\n" +
                        "<div class=\"subType-IMAGE\" style=\"margin: 0px auto; padding: 0px; box-sizing: border-box; width: 780px;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box;\" src=\"https://thumbnail7.coupangcdn.com/thumbnails/remote/q89/image/retail/images/2018/09/03/10/9/ee789a5f-aa42-4b5e-ad6a-7c04c212f160.jpg\" alt=\"\" width=\"100%\" /></div>\n" +
                        "</div>")
                .title("신선한 우유 디테일")
                .type("milk")
                .build();

        itemService.register(itemDTO);

        ItemDTO itemDTO1 = ItemDTO.builder()
                .stock((int) (Math.random() *15+1))
                .price((int) ((Math.random() *20+1)*100))
                .thumbImg("https://coupenweb.s3.ap-northeast-2.amazonaws.com/meat01.jpg")
                .writer("meat")
                .content("\t<div class=\"type-TEXT\" style=\"margin: 0px 0px 40px; padding: 0px; box-sizing: border-box; font-family: 'apple sd gothic neo', '맑은 고딕', 'malgun gothic', 나눔고딕, nanumgothic, 돋움, dotum, sans-serif; font-size: 16px; background-color: #ffffff;\">\n" +
                        "<div class=\"subType-TEXT\" style=\"margin: 0px; padding: 0px; box-sizing: border-box;\">\n" +
                        "<div id=\"container-core\" style=\"margin: 20px auto; padding: 0px; box-sizing: border-box; max-width: 780px; width: auto; border: 0px solid #bcbcbc;\">\n" +
                        "<div style=\"margin: 15px 0px 20px; padding: 0px; box-sizing: border-box; border-top: 1px solid #777777;\"><span style=\"box-sizing: border-box; font-size: 2em; line-height: 0.6em; font-weight: bold; letter-spacing: -0.05em; padding: 10px 10px 0px 0px;\">핵심 포인트</span></div>\n" +
                        "<div id=\"content-left\" style=\"margin: 0px 0px 8px; padding: 0px; box-sizing: border-box; width: 390px; float: left;\">\n" +
                        "<table style=\"font-family: 돋움, Dotum, sans-serif; border-spacing: 0px; max-width: 100%; background-color: transparent; border: 0px; width: 390px;\">\n" +
                        "<tbody style=\"box-sizing: border-box;\">\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 46.7917px;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box; max-width: 100px; width: 46.7917px;\" src=\"http://img2a.coupangcdn.com/image/retail/images/45582454356573-39e83443-639f-477b-9499-9ad5c5a8e0f3.png\" /></td>\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 343.208px; height: 54px; vertical-align: middle;\">\n" +
                        "<p style=\"margin: 10.2917px 0px 10px 6.85417px; padding: 0px; box-sizing: border-box; font-size: 1.2em; font-weight: bold; letter-spacing: -0.03em;\">상품 특징</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box;\" colspan=\"2\">\n" +
                        "<p style=\"margin: 0px 0px 10px; padding: 0px; box-sizing: border-box; font-size: 1.2em; letter-spacing: -0.03em; line-height: 1.4;\">- 프라임 등급 부채살로 엄선한 제품<br style=\"box-sizing: border-box;\" />- 촉촉한 육즙과 은은한 육향을 지닌 부채살</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</tbody>\n" +
                        "</table>\n" +
                        "</div>\n" +
                        "<div id=\"content-right\" style=\"margin: 0px 0px 8px; padding: 0px; box-sizing: border-box; width: 390px; float: right;\">\n" +
                        "<table style=\"font-family: 돋움, Dotum, sans-serif; border-spacing: 0px; max-width: 100%; background-color: transparent; border: 0px; width: 390px;\">\n" +
                        "<tbody style=\"box-sizing: border-box;\">\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 46.7917px;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box; max-width: 100px; width: 46.7917px;\" src=\"http://img2a.coupangcdn.com/image/retail/images/6804456357169-5fbe96be-d61b-469b-8ff3-7ef47235658f.png\" /></td>\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 343.208px; height: 54px; vertical-align: middle;\">\n" +
                        "<p style=\"margin: 10.2917px 0px 10px 6.85417px; padding: 0px; box-sizing: border-box; font-size: 1.2em; font-weight: bold; letter-spacing: -0.03em;\">보관 방법</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box;\" colspan=\"2\">\n" +
                        "<p style=\"margin: 0px 0px 10px; padding: 0px; box-sizing: border-box; font-size: 1.2em; letter-spacing: -0.03em; line-height: 1.4;\">- 냉장 보관(-2~10℃)<br style=\"box-sizing: border-box;\" />- 개봉 후 빠른 섭취 권장</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</tbody>\n" +
                        "</table>\n" +
                        "</div>\n" +
                        "<div id=\"content-left\" style=\"margin: 0px 0px 8px; padding: 0px; box-sizing: border-box; width: 390px; float: left;\">\n" +
                        "<table style=\"font-family: 돋움, Dotum, sans-serif; border-spacing: 0px; max-width: 100%; background-color: transparent; border: 0px; width: 390px;\">\n" +
                        "<tbody style=\"box-sizing: border-box;\">\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 46.7917px;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box; max-width: 100px; width: 46.7917px;\" src=\"http://img2a.coupangcdn.com/image/retail/images/7024063751658-69f3d49c-8443-4cfd-acd3-0d99dc1c3123.png\" /></td>\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 343.208px; height: 54px; vertical-align: middle;\">\n" +
                        "<p style=\"margin: 10.2917px 0px 10px 6.85417px; padding: 0px; box-sizing: border-box; font-size: 1.2em; font-weight: bold; letter-spacing: -0.03em;\">활용법</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box;\" colspan=\"2\">\n" +
                        "<p style=\"margin: 0px 0px 10px; padding: 0px; box-sizing: border-box; font-size: 1.2em; letter-spacing: -0.03em; line-height: 1.4;\">- 바로 조리할 수 있는 냉장육<br style=\"box-sizing: border-box;\" />- 스테이크로 조리하기에 적합한 제품</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</tbody>\n" +
                        "</table>\n" +
                        "</div>\n" +
                        "<div id=\"content-right\" style=\"margin: 0px 0px 8px; padding: 0px; box-sizing: border-box; width: 390px; float: right;\">\n" +
                        "<table style=\"font-family: 돋움, Dotum, sans-serif; border-spacing: 0px; max-width: 100%; background-color: transparent; border: 0px; width: 390px;\">\n" +
                        "<tbody style=\"box-sizing: border-box;\">\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 46.7917px;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box; max-width: 100px; width: 46.7917px;\" src=\"http://img2a.coupangcdn.com/image/retail/images/6986705065517-d992a00b-8808-4f02-8580-c48f3dc39ba6.png\" /></td>\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 343.208px; height: 54px; vertical-align: middle;\">\n" +
                        "<p style=\"margin: 10.2917px 0px 10px 6.85417px; padding: 0px; box-sizing: border-box; font-size: 1.2em; font-weight: bold; letter-spacing: -0.03em;\">인증과 수상</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box;\" colspan=\"2\">\n" +
                        "<p style=\"margin: 0px 0px 10px; padding: 0px; box-sizing: border-box; font-size: 1.2em; letter-spacing: -0.03em; line-height: 1.4;\">- 안심할 수 있는 HACCP 인증</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</tbody>\n" +
                        "</table>\n" +
                        "</div>\n" +
                        "<div id=\"footer\" style=\"margin: 0px; padding: 10px; box-sizing: border-box; position: relative; clear: both; border-bottom: 0px solid #000000;\">\n" +
                        "<p style=\"margin: 0px 0px 10px; padding: 0px; box-sizing: border-box;\">&nbsp;</p>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<div class=\"type-IMAGE_NO_SPACE\" style=\"margin: 0px; padding: 0px; box-sizing: border-box; font-family: 'apple sd gothic neo', '맑은 고딕', 'malgun gothic', 나눔고딕, nanumgothic, 돋움, dotum, sans-serif; font-size: 16px; background-color: #ffffff;\">\n" +
                        "<div class=\"subType-IMAGE\" style=\"margin: 0px auto; padding: 0px; box-sizing: border-box; width: 780px;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box;\" src=\"https://thumbnail8.coupangcdn.com/thumbnails/remote/q89/image/retail/images/1669947588719662-fd54ac21-aceb-423d-b9b3-ef8d60abddfb.jpg\" alt=\"\" width=\"100%\" /></div>\n" +
                        "</div>\n" +
                        "<div class=\"type-TEXT\" style=\"margin: 0px 0px 40px; padding: 0px; box-sizing: border-box; font-family: 'apple sd gothic neo', '맑은 고딕', 'malgun gothic', 나눔고딕, nanumgothic, 돋움, dotum, sans-serif; font-size: 16px; background-color: #ffffff;\">\n" +
                        "<div class=\"subType-TEXT\" style=\"margin: 0px; padding: 0px; box-sizing: border-box;\">\n" +
                        "<p style=\"margin: 30px auto 0px; padding: 0px; box-sizing: border-box; max-width: 780px; width: auto; font-size: 1.6em; line-height: 1.4em; letter-spacing: -0.03em;\">진한 육향과 부드러운 육즙이 입안 가득 퍼지는</p>\n" +
                        "<p style=\"margin: 6px auto 20px; padding: 0px; box-sizing: border-box; max-width: 780px; width: auto; font-weight: bold; font-size: 2.5em; line-height: 1.2em; letter-spacing: -0.03em;\">프라임 부채살 스테이크 컷</p>\n" +
                        "<p style=\"margin: 20px auto 0px; padding: 0px; box-sizing: border-box; max-width: 780px; width: auto; font-size: 1.22em; line-height: 2em; letter-spacing: -0.01em;\">소의 부채살은 깨끗하고 균형감 있는 마블링과 가느다란 힘줄이 먹음직스럽게 어우러진 부위인데요. 육질이 연해 씹을수록 쫀득하고 부드러운 식감을 자랑하고, 이런 쫄깃한 식감과 더불어 고소한 육즙과 은은한 육향을 선사하지요. 신선함이 느껴지는 프라임 등급의 부채살로 소고기 본연의 담백한 풍미를 맛있게 즐겨보세요. 고품질 소고기만을 엄선해 더욱 맛있는 스테이크 요리를 완성해준답니다.</p>\n" +
                        "</div>\n" +
                        "</div>")
                .title("신선한 육류  디테일")
                .type("meat")
                .build();

        itemService.register(itemDTO1);

        ItemDTO itemDTO2 = ItemDTO.builder()
                .stock((int) (Math.random() *15+1))
                .price((int) ((Math.random() *20+1)*100))
                .thumbImg("https://coupenweb.s3.ap-northeast-2.amazonaws.com/grain01.jpg")
                .writer("grain")
                .content("<p><span style=\"font-size: 2em; font-weight: bold; letter-spacing: -0.05em; background-color: #ffffff; font-family: 'apple sd gothic neo', '맑은 고딕', 'malgun gothic', 나눔고딕, nanumgothic, 돋움, dotum, sans-serif;\">핵심 포인트</span></p>\n" +
                        "<div class=\"type-TEXT\" style=\"margin: 0px 0px 40px; padding: 0px; box-sizing: border-box; font-family: 'apple sd gothic neo', '맑은 고딕', 'malgun gothic', 나눔고딕, nanumgothic, 돋움, dotum, sans-serif; font-size: 16px; background-color: #ffffff;\">\n" +
                        "<div class=\"subType-TEXT\" style=\"margin: 0px; padding: 0px; box-sizing: border-box;\">\n" +
                        "<div id=\"container-core\" style=\"margin: 20px auto; padding: 0px; box-sizing: border-box; max-width: 780px; width: auto; border: 0px solid #bcbcbc;\">\n" +
                        "<div id=\"content-left\" style=\"margin: 0px 0px 8px; padding: 0px; box-sizing: border-box; width: 390px; float: left;\">\n" +
                        "<table style=\"font-family: 돋움, Dotum, sans-serif; border-spacing: 0px; max-width: 100%; background-color: transparent; border: 0px; width: 390px;\">\n" +
                        "<tbody style=\"box-sizing: border-box;\">\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 46.7917px;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box; max-width: 100px; width: 46.7917px;\" src=\"http://img2a.coupangcdn.com/image/retail/images/45582454356573-39e83443-639f-477b-9499-9ad5c5a8e0f3.png\" /></td>\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 343.208px; height: 54px; vertical-align: middle;\">\n" +
                        "<p style=\"margin: 10.2917px 0px 10px 6.85417px; padding: 0px; box-sizing: border-box; font-size: 1.2em; font-weight: bold; letter-spacing: -0.03em;\">상품 특징</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box;\" colspan=\"2\">\n" +
                        "<p style=\"margin: 0px 0px 10px; padding: 0px; box-sizing: border-box; font-size: 1.2em; letter-spacing: -0.03em; line-height: 1.4;\">- 세척할 필요 없이 간편하게 사용하는 현미<br style=\"box-sizing: border-box;\" />- 특유의 구수한 풍미와 고소한 맛이 일품</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</tbody>\n" +
                        "</table>\n" +
                        "</div>\n" +
                        "<div id=\"content-right\" style=\"margin: 0px 0px 8px; padding: 0px; box-sizing: border-box; width: 390px; float: right;\">\n" +
                        "<table style=\"font-family: 돋움, Dotum, sans-serif; border-spacing: 0px; max-width: 100%; background-color: transparent; border: 0px; width: 390px;\">\n" +
                        "<tbody style=\"box-sizing: border-box;\">\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 46.7917px;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box; max-width: 100px; width: 46.7917px;\" src=\"http://img2a.coupangcdn.com/image/retail/images/6804456357169-5fbe96be-d61b-469b-8ff3-7ef47235658f.png\" /></td>\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 343.208px; height: 54px; vertical-align: middle;\">\n" +
                        "<p style=\"margin: 10.2917px 0px 10px 6.85417px; padding: 0px; box-sizing: border-box; font-size: 1.2em; font-weight: bold; letter-spacing: -0.03em;\">보관 방법</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box;\" colspan=\"2\">\n" +
                        "<p style=\"margin: 0px 0px 10px; padding: 0px; box-sizing: border-box; font-size: 1.2em; letter-spacing: -0.03em; line-height: 1.4;\">- 직사광선을 피해 서늘한 곳에 보관<br style=\"box-sizing: border-box;\" />- 개봉 후에는 밀봉하여 냉장 보관</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</tbody>\n" +
                        "</table>\n" +
                        "</div>\n" +
                        "<div id=\"content-left\" style=\"margin: 0px 0px 8px; padding: 0px; box-sizing: border-box; width: 390px; float: left;\">\n" +
                        "<table style=\"font-family: 돋움, Dotum, sans-serif; border-spacing: 0px; max-width: 100%; background-color: transparent; border: 0px; width: 390px;\">\n" +
                        "<tbody style=\"box-sizing: border-box;\">\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 46.7917px;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box; max-width: 100px; width: 46.7917px;\" src=\"http://img2a.coupangcdn.com/image/retail/images/6673968021650-0e59bd9e-d162-45b6-a887-cdd29a8b3c86.png\" /></td>\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 343.208px; height: 54px; vertical-align: middle;\">\n" +
                        "<p style=\"margin: 10.2917px 0px 10px 6.85417px; padding: 0px; box-sizing: border-box; font-size: 1.2em; font-weight: bold; letter-spacing: -0.03em;\">재료와 영양 성분</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box;\" colspan=\"2\">\n" +
                        "<p style=\"margin: 0px 0px 10px; padding: 0px; box-sizing: border-box; font-size: 1.2em; letter-spacing: -0.03em; line-height: 1.4;\">- 식이섬유소, 리놀레산 등이 풍부한 현미<br style=\"box-sizing: border-box;\" />- 비타민B1, E 등의 영양소 함유</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</tbody>\n" +
                        "</table>\n" +
                        "</div>\n" +
                        "<div id=\"content-right\" style=\"margin: 0px 0px 8px; padding: 0px; box-sizing: border-box; width: 390px; float: right;\">\n" +
                        "<table style=\"font-family: 돋움, Dotum, sans-serif; border-spacing: 0px; max-width: 100%; background-color: transparent; border: 0px; width: 390px;\">\n" +
                        "<tbody style=\"box-sizing: border-box;\">\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 46.7917px;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box; max-width: 100px; width: 46.7917px;\" src=\"http://img2a.coupangcdn.com/image/retail/images/6734130828825-78fe8ddd-2222-4a18-be57-c1b42c116f61.png\" /></td>\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box; width: 343.208px; height: 54px; vertical-align: middle;\">\n" +
                        "<p style=\"margin: 10.2917px 0px 10px 6.85417px; padding: 0px; box-sizing: border-box; font-size: 1.2em; font-weight: bold; letter-spacing: -0.03em;\">생산 유통 과정</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "<tr style=\"box-sizing: border-box;\">\n" +
                        "<td style=\"margin: 0px; padding: 0px; box-sizing: border-box;\" colspan=\"2\">\n" +
                        "<p style=\"margin: 0px 0px 10px; padding: 0px; box-sizing: border-box; font-size: 1.2em; letter-spacing: -0.03em; line-height: 1.4;\">- 150m 아래 지하 암반수로 깨끗이 세척<br style=\"box-sizing: border-box;\" />- 적외선 2단계 건조 공정을 거친 제품</p>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</tbody>\n" +
                        "</table>\n" +
                        "</div>\n" +
                        "<div id=\"footer\" style=\"margin: 0px; padding: 10px; box-sizing: border-box; position: relative; clear: both; border-bottom: 0px solid #000000;\">\n" +
                        "<p style=\"margin: 0px 0px 10px; padding: 0px; box-sizing: border-box;\">&nbsp;</p>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<div class=\"type-IMAGE_NO_SPACE\" style=\"margin: 0px; padding: 0px; box-sizing: border-box; font-family: 'apple sd gothic neo', '맑은 고딕', 'malgun gothic', 나눔고딕, nanumgothic, 돋움, dotum, sans-serif; font-size: 16px; background-color: #ffffff;\">\n" +
                        "<div class=\"subType-IMAGE\" style=\"margin: 0px auto; padding: 0px; box-sizing: border-box; width: 780px;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box;\" src=\"https://thumbnail10.coupangcdn.com/thumbnails/remote/q89/image/retail/images/2020/01/30/11/0/515d289c-69b5-4c71-a2ac-90eea58edf1f.jpg\" alt=\"\" width=\"100%\" /></div>\n" +
                        "</div>\n" +
                        "<div class=\"type-TEXT\" style=\"margin: 0px 0px 40px; padding: 0px; box-sizing: border-box; font-family: 'apple sd gothic neo', '맑은 고딕', 'malgun gothic', 나눔고딕, nanumgothic, 돋움, dotum, sans-serif; font-size: 16px; background-color: #ffffff;\">\n" +
                        "<div class=\"subType-TEXT\" style=\"margin: 0px; padding: 0px; box-sizing: border-box;\">\n" +
                        "<p style=\"margin: 30px auto 0px; padding: 0px; box-sizing: border-box; max-width: 780px; width: auto; font-size: 1.6em; line-height: 1.4em; letter-spacing: -0.03em;\">신선하고 간편하게 바로 즐기는 우리 곡물</p>\n" +
                        "<p style=\"margin: 8px auto 30px; padding: 0px; box-sizing: border-box; max-width: 780px; width: auto; font-weight: bold; font-size: 2.8em; line-height: 1.2em; letter-spacing: -0.03em;\">씻어나온 현미</p>\n" +
                        "<p style=\"margin: 20px auto 0px; padding: 0px; box-sizing: border-box; max-width: 780px; width: auto; font-size: 1.22em; line-height: 2em; letter-spacing: -0.01em;\">벼에서 왕겨를 제거한 현미. 백미에 없는 쌀겨와 배아 부분이 있어 그만큼 더욱 풍부한 영양을 지니고 있어요. 식이섬유소는 기본이고, 비타민과 리놀레산 등도 다량 함유해 현미밥으로 지어 드시면 든든하고 건강한 한 끼를 즐기실 수 있죠. 다양한 방법으로 요리할 수 있는 현미를 신선한 국내산으로 골라보세요. 150m 아래 지하 암반수로 깨끗하게 완전 세척을 거친 후 적외선 2단계 건조 공정을 거쳤답니다. 따로 씻어낼 필요 없이 바로 사용할 수 있는 고품질 현미지요. 튼튼한 플라스틱 밀폐 용기에 담아 보관하기에도 간편할 거예요.</p>\n" +
                        "</div>\n" +
                        "</div>")
                .title("신선한 곡물 디테일")
                .type("grain")
                .build();

        itemService.register(itemDTO2);

        ItemDTO itemDTO3 = ItemDTO.builder()
                .stock((int) (Math.random() *15+1))
                .price((int) ((Math.random() *20+1)*100))
                .thumbImg("https://coupenweb.s3.ap-northeast-2.amazonaws.com/vegetable01.jpg")
                .writer("vegetable")
                .content("<p>&nbsp;</p>\n" +
                        "<div class=\"type-IMAGE_NO_SPACE\" style=\"margin: 0px; padding: 0px; box-sizing: border-box;\">\n" +
                        "<div class=\"subType-IMAGE\" style=\"margin: 0px auto; padding: 0px; box-sizing: border-box; width: 780px;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box;\" src=\"https://thumbnail10.coupangcdn.com/thumbnails/remote/q89/image/retail/images/81934842291536-4841488e-85b9-4797-81b9-74cd6e24f5b9.jpg\" alt=\"\" width=\"100%\" /></div>\n" +
                        "</div>\n" +
                        "<div class=\"type-IMAGE_NO_SPACE\" style=\"margin: 0px; padding: 0px; box-sizing: border-box;\">\n" +
                        "<div class=\"subType-IMAGE\" style=\"margin: 0px auto; padding: 0px; box-sizing: border-box; width: 780px;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box;\" src=\"https://thumbnail8.coupangcdn.com/thumbnails/remote/q89/image/retail/images/81934634240109-03d55afe-b678-4d22-9fb1-741238d2ee28.jpg\" alt=\"\" width=\"100%\" /></div>\n" +
                        "</div>\n" +
                        "<div class=\"type-TEXT\" style=\"margin: 0px 0px 40px; padding: 0px; box-sizing: border-box;\">\n" +
                        "<div class=\"subType-TEXT\" style=\"margin: 0px; padding: 0px; box-sizing: border-box;\">\n" +
                        "<div style=\"margin: 50px auto 30px; padding: 50px 0px; box-sizing: border-box; max-width: 780px; width: auto; text-align: center; border-top: 1px solid #000000; border-bottom: 1px solid #000000;\">\n" +
                        "<div style=\"margin: 0px; padding: 0px; box-sizing: border-box; font-size: 3em; color: #4f4f4f; font-weight: bold; letter-spacing: -0.08em;\">신선식품 장보기</div>\n" +
                        "<div style=\"margin: 0px; padding: 0px; box-sizing: border-box;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box; max-width: 300px; width: 300px;\" src=\"http://img2a.coupangcdn.com/image/retail/images/53806409408632-252dd992-8505-4ef7-ae6c-5a1adf7b90c3.png\" /></div>\n" +
                        "</div>\n" +
                        "<div id=\"container-bottom\" style=\"margin: 50px auto; padding: 0px; box-sizing: border-box; max-width: 780px; width: auto; border: 0px solid #bcbcbc;\">\n" +
                        "<div id=\"content-left2\" style=\"margin: 10px 0px 20px; padding: 0px; box-sizing: border-box; width: 260px; float: left; text-align: center; font-family: 'apple sd gothic neo', '맑은 고딕', 'malgun gothic', 나눔고딕, nanumgothic, 돋움, dotum, sans-serif; font-size: 16px; background-color: #ffffff;\">\n" +
                        "<div style=\"margin: 0px; padding: 0px; box-sizing: border-box;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box; max-width: 90px; width: 90px;\" src=\"http://img2a.coupangcdn.com/image/retail/images/59457106849649-5b9a56bd-dd1e-4200-a2dc-28c09c67ad2a.png\" /></div>\n" +
                        "<div style=\"margin: 5.19792px 0px 0px; padding: 0px; box-sizing: border-box; font-size: 1.5em; letter-spacing: -0.03em; line-height: 1.3em;\"><span style=\"box-sizing: border-box; font-weight: bold;\">산지</span>의&nbsp;<span style=\"box-sizing: border-box; font-weight: bold;\">신선함</span>을<br style=\"box-sizing: border-box;\" /><span style=\"box-sizing: border-box; font-weight: bold;\">그대로</span></div>\n" +
                        "</div>\n" +
                        "<div id=\"content-left2\" style=\"margin: 10px 0px 20px; padding: 0px; box-sizing: border-box; width: 260px; float: left; text-align: center; font-family: 'apple sd gothic neo', '맑은 고딕', 'malgun gothic', 나눔고딕, nanumgothic, 돋움, dotum, sans-serif; font-size: 16px; background-color: #ffffff;\">\n" +
                        "<div style=\"margin: 0px; padding: 0px; box-sizing: border-box;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box; max-width: 90px; width: 90px;\" src=\"http://img2a.coupangcdn.com/image/retail/images/59487999945272-c5e6b827-0997-4873-bc5d-a4d0eb7f9bab.png\" /></div>\n" +
                        "<div style=\"margin: 5.19792px 0px 0px; padding: 0px; box-sizing: border-box; font-size: 1.5em; letter-spacing: -0.03em; line-height: 1.3em;\"><span style=\"box-sizing: border-box; font-weight: bold;\">수천 개</span>의<br style=\"box-sizing: border-box;\" /><span style=\"box-sizing: border-box; font-weight: bold;\">다양한 상품들</span></div>\n" +
                        "</div>\n" +
                        "<div id=\"content-left2\" style=\"margin: 10px 0px 20px; padding: 0px; box-sizing: border-box; width: 260px; float: left; text-align: center; font-family: 'apple sd gothic neo', '맑은 고딕', 'malgun gothic', 나눔고딕, nanumgothic, 돋움, dotum, sans-serif; font-size: 16px; background-color: #ffffff;\">\n" +
                        "<div style=\"margin: 0px; padding: 0px; box-sizing: border-box;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box; max-width: 90px; width: 90px;\" src=\"http://img2a.coupangcdn.com/image/retail/images/59505551130363-e42d18f2-97b8-479c-b3f5-8e4fc7004f67.png\" /></div>\n" +
                        "<div style=\"margin: 5.19792px 0px 0px; padding: 0px; box-sizing: border-box; font-size: 1.5em; letter-spacing: -0.03em; line-height: 1.3em;\"><span style=\"box-sizing: border-box; font-weight: bold;\">신선식품 전용</span><br style=\"box-sizing: border-box;\" />물류센터</div>\n" +
                        "</div>\n" +
                        "<div id=\"content-left2\" style=\"margin: 10px 0px 20px; padding: 0px; box-sizing: border-box; width: 260px; float: left; text-align: center; font-family: 'apple sd gothic neo', '맑은 고딕', 'malgun gothic', 나눔고딕, nanumgothic, 돋움, dotum, sans-serif; font-size: 16px; background-color: #ffffff;\">\n" +
                        "<div style=\"margin: 0px; padding: 0px; box-sizing: border-box;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box; max-width: 90px; width: 90px;\" src=\"http://img2a.coupangcdn.com/image/retail/images/59526770138984-14a5bee3-accf-4cd8-9057-a6427592a06c.png\" /></div>\n" +
                        "<div style=\"margin: 5.19792px 0px 0px; padding: 0px; box-sizing: border-box; font-size: 1.5em; letter-spacing: -0.03em; line-height: 1.3em;\"><span style=\"box-sizing: border-box; font-weight: bold;\">환경</span>을&nbsp;<span style=\"box-sizing: border-box; font-weight: bold;\">생각</span>하는<br style=\"box-sizing: border-box;\" /><span style=\"box-sizing: border-box; font-weight: bold;\">포장재</span>&nbsp;사용</div>\n" +
                        "</div>\n" +
                        "<div id=\"content-left2\" style=\"margin: 10px 0px 20px; padding: 0px; box-sizing: border-box; width: 260px; float: left; text-align: center; font-family: 'apple sd gothic neo', '맑은 고딕', 'malgun gothic', 나눔고딕, nanumgothic, 돋움, dotum, sans-serif; font-size: 16px; background-color: #ffffff;\">\n" +
                        "<div style=\"margin: 0px; padding: 0px; box-sizing: border-box;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box; max-width: 90px; width: 90px;\" src=\"http://img2a.coupangcdn.com/image/retail/images/59541654643433-bde3a583-ec1f-4339-a0bf-b9d8fd0d30b7.png\" /></div>\n" +
                        "<div style=\"margin: 5.19792px 0px 0px; padding: 0px; box-sizing: border-box; font-size: 1.5em; letter-spacing: -0.03em; line-height: 1.3em;\"><span style=\"box-sizing: border-box; font-weight: bold; letter-spacing: -0.585px;\">새벽도착&nbsp;</span><span style=\"box-sizing: border-box; letter-spacing: -0.585px;\">그리고&nbsp;</span><br style=\"box-sizing: border-box; letter-spacing: -0.585px;\" /><span style=\"box-sizing: border-box; letter-spacing: -0.585px;\">더 빠른&nbsp;</span><span style=\"box-sizing: border-box; font-weight: bold; letter-spacing: -0.585px;\">오늘도착</span></div>\n" +
                        "</div>\n" +
                        "<div id=\"content-left2\" style=\"margin: 10px 0px 20px; padding: 0px; box-sizing: border-box; width: 260px; float: left; text-align: center; font-family: 'apple sd gothic neo', '맑은 고딕', 'malgun gothic', 나눔고딕, nanumgothic, 돋움, dotum, sans-serif; font-size: 16px; background-color: #ffffff;\">\n" +
                        "<div style=\"margin: 0px; padding: 0px; box-sizing: border-box;\"><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box; max-width: 90px; width: 90px;\" src=\"http://img2a.coupangcdn.com/image/retail/images/59559812694017-cb9fb425-643f-4cdc-b6e5-62a452f45340.png\" /></div>\n" +
                        "<div style=\"margin: 5.19792px 0px 0px; padding: 0px; box-sizing: border-box; font-size: 1.5em; letter-spacing: -0.03em; line-height: 1.3em;\"><span style=\"box-sizing: border-box; font-weight: bold;\">15,000원</span>&nbsp;이상<br style=\"box-sizing: border-box;\" /><span style=\"box-sizing: border-box; font-weight: bold;\">무조건 무료배송</span></div>\n" +
                        "</div>\n" +
                        "<div id=\"footer1028\" style=\"margin: 0px; padding: 10px; box-sizing: border-box; clear: both; border-bottom: 0px solid #000000; font-family: 'apple sd gothic neo', '맑은 고딕', 'malgun gothic', 나눔고딕, nanumgothic, 돋움, dotum, sans-serif; font-size: 16px; background-color: #ffffff;\">\n" +
                        "<p style=\"margin: 0px 0px 10px; padding: 0px; box-sizing: border-box;\">&nbsp;</p>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</div>")
                .title("유기농 채소 디테일 ")
                .type("vegetable")
                .build();

        itemService.register(itemDTO3);

        ItemDTO itemDTO4 = ItemDTO.builder()
                .stock((int) (Math.random() *15+1))
                .price((int) ((Math.random() *20+1)*100))
                .thumbImg("https://coupenweb.s3.ap-northeast-2.amazonaws.com/fruit01.jfif")
                .writer("fruit")
                .content("<p><img style=\"border: 0px; padding: 0px; vertical-align: middle; box-sizing: border-box; font-family: 'apple sd gothic neo', '맑은 고딕', 'malgun gothic', 나눔고딕, nanumgothic, 돋움, dotum, sans-serif; font-size: 16px; background-color: #ffffff;\" src=\"https://thumbnail9.coupangcdn.com/thumbnails/remote/q89/image/retail/images/73326027820206-fcc539e8-033a-4352-b39c-a268c7c59592.jpg\" alt=\"\" width=\"100%\" /></p>")
                .title("유기농 과일 디테일")
                .type("fruit")
                .build();

        itemService.register(itemDTO4);

    }
}