-- INSERT INTO author (ID, FIRST_NAME, LAST_NAME, USERNAME)
-- SELECT *
--   FROM CSVREAD( 'classpath:authors.csv', NULL )

-- tags inserts
INSERT INTO tag(id,tag_name) VALUES (1,'test');
INSERT INTO tag(id,tag_name) VALUES (2,'java');
INSERT INTO tag(id,tag_name) VALUES (3,'mvc');
INSERT INTO tag(id,tag_name) VALUES (4,'happy');
INSERT INTO tag(id,tag_name) VALUES (5,'sad');
INSERT INTO tag(id,tag_name) VALUES (6,'whatever');
INSERT INTO tag(id,tag_name) VALUES (7,'marvel');
INSERT INTO tag(id,tag_name) VALUES (8,'dc');
INSERT INTO tag(id,tag_name) VALUES (9,'snap');
INSERT INTO tag(id,tag_name) VALUES (10,'thanos');
INSERT INTO tag(id,tag_name) VALUES (11,'gsw');
INSERT INTO tag(id,tag_name) VALUES (12,'wiz');
INSERT INTO tag(id,tag_name) VALUES (13,'bulls');
INSERT INTO tag(id,tag_name) VALUES (14,'jordan');
INSERT INTO tag(id,tag_name) VALUES (15,'lebron');
INSERT INTO tag(id,tag_name) VALUES (16,'durant');
INSERT INTO tag(id,tag_name) VALUES (17,'harden');
INSERT INTO tag(id,tag_name) VALUES (18,'bucks');
INSERT INTO tag(id,tag_name) VALUES (19,'giannis');
INSERT INTO tag(id,tag_name) VALUES (20,'shaq');

-- author inserts
INSERT INTO author(id,first_name,last_name,username) VALUES (1,'Thomasa','Rignold','trignold0');
INSERT INTO author(id,first_name,last_name,username) VALUES (2,'Ilysa','MacCroary','imaccroary1');
INSERT INTO author(id,first_name,last_name,username) VALUES (3,'Aleksandr','Dike','adike2');
INSERT INTO author(id,first_name,last_name,username) VALUES (4,'Rollins','Dearell','rdearell3');
INSERT INTO author(id,first_name,last_name,username) VALUES (5,'Vinnie','Valentine','vvalentine4');
INSERT INTO author(id,first_name,last_name,username) VALUES (6,'Hesther','Alchin','halchin5');
INSERT INTO author(id,first_name,last_name,username) VALUES (7,'Raleigh','Degue','rdegue6');
INSERT INTO author(id,first_name,last_name,username) VALUES (8,'Olav','Mulqueeny','omulqueeny7');
INSERT INTO author(id,first_name,last_name,username) VALUES (9,'Em','Maciunas','emaciunas8');
INSERT INTO author(id,first_name,last_name,username) VALUES (10,'Thor','Quelch','tquelch9');
INSERT INTO author(id,first_name,last_name,username) VALUES (11,'Anatol','Van Halle','avanhallea');
INSERT INTO author(id,first_name,last_name,username) VALUES (12,'Ives','Riepl','irieplb');
INSERT INTO author(id,first_name,last_name,username) VALUES (13,'Tori','Kineton','tkinetonc');
INSERT INTO author(id,first_name,last_name,username) VALUES (14,'Vannie','Grzelczak','vgrzelczakd');
INSERT INTO author(id,first_name,last_name,username) VALUES (15,'Erik','Pales','epalese');
INSERT INTO author(id,first_name,last_name,username) VALUES (16,'Boyd','Zorzi','bzorzif');
INSERT INTO author(id,first_name,last_name,username) VALUES (17,'Mike','Anyene','manyeneg');
INSERT INTO author(id,first_name,last_name,username) VALUES (18,'Elie','Shoosmith','eshoosmithh');
INSERT INTO author(id,first_name,last_name,username) VALUES (19,'Amara','Andreazzi','aandreazzii');
INSERT INTO author(id,first_name,last_name,username) VALUES (20,'Ramon','Farran','rfarranj');

-- post inserts


