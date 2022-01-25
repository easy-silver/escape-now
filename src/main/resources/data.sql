-- 매장 정보 INSERT
INSERT INTO SHOP(SHOP_ID, NAME) VALUES(1, '넥스트에디션');
INSERT INTO SHOP(SHOP_ID, NAME) VALUES(2, '비밀의화원');

-- 지점 정보 INSERT
INSERT INTO BRANCH(SHOP_ID, AREA_CODE, NAME, URL) VALUES(1, 'GN', '강남1호', 'https://www.nextedition.co.kr/shops/NextEdition%20Gangnam');
INSERT INTO BRANCH(SHOP_ID, AREA_CODE, NAME, URL) VALUES(1, 'GN', '강남2호', 'https://www.nextedition.co.kr/shops/NextEdition%20Gangnam1');
INSERT INTO BRANCH(SHOP_ID, AREA_CODE, NAME, URL) VALUES(1, 'GN', '강남3호', 'https://www.nextedition.co.kr/shops/NextEdition%20Gangnam2');
INSERT INTO BRANCH(SHOP_ID, AREA_CODE, NAME, URL) VALUES(1, 'GN', '강남신논현', 'https://www.nextedition.co.kr/shops/Nextedition%20gangnamsinnonhyun');
INSERT INTO BRANCH(SHOP_ID, AREA_CODE, NAME, URL) VALUES(1, 'GN', '강남5호', 'https://www.nextedition.co.kr/shops/NextEdition%20Gangnam5');

INSERT INTO BRANCH(SHOP_ID, AREA_CODE, NAME, URL) VALUES(2, 'GN', '리버타운 강남', 'http://www.secretgardenescape.com/reservation.html?k_shopno=9');