INSERT INTO post(id,post_content) VALUES (1,'<img src="https://imagazine.pl/wp-content/uploads/2014/12/javaprob-001.png">');
INSERT INTO post(id,post_content) VALUES (2,'Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem.');
INSERT INTO post(id,post_content) VALUES (3,'Aenean lectus. Pellentesque eget nunc.');
INSERT INTO post(id,post_content) VALUES (4,'Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat. Nulla nisl. Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.');
INSERT INTO post(id,post_content) VALUES (5,'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat. Curabitur gravida nisi at nibh.');
INSERT INTO post(id,post_content) VALUES (6,'Fusce consequat. Nulla nisl. Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum. In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante.');
INSERT INTO post(id,post_content) VALUES (7,'Duis at velit eu est congue elementum. In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo. Aliquam quis turpis eget elit sodales scelerisque.');
INSERT INTO post(id,post_content) VALUES (8,'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.');
INSERT INTO post(id,post_content) VALUES (9,'Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam. Nam tristique tortor eu pede.');
INSERT INTO post(id,post_content) VALUES (10,'Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris. Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.');
INSERT INTO post(id,post_content) VALUES (11,'Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem. Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus. Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien.');
INSERT INTO post(id,post_content) VALUES (12,'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices.');
INSERT INTO post(id,post_content) VALUES (13,'Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.');
INSERT INTO post(id,post_content) VALUES (14,'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat. In congue.');
INSERT INTO post(id,post_content) VALUES (15,'Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.');
INSERT INTO post(id,post_content) VALUES (16,'Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc.');
INSERT INTO post(id,post_content) VALUES (17,'Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi. Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.');
INSERT INTO post(id,post_content) VALUES (18,'Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.');
INSERT INTO post(id,post_content) VALUES (19,'Praesent lectus. Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis. Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.');
INSERT INTO post(id,post_content) VALUES (20,'Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti. Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris. Morbi non lectus.');


-- comment inserts
INSERT INTO comment(id,author_id,post_id,comment_content) VALUES (1,1,1,'Duis at velit eu est congue elementum. In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo. Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.');
INSERT INTO comment(id,author_id,post_id,comment_content) VALUES (2,2,1,'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque. Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus.');
INSERT INTO comment(id,author_id,post_id,comment_content) VALUES (3,3,2,'Curabitur convallis. Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat.');
INSERT INTO comment(id,author_id,post_id,comment_content) VALUES (4,4,3,'Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim.');
INSERT INTO comment(id,author_id,post_id,comment_content) VALUES (5,5,5,'Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat. Nulla nisl. Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum. In hac habitasse platea dictumst.');
INSERT INTO comment(id,author_id,post_id,comment_content) VALUES (6,6,5,'Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.');
INSERT INTO comment(id,author_id,post_id,comment_content) VALUES (7,7,6,'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.');
INSERT INTO comment(id,author_id,post_id,comment_content) VALUES (8,8,6,'Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem. Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus. Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.');
INSERT INTO comment(id,author_id,post_id,comment_content) VALUES (9,9,6,'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus.');
INSERT INTO comment(id,author_id,post_id,comment_content) VALUES (10,9,8,'Mauris sit amet eros. Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor. Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum.');
INSERT INTO comment(id,author_id,post_id,comment_content) VALUES (11,11,9,'Vivamus in felis eu sapien cursus vestibulum. Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue.');
INSERT INTO comment(id,author_id,post_id,comment_content) VALUES (12,12,10,'Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh. In quis justo.');
INSERT INTO comment(id,author_id,post_id,comment_content) VALUES (13,13,11,'Nunc rhoncus dui vel sem. Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.');
INSERT INTO comment(id,author_id,post_id,comment_content) VALUES (14,14,12,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.');
INSERT INTO comment(id,author_id,post_id,comment_content) VALUES (15,15,13,'Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh. In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.');
INSERT INTO comment(id,author_id,post_id,comment_content) VALUES (16,16,15,'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat. Curabitur gravida nisi at nibh.');
INSERT INTO comment(id,author_id,post_id,comment_content) VALUES (17,17,16,'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo. Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor.');
INSERT INTO comment(id,author_id,post_id,comment_content) VALUES (18,18,17,'In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat. Nulla nisl. Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus.');
INSERT INTO comment(id,author_id,post_id,comment_content) VALUES (19,19,18,'Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.');
INSERT INTO comment(id,author_id,post_id,comment_content) VALUES (20,20,20,'Ut at dolor quis odio consequat varius. Integer ac leo.');



-- attachment inserts
INSERT INTO attachment(post_id,file_name) VALUES (1,'EtErosVestibulum.tiff');
INSERT INTO attachment(post_id,file_name) VALUES (2,'DapibusDuisAt.mp3');
INSERT INTO attachment(post_id,file_name) VALUES (3,'IpsumDolorSit.mov');
INSERT INTO attachment(post_id,file_name) VALUES (4,'NullaPede.mov');
INSERT INTO attachment(post_id,file_name) VALUES (4,'NibhIn.mp3');
INSERT INTO attachment(post_id,file_name) VALUES (5,'Volutpat.avi');
INSERT INTO attachment(post_id,file_name) VALUES (1,'Lectus.avi');
INSERT INTO attachment(post_id,file_name) VALUES (6,'LuctusEtUltrices.avi');
INSERT INTO attachment(post_id,file_name) VALUES (8,'Justo.avi');
INSERT INTO attachment(post_id,file_name) VALUES (11,'LuctusEtUltrices.avi');
INSERT INTO attachment(post_id,file_name) VALUES (8,'At.ppt');
INSERT INTO attachment(post_id,file_name) VALUES (8,'Cras.jpeg');
INSERT INTO attachment(post_id,file_name) VALUES (19,'EstDonec.tiff');
INSERT INTO attachment(post_id,file_name) VALUES (6,'DictumstAliquamAugue.xls');
INSERT INTO attachment(post_id,file_name) VALUES (13,'LobortisConvallisTortor.mp3');
INSERT INTO attachment(post_id,file_name) VALUES (2,'ErosSuspendisseAccumsan.avi');
INSERT INTO attachment(post_id,file_name) VALUES (19,'Nibh.avi');
INSERT INTO attachment(post_id,file_name) VALUES (5,'ASuscipitNulla.tiff');
INSERT INTO attachment(post_id,file_name) VALUES (20,'PhasellusIdSapien.mp3');



-- post_author inserts
INSERT INTO post_author(post_id,author_id) VALUES (1,1);
INSERT INTO post_author(post_id,author_id) VALUES (1,2);
INSERT INTO post_author(post_id,author_id) VALUES (2,3);
INSERT INTO post_author(post_id,author_id) VALUES (3,4);
INSERT INTO post_author(post_id,author_id) VALUES (4,4);
INSERT INTO post_author(post_id,author_id) VALUES (5,5);
INSERT INTO post_author(post_id,author_id) VALUES (6,6);
INSERT INTO post_author(post_id,author_id) VALUES (7,7);
INSERT INTO post_author(post_id,author_id) VALUES (7,8);
INSERT INTO post_author(post_id,author_id) VALUES (8,9);
INSERT INTO post_author(post_id,author_id) VALUES (9,10);
INSERT INTO post_author(post_id,author_id) VALUES (10,9);
INSERT INTO post_author(post_id,author_id) VALUES (11,11);
INSERT INTO post_author(post_id,author_id) VALUES (12,12);
INSERT INTO post_author(post_id,author_id) VALUES (13,13);
INSERT INTO post_author(post_id,author_id) VALUES (14,14);
INSERT INTO post_author(post_id,author_id) VALUES (15,15);
INSERT INTO post_author(post_id,author_id) VALUES (16,16);
INSERT INTO post_author(post_id,author_id) VALUES (17,17);
INSERT INTO post_author(post_id,author_id) VALUES (18,18);
INSERT INTO post_author(post_id,author_id) VALUES (19,19);
INSERT INTO post_author(post_id,author_id) VALUES (20,20);


INSERT INTO post_tag(post_id,tag_id) VALUES (1,1);
INSERT INTO post_tag(post_id,tag_id) VALUES (1,5);
INSERT INTO post_tag(post_id,tag_id) VALUES (1,6);
INSERT INTO post_tag(post_id,tag_id) VALUES (2,2);
INSERT INTO post_tag(post_id,tag_id) VALUES (3,3);
INSERT INTO post_tag(post_id,tag_id) VALUES (3,5);
INSERT INTO post_tag(post_id,tag_id) VALUES (4,4);
INSERT INTO post_tag(post_id,tag_id) VALUES (4,15);
INSERT INTO post_tag(post_id,tag_id) VALUES (5,5);
INSERT INTO post_tag(post_id,tag_id) VALUES (6,6);
INSERT INTO post_tag(post_id,tag_id) VALUES (6,16);
INSERT INTO post_tag(post_id,tag_id) VALUES (7,7);
INSERT INTO post_tag(post_id,tag_id) VALUES (7,17);
INSERT INTO post_tag(post_id,tag_id) VALUES (8,8);
INSERT INTO post_tag(post_id,tag_id) VALUES (9,9);
INSERT INTO post_tag(post_id,tag_id) VALUES (9,19);
INSERT INTO post_tag(post_id,tag_id) VALUES (9,3);
INSERT INTO post_tag(post_id,tag_id) VALUES (10,10);
INSERT INTO post_tag(post_id,tag_id) VALUES (11,11);
INSERT INTO post_tag(post_id,tag_id) VALUES (11,1);
INSERT INTO post_tag(post_id,tag_id) VALUES (12,12);
INSERT INTO post_tag(post_id,tag_id) VALUES (13,13);
INSERT INTO post_tag(post_id,tag_id) VALUES (14,14);
INSERT INTO post_tag(post_id,tag_id) VALUES (14,1);
INSERT INTO post_tag(post_id,tag_id) VALUES (14,2);
INSERT INTO post_tag(post_id,tag_id) VALUES (15,15);
INSERT INTO post_tag(post_id,tag_id) VALUES (16,16);
INSERT INTO post_tag(post_id,tag_id) VALUES (16,18);
INSERT INTO post_tag(post_id,tag_id) VALUES (16,4);
INSERT INTO post_tag(post_id,tag_id) VALUES (17,17);
INSERT INTO post_tag(post_id,tag_id) VALUES (17,12);
INSERT INTO post_tag(post_id,tag_id) VALUES (18,18);
INSERT INTO post_tag(post_id,tag_id) VALUES (19,19);
INSERT INTO post_tag(post_id,tag_id) VALUES (19,9);
INSERT INTO post_tag(post_id,tag_id) VALUES (19,1);
INSERT INTO post_tag(post_id,tag_id) VALUES (20,20);


